use javadb;

drop table if exists room;
drop table if exists guest;

create table if not exists room (
rno varchar(4) primary key,
empty tinyint(1) default 0,
check_in_time datetime,
check_out_time datetime
);

create table if not exists guest (
name varchar(100) primary key,
tel varchar(20) not null,
age int(3),
gen tinyint(1)
);