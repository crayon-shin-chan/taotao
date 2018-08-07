package czy.taotao.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *  作为Eureka客户端不需要其他配置，这样就可以实现服务注册
 *  并不需要以下注解
 *	@EnableEurekaClient
 *	@EnableDiscoveryClient
 */
@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}
}
