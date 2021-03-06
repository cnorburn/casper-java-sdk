package com.casper.sdk.exceptions;

/**
 * Custom HTTP Exception
 */
public class HttpException extends Exception {

    public HttpException(final String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
