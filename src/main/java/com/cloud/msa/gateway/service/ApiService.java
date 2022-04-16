package com.cloud.msa.gateway.service;

import com.cloud.msa.gateway.domain.vo.ApiRoute;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ApiService {
    Flux<ApiRoute> findApiRoutes();

    Mono<ApiRoute> findApiRoute(Long id);
}
