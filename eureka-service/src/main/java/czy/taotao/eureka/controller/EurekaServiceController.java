package czy.taotao.eureka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* eureka查看服务列表的控制器 */
@RestController
@RequestMapping("service")
public class EurekaServiceController {

    private static final Logger logger = LoggerFactory.getLogger(EurekaServiceController.class);

    /* 注入客户端 */
    @Autowired
    private DiscoveryClient client;

    /* 获取服务名称列表 */
    @GetMapping("all")
    public List<String> getAll(){
        return this.client.getServices();
    }

    /* 获取指定服务名称的实例列表 */
    @GetMapping("{serviceId}")
    public List<ServiceInstance> getService(@PathVariable String serviceId){
        return this.client.getInstances(serviceId);
    }


}
