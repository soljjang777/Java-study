create table account_1 (
a_name varchar2 (20 char) not null,
a_id varchar2 (30 char) primary key,
a_pw varchar2 (30 char) not null,
a_gender char (1 char) not null,
a_addr varchar2 (100 char) not null,
a_interest varchar2 (100 char) not null,
a_introduce varchar2 (200 char) not null,
a_img varchar2 (300 char) not null
);

insert into account_1 values ('sr','id','pw','여','주소','관심사','자기소개','asd.jsp');

select * from account_1;