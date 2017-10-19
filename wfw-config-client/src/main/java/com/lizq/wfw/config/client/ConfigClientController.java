package com.lizq.wfw.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

	@Value("${hello}")
	private String from;
	
	@GetMapping(value="/")
	public String hello() {
		return from;
	}
}
