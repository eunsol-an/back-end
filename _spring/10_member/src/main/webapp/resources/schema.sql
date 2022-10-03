create table member (
email varchar(100) not null,
pwd varchar(1000) not null,
nick_name varchar(100) not null,
reg_at datetime default current_timestamp,
last_login datetime default null,
grade tinyint default '10',
primary key(email)
) default CHARSET=utf8mb4;