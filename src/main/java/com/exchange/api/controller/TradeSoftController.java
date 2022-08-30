package com.exchange.api.controller;

import com.exchange.api.service.TradeSoftSerivce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path="/api/exchanges/")
public class TradeSoftController {
    private static final Logger LOG = LoggerFactory.getLogger(TradeSoftController.class);

    @Autowired
    TradeSoftSerivce service;

    @GetMapping("{exchangeName}/order-books")
    public void getBooksQuotes(@RequestParam("price") String price,@RequestParam("quantity") String quantity,@RequestParam("orderType") String orderType){
    }

    @GetMapping("l3/order-books")
    public void fetchBookQuatation(@RequestParam("symbol")String symbol) throws IOException {
       service.fetchBookQuatation(symbol);
    }
}
