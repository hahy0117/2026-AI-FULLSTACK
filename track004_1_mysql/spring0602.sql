use mbasic;

create table userinfo_e(
no int not null primary key auto_increment,
email varchar(100) not null,
age int null);

desc userinfo_e;

-- >2. crud - insert, select, update, delete
-- insert :  insert into userinfo_e (email,age) values(?,?)
insert into userinfo_e values(1,'haru',6);
-- select (전체): select*from userinfo_e
select*from userinfo_e;
-- select (해당번호의 읽기):
select*from userinfo_e where no=1;
-- update (해당번호 수정) : 
update userinfo_e set no=2;
-- delete (해당번호 삭제) : 
delete from userinfo_e where no=2;

create table mvcboard2(
bno int not null primary key auto_increment,
bname varchar(20) not null,
bpass varchar(50) not null,
btitle varchar(1000) not null,
bcontent text not null,
bdate timestamp not null default CURRENT_TIMESTAMP,
bhit int not null default 0,
bhip varchar(50) not null);

alter table mvcboard2 change bhip bip varchar(50);
desc  mvcboard2;
select*from mvcboard2;
insert into mvcboard2 (bname,bpass,btitle,bcontent,bip) values('haru','hi','hi2','dd','dd');
alter table mvcboard2 change bcontent bcontext text not null;
use mbasic;
delete from mvcboard2;

alter table  mvcboard2 add bfile varchar(500) default 'the703.png';
insert into mvcboard2(bname,bpass,btitle,bcontext,bip,bfile)
select bname,bpass,btitle,bcontext, bip,bfile from mvcboard2;

select*from mvcboard2 order by bno desc;
select*from mvcboard2 order by bno desc limit 0,10;


