package czy.taotao.oauth2.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Jwt token转换器
 */
@Component
public class MyJwtTokenConverter extends JwtAccessTokenConverter {

    private static final Logger logger = LoggerFactory.getLogger(MyJwtTokenConverter.class);

    private static final String USER_INFO_KEY = "user";

    /**
     * 生成访问token，向其中加入认证信息
     * @param accessToken：原始token
     * @param authentication：认证信息
     * @return
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Object principal = authentication.getPrincipal();
        /* 将当前认证用户添加为附加信息 */
        accessToken.getAdditionalInformation().put(USER_INFO_KEY, principal);
        return super.enhance(accessToken, authentication);
    }

    /**
     * 解析token
     * @param value：不知道
     * @param map：token的键值对
     * @return：返回原始token
     */
    @Override
    public OAuth2AccessToken extractAccessToken(String value, Map<String, ?> map){
        /* 获取原始token */
        OAuth2AccessToken oauth2AccessToken = super.extractAccessToken(value, map);
        return oauth2AccessToken;
    }

}
