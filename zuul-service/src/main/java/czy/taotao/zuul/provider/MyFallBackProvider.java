package czy.taotao.zuul.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* FallbackProvider是zuul服务为指定服务提供的异常回调处理组件 */
@Component
class MyFallbackProvider implements FallbackProvider {

    private static final Logger logger = LoggerFactory.getLogger(MyFallbackProvider.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /* 处理的服务名 */
    @Override
    public String getRoute() {
        return "exception";
    }

    /**
     * 异常回调处理方法
     * @param route：路由
     * @param cause：异常
     * @return：回调响应
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, final Throwable cause) {

        logger.info("发生了路由请求错误："+route+","+cause.getLocalizedMessage());

        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            @Override
            public InputStream getBody() throws IOException {
                Map<String,String> body = new HashMap<>();
                body.put("route",route);
                body.put("cause",cause.getLocalizedMessage());
                return new ByteArrayInputStream(objectMapper.writeValueAsBytes(body));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}