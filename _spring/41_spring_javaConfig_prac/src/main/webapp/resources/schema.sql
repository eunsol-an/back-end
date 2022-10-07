create table board (
bno bigint not null auto_increment,
title varchar(200) not null,
content text not null,
writer varchar(100) not null,
reg_at datetime default now(),
mod_at datetime default now(),
read_count int(10) default 0,
primary key (bno)
);