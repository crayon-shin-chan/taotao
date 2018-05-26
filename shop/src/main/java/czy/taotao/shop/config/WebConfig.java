package czy.taotao.shop.config;

import czy.taotao.shop.controller.Controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;



/**
 * @author czy
 * spring mvc 配置
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses=Controller.class)
public class WebConfig extends WebMvcConfigurerAdapter{
	
	/**
	 *  基于注解的请求映射处理器,mvc启用之后已经不需要配置
	 */
	/*@Bean
	public HandlerMapping handlerMapping(){
		RequestMappingHandlerMapping hm = new RequestMappingHandlerMapping();
		hm.setUseSuffixPatternMatch(true);
		hm.setUseTrailingSlashMatch(true);
		return hm;
 	}*/
	
	/** 
	 * 	基于注解的请求映射适配器
	 */
	/*@Bean
	public HandlerAdapter handlerAdapter(){
		RequestMappingHandlerAdapter ha = new RequestMappingHandlerAdapter();
		return ha;
	}
	
*/    /*	
	 * 内部视图解析器
	 */
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setCache(true);
		vr.setPrefix("/html/");
		vr.setSuffix(".html");
		return vr;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}


}