package com.exchange.api.tradesoft;

import com.exchange.api.impl.TradeSoftImpl;
import com.exchange.api.service.TradeSoftSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;

@SpringBootApplication
public class TradeSoftApplication extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TradeSoftApplication.class);
	}





	public static void main(String[] args) throws IOException {
		SpringApplication.run(TradeSoftApplication.class, args);
	}

}
