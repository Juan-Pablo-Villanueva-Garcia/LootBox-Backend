package com.lootbox.ecommercelb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lootbox.ecommercelb.dto.ChangePassword;
import com.lootbox.ecommercelb.models.Producto;
import com.lootbox.ecommercelb.models.Usuario;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc //PErmite realizar las pruebas unitarias, levanta el servidor
class EcommercelbApplicationTests {
	private final String token = "Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtaW5waW4xMjNAZ21haWwuY29tIiwicm9sZSI6InVzZXIiLCJpYXQiOjE3NDgyOTAzNjYsImV4cCI6MTc0ODM3Njc2Nn0.UQwEg7Voqn0eWQVhF32WbUFg6MdUKIYQrDAaejBiicY";
	
	@Autowired
	private MockMvc mockMvc;//Punto d epartida para probar los métodos

	@Test
	@DisplayName("Se pureba el Get del endpoint http://localhost:8080/api/prod/1")
	void pruebaGET() throws Exception {
		this.mockMvc.perform(get("/api/prod/1"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("LootBox Com")));
	}//pruebaGET()
	

	@Test
	//@Disabled("Se probó una vez, se deshabiliata a la siguientes")
	@DisplayName("Se pureba el DELETE del endpoint http://localhost:8080/api/prod/3")
	void pruebaDELETE() throws Exception {
		this.mockMvc.perform(delete("/api/prod/3")
				.header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("LootBox Legendaria")));
	}//pruebaDELETE()
	
	@Test
	@DisplayName("Se pureba el DELETE del endpoint http://localhost:8080/api/productos/5")
	void pruebaPUT() throws Exception {
		this.mockMvc.perform(put("/api/prod/5?price=127.99&imagen=pruebaimagencambio.jpg")
				.header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("127.99")))
		.andExpect(content().string(containsString("pruebaimagencambio.jpg")));
	}//pruebaPUT()
	
	@Test
	@DisplayName("Se pureba el post del endpoint http://localhost:8080/api/productos/")
	void pruebaPOST() throws Exception {
		Producto producto = new Producto(
				"Producto nuevo",
				"imagen.jpg",
				"Esto es una descripción",
				"categoria",
				123.99,
				"{calif:4.4,count:234}",
				234,
				99,
				135.00
				//tring name, String imagen, String descripcion, String category, Double price, String jSON,
				//Integer sku, Integer stock, Double costo
				);
				
		this.mockMvc.perform(post("/api/prod/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(producto))
				.header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Producto nuevo")));
		//.andExpect(content().string(containsString("Pluma.jpg")));
	}//pruebaPOST()
//	
	
	
	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}//catch
	}//asJsonString
	
	@Test
	@DisplayName("Se pureba el Get del endpoint http://localhost:8080/api/usuarios/1")
	void pruebaGETUser() throws Exception {
		this.mockMvc.perform(get("/api/usuarios/3")
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("MIN2")));
	}//pruebaGETUser()
	@Test
	@DisplayName("Se pureba el Get del endpoint http://localhost:8080/api/usuarios")
	void pruebaGETUsers() throws Exception {
		this.mockMvc.perform(get("/api/usuarios/")
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk());
	}//pruebaGETUsers()
	@Test
	@Disabled("Se probó una vez, se deshabiliata a la siguientes")
	@DisplayName("Se pureba el delete del endpoint http://localhost:8080/api/usuarios/1")
	void pruebaDELETEeusers() throws Exception {
		this.mockMvc.perform(delete("/api/usuarios/1")
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Simon")));
	}//pruebaDeleteUsers()
	@Test
	@Disabled("Se probó una vez, se deshabiliata a la siguientes")
	@DisplayName("Se pureba el post del endpoint http://localhost:8080/api/usuarios/")
	void pruebaPOSTeusers() throws Exception {
		Usuario u = new Usuario(
				"MIN2",
				"min2@gmail.com",
				"5512345678",
				"contra",
				"sasdfasdfasdf"
				);
				
		this.mockMvc.perform(post("/api/usuarios/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(u))
				.header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("MIN2")));
	}//pruebaPOST()
	@Test
	@DisplayName("Se pureba el POST del endpoint http://localhost:8080/api/usuarios/2")
	void pruebaPUTUsuarios() throws Exception {
		ChangePassword c = new ChangePassword(
				
					  "contra",
					  "fin1234"
					
				);
		this.mockMvc.perform(put("/api/usuarios/3?password=324242")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(c))
		        .header("Authorization", token))
		    .andDo(print())
		    .andExpect(status().isOk())
		    .andExpect(content().string(containsString("MIN2")));
	}//pruebaPUT()
	

}//Class EcommerceApplicationTests