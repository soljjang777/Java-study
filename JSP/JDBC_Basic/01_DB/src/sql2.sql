create table snack(
s_no number(3) primary key,
s_name varchar2 (20 char) not null,
s_maker varchar2 (20 char) not null,
s_weight number(4,1) not null, --4�ڸ� ���� �Ҽ���1�ڸ�
s_price number(4) not null,
s_exp date not null
);

-- sysdate : ���� �ð� ��¥ (java : date)
insert into snack values (1, '���ĸ�', '���', 60, 1000, sysdate);
insert into snack values (50, '�ɰԶ�', '����', 70, 1200, sysdate);

-- Ư�� �ð� ��¥ :
-- to_date('��','����')
--  		YYYY MM DD HH : MI : SS(����Ŭ�� �빮�ڷ�ó��)
insert into snack values (3, '������', '�Ե�', 70.5, 1300, to_date('2021-12-01','YYYY-MM-DD'));

select * from snack;

drop table snack cascade constraint purge;