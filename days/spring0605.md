
<welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
여기 바로 밑에다가 붙여넣기ㅇ

<!-- 한글 인코딩 필터 설정 -->
<filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
    </init-param>
    <init-param>
        <param-name>forceEncoding</param-name>
        <param-value>true</param-value>
    </init-param>
</filter>

<filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>

🚀 정리
addFlashAttribute → 일회성 메시지 전달 (성공/실패 알림, 안내 등)

addAttribute → URL 파라미터 전달 (예: ?page=2)


-------------------------------------------
■1.  git branch
> https://github.com/sally03915/2026-ai_branch.git

🛠️ 팀원 작업 흐름
1. 저장소 클론하기
git clone <팀장이 만든 저장소 주소>
cd <저장소 폴더>

2. 브랜치 생성하기
git checkout -b feature-브랜치이름

3. 작업 후 커밋하기
git add .
git commit -m "작업 내용 설명"

4. 원격 저장소에 브랜치 푸시하기
git push origin feature-브랜치이름
----------------------------------------

git clone https://github.com/look-93/moit.git 
git checkout -b feature- 이름 입력 

git add .
git commit -m"작업이름"
git push --set-upstream origin feature-hhw
git push origin feature-브런치 이름
git branch 로 한 번 확인
