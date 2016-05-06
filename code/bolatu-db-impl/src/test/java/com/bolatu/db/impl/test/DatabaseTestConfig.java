package com.bolatu.db.impl.test;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
@EnableMongoRepositories(mongoTemplateRef = "mongoOperations", basePackages = {"com.bolatu.db.impl.repository"})
@ComponentScan(basePackages = { "com.bolatu.db.impl.dao" })
@PropertySource("classpath:db-config-test.properties")
public class DatabaseTestConfig {

	@Value("${db.connection.url}")
	private String dbUrl;

	@Value("${db.username}")
	private String username;

	@Value("${db.password}")
	private String password;

	@Value("${db.databasename}")
	private String databasename;

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		String formattedUrl = MessageFormat.format(dbUrl, username, password,
				databasename);
		return new SimpleMongoDbFactory(new MongoClient(new MongoClientURI(
				formattedUrl)), databasename);
	}

	@Bean
	public MongoTemplate mongoOperations() throws Exception {
		DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
		MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, new MongoMappingContext());
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);
		return mongoTemplate;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
