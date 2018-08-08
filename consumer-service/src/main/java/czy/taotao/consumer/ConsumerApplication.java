package czy.taotao.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *  必须@EnableFeignClients，才可以扫描到FeignClient注解的Bean
 *  必须@EnableHystrixDashboard，才能使用仪表盘监控熔断器情况
 */
@EnableFeignClients
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
