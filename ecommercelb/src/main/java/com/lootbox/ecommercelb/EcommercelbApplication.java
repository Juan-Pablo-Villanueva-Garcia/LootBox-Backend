package com.lootbox.ecommercelb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.lootbox.ecommercelb.config.JwtFilter;

@SpringBootApplication
public class EcommercelbApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommercelbApplication.class, args);
	}//main
	
	@Bean
	public FilterRegistrationBean<JwtFilter> jwFilter(){
		FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<JwtFilter>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/usuarios/*");
		registrationBean.addUrlPatterns("/api/prod/*");
		registrationBean.addUrlPatterns("/api/pedidoprod/*");
		return registrationBean;
	}
}
