package com.lootbox.ecommercelb.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import com.lootbox.ecommercelb.extras.HttpMethod;
import com.lootbox.ecommercelb.extras.MethodCheck;

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
		String uri = httpServletRequest.getRequestURI();
		HttpMethod method = HttpMethod.valueOf(httpServletRequest.getMethod());
		
		boolean requiereToken =
					(uri.contains("/api/pedidoprod/"))
				||	(uri.contains("/api/usuarios/") && !MethodCheck.registro.contains(method)) 
				||	(uri.contains("/api/pedidos/") && MethodCheck.escritura.contains(method))
			    || 	(uri.contains("/api/prod/") && MethodCheck.escritura.contains(method));
			    
		if (requiereToken) {
			String authHeader = httpServletRequest.getHeader("Authorization");
			if (authHeader == null || !authHeader.startsWith("Bearer: ")) {
				System.out.println("1. Invalid Token");
				throw new ServletException("1. Invalid Token");
			}//Validar que se recibió un dato.
			try {
				Claims claims = Jwts.parser()
						.setSigningKey(secret)
						.parseClaimsJws(authHeader.substring(7)) //Se elimina el auth y se mantiene la key
						.getBody();
				
				claims.forEach((key, value) -> {
					System.out.println("Key: " + key + " value: " + value);
				});
				
			} catch (SignatureException | MalformedJwtException | ExpiredJwtException e) {
				System.out.println("2. Invalid Token");
				throw new ServletException("2. Invalid Token");
			}//catch
		}//if-token
		chain.doFilter(request, response);
	}//doFilter()
}//class JwtFilter
