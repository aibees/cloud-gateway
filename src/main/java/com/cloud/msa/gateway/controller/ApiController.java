package com.cloud.msa.gateway.controller;

import com.cloud.msa.gateway.service.ApiService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ApiController {
    private final ApiService apiService;

    @GetMapping("/all")
    public Object getRoutes() {
        return apiService.findApiRoutes();
    }
}
