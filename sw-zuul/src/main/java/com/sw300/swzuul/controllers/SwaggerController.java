package com.sw300.swzuul.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Component
@Primary
@EnableAutoConfiguration
public class SwaggerController implements SwaggerResourcesProvider {


    private final RouteLocator routeLocator;

    public SwaggerController(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    @Override
    public List get() {
        List<SwaggerResource> resources = routeLocator.getRoutes().stream().distinct().map(route -> {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(route.getLocation());
            swaggerResource.setLocation(route.getFullPath().replace("**", "v2/api-docs"));
            swaggerResource.setSwaggerVersion(SWAGGER_2.getVersion());

            return swaggerResource;

        }).collect(Collectors.toList());

        return resources;
    }
}
