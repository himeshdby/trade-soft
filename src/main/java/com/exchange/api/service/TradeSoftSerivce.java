package com.exchange.api.service;

import com.exchange.api.bean.BookVO;
import com.exchange.api.bean.SymbolVO;

import java.io.IOException;
import java.util.List;

public interface TradeSoftSerivce {

    public List<BookVO> getBookQuatationType(String Price, String Quantity, String orderType)throws IOException;
    public List<BookVO> fetchBookQuatation(String symbol)throws IOException;
    public List<BookVO> fetchBookSymbol(String symbol)throws IOException;

}
