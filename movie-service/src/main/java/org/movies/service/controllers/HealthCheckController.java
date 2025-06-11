package org.movies.service.controllers;

import org.movies.service.dtos.Response;
import org.movies.service.utils.Constants;
import org.movies.service.utils.ResponseEntityBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(Constants.API_VERSION + "/movies")
public class HealthCheckController {
    @Value("${SERVER_NAME:Unknown}")
    private String serverName;

    @GetMapping("/healthz")
    public ResponseEntity<Response> healthCheck() {
        log.info("Health check request received from {}", serverName);
        return ResponseEntityBuilder.create().withStatus(HttpStatus.OK)
                .withMessage("OK")
                .withData("status", "UP")
                .withData("Server", serverName)
                .build();
    }
}