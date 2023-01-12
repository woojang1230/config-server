package com.woojang.springconfigclient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RefreshScope
@RestController
public class ConfigClientRestController {
    private static final Log LOG = LogFactory.getLog( ConfigClientRestController.class );
    private final String serviceProfile;
    private final String port;
    private final String dburl;

    public ConfigClientRestController(@Value("${service.client.text}") final String serviceProfile,
                                      @Value("${server.port}") final String port,
                                      @Value("${spring.datasource.url}") final String dburl) {
        this.serviceProfile = serviceProfile;
        this.port = port;
        this.dburl = dburl;
    }

    @GetMapping("/service/text")
    public ResponseEntity<String> getText() {
        LOG.info("HIHIHI!!!!!!!!!!");
        return ResponseEntity.ok(this.dburl);
    }
}
