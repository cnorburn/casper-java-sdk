package com.casper.sdk.service.http.rpc;

import java.util.HashMap;

/**
 * Simple class to build up the rpc json call
 * The class is instantiated and it's json conversion used as the rpc payload
 */
public class Method {

    private final int id = 1;
    private final String jsonrpc = "2.0";
    private String method;
    private HashMap<String, Object> params;

    public Method() {}

    public Method(final String method) {
        this.method = method;
    }

    public Method(final String method, final HashMap<String, Object> params) {
        this.method = method;
        this.params = params;
    }

    public int getId() {
        return id;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public HashMap<String, Object> getParams() {
        return params;
    }
}
