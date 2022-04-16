package com.cloud.msa.gateway.domain.repo;

import com.cloud.msa.gateway.domain.vo.ApiRoute;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRouteRepository extends R2dbcRepository<ApiRoute, Long> {

}
