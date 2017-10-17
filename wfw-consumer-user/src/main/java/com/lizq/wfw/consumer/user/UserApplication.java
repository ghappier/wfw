package com.lizq.wfw.consumer.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author hhly-pc
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserApplication {
	
	@Bean
	@LoadBalanced
	protected RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
