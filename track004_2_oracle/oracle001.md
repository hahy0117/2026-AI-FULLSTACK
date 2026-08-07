#1.oracle
-데이터베이스언어
1)데이터 정의어(DDL): create ,alter,drop(cad)
2)데이터 조작어(DML): insert,select,update,delete(crud)
3)데이터 제어어(DCL):grant,revoke

1.oracle 설치
-sql developer 설치 (sql 편집)
사용
sql (CMD)
sqlplus
conn system/1234
exit 닫을 때


유저 만들기 (오라클 12 이상에서 기존방식으로 사용자 생성 허용)
alter session set "_oracle_script"=true;
create user scott identified by tiger;


권한부여
grant connection resource to scott;
안되면 
grant connect, resource to scott;

<실습2>
 sql(sqldeveloper)

 scott 비번 tiger

alter user scott default tablespace users quota unlimited on users;
grant create table to scott; -- 물리적공간 이용


<실습2>
sql(sqldeveloper)

## 1.테이블 만들기
-- 테이블명 자료형 옵션 
-- 오라클에서는 int -> number 
-- varchar -> varchar2

create table dept(
deptno number primary key,
dname varchar2(14),
loc varchar2(13)
);


2.dml(crud)


--4.sequence (숫자 자동증가)
create sequence dept_seq; -- 암기
insert into dept(deptno,dname,loc)values(dept_seq.nextval,'AIDEV','SEOUL');

select * from dept;
