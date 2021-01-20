package com.JobApplication.multipleibanvalidation.models;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientForSingleIBANVerification {

    private WebClient client;

    public WebClientForSingleIBANVerification() {
        this.client = WebClient.builder()
                      .baseUrl("http://localhost:8081")
                      .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                      .build();
    }

    public WebClient getClient() {
        return client;
    }
}
