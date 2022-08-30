package com.exchange.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class ConnectUtils {

    @Autowired
    private static RestTemplate restTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(ConnectUtils.class);

    //get response from rest service
    public static String getHttpResponse(String authenticationToken, final String uri) {
        String result = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add(CommonConstants.HEADER_TOKEN ,authenticationToken);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

            ResponseEntity<String> exchange = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
            return exchange.getBody();
        }
        catch(Exception ex) {
            LOG.info("Integration service connection exception"+ex);
        }
        return result;
    }

}
