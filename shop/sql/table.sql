drop database if exists shop;
create database shop;

use shop;
drop table if exists user;
create table user(
	id int(11) auto_increment primary key,
	name varchar(20) unique not null,
	age int(11) not null
) engine=innodb default charset=utf8;
