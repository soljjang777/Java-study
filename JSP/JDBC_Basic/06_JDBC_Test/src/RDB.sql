-- RDBMS(Relational)�����ͺ��̽��޴�����Ʈ�ý���
-- ���̺��� ���踦 �߽����� ����..

-- ���� ȫ����� ¥��� 5000�� - 1 pk
-- ���� �λ������� ������ 6000�� - 2 pk
-- ���ﵿ�� �ִ� ���ٹ� 3000�� �� - 3
-- ��ġ���� �ִ� ��Ÿ�������� ��ü�� - 4
-----------------------------------------------------------------------------------
	--���̺����
	
create table menu (
	m_no number(3) primary key,
	m_name varchar2 (20 char) not null,
	m_price number(6) not null,
	m_place number(3) not null
);

create table restaurant (
	r_no number primary key,
	r_name varchar2 (30 char) not null,
	r_place varchar2 (20 char) not null
);

create table human (
	h_no number(3) primary key,
	h_name varchar2 (30 char) not null,
	h_birth date not null
);

create table owner (
	o_no number(3) primary key,
	o_ceo number(3) not null,
	o_restaurant number(3) not null
);

create sequence  menu_seq;
create sequence  restaurant_seq;
create sequence  human_seq;
create sequence  owner_seq;
-----------------------------------------------------------------------------------
	-- ������ �ֱ�
	
insert into menu values (menu_seq.nextval, '������â', 10000, 1);
insert into menu values (menu_seq.nextval, '�Ұ�â', 15000, 1);
insert into menu values (menu_seq.nextval, '��ä��â', 9000, 2);
insert into menu values (menu_seq.nextval, 'ī���', 6000, 3);
insert into menu values (menu_seq.nextval, '�Ƹ޸�ī��', 4000, 3);
insert into menu values (menu_seq.nextval, '������', 7000, 4);

insert into restaurant values (restaurant_seq.nextval, 'Ȳ�Ұ�â', '����');
insert into restaurant values (restaurant_seq.nextval, '���빮��â', '���빮');
insert into restaurant values (restaurant_seq.nextval, 'Ȳ�Ұ�â', '���빮');
insert into restaurant values (restaurant_seq.nextval, '��Ÿ����', '����');
insert into restaurant values (restaurant_seq.nextval, '��Ÿ����', '����');
insert into restaurant values (500, '��Ÿ����', '��ȭ��');

insert into human values (human_seq.nextval, '��', to_date('1980-05-05', 'YYYY-MM-DD'));
insert into human values (human_seq.nextval, '��', to_date('1985-06-05', 'YYYY-MM-DD'));
insert into human values (human_seq.nextval, '��', to_date('1980-07-05', 'YYYY-MM-DD'));
insert into human values (human_seq.nextval, '��', to_date('1985-08-05', 'YYYY-MM-DD'));
--------------
insert into human values (1, '��', to_date('1980-05-05', 'YYYY-MM-DD'));
insert into human values (2, '��', to_date('1985-06-05', 'YYYY-MM-DD'));
insert into human values (3, '��', to_date('1980-07-05', 'YYYY-MM-DD'));
insert into human values (4, '��', to_date('1985-08-05', 'YYYY-MM-DD'));
-- insert into human values (200, '��', to_date('1985-08-05', 'YYYY-MM-DD'));

insert into owner values (owner_seq.nextval, 1, 1);
insert into owner values (owner_seq.nextval, 2, 2);
insert into owner values (owner_seq.nextval, 3, 3);
insert into owner values (owner_seq.nextval, 4, 4);
-- insert into owner values (owner_seq.nextval, 200, 4);
insert into owner values (owner_seq.nextval, 4, 500); -- �̾� ��ȭ��������
-----------------------------------------------------------------------------------
	-- �޴� �߰�
	
-- ��Ÿ���� ��ȭ������ ü����ν� ���� �߰�
insert into menu values (menu_seq.nextval, 'ü����ν�', 5000, 500);
-- ���⽺���� 2�� ��������� �߰�
insert into menu values (menu_seq.nextval, '���⽺����', 4000, 2);
-- ���⽺���� ��â���� �߸� ������ ���� ��������
update menu
set m_place = 4
where m_name = '���⽺����';

-- �װ� �����
-- ü����ν�
delete menu
where m_name = 'ü����ν�';

-- ���� �˰� �ִ� ���� �̸�, ��ġ(���� ��ȸ) - �̸� �����ټ�
select r_name, r_place
from restaurant
order by r_name

-- ���� ��� �޴��� ����
select * from menu
where m_price =(
	select max(m_price)
	from menu
) 

-- �ֿ����� ����
select * from human
where h_birth =(
	select min(h_birth)
	from human
)

-- ��â �ø��� ��հ�
select avg(m_price) from menu
where m_name like '%��â%';

-- ���� ���� ����
select * from restaurant
where r_place = '����';

-- ���� �� �޴��� �Ĵ� �Ĵ��� �̸���, ��ġ	
select * from menu
where m_price = (
	select min(m_price)
	from menu
)


select r_name, r_place from restaurant
where r_no in (
	select m_place from menu
	where m_price = (
	select min(m_price)
	from menu
	)
)

-- ���빮���� ���� �� �ִ� ������ �̸�, ����
select m_name, m_price from MENU
where m_place in (
	select r_no from restaurant
	where  r_place = '���빮'
);

-- ��â �ø���� ��� ������ ���� ���� �� �ֳ�?(�������?)
select r_name, r_place from RESTAURANT
where r_no in (
	select m_place from MENU
	where m_name like '%��â%'
);

-- ���� �� Ŀ�Ǹ� �Ĵ� ������ �̸�, ����
select r_name, r_place from RESTAURANT
where (r_no) and (where r_name = '��Ÿ����' or r_name ='Ȳ�Ұ�â')in (
	select m_place from MENU
	where m_place = (
	select min(m_price)
	from MENU
	)
);

-----------------------------------------------------------------------------------
-- join
-- ���� �ٸ� ���̺� ������ �� �� ���踦 ����� ��
select m_name, m_price, r_name, r_place
from menu, restaurant
where r_no = m_place

--��Ÿ���� ���������� �޴� �̸� ����(������� ������)
select m_name, m_price, r_name, r_place
from menu, restaurant
where r_name = '��Ÿ����' and r_place = '����'; --�ȳ���(�����ð� ����)

select m_name, m_price, r_name, r_place
from menu, restaurant
where m_place = (
	select r_no
	from restaurant
	where r_plaace = '����' and r_name = '��Ÿ����' --�ȳ���(�����ð� ����)
)
-- �� ���̺� �� ���� ���ִѱ� ������ �� �����°� 
select m_name, m_price, r_name, r_place
from menu, restaurant
where r_no = m_place and m_place = (
	select r_no
	from restaurant
	where r_place = '����' and r_name = '��Ÿ����' 
)

select m_name, m_price, r_name, r_place
from menu, restaurant
where r_no = m_place and r_place = '����' and r_name = '��Ÿ����' 

-- ���� ���� ����Գ� ������ �����, ��ġ, ����� �̸�,����, �޴���, ����
select h_name, h_birth, r_name, r_place, m_name, m_price
from human, restaurant, menu, owner
where r_no = m_place 
   and h_no = o_ceo
   and o_restaurant = r_no
   and h_birth = (
      select max(h_birth)
      from human
      )

-- �ֿ����� �������� �޴���, �޴� ����
select m_name, m_price
from menu, human, restaurant, owner
where r_no = m_place 
and h_no = o_ceo 
and r_no = o_restaurant
and h_birth = (
	select min(h_birth)
	from human
)-- ����1

select m_name, m_price
from menu, human, owner
where h_no = o_ceo 
and m_place = o_restaurant
and h_birth = (
	select min(h_birth)
	from human
)-- ����2

select m_name, m_price
from menu
where m_place in (
	select r_no
	from RESTAURANT
	where r_no = (
		select o_ceo
		from owner
		where o_ceo = (
			select h_no
			from HUMAN
				where h_birth =(
				select min(h_birth)
				from human
				)
		)
	)
);-- �̷������� �ϴ°� �ȵ� �����Ѵ��� 

select m_name, m_price
from menu
where m_place = (
		select o_restaurant
		from owner
		where o_ceo = (
			select h_num
			from human
			where h_birth = (
				select min(h_birth)
				from human
			)
		)
);-- �̷������� �ϴ°� �ȵ� �����Ѵ��� (���� ���� Ÿ��Ÿ�� ��)
-----------------------------------------------------------------------------------
-- Ȳ�Ұ�â ������ ��ü �޴���, ����, ������ġ
select m_name, m_price, m_place
from menu, restaurant
where r_no = m_place
and r_name = 'Ȳ�Ұ�â'

-- ���� �Ѱ� �Ĵ� �����, ��ġ, �޴���, ����
select r_name, r_place, m_name, m_price
from restaurant, menu
where m_place = r_no and m_price = (select min(m_price) from menu)

-----------------------------------------------------------------------------------
-- CR Update Delete
-- ������â ���� �λ� (13000)
update menu 
set m_price = 13000
where m_name = '������â'

-- ���� �� �޴� ���� �̺�Ʈ
update menu
set m_price = 0
where m_price = (
select min(m_price) from menu
)
-- �޴� ��ü�� ��պ��� ��� �޴��� 10% ����
update menu
set m_price = m_price * (m_price / 10)
where m_price > (select avg(m_price) from menu);

-- ���빮 ���� �޴��� 1000�� �λ�
update menu
set m_price = m_price + 1000 
where m_place in (
	select r_no
	from restaurant
	where r_place = '���빮'
)
-- Ŀ�� �� '��' ������ ������ 500�� �λ�
update menu
set m_price = m_price + 500
where m_name like '%��%'
-----------------------------------------------------------------------------------
-- '��' ��� ���ڰ� �� �޴� �� ����
delete menu
where m_name like '%��%';

-- ���� ����(�޴� ����)
delete menu
where m_place = 5
	select r_no
	from restaurant
	where r_place = '����' and r_name = '��Ÿ����'
	
-- ���� ����(����)
delete rastaurant
where r_place = '����' and r_name = '��Ÿ����'

-- '��â' �� ������ �޴��� �� ����
delete menu
where m_place in (
	select r_no
	from restaurant
	where r_name like '%��â%'
	);

-----------------------------------------------------------------------------------
select * from menu;
select * from restaurant;
select * from human;
select * from owner;
-----------------------------------------------------------------------------------
drop sequence  menu_seq;
drop sequence  restaurant_seq;
drop sequence  human_seq;
drop sequence  owner_seq;

drop table menu cascade constraint purge;
drop table restaurant cascade constraint purge;
drop table human cascade constraint purge;
drop table owner cascade constraint purge;
------------------------------------------------------------------------------------
