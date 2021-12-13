--pk, 이름, 체중, 키, bmi(2자리), 결과 
-- 테이블 - 

create table bmi (
b_number number(3) primary key,
b_name varchar2(20 char) not null,
b_weight number(6,2) not null,
b_height number(6,2) not null,
b_bmi number(5,2) not null,
b_result varchar2(10 char) not null
);

create sequence bmi_seq;


select * from bmi;
drop table bmi cascade constraint purge;