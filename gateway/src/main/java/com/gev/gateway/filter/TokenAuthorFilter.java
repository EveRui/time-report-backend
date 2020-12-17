package com.gev.gateway.filter;

import com.gev.gateway.util.JwtUtils;
import com.gev.gateway.util.MonoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class TokenAuthorFilter implements GlobalFilter {
    @Autowired
    private JwtUtils jwtUtils;

    final Logger logger = LoggerFactory.getLogger(TokenAuthorFilter.class);

    private String parseJwt(ServerHttpRequest request) {
        String headerAuth = request.getHeaders().getFirst("Authorization");
        System.out.println("Gateway headerAuth: " + headerAuth);
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }

        return null;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            logger.info("Global Jwt Filter executed");
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();
            String jwt = parseJwt(request);
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                String username = jwtUtils.getUserNameFromJwtToken(jwt);
                System.out.println("Gateway username: " + username);
                return chain.filter(exchange);
            }
            else {
                System.out.println("Gateway jwt check fails");
                response.setStatusCode(HttpStatus.FORBIDDEN);
                return MonoUtil.getNeedToken(response);
            }
    }
}
