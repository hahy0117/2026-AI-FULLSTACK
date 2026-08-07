use mbasic;
desc users;
select*from users;
create table users(
  uno int not null  auto_increment primary key, 
  nickname varchar(20) not null,
  bpass    varchar(50) not null,
  email    varchar(100) not null,
  mobile   varchar(50) not null, 
  udate timestamp  not null  default current_timestamp  , 
  bip     varchar(50) not null 
);
use mbasic;
select*from users where email=? and bpass=? ;
select*from users;
delete from users;

select count(*) cnt from users;

select*from users where email='gg@11'