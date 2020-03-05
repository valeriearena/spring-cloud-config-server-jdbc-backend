/**
 * 
 */
package com.aric.samples.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TTDKOC
 * 	https://dzone.com/articles/spring-cloud-config-server-for-the-impatient
 * 	http://localhost:8080/api
 * 	http://localhost:8080/actuator
 *	curl -X POST http://localhost:8080/actuator/refresh
 */
@RestController
@RequestMapping(path = "/api")
@RefreshScope
public class SampleApi {

	@Value("${sampleconfigclient.test1}")
	private String aConf;
	
	@GetMapping
	public String getConf() {
		return this.aConf;
	}
}
