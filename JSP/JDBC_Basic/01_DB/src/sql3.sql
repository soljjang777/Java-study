create table snack(
s_no number(10) primary key,
s_name varchar2 (20 char) not null,
s_maker varchar2 (20 char) not null,
s_weight number(4,1) not null, --4자리 수에 소수점1자리
s_price number(4) not null,
s_exp date not null
);

-- 숫자 자동으로 올리기 : sequence(테이블과 무관) - 오라클 기능
create sequence 시퀀스명;
create sequence snack_seq;
-- 시퀀스명.nextval 로 사용

insert into snack values (snack_seq.nextval, '양파링', '농심', 60, 1000, sysdate);
insert into snack values (snack_seq.nextval, '새우깡', '해태', 50, 1100, sysdate);
insert into snack values (snack_seq.nextval, '칙촉', '롯데', 10, 2000, sysdate);
insert into snack values (snack_seq.nextval, '고래밥', '오리온', 20, 900, sysdate);
insert into snack values (snack_seq.nextval, '감자깡', '오리온', 20, 900, sysdate);
insert into snack values (snack_seq.nextval, '롯데빼빼로', '해태', 20, 1600, sysdate);
insert into snack values (snack_seq.nextval, '누드빼빼로', '해태', 20, 1600, sysdate);

select * from snack;
drop table snack cascade constraint purge;