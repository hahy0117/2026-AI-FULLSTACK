use mbasic;

desc users;
select*from users;
create table authorities(
email varchar(50)  not null,
auth varchar(50)  not null);
desc ahthorities;
select*from authorities;
insert into authorities values ('1@1','ROLE_MEMBER');
insert into authorities values ('1@1','ROLE_ADMIN');
delete from authorities;

alter table users   modify  bpass varchar(500) not null;
delete from users;
delete from users where uno=23;
