create table member (
email varchar(100) not null,
pwd varchar(1000) not null,
nick_name varchar(100) not null,
reg_at datetime default current_timestamp,
last_login datetime default null,
grade tinyint default '10',
primary key(email)
) default CHARSET=utf8mb4;

create table product (
pno bigint not null auto_increment,
category varchar(100) default null,
pname varchar(100) not null,
price int not null,
writer varchar(100) not null,
description text,
made_by varchar(100),
reg_at datetime default current_timestamp,
mod_at datetime default current_timestamp,
read_count int default '0',
cmt_qty int default '0',
primary key(pno)
) default CHARSET=utf8mb4;

create table comment (
cno bigint not null auto_increment,
pno bigint not null,
writer varchar(100) not null,
content varchar(2000) not null,
reg_at datetime default current_timestamp,
mod_at datetime default current_timestamp,
primary key (cno)
) default CHARSET=utf8mb4;

-- 새롭게 만든 스키마
drop table member;
create table member (
email varchar(100) not null,
pwd varchar(1000) not null,
nick_name varchar(100) not null,
reg_at datetime default current_timestamp,
last_login datetime default null,
grade tinyint default '10',
primary key(email)
) default CHARSET=utf8mb4;

drop table product;
create table product (
pno bigint not null auto_increment,
category varchar(100) default null,
pname varchar(100) not null,
price int not null,
writer varchar(100) not null,
description text,
made_by varchar(100),
reg_at datetime default current_timestamp,
mod_at datetime default current_timestamp,
read_count int default '0',
cmt_qty int default '0',
primary key(pno)
) default CHARSET=utf8mb4;

drop table comment;
create table comment (
cno bigint not null auto_increment,
pno bigint not null,
writer varchar(100) not null,
content varchar(2000) not null,
reg_at datetime default current_timestamp,
mod_at datetime default current_timestamp,
primary key (cno)
) default CHARSET=utf8mb4;

create table attached_file (
uuid varchar(256) primary key,
save_dir varchar(1000) not null,
file_name varchar(1000) not null,
file_type tinyint(1) default 0,
pno bigint not null,
file_size bigint not null,
reg_at datetime default current_timestamp
) default CHARSET=utf8mb4;

ALTER TABLE springdb.product ADD file_count INT DEFAULT 0 NULL;

create table member_img (
uuid varchar(256) primary key,
save_dir varchar(1000) not null,
file_name varchar(1000) not null,
file_size bigint not null,
email varchar(100) not null,
reg_at datetime default current_timestamp
); default CHARSET=utf8mb4;