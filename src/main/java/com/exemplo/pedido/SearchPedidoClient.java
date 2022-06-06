package com.exemplo.pedido;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SearchPedidoClient {

	public static void main(String[] args) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request  = HttpRequest.newBuilder().uri(newUri("http://localhost:8092/v1/Pedido"))
												       .header("Accept", "application/json")
												       .GET()
												       .build();
		HttpResponse<String> response = send(client, request);
		List<PedidoOutDTO> listDto = toListDto(response);
		listDto.forEach(System.out::println);
		
		request  = HttpRequest.newBuilder().uri(newUri("http://localhost:8092/v1/Pedido/4/itens"))
					       .header("Accept", "application/json")
					       .GET()
					       .build();
		response = send(client, request);
		List<ItemPedidoDTO> listItensDto = toListItensDto(response);
		listItensDto.forEach(System.out::println);
		
	}

	private static List<ItemPedidoDTO> toListItensDto(HttpResponse<String> response) {
		try {
			return new ObjectMapper().readValue(response.body(), new TypeReference<List<ItemPedidoDTO>>() {});
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	private static List<PedidoOutDTO> toListDto(HttpResponse<String> response) {
		try {
			return new ObjectMapper().readValue(response.body(), new TypeReference<List<PedidoOutDTO>>() {});
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

	private static URI newUri(String uri) {
		try {
			return new URI(uri);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
	
}
