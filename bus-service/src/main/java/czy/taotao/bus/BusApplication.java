package czy.taotao.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 消息总线服务
 */
@SpringBootApplication
public class BusApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusApplication.class, args);
	}
}
