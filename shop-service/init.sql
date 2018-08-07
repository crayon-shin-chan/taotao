drop database if exists shop;
create database shop;
use shop;
drop table if exists goods;
create table goods(
	id int(11) primary key not null auto_increment,
	name varchar(20) not null unique,
	price double not null
)engine=innodb  default charset=utf8;

insert into goods (name,price) values ("iphone8",8888),("小米MIX3",5000),("华为META10",4300);

desc goods;