package czy.taotao.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import czy.taotao.shop.config.DataConfig;

@Configuration
@Import(DataConfig.class)
public class RootConfig {
	
	
}