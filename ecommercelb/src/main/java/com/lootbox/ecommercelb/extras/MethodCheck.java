package com.lootbox.ecommercelb.extras;

import java.util.EnumSet;

public class MethodCheck {
	
	 public static final EnumSet<HttpMethod> crud = EnumSet.of(
			 HttpMethod.GET, 
			 HttpMethod.POST, 
			 HttpMethod.PUT, 
			 HttpMethod.DELETE);
	 
	 public static final EnumSet<HttpMethod> lectura = EnumSet.of(
			 HttpMethod.GET, 
			 HttpMethod.HEAD, 
			 HttpMethod.OPTIONS);
	 
	 public static final EnumSet<HttpMethod> escritura = EnumSet.of(
    		 HttpMethod.POST, 
    		 HttpMethod.PUT, 
    		 HttpMethod.DELETE, 
    		 HttpMethod.PATCH);
     
	 public static final EnumSet<HttpMethod> registro = EnumSet.of( 
    		 HttpMethod.POST);
     
	 public static final EnumSet<HttpMethod> administrador = EnumSet.of(
    		 HttpMethod.GET, 
    		 HttpMethod.POST, 
    		 HttpMethod.PUT, 
    		 HttpMethod.DELETE, 
    		 HttpMethod.PATCH);
     
	 public static final EnumSet<HttpMethod> todo = EnumSet.allOf(HttpMethod.class);

}
