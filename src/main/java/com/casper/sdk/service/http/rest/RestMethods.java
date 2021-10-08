package com.casper.sdk.service.http.rest;

import com.casper.sdk.Properties;
import com.casper.sdk.exceptions.HttpException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class RestMethods {

    public Optional<String> restCallGetMethod(final String url) throws HttpException {

        try{
            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(
                            new StringBuilder().append(Properties.properties.get("node-url")).append(":")
                                    .append(Properties.properties.get("node-port")).append("/").append(url).toString()))
                    .header("Accept", "application/json")
                    .header("Content-type", "application/json")
                    .GET()
                    .build();

            final HttpResponse<String> response = HttpClient.newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return Optional.ofNullable(response.body());

        } catch (Exception e) {
            throw new HttpException(e.getMessage());
        }

    }

}
