package com.cloud.msa.gateway.service;

import com.cloud.msa.gateway.domain.vo.ApiRoute;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.BooleanSpec;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import reactor.core.publisher.Flux;

@AllArgsConstructor
public class ApiPathRouteLocator implements RouteLocator {

    private final ApiService apiService;
    private final RouteLocatorBuilder routeLocatorBuilder;

    @Override
    public Flux<Route> getRoutes() {
        RouteLocatorBuilder.Builder routeBuilder = routeLocatorBuilder.routes();

        return apiService.findApiRoutes().map(
                api_route -> routeBuilder.route(String.valueOf(api_route.getId()),
                            predicateSpec -> setPredicateSpec(api_route, predicateSpec)
                        )
        ).collectList()
        .flatMapMany(
                builders -> routeBuilder.build().getRoutes()
        );
    }

    private Buildable<Route> setPredicateSpec(ApiRoute route, PredicateSpec spec) {
        BooleanSpec booleanSpec = spec.path(route.getPath());
        if (!StringUtils.isEmpty(route.getMethod())) {
            booleanSpec
//                    .and()
//                    .header("x-header-verify", route.getVerify())
                    .and()
                    .method(route.getMethod());
        }
        return booleanSpec.uri(route.getUri());
    }
}
