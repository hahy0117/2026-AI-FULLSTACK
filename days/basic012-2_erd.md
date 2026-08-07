1.erd (ENTITY  RELATIONSHIP DIAGRAM) 
데이터 관계간에 초점을 둔 모델

1.개체(entity) -테이블
2.속성(attribute) - 열 ,컬럼
3.관계(relationship) -외래키
예) emp(deptno)  dept(deptno)

2.~로 구성되어있다

ex1) 하나의 A는 여러개의 B로 구성되어 있다
[홍길동]┼───┼[주민증]

ex2) 하나의 A는 여러개의 B로 구성되어 있다
[홍길동]┼───∈[java,jsp,spring,mysql]

3.점선 vs 실선
실선: 부모테이블의 기본키를 자식테이블의 기본키로 사용
점선: 부모테이블의 기본키를 자식테이블의 기본키로 사용 안한 경우 

 1:다 다:다
-학과와 학생 1:다
학과는 많은 학생을 가질 수 있다.
학생은 한 학과에 소속된다.

-학과와 교수 1:다
학과는 많은 교수를 가질 수 있다.
교수는 한 학과에 소속된다.

-교수와 개설과목 1:다
학과는 많은 과목을 가르칠 수 있다.
과목은 강의하는 교수 한명이 지정된다.

-과목과 학생 다:다
과목은 수강하는 많은 학생을 가진다.
학생은 많은 과목을 수강 할 수 있다.


<<테이블>>
    학생(Student)
        학번(std_id), 성명(std_name), 키(height), 학과코드(dept_id)

    학과(Department)
        학과코드(dept_id), 학과명(dept_name)

    교수(Professor)
        교수코드(prof_id), 교수명(prof_name), 학과코드(dept_id)

    개설과목(Course)
        과목코드(course_id), 과목명(course_name), 교수코드(prof_id),
        시작일(start_date), 종료일(end_date)

    수강(std_Course)
        학번(std_id), 과목코드(course_id)

ex1)   학과와 학생은  
<< 학과(Department)>>┼ ------------- ∈<<학생(Student)>>
학과코드(dept_id)                           학번(std_id) 
학과명(dept_name)                          성명(std_name)   
                                          키(height)   
                                         학과코드(dept_id:☆fk)

1)학과와 학생은 1:다
2)부모테이블:학과  / 자식테이블 : 학생
3)점선


학과와 교수는   
<< 학과(Department)>> ┼ ----------------∈<< 교수(Professor)>>
학과코드(dept_id)                       교수코드(prof_id)  
학과명(dept_name)                   교수명(prof_name)
                                   학과코드(dept_id)   
1)학과와 교수 -> 1:다
2)부모테이블:학과 /자식테이블 :교수
3)점선

ex3) 교수와 개설과목 -> 1:다
학과는 많은 과목을 가르칠 수 있다
과목은 강의하는 교수한명이 지정된다.
교수와 개설과목은  1:다 관계

<< 교수(Professor)>> ┼ -------------------++++      ∈ <<개설과목(Course)>>
교수코드(prof_id)                               과목코드(course_id:prof_id:)      
교수명(prof_name                               과목명(course_name)  
학과코드(dept_id)                               교수코드(prof_id *fk)
                                               시작일(start_date)
                                               종료일(end_date)


 ex4) 과목와 학생     → 다:다
    과목은 수강하는 많은 학생을 가진다.
    학생은 많은 과목을 수강할 수 있다.

<<개설과목(Course)>                <<수강(std_Course)>>                <<학생(Student)>>
과목코드(course_id:prof_id)         학번(std_id)                      학번(std_id)       
과목명(course_name)               과목코드(course_id)                  성명(std_name)
교수코드(prof_id)                                                    키(height)
시작일(start_date)                                                    학과코드(dept_id)
종료일(end_date)

       

예)    dept(deptno)┼------─∈emp(deptno)     
       deptno(★PK)        empno(★PK)
                           deptno(☆FK)  

풀이1) dept와 emp은   1:다
      한 부서는 여러명의 사원이 소속  
풀이2) 부모테이블 : dept      /  자식테이블  :   emp
      dept 테이블이 존재해야, 사원을 해당 부서에 배치 
풀이3) 점선(비식별관계)계)       

FOREIGN KEY
    => 외래키(참조키)
    => 다른테이블의 기본키를 참조하는 키
    => 중복가능 / NULL 허용함
    => 참조되고있는테이블의 데이터 값 이외의 값은 삽입할수 없음.
    => insert할때 잘못된 데이터 삽이 안되록하는 것
    => 레코드 삭제나 테이블삭제를 할때는 반드시 FOREIGN KEY가
       지정된 레코드나 테이블을 삭제한후에 참조대상을 삭제할수 있다.


    방법
       [ CONSTRAINT 별칭 ] REFERENCES 테이블이름(필드명)

       ----
(1) 부모테이블 t1
create table t1 ( no int not null  auto_increment primary key, name varchar(100));

(2) 자식테이블 t2                   
create table t2 (
    ino   int not null      primary key ,
    foreign key(ino)  references t1(no)
)   -- 외래키 (ino)    참고테이블 t1(no필드)

(3) t1에서 no는 1,2  부모의 값이 : 1,2
   insert into  t1( no, name ) values (1,'first');
   insert into  t1( no, name ) values (2,'second');

(4) 다음에서 오류나는 코드는?
    insert into t2 (ino)  values (1);
    insert into t2 (ino)  values (3);
ERROR 1452 (23000): Cannot add or update a child row: a foreign key constraint fails (`mbasic`.`t2`, CONSTRAINT `t2_ibfk_1` FOREIGN KEY (`ino`) REFERENCES `t1` (`no`))

(5) 부모테이블 t3
create table t1 ( no int not null  auto_increment primary key, name varchar(100));

(6) 자식테이블 t4                 
create table t2 (
    ino   int not null      primary key ,
    foreign key(ino)  references t1(no)
)   -- 외래키 (ino)    참고테이블 t1(no필드)

(7)
 insert into  t3( no, name ) values (1,'first');
insert into  t3( no, name ) values (2,'second');
insert into t4(ino) vlues (2);
