package com.cloud.msa.gateway.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "api_route")
public class ApiRoute {
    @Id
    private long id;
    private String path;
    private String method;
    private String uri;
    private String verify;
}
