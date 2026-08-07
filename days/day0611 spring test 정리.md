###  Spring
■ 기술스택 : spring + mysql  + mybatis  + security + jstl + ajax

- [ ] 1. project 만들기
    1. dynamic web project - projcte2
    2. configure  - [Convert to Maven Project]
    3. spring      - add Spring project Nature
    4. java se-11 / project facts, build path

- [ ] 2. pom.xml
부품객체 다운로드-

 <packaging>war</packaging>
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
       <groupId>org.mybatis</groupId>  --sql 구문 처리
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
      
      
   
   <!-- spring-webmvc -->   
   <!-- spring-webmvc -->   
   <!-- spring-webmvc -->    
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
     <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-webmvc</artifactId>
       <version>4.3.27.RELEASE</version>
     </dependency>
   <!-- jstl -->    
   <!-- jstl -->    
     <!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
   <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
   </dependency>
   
   <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
   </dependency>     
      
      
<!-- img upload -->   
<!-- img upload -->    
   <!-- commons-fileupload -->
   <dependency>
      <groupId>commons-fileupload</groupId>
      <artifactId>commons-fileupload</artifactId>
      <version>1.3.1</version>
   </dependency>

   <!-- commons-io -->
   <dependency>
      <groupId>commons-io</groupId>
      <artifactId>commons-io</artifactId>
      <version>2.11.0</version>
   </dependency>
<!-- img upload -->   
<!-- img upload -->          
      
      
      <!-- SECURITY -->
      <!-- SECURITY -->
      <!-- SECURITY -->
      <!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-core -->
      <dependency>
         <groupId>org.springframework.security</groupId>
         <artifactId>spring-security-web</artifactId>
         <version>4.2.2.RELEASE</version>
         <!-- <version>5.0.7.RELEASE</version> -->
      </dependency>
      <dependency>
         <groupId>org.springframework.security</groupId>
         <artifactId>spring-security-config</artifactId>
         <version>4.2.2.RELEASE</version>
      </dependency>
      <dependency>
         <groupId>org.springframework.security</groupId>
         <artifactId>spring-security-core</artifactId>
         <version>4.2.2.RELEASE</version>
      </dependency>
      <dependency>
         <groupId>org.springframework.security</groupId>
         <artifactId>spring-security-taglibs</artifactId>
         <version>4.2.2.RELEASE</version>
      </dependency>
      <!-- SECURITY -->
      <!-- SECURITY -->
      <!-- SECURITY -->      
      <!-- jackson -->
      <!-- jackson -->
      
      <!-- https://mvnrepository.com/artifact/org.codehaus.jackson/jackson-mapper-asl -->
      <!-- <dependency> <groupId>org.codehaus.jackson</groupId> <artifactId>jackson-mapper-asl</artifactId> 
         <version>1.9.13</version> </dependency> -->
      <dependency>
         <groupId>com.fasterxml.jackson.core</groupId>
         <artifactId>jackson-databind</artifactId>
         <version>2.17.2</version> <!-- 최신 안정 버전 사용 -->
      </dependency>
      <dependency>
         <groupId>com.fasterxml.jackson.core</groupId>
         <artifactId>jackson-core</artifactId>
         <version>2.17.2</version>
      </dependency>
      <dependency>
         <groupId>com.fasterxml.jackson.core</groupId>
         <artifactId>jackson-annotations</artifactId>
         <version>2.17.2</version>
      </dependency>
      
  </dependencies>

  
<build>
    <resources>
       <resource>
          <directory>src/main/resources</directory>
       </resource>
    </resources> 

- [ ] 3. web.xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" id="WebApp_ID" version="4.0">
  <display-name>project2</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  
  <!-- UTF-8  -->
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
  
  
  <!-- 스프링구동  C : ContextLoaderListener -->
  <!-- needed for ContextLoaderListener -->
   <context-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:/config/*-context.xml</param-value>
   </context-param>

   <!-- Bootstraps the root web application context before servlet initialization -->
   <listener>
      <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
   </listener>
   
  
   <filter>
      <filter-name>springSecurityFilterChain</filter-name>
      <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
   </filter>
   <filter-mapping>
      <filter-name>springSecurityFilterChain</filter-name>
      <url-pattern>/*</url-pattern>
   </filter-mapping>
      
   
  <!-- 경로처리   D : DispatcherServlet -->
  <!-- The front controller of this Spring Web application, responsible for handling all application requests -->
   <servlet>
      <servlet-name>springDispatcherServlet</servlet-name>
      <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
      <init-param>
         <param-name>contextConfigLocation</param-name>
         <param-value>classpath:/config/servlet-context.xml</param-value>
      </init-param>
      <load-on-startup>1</load-on-startup>
   </servlet>

   <!-- Map all requests to the DispatcherServlet for handling -->
   <servlet-mapping>
      <servlet-name>springDispatcherServlet</servlet-name>
      <url-pattern>/</url-pattern>
   </servlet-mapping>
  
  
</web-app>

- [ ] 4. confing  
    1. root-context.xml
    2. servlet-context.xml
    3. security-context.xml
    
    src/main/java 우클릭 -> new-> other 들어간 다음 spring 치고 맨 위에 /config 쓰고 그 안에 root-context.xml 만들어서 beans context jdbc bybatis 만들고
    나머지 2,3번 파일은 복사 붙여 넣기 하고 이름 변경

- [ ] 5. 각종설정파일
project2 우클릭 -> new -> source folder ->src/main/resources 이름 설정
1.root-context.xml 관련
config 우클릭 -> file ->db.properties
   config/db.properties
   
   config/mybatis-config.xml
   config/test-mapper.xml
   com.the703.dao.mapper -> src/main/java -> package 누르고 만들기
   패키지 안에 인터페이스 파일 Mapper 만들기

src/main/resuores 파일안에 
파일 두개 넣기
   resources/log4j2.properties
   resources/log4jdbc.log4j2.properties

   user-mapper.xml 만들고

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.the703.dao.UserMapper">



	<select resultMap="authListMap" id="readAuth"
		parameterType="string">
		select u.email, u.bpass, a.auth
		from users u left join authorities a on u.email = a.email
		where u.email =#{email}
	</select>
	<resultMap id="authListMap" type="AuthUserDto">
		<result property="email" column="email" />
		<result property="bpass" column="bpass" />
		<collection property="authList" resultMap="authMap" />
	</resultMap>
	<resultMap id="authMap" type="AuthDto">
		<result property="auth" column="auth" />
	</resultMap>
	
	
</mapper>

- [ ] 6. 부품테스트
context,ds,sqlsession
test-mapper.xml /TestMapper
select now() public String now()
----------------------------------
여기서 부터는 각자 파트 하기

- [ ] 7. 개발 - Model
0)테이블 만들기
1)boardDto -com.the703.dto/mybatis-config.xml  
mybatis에 	<typeAlias type="com.the703.dto.BoardDto" alias="BoardDto"/> 등록하기
2)BoardMapper,board-mapper.xml -root-context.xml
3)BoardService,BoardSeriveImpl 


- [ ] 8. 개발 - Controller
4) BoardCotroller - Service 사용 - security-context.xml (허용)


- [ ] 9. 개발 - 
5)[view]-[board]  -csrf


 