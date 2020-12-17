package com.gev.gateway.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

public class MonoUtil {
//    public static Mono<Void> buildServerResponse(ServerHttpResponse response, HttpStatus httpStatus, String msg)  {
//        response.setStatusCode(HttpStatus.OK);
//        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
//        try {
//            return response.writeWith(Mono.just(response.bufferFactory().wrap(JSONObject.toJSONString(ResponseResult.error(httpStatus.value(), msg)).getBytes("UTF-8"))));
//        } catch (UnsupportedEncodingException e) {
//            return response.writeWith(Mono.just(response.bufferFactory().wrap(JSONObject.toJSONString(ResponseResult.error(httpStatus.value(), "UnsupportedEncodingException")).getBytes())));
//        }
//    }

    public static Mono<Void> getNeedToken(ServerHttpResponse response) {
        return buildServerResponse(response, -1, "Invalid token");
    }


    public static Mono<Void> buildServerResponse(ServerHttpResponse response, int status, String msg)  {
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().add("Content-Type", "application/json");
        try {
            return response.writeWith(Mono.just(response.bufferFactory().wrap(msg.getBytes())));
        } catch (Exception e) {
            return response.writeWith(Mono.just(response.bufferFactory().wrap(e.getMessage().getBytes())));
        }
    }
}
