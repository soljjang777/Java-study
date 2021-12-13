create table snack(
s_no number(10) primary key,
s_name varchar2 (20 char) not null,
s_maker varchar2 (20 char) not null,
s_weight number(4,1) not null, --4�ڸ� ���� �Ҽ���1�ڸ�
s_price number(4) not null,
s_exp date not null
);

-- ���� �ڵ����� �ø��� : sequence(���̺�� ����) - ����Ŭ ���
create sequence ��������;
create sequence snack_seq;
-- ��������.nextval �� ���

insert into snack values (snack_seq.nextval, '���ĸ�', '���', 60, 1000, sysdate);
insert into snack values (snack_seq.nextval, '�����', '����', 50, 1100, sysdate);
insert into snack values (snack_seq.nextval, 'Ģ��', '�Ե�', 10, 2000, sysdate);
insert into snack values (snack_seq.nextval, '����', '������', 20, 900, sysdate);
insert into snack values (snack_seq.nextval, '���ڱ�', '������', 20, 900, sysdate);
insert into snack values (snack_seq.nextval, '�Ե�������', '����', 20, 1600, sysdate);
insert into snack values (snack_seq.nextval, '���廩����', '����', 20, 1600, sysdate);

select * from snack;
drop table snack cascade constraint purge;