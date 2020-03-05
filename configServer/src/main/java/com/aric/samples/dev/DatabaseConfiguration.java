/**
 * 
 */
package com.aric.samples.dev;

import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Dursun KOC
 *
 * https://github.com/dursunkoc/samplespringbootdbconfigserver
 */
@Configuration
@Profile("pg-dev")
public class DatabaseConfiguration {
	@Bean
	public TomcatServletWebServerFactory tomcatFactory() {
	    return new TomcatServletWebServerFactory() {
	    	
	    	@Override
	    	protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
	    		tomcat.enableNaming();
	    		return super.getTomcatWebServer(tomcat);
	    	}

	        
	        @Override
	        protected void postProcessContext(Context context) {
	        	super.postProcessContext(context);
	        	ContextResource contextResource = new ContextResource();
	            contextResource.setName("jdbc/config");
	            contextResource.setType(DataSource.class.getName());
	            contextResource.setProperty("driverClassName", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            contextResource.setProperty("url", "jdbc:sqlserver://10.0.0.197:1433;database=heartbeat");
//	            contextResource.setProperty("factory", "org.apache.tomcat.jdbc.pool.DataSourceFactory");
	            contextResource.setProperty("username", "heartbeat");
	            contextResource.setProperty("password", "heartbeat");
	            context.getNamingResources().addResource(contextResource);
	        }
	    };
	}
}