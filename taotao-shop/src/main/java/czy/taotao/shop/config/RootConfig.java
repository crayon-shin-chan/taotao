package czy.taotao.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.context.annotation.Bean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.core.env.Environment;
import javax.sql.DataSource;
import java.lang.System;
import java.lang.Exception;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class RootConfig {
	
	@Autowired
	public Environment env;

	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driverClass"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("user"));
		ds.setPassword(env.getProperty("jdbc.password"));
		ds.setInitialSize(10);
		return ds;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource){
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setConfigLocation(new ClassPathResource("mybatis.xml"));
		SqlSessionFactory sf = null;
		try{
			sf = bean.getObject();
		}catch(Exception ex){
			System.out.println("获取SqlSessionFactory失败");
			System.out.println(ex);
		} 
		return sf;
	}
	
}