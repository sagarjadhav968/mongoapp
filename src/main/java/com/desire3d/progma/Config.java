package com.desire3d.progma;

import java.util.Properties;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration(exclude = { MongoAutoConfiguration.class, MongoDataAutoConfiguration.class })
public class Config {

	@Bean
	public PersistenceManagerFactory getPersistenceManagerFactory() {
		Properties prop = new Properties();
		prop.setProperty("javax.jdo.option.ConnectionURL", "mongodb:localhost:27017/progmadb");
		prop.setProperty("javax.jdo.option.ConnectionUserName", "progmadbuser");
		prop.setProperty("javax.jdo.option.ConnectionPassword", "$progmadbuser@metamagic#2k.18");
		prop.setProperty("javax.jdo.option.Mapping", "mongodb");
		prop.setProperty("datanucleus.schema.autoCreateAll", "true");
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(prop);
		return pmf;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
