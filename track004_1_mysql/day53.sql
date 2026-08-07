use mbasic;

create table t1(
no int not null primary key  auto_increment,
name varchar(100) null);

desc t1;
drop table t1;
desc t2;

create table t2(
ino int not null  primary key ,
foreign key(ino) references t1(no)
); -- 외래키 (ino) 참고테이블 t1(no 필드)