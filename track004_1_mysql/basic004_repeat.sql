-- 1.  데이터베이스 언어
-- -- DDL(  정의어   )  CREATE, ALTER, DROP 
-- -- DML( 조작어   )    ___insert_____, __update______, __select______ , ___delete_____ 
-- -- DCL( 제어어  )     __grant______, _revoke_______


-- 2. 다음과 같이 테이블준비
-- -- DB명     : test   
-- -- 테이블명: userinfo
-- -- 필드1 -  필수입력 no    ,  숫자자동증가, 기본키      정수형
-- -- 필드2 -  필수입력  name  가변형문자열(100)
-- -- 필드3 -  필수입력  age      정수형
-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type         | Null | Key | Default | Extra          |
-- +-------+--------------+------+-----+---------+----------------+
-- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- | name  | varchar(100) | NO   |     | NULL    |                |
-- | age   | int          | NO   |     | NULL    |                |
-- +-------+--------------+------+-----+---------+----------------+
-- 3 rows in set (0.00 sec)
create database test;
use test;

create table test(
no int not null primary key auto_increment,
name varchar(100) not null,
age int not null
);
alter table test add email varchar(100);
alter table test change email email2 varchar(50);
alter table test modify email2 varchar(100);
alter table test drop  column email2;
desc test;


use mbasic;


-- 3. 다음을 수정  
-- alter table (add,drop,change/modify,rename)

-- -- 1. 이메일 필드 추가(add)       email varchar(100)
-- -- 2. 이메일 필드 수정(change)   email을 email2로  자료형은 varchar(50) 으로 
--                              email을 email2로 자료형은 varchar(50)으로 바꾸세요 (이상한점)-modify는 필드명 수정안됨
-- -- 3. 이메일 필드 수정(modify)    email2  자료형은 varchar(100) 으로 
-- -- 4. 이메일 필드 삭제(drop)   
