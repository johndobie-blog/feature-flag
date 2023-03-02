package com.sdbc.demo.web.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConditionalOnProperty(name = "echo.enabled", havingValue = "true", matchIfMissing = false)
public class EchoController {

    public static final String ECHO_ENDPOINT = "/echo";

    @GetMapping(ECHO_ENDPOINT)
    public String echo(@RequestParam String message) {
        return message;
    }
}
