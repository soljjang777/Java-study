create table member(
m_no number(3) primary key,
m_name varchar(20 char) not null,
m_age number(2) not null
);

create sequence member_seq;

insert into member values (member_seq.nextval, '�׽�Ʈ', 20);

select * from member;