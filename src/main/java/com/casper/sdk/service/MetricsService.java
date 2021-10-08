package com.casper.sdk.service;

import com.casper.sdk.service.http.rest.RestMethods;

import java.util.Optional;

public class MetricsService {

    RestMethods restMethods;

    public MetricsService(){
        restMethods = new RestMethods();
    }

    public String getMetrics() throws Throwable {

        Optional<String> result = restMethods.restCallGetMethod("metrics");
        return (result.isEmpty()) ? null : result.get();

    }
}
