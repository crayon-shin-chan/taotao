use spring_oauth2_demo;
insert into oauth_client_details (appId,resourceIds,appSecret,scope,grantTypes,redirectUrl,authorities,access_token_validity,refresh_token_validity)
values
('1','resource','key','','password','http://baidu.com','',1,1);