package czy.taotao.zuul.config;

import org.springframework.cloud.netflix.zuul.filters.post.LocationRewriteFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* zuul内建，但是并未默认使用的过滤器配置 */
@Configuration
public class ZuulFilterConfiguration {

    /**
     * 当web程序使用HTTP状态码3XX重定向时，直接写入的重定向URL为服务的原始路径
     * LocationRewriteFilter过滤器可以重写Location标头
     * 但是如果重定向到外部URL时，则不应重写
     */
    @Bean
    public LocationRewriteFilter locationRewriteFilter() {
        return new LocationRewriteFilter();
    }

}
