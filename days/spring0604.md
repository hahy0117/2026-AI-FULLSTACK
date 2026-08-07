> 실습
1. project 만들기
    1. dynamic web project - ex02
    2. configure  - [Convert to Maven Project]
    3. spring      - add Spring project Nature
    4. java se-11 / project facts, build path
    5. build path - add Libraries - JUnit 4
    
2. pom.xml 에  jar 파일 다운로드 받기
3. root-context 에   내용설정
   1) DataSource
   2) Mybatis
   3) Mapper
4. 각종 설정파일들설정
    com.the703.dao   - @Mapper 
    com.the703.dto    
    config       
      ㄴ db.properties
      ㄴ mybatis-config.xml
      ㄴ test-mapper.xml
      ㄴ board-mapper.xml
5. 테스트파일설정
  
6. test-mapper.xml
select now()   
    
7. mvcboard
mysql> desc mvcboard2;
+----------+---------------+------+-----+-------------------+-------------------+
| Field    | Type          | Null | Key | Default           | Extra             |
+----------+---------------+------+-----+-------------------+-------------------+
| bno      | int           | NO   | PRI | NULL              | auto_increment    |
| bname    | varchar(20)   | NO   |     | NULL              |                   |
| bpass    | varchar(50)   | NO   |     | NULL              |                   |
| btitle   | varchar(1000) | NO   |     | NULL              |                   |
| bcontent | text          | NO   |     | NULL              |                   |
| bdate    | timestamp     | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| bhit     | int           | NO   |     | 0                 |                   |
| bip      | varchar(50)   | NO   |     | NULL              |                   |
+----------+---------------+------+-----+-------------------+-------------------+
8 rows in set (0.00 sec)

mysql>      


pox.xml 파일 만들기

packaging 랑 build 사이에 붙여 놓기
    <dependencies>
   <!-- TEST Unit  --> 
   <!-- https://mvnrepository.com/artifact/junit/junit -->
   <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
   </dependency>
   
   <!-- spring di, context-info  --> 
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
   <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.3.27.RELEASE</version>
   </dependency>
   
   
   <!-- spring test tool --> 
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
   <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>4.3.27.RELEASE</version>
      <scope>test</scope>
   </dependency>
   
   <!-- LOMBOK : getters/setters, constructor, toString -->      
   <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
   <dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
       <version>1.18.18</version>
       <scope>provided</scope>
   </dependency>   
    
    <!--  MYSQL/ORACLE    
   <dependency>
      <groupId>com.oracle.database.jdbc</groupId>
      <artifactId>ojdbc11</artifactId>
      <version>21.9.0.0</version>
   </dependency> -->
   
   <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>8.0.28</version>
   </dependency>
   
   <!-- jdbc -->
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-jdbc</artifactId>
       <version>4.3.20.RELEASE</version>
   </dependency>
         
   <!-- MYBATIS - mapper -->
   <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
   <dependency>
       <groupId>org.mybatis</groupId>
       <artifactId>mybatis</artifactId>
       <version>3.5.6</version>
   </dependency>
   
   <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
   <dependency>
       <groupId>org.mybatis</groupId>
       <artifactId>mybatis-spring</artifactId>
       <version>2.0.6</version>
   </dependency> 
   
   
   <!-- HikariCP : connector pool  -->
   <!-- https://mvnrepository.com/artifact/com.zaxxer/HikariCP -->
   <dependency>
       <groupId>com.zaxxer</groupId>
       <artifactId>HikariCP</artifactId>
       <version>2.7.4</version>
   </dependency>
      
   <!--  sql query  -->   
   <!-- https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4 -->
   <dependency>
       <groupId>org.bgee.log4jdbc-log4j2</groupId>
       <artifactId>log4jdbc-log4j2-jdbc4</artifactId>
       <version>1.16</version>
   </dependency>
      
  </dependencies>


  ##  ex02 - log4jdbc + HicariCP
  -- root-context.xml 파일

  <context:property-placeholder location="classpath:config/db.properties"/>
   <bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource">
      <property name="driverClassName" value="${db.driverClass}" />
      <property name="jdbcUrl" value="${db.url}" />
      <property name="username"  value="${db.username}"/>
      <property name="password" value="${db.password}"/>
   </bean>

<baen> 안에 클래스 변경 <property> 안에 driverClassName , value값 바꾸기 , jdbcUrl, value 값 변경하기 

-- ex02/pom.xml 파일 안에 붙여넣기

<dependency>
     <groupId>org.apache.logging.log4j</groupId>
     <artifactId>log4j-core</artifactId>
     <version>2.17.2</version>
   </dependency>
   <dependency>
     <groupId>org.apache.logging.log4j</groupId>
     <artifactId>log4j-api</artifactId>
     <version>2.17.2</version>
   </dependency> 
   <dependency>
     <groupId>org.apache.logging.log4j</groupId>
     <artifactId>log4j-slf4j-impl</artifactId>
     <version>2.17.2</version>
   </dependency>   

 --db properties 파일 안에 driverClass 변경  
db.driverClass=net.sf.log4jdbc.sql.jdbcapi.DriverSpy
db.url=jdbc:log4jdbc:mysql://localhost:3306/mbasic
db.username=root
db.password=1234

spring 파일 5개선택
beans context jdbc mvc mybatis 



-------------------------------------------
-----------------------------
#5.   MVC
-----------------------------
▶STEP1. MVC
>> 서로 영향없이 쉽게 고칠수 있는 애플리케이션을 만들수 있음.
- MODEL   데이터 ( dto, dao, service )
- VIEW      화면   ( html, css, js/jquery)
- Controller 비지니스로직

▶STEP2. MVC1  vs  MVC2
1. MVC1 -   Controller 의 역할 jsp 담당
2. MVC2 -   Controller 의 역할 servlet 담당

▶STEP3. SPRING MVC
--------FrontController
            /list.do              BList           /board/list.jsp
[클라이언트] → [FrontController]   → 세부Controller → View
                                 → 세부Controller → View
                                 → 세부Controller → View
1. FrontController  공통작업수행
2. 세부Controller  View에 최종결과 생성
   
--------SPRING MVC
[클라이언트] 
↓  ① /list.do
 [FrontController] 
<<DispatcherServlet>>  ② Handler Mapping   @Controller
             ↓ 위임      
          ★③세부Controller   
         ← ④ 
⑥↑↓ ⑤   
View
① 클라이언트 요청  ( 코요테/ web.xml 
         - spring관련: root-context.xml,servlet-context.xml )
② DispatcherServlet - Handler Mapping을 사용해서 처리할 Controller확인
③ 세부Controller  클라이언트 요청처리 ( service - 비지니스로직 )
④ 요청결과와 View정보를 DispatcherServlet에게 줌
⑤ DispatcherServlet는 ViewResolver로 부터 응답결과를 생성할 View객체 생성
⑥ View 응답생성 - response




[실습]
1) view.zip 다운로드
2) servlet-context.xml 확인 -/view/ 폴더 안에 압축풀기
<bean id="viewResolver"
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/view/" />
		<property name="suffix" value=".jsp" />
	</bean>
3) com.the703.controller
- BoardController
■ RequestMapping 경로        ■해당 view 설정

/board/list.do             /view/board/list.jsp 
/board/write.do           /view/board/write.jsp    (글쓰기폼)
/board/detail.do          /view/board/detailjsp    (상세보기)
/board/edit.do            /view/board/edit.jsp     (수정하기폼)
/board/delete.do          /view/board/delete.jsp   (삭제하기폼)

--controller 파일에 만들기 
controller 파일 만들때 com.the703.controller 패키지 안에 컨트롤+n 하고 class 파일로 만들기

@RequestMapping("/basic.do")
	public String basic(Model model) {
		model.addAttribute("result","Hello");
		return "basic"; // /view/ +basic +.jsp
	}
