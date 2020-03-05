/**
 * 
 */
package com.spring.cloud.samples.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TTDKOC
 */
@RestController
@RequestMapping(path = "/api")
@RefreshScope
public class ClientController {

	@Value("${sampleconfigclient.test1}")
	private String aConf;
	
	@GetMapping
	public String getConf() {
		return this.aConf;
	}
}
