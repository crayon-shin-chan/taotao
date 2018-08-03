package czy.taotao.configcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/* 启用配置服务器 */
@EnableConfigServer
@SpringBootApplication
public class ConfigCenterApplication {

	/**
	 * 配置中心访问配置文件路由占位符：
	 * name：应用程序名称
	 * profile：当前激活的profile
	 * label：当前的标签，在版本控制系统中有明确意义
	 *
	 * 配置中心访问指定配置文件有以下方法：
	 * /{name}-{profile}.(yml|json|properties)：这种方式可以直接获取配置文件内容，而没有其他嵌套的字段
	 * /{label}/name}-{profile}.(yml|json|properties)：这种方式获取结果与上面一样，但是可以加上标签
	 * /{name}/{profile}：这种方式获取到的配置文件会嵌套在返回jaon结果中，作为一个字段返回
	 * /{name}/{profile}/{label}：可以获取指定标签内容
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigCenterApplication.class, args);
	}
}
