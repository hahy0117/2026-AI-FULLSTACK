테이블/시퀀스
sql
 본인 커리에 조인 서브쿼리 추가
1) 회원가입

insert into appuser (APP_USER_ID,EMAIL ,PASSWORD , MBTI_TYPE_ID ,CREATED_AT ,UFILE ,MOBILE ,NICKNAME ,PROVIDER ,PROVIDER_ID )
values (apperuser_seq.nextval,'first@gmail.com','111',1,sysdate,'1.png','01011111111','first','the703','t7-1')
2) 로그인
-이메일로 이메일, 비밀번호 , 권한

select u.email , u.password,a.auth
from appuser u left join authorities a on u.email=a.email
where u.email='first@gmail.com';

3) 이메일로 유저 찾기

select * from appuser where email='first@gamil.com';
4) 이메일로 중복 검사

select count (*) from appuser where email='first@gmail.com';
5)  회원 수정

ㅁupdate appuser set password='2222';
mbti_type_id=2,
ufile ='2.png',
nickname='second',
mobile='01022222222';
provider='naver',
providerId='n-1',
where app_user_id=2; -- 있는 번호로 넣기

6)  회원 삭제

delete from appuser where app_user_id=2;
7) 권한 삽입

insert into AUTHORITIES  (AUTH_ID ,EMAIL ,AUTH )
values (auth_seq.nextval,'first@gmail.com','role_member');
8) 권한 삭제
delete from authorities where email='first@gamil.com';