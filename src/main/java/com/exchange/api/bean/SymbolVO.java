package com.exchange.api.bean;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class SymbolVO {


    private String base_currency;
    private String base_currency_scale;
    private String counter_currency;
    private String counter_currency_scale;
    private String min_price_increment;
    private String min_price_increment_scale;
    private String min_order_size;
    private String min_order_size_scale;
    private String max_order_size;
    private String max_order_size_scale;
    private String lot_size;
    private String lot_size_scale;
    private String status;
    private String id;
    private String auction_price;
    private String auction_size;
    private String auction_time;
    private String imbalance;
}
