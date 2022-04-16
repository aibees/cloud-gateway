package com.cloud.msa.gateway.common.configure;

import com.cloud.msa.gateway.service.ApiPathRouteLocator;
import com.cloud.msa.gateway.service.ApiService;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfigure {
    @Bean
    public RouteLocator routeLocator(ApiService apiService, RouteLocatorBuilder builder) {
        return new ApiPathRouteLocator(apiService, builder);
    }
}
