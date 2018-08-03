package czy.taotao.eurekacenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaCenterApplication {

	/**
	 * 服务中心管理面板包含两个端点：
	 * /：主管理面板
	 * /lastn：也是一个面板，不过内容不同
	 */
	public static void main(String[] args) {
		SpringApplication.run(EurekaCenterApplication.class, args);
	}
}
