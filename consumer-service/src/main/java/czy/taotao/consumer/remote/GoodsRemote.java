package czy.taotao.consumer.remote;


import czy.taotao.consumer.model.Goods;
import czy.taotao.consumer.remote.fallback.GoodsRemoteFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 使用@EnableFeignClients，才可以扫描到FeignClient注解的Bean，并不需要Component注解
 * 这里获取的结果可以使用jackson反序列化为对象，使用json或者xml序列化规则
 * jackson要求类有默认无参构造函数
 */
@FeignClient(name="shop-service",fallback = GoodsRemoteFallback.class)
public interface GoodsRemote {

    @GetMapping("/goods/all")
    Goods[] getGoodses();

}
