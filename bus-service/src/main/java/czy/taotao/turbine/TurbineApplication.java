package czy.taotao.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;


/**
 * 监控页面路径还是/hystrix/monitor
 * 但是流的路径是/turbine.stream
 */
@EnableTurbine
@SpringBootApplication
@EnableHystrixDashboard
public class TurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbineApplication.class, args);
	}
}
