package in.ajay.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;


import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerRequest;

import java.util.Set;


@Component
public class MyFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		System.out.println("Filter Executed...");
		
		HttpRequest request = exchange.getRequest();
		HttpHeaders headers = request.getHeaders();
		Set<String> keyset = headers.keySet();
		for(String key : keyset) {
			
			System.out.println(key+" -- ");
			System.out.println(headers.getValuesAsList(key));
			
		}
		
		/*
		 * ServerHttpRequest request = exchange.getRequest();
		 * org.springframework.http.HttpHeaders headers = request.getHeaders();
		 * Set<String> keyset = headers.keySet(); for (String key : keyset) {
		 * System.out.println(key+" -- ");
		 * System.out.println(headers.getValuesAsList(key)); }
		 */
		
		
		return chain.filter(exchange);
	}

	
}
