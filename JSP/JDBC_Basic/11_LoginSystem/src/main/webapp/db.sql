create table login_test3(
	l_id varchar2 (20 char) primary key,
	l_pw varchar2 (20 char) not null,
	l_name varchar2 (20 char) not null
);

insert into login_test3 values ('sr','1004','¼Ö¸®');

select * from login_test3

drop table login_test3;