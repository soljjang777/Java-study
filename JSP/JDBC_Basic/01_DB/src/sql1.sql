--주석

--여러줄 블록 지정 -> alt + x
--한줄 실행 : alt + s( 그 줄에 커서 놓고)

--테이블 생성
create table product(
p_name varchar2(10 char),
p_price number(4)
);

--데이터 삽입
insert into PRODUCT values ('볼펜',1000);

--조회
select * from PRODUCT

---------------------------------------------------------
-- 행, row,  행 하나가 데이터 1개. record라고 함.
-- 열, filed, 속성, colum
-- oracle 대/소문자 구분x 다 대문자

-- DBA : 서버 전원관리, 백업/복구, 계정관리 

-- DBP : CRUD (우리의 목표) (Create Read Update Delete)

-- SQL (Structured Query Language) : DB를 제어하는 언어
-- 다른 메이커 98.99% 비슷 
-- ;  문장 끝
---------------------------------------------------------

--1) 테이블 만들기
	-- 학생.  이름, 나이, 국, 영, 수
create table student(
s_name varchar2(10 char),
s_age number(3),
s_kor number(3),
s_eng number(3),
s_math number(3)
);

--2)데이터 삽입
	--1개
insert into student values ('솔리', 28, 100, 90, 90);

insert into student(s_name, s_age) values ('준석',20);
insert into student(s_kor, s_eng, s_math, s_age, s_name)
values(10, 20, 30, 28, '솔리');



--3) 조회
select * from student;
---------------------------------------------------------
-- 안쓴건 -> Null
-- 필드 순서를 왜 바꾸는지, Null을 둬서 어쩔건지
-- 0점이면 0점이지 null로 비워두면 나중에 계산같은거 할 때 골치아픔
-- 테이블을 만들때 옵션을 쓸 수 있음
-- primary key 고유해야되는 값 즉 중복안됨

create table student2(
s_no number(2) primary key,
s_name varchar2(10 char) not null,
s_age number(3) not null,
s_kor number(3) not null,
s_eng number(3) not null,
s_math number(3) not null
);

insert into student2 values (1, '솔리', 28, 100, 90, 90);
insert into student2 values (10, '준석', 25, 90, 90, 90);
insert into student2 values (5, '병관', 23, 90, 90, 90);
insert into student2 values (20, '병관', 23, 100, 100, 100);

select * from student2;

-- 테이블 삭제
drop table student2 -- 이렇게 휴지통(찌꺼기 남음)
cascade constraint purge; -- 휴지통 않너고, 테이블에 걸린 각종 규제들 같이 삭제


-- 옵션
-- not null : 사실상 기본, 필수
-- primary key : not null 기능포함, 중복불허
-- 그 테이블을 대표하는 값 => 테이블 하나에는 pk 하나 있는게 좋음
-- id => 곧 나

-- 데이터 수정 ( cr Update d)
-- 10번 사람의 영어점수를 50점으로 
update student2
set s_eng = 100
where s_no = 10;

select * from student2;

-- 데이터 삭제 (cru Delete)
-- 두현씨 삭제 
delete student2 where s_no = 20;
s

-- student2 테이블의 학생 이름들 
select s_name from student2;

-- 저 테이블에의 학생 이름과 나이, 영어점수
select s_name,s_age,s_eng from student2;




