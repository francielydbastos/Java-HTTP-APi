package com.httpstudies;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class PostRequest {
	
	public static final String URL = "http://httpbin.org/forms/post";
	public static final String FILE_JSON = "C:\\Users\\franc\\Documents\\workspace-spring-tool-suite-4-4.13.0.RELEASE\\httpstudies\\src\\com\\httpstudies\\pedido.json";
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder()
				.POST(HttpRequest.BodyPublishers.ofFile(Path.of(FILE_JSON)))
				.timeout(Duration.ofMinutes(2))
				.uri(URI.create(URL))
				.build();
		
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenAccept(System.out::println)
				.join();
		
	}
}
