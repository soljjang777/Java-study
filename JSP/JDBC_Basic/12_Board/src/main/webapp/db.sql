create table movie_test(
	m_no number(3) primary key,
	m_title varchar2(30 char) not null,
	m_actor varchar2(30 char) not null,
	m_img varchar2(200 char) not null,
	m_story varchar2(100 char) not null
)

create sequence movie_test_seq;

insert into movie_test values (movie_test_seq.nextval,'����','���','����','�ٰŸ�');
insert into movie_test values (movie_test_seq.nextval,'����2','���2','����2','�ٰŸ�2');

select * from movie_test;

create table review_test(
 r_no number(3) primary key,
 r_title varchar2 (50 char) not null,
 r_txt varchar2 (200 char) not null,
 r_date date not null
)

create sequence review_test_seq;

insert into review_test values (review_test_seq.nextval, '����', '����', sysdate);
insert into review_test values (review_test_seq.nextval, '����2', '����2', sysdate);

select * from review_test;