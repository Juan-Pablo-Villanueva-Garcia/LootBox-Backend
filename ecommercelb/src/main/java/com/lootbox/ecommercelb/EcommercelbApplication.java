package com.lootbox.ecommercelb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import com.lootbox.ecommercelb.config.JwtFilter;

@SpringBootApplication
public class EcommercelbApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommercelbApplication.class, args);
	}//main
	public FilterRegistrationBean<JwtFilter> jwFilter(){
		FilterRegistrationBean<JwtFilter> registrarionBean = new FilterRegistrationBean<JwtFilter>();
		registrarionBean.setFilter(new JwtFilter());
		registrarionBean.addUrlPatterns("/api/usuarios/*");
		return registrarionBean;
	}
}
