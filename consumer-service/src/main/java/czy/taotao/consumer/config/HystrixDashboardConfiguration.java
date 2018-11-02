package czy.taotao.consumer.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HystrixDashboardConfiguration {

    /**
     * 注册返回/hystrix.stream流数据的Servlet
     * 管理页面通过polling轮训获取最新的熔断器监控情况
     * 注意：一开始未访问服务时，管理页面显示loading字样
     * 直到第一个服务消费请求出现，管理页面才出现监控面板
     * 默认的配置有一个proxy.stream的流，但是好像不起作用
     *
     * 监控页面为/hystrix/monitor，需要设置上面的stream
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
