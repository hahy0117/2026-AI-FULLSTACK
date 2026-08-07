use mbasic;
select*from userinfo;
select*from milk;
desc milk;
insert into milk values(1,'바나나우유',1700,0,0);
insert into milk values(2,'딸기우유',1500,0,0);
alter table milk change manme  mname varchar(50);
alter table milk modify mnum int null;
alter table milk modify mtotal int null;
-- <!--       주문현황표             -->
-- <!--       주문현황표             -->
-- <!-- 
-- = MODEL
-- ★ 다음과 같이 테이블을 준비해주세요!
select*from milk_order;

	
use mbasic;

-- mysql> desc milk_order;
-- +-------+--------------+------+-----+-------------------+-------------------+
-- | Field | Type         | Null | Key | Default           | Extra             |
-- +-------+--------------+------+-----+-------------------+-------------------+
-- | ono   | int          | NO   | PRI | NULL              | auto_increment    |
-- | oname | varchar(20)  | NO   |     | NULL              |                   |
-- | onum  | int          | NO   |     | NULL              |                   |
-- | odate | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
-- | oip   | varchar(100) | NO   |     | NULL              |                   |
-- +-------+--------------+------+-----+-------------------+-------------------+
-- 5 rows in set (0.00 sec)


-- -- Q1.  milk_order 값삽입.  insert 구문 완성    
insert into milk_order values(1,'딸기우우',11,'2026.07.08','바나나');

-- -- Q2.  milk_order ono가 1인데이터 조회 
-- -- Q3.  milk_order 전체데이터조회
-- -- Q4.  milk_order 해당번호의 이름과 갯수 수정
-- -- Q5.  milk_order 해당번호의 데이터 삭제



--  -->