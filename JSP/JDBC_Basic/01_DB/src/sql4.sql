-- SELECT

select * from snack;

-- 전체 과자 이름, 가격, 무게
select s_name, s_price, s_weight from snack;

-- 전체 과자 이름, 제조사, 가격, 무게, 유통기한
select s_name, s_maker, s_price, s_exp from snack;

-- 필드명이 맘에 안들면 as XXX 해서 바꿀 수 있음
select s_name, s_maker as jejosa, s_price, s_exp from snack;

-- 다시 과자 이름, 가격
select s_name, s_price from snack;

-- 이 상태에서 부과세 하고 싶음(s_vat)
select s_name, s_price * 0.1 from snack;
select s_name, s_price * 0.1 as s_vat from snack;

-- test 
-- 전체 과자 이름, 제조사, 가격, g당 얼마(s_g)
select s_name, s_maker, s_price, round(s_price / s_weight) as s_g from snack;

-- 전체 과자 평균 가격
-- 지금까지는 레코드(행) 계산 인데
-- 이건 열이 필요
-- 오라클에 통계함수가 있음 : max, min, sum, avg, count, ...

select avg(s_price) from snack; 

-- 제일 싼과자
select min(s_price) from snack; 

-- 유통기한이 제일 오래 남은 과자
select max(s_exp) from snack;

-- 과자가 총 몇개? : count 레코드(열) 세는 특성상 뭘써도 똑같음
select count(s_no) from snack;
select count(s_name) from snack;
select count(*) from snack;

-- 전체 과자의 이름, 가격, 회사명
-- 과자 이름이 양파링 인거 (조건)

select s_name, s_price, s_maker
from snack
where s_name = '고래밥';

-- 농심 과자의 이름과 가격
select s_name, s_price
from snack
where s_maker = '농심';

-- 농심과자의 평균 가격
select avg(s_price)
from snack
where s_maker = '농심';

-- 먹으면 안되는 과자의 이름, 가격
select s_name, s_price 
from snack
where s_exp < sysdate ;

-- '%ㅋ' : ㅋ로 끝나는거 
-- 'ㅋ%' : ㅋ로 시작하는거 
-- '%ㅋ%' : ㅋ로 있는거(포함하는거)

-- 깡 으로 끝나는 시리즈 과자 이름, 가격
select s_name, s_price
from snack
where s_name like '%깡';

-- 쉐이크(딸기맛), 쉐이크()
select * snack
where s_name '쉐이크%'

-- test
-- 빼빼로 시리즈의 과자 이름, 가격
select s_name, s_price from snack
where s_name like '%빼빼로%';

-- 깡 시리즈 중 최고가
select max(s_price) from snack where s_name like '%깡%';

-- 제일 비싼 과자(이름,제조사,가격)
select s_name, s_maker, s_price from snack
where max(s_price) where s_price;

-----------------------------------------------------------
--subQuery (쿼리 속 쿼리)

-- 제일 비싼
select max(s_price) from snack;

-- 제일 비싼 과자(이름,제조사,가격)
select s_name, s_maker, s_price
from snack
where s_price = (
   select max(s_price)
   from SNACK
   );

-- 평균가
select avg(s_price)
from snack

-- 평균가 보다 비싼 과자(이름, 가격)
select s_name, s_price from snack
where s_price > (select avg(s_price)
from snack);

-- 제일 가벼운 과자(이름, 가격)
select s_name, s_price from snack
where s_weight = (select min(s_weight) from snack);


select * from snack;

-- 농심, 해태 과저 정보 전체

select * from snack
where s_maker ='농심' or s_maker = '해태';

-- 1000 < 가격 < 1500 인 과자 정보 전체
select * from snack
where 1000 < s_price and s_price < 1500;

--------------------------------------

-- 정렬 order by 컬럼   desc(역순)

-- 롯데 과자 전체 이름순으로 정렬
select * from SNACK
where s_maker = '해태'
order by s_name;

-- 과자 전체 정보를 가격순(오름차순)
select * from snack
order by s_price, s_name ; --가격이 같은게 먼저 정렬되고 중복은 이름순으로 정렬됨

-- 1500원 전재산 
-- 내가 삭먹을 수 있는 과자 리스트
-- 유통기한이 짧은걸 위로 정렬
select * from SNACK
where 1500 > s_price
order by s_exp;






































