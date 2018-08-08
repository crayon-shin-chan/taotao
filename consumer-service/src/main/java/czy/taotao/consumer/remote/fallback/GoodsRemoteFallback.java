package czy.taotao.consumer.remote.fallback;

import czy.taotao.consumer.model.Goods;
import czy.taotao.consumer.remote.GoodsRemote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 熔断器fallback类，需要实现FeignClient客户端接口，并且实现远程调用方法
 * 在FeignClient注解中将fallback属性设置为实现类的class
 * 即可达到熔断效果
 *
 * 这里有一个问题：熔断回调方法，应该返回什么值
 * 由于原来方法是返回Goods对象，自动进行了响应的反序列化
 * 则熔断回调方法不能返回字符串，否则类型不兼容
 * 而如果熔断回调方法想要返回字符串，则原方法也要返回字符串
 * 那么反序列化就需要手动编码进行
 * 目前没有特别合适的返回对象，可以来对返回值进行判断
 * null是个简单方式，不过不明确
 */
@Component
public class GoodsRemoteFallback implements GoodsRemote {

    private static final Logger logger = LoggerFactory.getLogger(GoodsRemoteFallback.class);

    @Override
    public Goods[] getGoodses() {
        logger.info("调用getGoodses回调方法");
        return new Goods[0];
    }
}
