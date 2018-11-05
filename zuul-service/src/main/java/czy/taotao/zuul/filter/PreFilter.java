package czy.taotao.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * 配置一个pre类型的Zuul过滤器，用于在请求被路由之前拦截请求
 */
@Component
public class PreFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(PreFilter.class);
    private static final Random random = new Random();

    @Override
    public boolean isStaticFilter() {
        return false;
    }

    @Override
    public boolean isFilterDisabled() {
        return false;
    }

    @Override
    public ZuulFilterResult runFilter() {
        return super.runFilter();
    }

    /* 过滤器类型，以字符串给出？ */
    @Override
    public String filterType() {
        return "pre";
    }

    /* 过滤器顺序 */
    @Override
    public int filterOrder() {
        return 0;
    }

    /* 是否应该过滤 */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 拦截运行方法，为每个请求线程运行一次
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        /* 获取请求上下文 */
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();

        logger.info("接收到一个请求："+request.getRequestURI());

        int r = random.nextInt(10);
        if(r%2==1){
            logger.info("随机出一个奇数，请求不会被路由");
            /* 设置是否路由请求 */
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(500);
            response.setContentType("text/plain;charset=UTF-8");
            context.setResponseBody("因为运气不佳，请求被拦截");
        }else{
            logger.info("随机出一个偶数，请求将会被路由");
            context.setSendZuulResponse(true);
            context.setResponseStatusCode(200);
        }
        return null;
    }
}
