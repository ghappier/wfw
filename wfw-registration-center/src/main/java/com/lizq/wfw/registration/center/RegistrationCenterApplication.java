package com.lizq.wfw.registration.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author hhly-pc
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistrationCenterApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegistrationCenterApplication.class, args);
	}
}
