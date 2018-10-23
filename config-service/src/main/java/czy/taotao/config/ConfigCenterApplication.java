package czy.taotao.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/* 启用配置服务器 */
@EnableConfigServer
@SpringBootApplication
public class ConfigCenterApplication {

	/**
	 * 配置中心所有路由为：
	 *
	 * /error：错误页面
	 * /encrypt,methods=POST：对请求体进行加密，返回加密后内容
	 * /encrypt/{name}/{profiles},methods=POST：对请求体进行加密，默认情况下所有的都使用相同的密钥对，如果需要定制密钥对，需要另外配置
	 * /decrypt,methods=POST：对请求体进行解密，返回明文
	 * /decrypt/{name}/{profiles},methods=POST：对请求体进行揭秘，路径参数无用
	 * /encrypt/status],methods=GET：加密是否启用
	 * /key],methods=GET：获取公钥
	 * /key/{name}/{profiles},methods=GET：也是获取公钥，返回值与上面一样
	 *
	 * 配置中心访问配置文件路由占位符：
	 * name：应用程序名称
	 * profile：当前激活的profile
	 * label：当前的标签，在版本控制系统中有明确意义
	 *
	 * 配置中心访问指定配置文件有以下方法：
	 * /{name}-{profile}.(yml|json|properties)：这种方式可以直接获取配置文件内容，而没有其他嵌套的字段
	 * /{label}/name}-{profile}.(yml|json|properties)：这种方式获取结果与上面一样，但是可以加上标签
	 * /{name}/{profile}：这种方式获取到的配置文件会嵌套在返回json结果中，作为一个字段返回
	 * /{name}/{profile}/{label}：可以获取指定标签内容
	 *
	 * 配置中心有关加密的路由有：
	 * /key：获取加密公钥的方法，返回公钥文本
	 * /encrypt/status：获取当前加密状态
	 * /encrypt：对请求体进行加密
	 * /decrypt：对请求体进行解密
	 * /encrypt/{name}/{profiles}：使用指定name、profiles对应的key对请求体加密
	 * /decrypt/{name}/{profiles}：使用指定name、profiles对应的key对请求体解密
	 * 注意：开启加密之后，原有配置文件端点返回数据并不会加密，还是明文，可能配置不对
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigCenterApplication.class, args);
	}
}
