create table mvcboard1(
bno int not null primary key auto_increment,
bname varchar(200) not null,
bpass varchar(50) not null,
btitle varchar(1000) not null,
bdate timestamp not null default current_timestamp,
bhit int not null default 0,
bip varchar(50) not null);
use mbasic;
desc mvcboard1;
alter table mvcboard1 add bcontent  text not null;
alter table mvcboard1 modify column bcontent text not null after btitle;
insert into mvcboard1 (bname,bpass,btitle,bcontent,bip) values ('하마','11','oo','dd','11');
select*from mvcboard1;
delete from mvcboard1;