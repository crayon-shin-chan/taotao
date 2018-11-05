package czy.taotao.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/* 在保护模式关闭时，如果多个实例其中出现失效的，则zuul还有30秒左右时间会去访问这个实例 */

/**
 * zuul独有的端点为
 * /actuator/routes：路由路径与服务名映射，POST方法访问时强制刷新路由
 * /actuator/routes/details：路由详情映射
 * /actuator/filters：zuul过滤器类型与过滤器列表的映射
 */


/* 好像不需要这个Server注解，一个Proxy即可 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
}
