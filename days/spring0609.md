properties -> web-projectsetting -> cotext root 이름 폴더이름이랑 똑같이 바꾸기

web.xml에서도 이름 바꾸기

----------------------------------------------------------------
■ model
1) Dto - UserDto
2) Dao - UserMapper   user-mapper.xml
         join / login / mypage  / 아이디 중복검사 (해당 sql 찾기)
3) Service  테스트

n / login / mypage  / 아이디 중복검사 (해당 sql 찾기)

create  : 
    insert into users  (nickname ,bpass, email , mobile, bip )  
    values             ( #{nickname} ,#{bpass}, #{email} , #{mobile}, #{bip} ) 

read    : 
    select count(*) from users  where  email=#{email}  and  bpass=#{bpass}
    select       *  from users  where  uno=#{uno} 
    select    email from users  where  email=#{email}

    ▶ 1. Security?
 - 애플리케이션의 보안(인증, 인가)을 담당
 - Filter의 흐름에 따라 처리

▶ 2. 인증  VS  인가
 - 인증  Authentication - [본인]이 맞는지 확인 :여권갖고 비행기탑승, 로그인
 - 인가  Authorization  - 인증된사용자가 [접근가능] : 승객은 조종실에 못 들어감.

▶ 3. Security 아키텍쳐

=====================
       ② [UsernamePasswordAuthentication Token]
          ↓
① Http Request  →     [AuthenticationFilter] ③ ...  →  [Authentication  Manager]
         ↓⑩               ⑨     ←
          [SecurityContextHolder]
=====================

-1. 사용자가 로그인 폼태그 시도 (username + password 전달)
-2. UsernamePasswordAuthentication 요청정보  Authentication 를 생성
-3. Authentication 인증처리
★UsernamePasswordAuthentication

-10. 인증 완료가 [사용자정보]   SecurityContextHolder 담기
    - AuthenticationSuccessHandler   를 실행( 성공 )
    - AuthenticationFailureHandler   를 실행( 실패 )

=====================
 [AuthenticationFilter] ③   → [Authentication  Manager] → ④[AuthenticationProvider(s)]
                                            ← ⑨       ↑   ↓⑤   
                     ↑                            [ UserDetailsService ]    
                        ProviderManager                ↑   ↓⑥
                                                 [ UserDetails ]   

=====================
-4. Authentication  Manager  인증담당
★UsernamePasswordAuthentication  Token은 Provider를 찾는데 사용
 
AuthenticationProvider
★ 로그인정보 DB정보와 비교

UserDetailsService
★ DB에 있는 [사용자정보]가져오기

1.pom.xml
2.securityController
3.web.xml
4.SecurityController


insert 구문찾기 first@gmail.com /ROLM_MEMBER
join 이용해서 first@gamil.com 의 
email,bpass,auth 필드 값 찾기