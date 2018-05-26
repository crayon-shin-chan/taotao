package czy.taotao.shop.config;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import czy.taotao.shop.config.DataConfig;
import czy.taotao.shop.mapper.Mapper;
import czy.taotao.shop.service.Service;

@Configuration
@Import(DataConfig.class)
@ComponentScan(basePackageClasses=Service.class)
public class RootConfig {

}