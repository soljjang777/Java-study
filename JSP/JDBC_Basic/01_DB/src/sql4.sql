-- SELECT

select * from snack;

-- ��ü ���� �̸�, ����, ����
select s_name, s_price, s_weight from snack;

-- ��ü ���� �̸�, ������, ����, ����, �������
select s_name, s_maker, s_price, s_exp from snack;

-- �ʵ���� ���� �ȵ�� as XXX �ؼ� �ٲ� �� ����
select s_name, s_maker as jejosa, s_price, s_exp from snack;

-- �ٽ� ���� �̸�, ����
select s_name, s_price from snack;

-- �� ���¿��� �ΰ��� �ϰ� ����(s_vat)
select s_name, s_price * 0.1 from snack;
select s_name, s_price * 0.1 as s_vat from snack;

-- test 
-- ��ü ���� �̸�, ������, ����, g�� ��(s_g)
select s_name, s_maker, s_price, round(s_price / s_weight) as s_g from snack;

-- ��ü ���� ��� ����
-- ���ݱ����� ���ڵ�(��) ��� �ε�
-- �̰� ���� �ʿ�
-- ����Ŭ�� ����Լ��� ���� : max, min, sum, avg, count, ...

select avg(s_price) from snack; 

-- ���� �Ѱ���
select min(s_price) from snack; 

-- ��������� ���� ���� ���� ����
select max(s_exp) from snack;

-- ���ڰ� �� �? : count ���ڵ�(��) ���� Ư���� ���ᵵ �Ȱ���
select count(s_no) from snack;
select count(s_name) from snack;
select count(*) from snack;

-- ��ü ������ �̸�, ����, ȸ���
-- ���� �̸��� ���ĸ� �ΰ� (����)

select s_name, s_price, s_maker
from snack
where s_name = '����';

-- ��� ������ �̸��� ����
select s_name, s_price
from snack
where s_maker = '���';

-- ��ɰ����� ��� ����
select avg(s_price)
from snack
where s_maker = '���';

-- ������ �ȵǴ� ������ �̸�, ����
select s_name, s_price 
from snack
where s_exp < sysdate ;

-- '%��' : ���� �����°� 
-- '��%' : ���� �����ϴ°� 
-- '%��%' : ���� �ִ°�(�����ϴ°�)

-- �� ���� ������ �ø��� ���� �̸�, ����
select s_name, s_price
from snack
where s_name like '%��';

-- ����ũ(�����), ����ũ()
select * snack
where s_name '����ũ%'

-- test
-- ������ �ø����� ���� �̸�, ����
select s_name, s_price from snack
where s_name like '%������%';

-- �� �ø��� �� �ְ�
select max(s_price) from snack where s_name like '%��%';

-- ���� ��� ����(�̸�,������,����)
select s_name, s_maker, s_price from snack
where max(s_price) where s_price;

-----------------------------------------------------------
--subQuery (���� �� ����)

-- ���� ���
select max(s_price) from snack;

-- ���� ��� ����(�̸�,������,����)
select s_name, s_maker, s_price
from snack
where s_price = (
   select max(s_price)
   from SNACK
   );

-- ��հ�
select avg(s_price)
from snack

-- ��հ� ���� ��� ����(�̸�, ����)
select s_name, s_price from snack
where s_price > (select avg(s_price)
from snack);

-- ���� ������ ����(�̸�, ����)
select s_name, s_price from snack
where s_weight = (select min(s_weight) from snack);


select * from snack;

-- ���, ���� ���� ���� ��ü

select * from snack
where s_maker ='���' or s_maker = '����';

-- 1000 < ���� < 1500 �� ���� ���� ��ü
select * from snack
where 1000 < s_price and s_price < 1500;

--------------------------------------

-- ���� order by �÷�   desc(����)

-- �Ե� ���� ��ü �̸������� ����
select * from SNACK
where s_maker = '����'
order by s_name;

-- ���� ��ü ������ ���ݼ�(��������)
select * from snack
order by s_price, s_name ; --������ ������ ���� ���ĵǰ� �ߺ��� �̸������� ���ĵ�

-- 1500�� ����� 
-- ���� ����� �� �ִ� ���� ����Ʈ
-- ��������� ª���� ���� ����
select * from SNACK
where 1500 > s_price
order by s_exp;






































