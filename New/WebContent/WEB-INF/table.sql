--코드그룹 
create table users_code_group(
code_group_id varchar2(20) primary key,
code_group_name varchar2(20));
--코드그룹 아이디 테이블 인서트
insert into users_code_group values('user_grade', '회원권한코드');
insert into users_code_group values('user_state', '회원상태코드');



--상세코드
create table users_code_detail(
code_group_id varchar2(20) references board_code_group(code_group_id),
detail_code varchar2(5) primary key,
code_name varchar2(20),
eng_code_name varchar2(20));
--세부코드 테이블 인서트
insert into board_code_detail values('user_grade', 'g1', '일반','guest');
insert into board_code_detail values('user_grade', 'g2', '기자','reporter');
insert into board_code_detail values('user_grade', 'g3', '관리자','admin');
insert into board_code_detail values('user_state', 's1', '정상','normal');
insert into board_code_detail values('user_state', 's2', '정지','stop');
insert into board_code_detail values('user_state', 's3', '탈퇴','drop');


--유저 테이블
create table users(
user_id varchar2(20) primary key,
user_pwd varchar2(100) not null,
user_email varchar2(100),
user_name varchar2(20),
user_state_code varchar2(5) default 's1' references board_code_detail(detail_code),
user_authority_code varchar2(5) default 'g1' references board_code_detail(detail_code),
user_regdate date,
login_count number default 0);



--뉴스 topic 테이블
create table topic(
topic_code varchar2(5) primary key,
topic_name varchar2(20) not null,
);

--뉴스 topic 테이블 insert
insert into topic values('t1', '경제');
insert into topic values('t2', '정치');
insert into topic values('t3', 'IT/과학');

-- topic category 테이블
create table topic_category(
topic_code varchar2(5) references topic(topic_code),
category_id varchar2(5) primary key,
category_name varchar2(20) not null
)
--category insert
insert into topic_category values('t1', 'c1', '금융');
insert into topic_category values('t1', 'c2', '증권');
insert into topic_category values('t1', 'c3', '부동산');
insert into topic_category values('t2', 'c4', '청와대');
insert into topic_category values('t2', 'c5', '북한');
insert into topic_category values('t2', 'c6', '행정');
insert into topic_category values('t3', 'c7', '모바일');
insert into topic_category values('t3', 'c8', 'IT일반');
insert into topic_category values('t3', 'c9', '게임');


--기사 테이블
create table article(
article_num number primary key,
article_title varchar2(500) not null,
article_writer varchar2(20) references users(user_id),
article_content clob,
article_viewcount number,
article_regdate date,
category_id varchar2(5) references topic_category(category_id),
);

--파일 테이블
create table article_file(
file_num number primary key,
article_num number references board(board_num),
file_ori_title varchar2(50),
file_save_title varchar2(50),
file_size long,
file_regdate date
);


