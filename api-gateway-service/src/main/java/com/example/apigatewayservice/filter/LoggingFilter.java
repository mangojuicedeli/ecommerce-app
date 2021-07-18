package com.example.apigatewayservice.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LoggingFilter extends AbstractGatewayFilterFactory<LoggingFilter.Config> {

    @Data
    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }

    public LoggingFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
//        return (exchange, chain) -> {
//            ServerHttpRequest request = exchange.getRequest();
//            ServerHttpResponse response = exchange.getResponse();
//
//            log.info("global filter baseMessage: {}", config.getBaseMessage());
//
//            // global PRE-log
//            if (config.isPreLogger()) {
//                log.info("global filter start: request id -> {}", request.getId());
//            }
//
//            // global POST-log
//            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//                if (config.isPostLogger()) {
//                    log.info("global filter end: response code -> {}", response.getStatusCode());
//                }
//            }));
//        };
        GatewayFilter filter = new OrderedGatewayFilter((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("logging filter baseMessage: {}", config.getBaseMessage());

            // logging PRE-log
            if (config.isPreLogger()) {
                log.info("logging PRE-filter: request id -> {}", request.getId());
            }

            // logging POST-log
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if (config.isPostLogger()) {
                    log.info("logging POST-filter: response code -> {}", response.getStatusCode());
                }
            }));
        }, Ordered.LOWEST_PRECEDENCE); // 필터의 우선 순위를 설정할 수 있다. 지금은 LOWEST 이므로 필터 중 제일 마지막 순서로 실행된다.

        return filter;
    }
}
