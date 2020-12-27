package com.devdaljeet.grademanagementsystem.database;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/** Configure the connection to H2 database
 * @author Daljeet Singh (Dev-Daljeet)
 * @version 1.0
 */
@Configuration
public class DatabaseConfig {
	
	/** Connects to the DatabaseAcess class that will create query
	 * @param dataSource An instance of class DataSource
	 * @return NamedParameterJdbcTemplate An instance of class NamedParameterJdbcTemplate
	 */
	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource)
	{
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	/** Create connection to the database - h2
	 * @return dataSource An instance of class DataSource
	 */
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:testdb");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	
	/**Define default SQL files that will be executed when project starts 
	 * @return dataSource An instance of class DataSource
	 */
	@Bean
	public DataSource loadSchema()
	{
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("classpath:schema.sql").addScript("classpath:userSchema.sql").build();
	}
}
