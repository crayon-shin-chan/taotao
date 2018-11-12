package czy.taotao.oauth2.config;

import czy.taotao.oauth2.jwt.MyJwtTokenConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import javax.sql.DataSource;

/**
 * 认证服务配置，与spring security的配置一样
 * spring security是用户访问单体应用时的安全配置
 * oauth2 是oauth2客户端访问认证服务器时的安全配置
 */
@Configuration
public class Oauth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MyJwtTokenConverter jwtTokenConverter;

    @Bean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }

    /* 客户端详情服务配置，类似于用户详情配置，但是由于客户端一般不会随意增删，可以配置于内存中 */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        /* 使用数据库存储客户端信息 */
        clients.jdbc(dataSource);
    }


    /* 端点安全配置 */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        /* 密码编码器 */
        security.passwordEncoder(NoOpPasswordEncoder.getInstance())
                /* jwt公钥访问权限，允许所有*/
                .tokenKeyAccess("permitAll()")
                /* 检查token正确性端点权限，需要认证后访问 */
                .checkTokenAccess("isAuthenticated()")
                .realm("hehe")
                .allowFormAuthenticationForClients();
    }

    /* 端点配置 */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        /* token转换器，定义额token生产的逻辑 */
        endpoints.accessTokenConverter(jwtTokenConverter)
                /* token存储 */
                .tokenStore(tokenStore());
    }
}
