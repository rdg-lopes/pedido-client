package com.exemplo.pedido;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreatePedidoClient {

	public static void main(String[] args) {
		
		PedidoInputDTO input = new PedidoInputDTO();
		input.setCodCliente(1001);
		input.setItens(new ArrayList<ItemPedidoDTO>());
		
		ItemPedidoDTO item = new ItemPedidoDTO();
		item.setCodProduto(1001);
		item.setQtde(new BigDecimal(10));
		item.setVlUnitario(new BigDecimal("10.12"));
		input.getItens().add(item);
		
		item = new ItemPedidoDTO();
		item.setCodProduto(1002);
		item.setQtde(new BigDecimal(15));
		item.setVlUnitario(new BigDecimal("555.01"));
		input.getItens().add(item);
		
		item = new ItemPedidoDTO();
		item.setCodProduto(1003);
		item.setQtde(new BigDecimal(51));
		item.setVlUnitario(new BigDecimal("123.99"));
		input.getItens().add(item);
		
		String jsonInput = toJson(input);
		
		HttpRequest request = HttpRequest.newBuilder().uri(newUri("http://localhost:8091/v1/Pedido"))
				 									   .setHeader("Accept", "application/json")
				 									   .setHeader("Content-Type", "application/json")
				 									   .POST(BodyPublishers.ofString(jsonInput))
				 									   .build();
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response = send(client, request);
		
		PedidoDTO pedidoRespose = toDto(response);
		System.out.println(pedidoRespose);
	}
	

	private static PedidoDTO toDto(HttpResponse<String> response) {
		try {
			return new ObjectMapper().readValue(response.body(), PedidoDTO.class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}


	private static HttpResponse<String> send(HttpClient client, HttpRequest request) {
		try {
			return client.send(request, BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}


	private static String toJson(PedidoInputDTO input) {
		try {
			return new ObjectMapper().writeValueAsString(input);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	private static URI newUri(String uri) {
		try {
			return new URI(uri);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
	
}
