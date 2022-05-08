package com.cloud.msa.gateway.common.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@EnableWebFlux
public class WebConfiguration implements WebFluxConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/blog/**")
                .allowedMethods(HttpMethod.POST.name())
                .allowedMethods(HttpMethod.GET.name())
                .allowedMethods(HttpMethod.OPTIONS.name())
                .allowedOrigins("*");
    }
}