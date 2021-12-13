--�ּ�

--������ ��� ���� -> alt + x
--���� ���� : alt + s( �� �ٿ� Ŀ�� ����)

--���̺� ����
create table product(
p_name varchar2(10 char),
p_price number(4)
);

--������ ����
insert into PRODUCT values ('����',1000);

--��ȸ
select * from PRODUCT

---------------------------------------------------------
-- ��, row,  �� �ϳ��� ������ 1��. record��� ��.
-- ��, filed, �Ӽ�, colum
-- oracle ��/�ҹ��� ����x �� �빮��

-- DBA : ���� ��������, ���/����, �������� 

-- DBP : CRUD (�츮�� ��ǥ) (Create Read Update Delete)

-- SQL (Structured Query Language) : DB�� �����ϴ� ���
-- �ٸ� ����Ŀ 98.99% ��� 
-- ;  ���� ��
---------------------------------------------------------

--1) ���̺� �����
	-- �л�.  �̸�, ����, ��, ��, ��
create table student(
s_name varchar2(10 char),
s_age number(3),
s_kor number(3),
s_eng number(3),
s_math number(3)
);

--2)������ ����
	--1��
insert into student values ('�ָ�', 28, 100, 90, 90);

insert into student(s_name, s_age) values ('�ؼ�',20);
insert into student(s_kor, s_eng, s_math, s_age, s_name)
values(10, 20, 30, 28, '�ָ�');



--3) ��ȸ
select * from student;
---------------------------------------------------------
-- �Ⱦ��� -> Null
-- �ʵ� ������ �� �ٲٴ���, Null�� �ּ� ��¿����
-- 0���̸� 0������ null�� ����θ� ���߿� ��갰���� �� �� ��ġ����
-- ���̺��� ���鶧 �ɼ��� �� �� ����
-- primary key �����ؾߵǴ� �� �� �ߺ��ȵ�

create table student2(
s_no number(2) primary key,
s_name varchar2(10 char) not null,
s_age number(3) not null,
s_kor number(3) not null,
s_eng number(3) not null,
s_math number(3) not null
);

insert into student2 values (1, '�ָ�', 28, 100, 90, 90);
insert into student2 values (10, '�ؼ�', 25, 90, 90, 90);
insert into student2 values (5, '����', 23, 90, 90, 90);
insert into student2 values (20, '����', 23, 100, 100, 100);

select * from student2;

-- ���̺� ����
drop table student2 -- �̷��� ������(��� ����)
cascade constraint purge; -- ������ �ʳʰ�, ���̺� �ɸ� ���� ������ ���� ����


-- �ɼ�
-- not null : ��ǻ� �⺻, �ʼ�
-- primary key : not null �������, �ߺ�����
-- �� ���̺��� ��ǥ�ϴ� �� => ���̺� �ϳ����� pk �ϳ� �ִ°� ����
-- id => �� ��

-- ������ ���� ( cr Update d)
-- 10�� ����� ���������� 50������ 
update student2
set s_eng = 100
where s_no = 10;

select * from student2;

-- ������ ���� (cru Delete)
-- ������ ���� 
delete student2 where s_no = 20;
s

-- student2 ���̺��� �л� �̸��� 
select s_name from student2;

-- �� ���̺��� �л� �̸��� ����, ��������
select s_name,s_age,s_eng from student2;




