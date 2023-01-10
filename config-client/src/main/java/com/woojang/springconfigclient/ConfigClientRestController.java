package com.woojang.springconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigClientRestController {
    private final String serviceProfile;
    private final String port;

    public ConfigClientRestController(@Value("${service.client.text}") final String serviceProfile,
                                      @Value("${server.port}") final String port) {
        this.serviceProfile = serviceProfile;
        this.port = port;
    }

    @GetMapping("/service/text")
    public ResponseEntity<String> getText() {
        return ResponseEntity.ok(this.serviceProfile);
    }
}
