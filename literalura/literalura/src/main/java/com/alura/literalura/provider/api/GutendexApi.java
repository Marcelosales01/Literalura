package com.alura.literalura.provider.api;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class GutendexApi {

    private static String BASE_URL = "https://gutendex.com/books";

    private HttpClient createClient() {
        return HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
    }

    public HttpRequest createRequestToGetBook(String title) {

        String url = BASE_URL + "?search=" + title.replace(" ", "%20");

        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
    }

    public HttpResponse<String> getResponse(HttpRequest request) {
        HttpClient client = createClient();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.out.println("Não foi estabelecer conexão com a ExchangerateApi. Finalizando programa...");
            System.exit(0);
        }
        return null;
    }

}