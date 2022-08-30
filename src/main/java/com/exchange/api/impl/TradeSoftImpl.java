package com.exchange.api.impl;

import com.exchange.api.bean.BookVO;
import com.exchange.api.bean.SymbolVO;
import com.exchange.api.controller.TradeSoftController;
import com.exchange.api.service.TradeSoftSerivce;
import com.exchange.api.utils.CommonConstants;
import com.exchange.api.utils.ConnectUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TradeSoftImpl implements TradeSoftSerivce {

    private static final Logger LOG = LoggerFactory.getLogger(TradeSoftImpl.class);
    @Override
    public List<BookVO> getBookQuatationType(String Price,String Quantity,String orderType) throws JsonProcessingException {
        String url = CommonConstants.BASE_URL+CommonConstants.ORDER_BOOKS+orderType;
        String httpResponse = ConnectUtils.getHttpResponse(null,url);
        LOG.info("RESulltttt===" + httpResponse);
        JSONObject json = new JSONObject(httpResponse);
        Object object2 = json.get("code");
        if (!object2.equals("404")) {
            Object object = json.get("result");
            Collection<BookVO> readValues = new ObjectMapper()
                    .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .readValue(object.toString(), new TypeReference<Collection<BookVO>>(){ });
            LOG.info("JSONRESulltttt===" + readValues.toString());
            return (List<BookVO>) readValues;
        }
        return Collections.emptyList();
    }

    @Override
    public List<BookVO> fetchBookQuatation(String symbol) throws IOException {
        String url = CommonConstants.BASE_URL+CommonConstants.BOOK_DATA+"BTC-USD";
        String httpResponse = ConnectUtils.getHttpResponse(null,url);
        return null;
    }

    @Override
    public List<BookVO> fetchBookSymbol(String symbol) throws IOException {
        return null;
    }


}
