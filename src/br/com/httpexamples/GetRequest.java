package br.com.httpexamples;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class GetRequest {
	
	public static final String URL_GET = "https://jsonplaceholder.typicode.com/posts";
	public static final String URL_GET2 = "http://httpbin.org/get";
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		//cliente HTTP
		HttpClient client = HttpClient.newHttpClient();
	
		// criar a requisi��o
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.timeout(Duration.ofSeconds(10))
				.uri(URI.create(URL_GET2))
				.build();
		
		// enviando uma solicitacao
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		// imprimir o conte�do recebido
		System.out.println(response.statusCode());
		System.out.println(response.body());
	}
}
