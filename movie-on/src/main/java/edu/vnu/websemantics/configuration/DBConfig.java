package edu.vnu.websemantics.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

/**
 * 
 * This class is used to establish a connection to the mongoDB database.
 *
 */
@Configuration
@ComponentScan("edu.vnu.websemantics")
@PropertySource("classpath:application-dev.properties")
public class DBConfig {

	@Autowired
	Environment env;
	@Autowired

	public DBConfig() {

	}
	@Bean
	public MongoDbFactory getMongoDbFactory() throws Exception {
		System.out.print(env.getProperty("host"));
		return new SimpleMongoDbFactory(
				new MongoClient(env.getProperty("host"), env.getProperty("port", Integer.class)),
				env.getProperty("dbName"));
	}

	@Bean
	public MongoTemplate getMongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(getMongoDbFactory());
		return mongoTemplate;
	}
}
