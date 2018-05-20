package czy.taotao.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.lang.System;

@Configuration
public class RootConfig {

	@Bean
	DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("dbc:mysql://localhost:3306/test");
		ds.setUsername("root");
		ds.setPassword("123456");
		ds.setInitialSize(10);
		return ds;
	}

	@Bean
	SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource ){
		System.out.println(((BasicDataSource)dataSource).getDriverClassName());
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		//bean.setConfigLocation(new ClassPathResource("mybatis.xml"));
		return bean;
	}
	
}