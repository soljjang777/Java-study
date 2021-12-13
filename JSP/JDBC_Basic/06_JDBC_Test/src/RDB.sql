-- RDBMS(Relational)데이터베이스메니지먼트시스템
-- 테이블간의 관계를 중심으로 뭔가..

-- 강남 홍콩반점 짜장면 5000원 - 1 pk
-- 종로 인생서렁탕 설렁탕 6000원 - 2 pk
-- 역삼동에 있는 빽다방 3000원 라떼 - 3
-- 대치동에 있는 스타벅스에서 돌체라떼 - 4
-----------------------------------------------------------------------------------
	--테이블생성
	
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
	-- 데이터 넣기
	
insert into menu values (menu_seq.nextval, '돼지곱창', 10000, 1);
insert into menu values (menu_seq.nextval, '소곱창', 15000, 1);
insert into menu values (menu_seq.nextval, '야채곱창', 9000, 2);
insert into menu values (menu_seq.nextval, '카페라떼', 6000, 3);
insert into menu values (menu_seq.nextval, '아메리카노', 4000, 3);
insert into menu values (menu_seq.nextval, '돌레라떼', 7000, 4);

insert into restaurant values (restaurant_seq.nextval, '황소곱창', '종로');
insert into restaurant values (restaurant_seq.nextval, '동대문곱창', '동대문');
insert into restaurant values (restaurant_seq.nextval, '황소곱창', '동대문');
insert into restaurant values (restaurant_seq.nextval, '스타벅스', '종로');
insert into restaurant values (restaurant_seq.nextval, '스타벅스', '강남');
insert into restaurant values (500, '스타벅스', '광화문');

insert into human values (human_seq.nextval, '김', to_date('1980-05-05', 'YYYY-MM-DD'));
insert into human values (human_seq.nextval, '나', to_date('1985-06-05', 'YYYY-MM-DD'));
insert into human values (human_seq.nextval, '박', to_date('1980-07-05', 'YYYY-MM-DD'));
insert into human values (human_seq.nextval, '이', to_date('1985-08-05', 'YYYY-MM-DD'));
--------------
insert into human values (1, '김', to_date('1980-05-05', 'YYYY-MM-DD'));
insert into human values (2, '나', to_date('1985-06-05', 'YYYY-MM-DD'));
insert into human values (3, '박', to_date('1980-07-05', 'YYYY-MM-DD'));
insert into human values (4, '이', to_date('1985-08-05', 'YYYY-MM-DD'));
-- insert into human values (200, '최', to_date('1985-08-05', 'YYYY-MM-DD'));

insert into owner values (owner_seq.nextval, 1, 1);
insert into owner values (owner_seq.nextval, 2, 2);
insert into owner values (owner_seq.nextval, 3, 3);
insert into owner values (owner_seq.nextval, 4, 4);
-- insert into owner values (owner_seq.nextval, 200, 4);
insert into owner values (owner_seq.nextval, 4, 500); -- 이씨 광화문점스벅
-----------------------------------------------------------------------------------
	-- 메뉴 추가
	
-- 스타벅스 광화문점에 체리블로썸 음료 추가
insert into menu values (menu_seq.nextval, '체리블로썸', 5000, 500);
-- 딸기스무디 2번 레스토랑에 추가
insert into menu values (menu_seq.nextval, '딸기스무디', 4000, 2);
-- 딸기스무디 곱창집에 잘못 넣은거 스벅 종로점에
update menu
set m_place = 4
where m_name = '딸기스무디';

-- 그거 지우기
-- 체리블로썸
delete menu
where m_name = '체리블로썸';

-- 내가 알고 있는 맛집 이름, 위치(매장 조회) - 이름 가나다순
select r_name, r_place
from restaurant
order by r_name

-- 제일 비싼 메뉴의 정보
select * from menu
where m_price =(
	select max(m_price)
	from menu
) 

-- 최연장자 정보
select * from human
where h_birth =(
	select min(h_birth)
	from human
)

-- 곱창 시리즈 평균가
select avg(m_price) from menu
where m_name like '%곱창%';

-- 종로 가게 정보
select * from restaurant
where r_place = '종로';

-- 제일 싼 메뉴를 파는 식당의 이름과, 위치	
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

-- 동대문에서 먹을 수 있는 음식의 이름, 가격
select m_name, m_price from MENU
where m_place in (
	select r_no from restaurant
	where  r_place = '동대문'
);

-- 곱창 시리즈는 어느 지역에 가면 먹을 수 있나?(어느가게?)
select r_name, r_place from RESTAURANT
where r_no in (
	select m_place from MENU
	where m_name like '%곱창%'
);

-- 제일 싼 커피를 파는 매장의 이름, 지역
select r_name, r_place from RESTAURANT
where (r_no) and (where r_name = '스타벅스' or r_name ='황소곱창')in (
	select m_place from MENU
	where m_place = (
	select min(m_price)
	from MENU
	)
);

-----------------------------------------------------------------------------------
-- join
-- 서로 다른 테이블 연결할 때 그 관계를 명시할 것
select m_name, m_price, r_name, r_place
from menu, restaurant
where r_no = m_place

--스타벅스 종리지점의 메뉴 이름 가격(레스토랑 정보도)
select m_name, m_price, r_name, r_place
from menu, restaurant
where r_name = '스타벅스' and r_place = '종로'; --안나옴(관계명시가 없음)

select m_name, m_price, r_name, r_place
from menu, restaurant
where m_place = (
	select r_no
	from restaurant
	where r_plaace = '종로' and r_name = '스타벅스' --안나옴(관계명시가 없음)
)
-- 두 테이블 잘 연결 해주닌깐 이제야 잘 나오는거 
select m_name, m_price, r_name, r_place
from menu, restaurant
where r_no = m_place and m_place = (
	select r_no
	from restaurant
	where r_place = '종로' and r_name = '스타벅스' 
)

select m_name, m_price, r_name, r_place
from menu, restaurant
where r_no = m_place and r_place = '종로' and r_name = '스타벅스' 

-- 제일 젊은 사장님네 가게의 매장명, 위치, 사장님 이름,생일, 메뉴명, 가격
select h_name, h_birth, r_name, r_place, m_name, m_price
from human, restaurant, menu, owner
where r_no = m_place 
   and h_no = o_ceo
   and o_restaurant = r_no
   and h_birth = (
      select max(h_birth)
      from human
      )

-- 최연장자 아저씨네 메뉴명, 메뉴 가격
select m_name, m_price
from menu, human, restaurant, owner
where r_no = m_place 
and h_no = o_ceo 
and r_no = o_restaurant
and h_birth = (
	select min(h_birth)
	from human
)-- 버전1

select m_name, m_price
from menu, human, owner
where h_no = o_ceo 
and m_place = o_restaurant
and h_birth = (
	select min(h_birth)
	from human
)-- 버전2

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
);-- 이런식으로 하는건 안됨 운좋앗던거 

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
);-- 이런식으로 하는건 안됨 운좋앗던거 (관계 없음 타고타고 들어감)
-----------------------------------------------------------------------------------
-- 황소곱창 가게의 전체 메뉴명, 가격, 매장위치
select m_name, m_price, m_place
from menu, restaurant
where r_no = m_place
and r_name = '황소곱창'

-- 제일 싼거 파는 매장명, 위치, 메뉴명, 가격
select r_name, r_place, m_name, m_price
from restaurant, menu
where m_place = r_no and m_price = (select min(m_price) from menu)

-----------------------------------------------------------------------------------
-- CR Update Delete
-- 돼지곱창 가격 인상 (13000)
update menu 
set m_price = 13000
where m_name = '돼지곱창'

-- 제일 싼 메뉴 무료 이벤트
update menu
set m_price = 0
where m_price = (
select min(m_price) from menu
)
-- 메뉴 전체의 평균보다 비싼 메뉴를 10% 할인
update menu
set m_price = m_price * (m_price / 10)
where m_price > (select avg(m_price) from menu);

-- 동대문 지역 메뉴들 1000원 인상
update menu
set m_price = m_price + 1000 
where m_place in (
	select r_no
	from restaurant
	where r_place = '동대문'
)
-- 커피 중 '라떼' 종류의 가격을 500원 인상
update menu
set m_price = m_price + 500
where m_name like '%라떼%'
-----------------------------------------------------------------------------------
-- '라떼' 라는 글자가 들어간 메뉴 다 삭제
delete menu
where m_name like '%라떼%';

-- 강남 스벅(메뉴 삭제)
delete menu
where m_place = 5
	select r_no
	from restaurant
	where r_place = '강남' and r_name = '스타벅스'
	
-- 강남 스벅(폐점)
delete rastaurant
where r_place = '강남' and r_name = '스타벅스'

-- '곱창' 들어간 매장의 메뉴를 다 삭제
delete menu
where m_place in (
	select r_no
	from restaurant
	where r_name like '%곱창%'
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
