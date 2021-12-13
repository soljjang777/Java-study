create table snack(
s_no number(3) primary key,
s_name varchar2 (20 char) not null,
s_maker varchar2 (20 char) not null,
s_weight number(4,1) not null, --4자리 수에 소수점1자리
s_price number(4) not null,
s_exp date not null
);

-- sysdate : 현재 시간 날짜 (java : date)
insert into snack values (1, '양파링', '농심', 60, 1000, sysdate);
insert into snack values (50, '꽃게랑', '해태', 70, 1200, sysdate);

-- 특성 시간 날짜 :
-- to_date('값','패턴')
--  		YYYY MM DD HH : MI : SS(오라클은 대문자로처리)
insert into snack values (3, '꼬깔콘', '롯데', 70.5, 1300, to_date('2021-12-01','YYYY-MM-DD'));

select * from snack;

drop table snack cascade constraint purge;