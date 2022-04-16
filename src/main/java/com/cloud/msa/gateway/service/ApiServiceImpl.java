package com.cloud.msa.gateway.service;

import com.cloud.msa.gateway.domain.repo.ApiRouteRepository;
import com.cloud.msa.gateway.domain.vo.ApiRoute;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ApiRouteRepository routeRepository;

    @Override
    public Flux<ApiRoute> findApiRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public Mono<ApiRoute> findApiRoute(Long id) {
        return null;
    }
}
