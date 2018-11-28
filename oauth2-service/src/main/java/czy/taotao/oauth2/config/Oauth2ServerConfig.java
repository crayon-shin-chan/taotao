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

    /* 客户端详情服务配置，类似于用户详情配置，但是由于客户端一般不会随意增删，可以配置于内存中
     * 客户端详情配置，是用于认证端口的，即/oauth/authorize这个端口，客户端各个属性如下：
     * clientId：客户端ID，唯一标识
     * resourceIds：客户端资源ID，多个ID以逗号分隔
     * secret：客户端密钥
     * scope：客户端域，多个域使用逗号分隔
     * authorized_grant_types：客户端授权类型，多个以逗号分隔
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        /* 使用数据库存储客户端信息 */
        clients.jdbc(dataSource);
    }


    /* 端点安全配置，这里的端点安全，实际上是以client_id为用户名,client_secret为密码的客户端安全配置，权限也是客户端具有的权限
     * 可以采用Http Basic认证来使用用户名/密码
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        /* 密码编码器 */
        security.passwordEncoder(NoOpPasswordEncoder.getInstance())
                /* jwt公钥访问权限，允许所有*/
                .tokenKeyAccess("permitAll()")
                /* 检查token正确性端点权限，需要认证后访问 */
                .checkTokenAccess("hasRole('ADMIN')")
                .realm("hehe")
                /* 是否允许表单认证 */
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
