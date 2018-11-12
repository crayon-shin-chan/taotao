package czy.taotao.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


/* 启用认证服务器，其他服务会调用认证服务器的接口，完成登陆、获取令牌等功能 */

/**
 * 认证服务器端点为：
 * /oauth/authorize：认证端点，GET、POST方法都可以访问，参数为
 * 		client_id：客户端id，客户端详情中配置，客户端认证时会自动带上
 * 		state：状态
 * 		redirect_uri：重定向URL，认证成功后的重定向URL，一般为访问的客户端URL
 * 		response_type：响应类型
 * 貌似还可以带有其他客户端详情的参数
 *
 * /oauth/token：获取访问token，GET、POST方法都可以访问，参数为
 * 		client_id：客户端id，用于标识客户端类型，不能为空，也不能是authenticated client
 * 		grant_type：授权类型
 * 		scope：
 *
 */


@SpringBootApplication
@EnableAuthorizationServer
public class Oauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2Application.class, args);
	}
}
