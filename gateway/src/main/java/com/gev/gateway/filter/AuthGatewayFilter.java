package com.gev.gateway.filter;

import jdk.internal.instrumentation.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class AuthGatewayFilter implements GatewayFilter, Ordered{

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Logger log = null;

        log.info("before");
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> log.info("after"))
        );

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
