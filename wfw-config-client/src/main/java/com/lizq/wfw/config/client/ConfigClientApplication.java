package com.lizq.wfw.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 
 * @author hhly-pc
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
}
