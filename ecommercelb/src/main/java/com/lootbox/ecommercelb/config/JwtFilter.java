package com.lootbox.ecommercelb.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean {
	public static String secret = "CocoMiniRockyRamonaLuigiYoshiLiaBenjiMikePorfirioOliviaNinaMaddyZeroCamilo";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String authHeader = httpServletRequest.getHeader("Authorization");
		String uri = httpServletRequest.getRequestURI();
		String method = httpServletRequest.getMethod();

		boolean requiereToken = false;

		if (uri.contains("/api/usuarios/")) {
			requiereToken = true;
		} else if (uri.contains("/api/prod/") && 
				  (method.equals("POST") || method.equals("PUT") || method.equals("DELETE"))) {
			requiereToken = true;
		}

		if (requiereToken) {
			if (authHeader == null || !authHeader.startsWith("Bearer: ")) {
				System.out.println("1. Invalid Token");
				throw new ServletException("1. Invalid Token");
			}
			String token = authHeader.substring(7);
			try {
				Claims claims = Jwts.parser().setSigningKey(secret)
					.parseClaimsJws(token).getBody();
				claims.forEach((key, value) -> 
					System.out.println("Key: " + key + " value: " + value));
			} catch (SignatureException | MalformedJwtException | ExpiredJwtException e) {
				System.out.println("2. Invalid Token");
				throw new ServletException("2. Invalid Token");
			}
		}

		chain.doFilter(request, response);
	}
}
