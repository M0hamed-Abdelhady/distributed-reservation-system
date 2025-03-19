package com.horines.userservice.utils;

import com.horines.userservice.dtos.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseEntityBuilder {
    private HttpStatus status;
    private String message;
    private Map<String, Object> data;
    private HttpHeaders headers;
    private String locationUrl;

    private ResponseEntityBuilder() {
        this.headers = new HttpHeaders();
        this.status = HttpStatus.OK;
        this.data = new HashMap<>();
    }

    public static ResponseEntityBuilder create() {
        return new ResponseEntityBuilder();
    }

    public ResponseEntityBuilder withStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public ResponseEntityBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseEntityBuilder withData(String key, Object data) {
        this.data.put(key, data);
        return this;
    }

    public ResponseEntityBuilder withHeaders(HttpHeaders headers) {
        this.headers = headers;
        return this;
    }

    public ResponseEntityBuilder withLocation(String locationUrl) {
        this.locationUrl = locationUrl;
        return this;
    }

    public ResponseEntity<Response> build() {
        Response response = Response.builder()
                .status(status.getReasonPhrase())
                .message(message)
                .data(data)
                .build();

        if (locationUrl != null && !locationUrl.isEmpty()) {
            headers.add("Location", locationUrl);
        }

        return new ResponseEntity<>(response, headers, status);
    }
}