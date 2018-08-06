drop database if exists shop;
create database shop;
use shop;
drop table if exists goods;
create table goods(
	id int(11) primary key not null auto_increment,
	name varchar(20) not null unique,
	price double not null
)engine=innodb  default charset=utf8;

desc goods;