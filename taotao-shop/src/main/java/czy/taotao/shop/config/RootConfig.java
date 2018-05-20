package czy.taotao.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.Driver;
import java.lang.System;

@Configuration
public class RootConfig {

	@Bean
	DataSource dataSource() {
		System.out.println("创建了数据源");
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("dbc:mysql://localhost:3306/test");
		ds.setUsername("root");
		ds.setPassword("123456");
		return ds;
	}

}