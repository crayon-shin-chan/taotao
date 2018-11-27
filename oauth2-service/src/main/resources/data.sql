use spring_oauth2_demo;
insert into oauth_client_details (client_id,resource_ids,client_secret,scope,authorized_grant_types,web_server_redirect_uri,authorities,access_token_validity,refresh_token_validity)
values
('1','resource','key',null,'password,implicit,authorization_code','http://baidu.com,http://localhost:3000','',1,1);