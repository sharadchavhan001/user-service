package com.app.product_service.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerYamlController {

    @GetMapping("/api.yaml")
    public ResponseEntity<Resource> getSwaggerYaml() {
        Resource resource = new ClassPathResource("swagger/api.yaml");
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/x-yaml");
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}
