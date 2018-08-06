package czy.taotao.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*spring boot 不需要配置包扫描，mapper扫描，如果配置了其中一个扫描，那么controller扫描会失效*/
@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}
}
