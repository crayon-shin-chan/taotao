/* 配置了客户端信息数据，这里的权限需要以ROLE_开头 */
use spring_oauth2_demo;
insert into oauth_client_details (client_id,resource_ids,client_secret,scope,authorized_grant_types,web_server_redirect_uri,authorities,access_token_validity,refresh_token_validity, additional_information, autoapprove)
values
('shop','goods','123456','write,read','refresh_token,password,implicit,authorization_code','http://baidu.com,http://localhost:3000','ROLE_ADMIN',1,0,null,'true');