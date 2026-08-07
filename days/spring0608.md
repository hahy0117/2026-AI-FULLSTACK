진행2. board 에 이미지 업로드 추가
0) 테이블에 이미지 경로추가
    bfile  varchar(500) 기본값 the703.png

- 테이블수정
- dto 수정
- board-mapper.xml 수정

1) 글삽입에서 이미지 업로드 추가
2) 글수정에서 이미지 업로드 추가
3) 상세보기 이미지가 있다면

3.paging?
cmd)
insert into mvcboard2(bname,bpass,btitle,bcontext,bip,bfile)
select bname,bpass,btitle,bcontent,bip,bfile from mvcboard2;

진행2.paging 컴포넌트 만들기

paging 1- Model) Mapper
1) 최신글을 기준으로 10개씩 가져오기
select*from mvcboard2 order by bno desc limit 0,10; 어디서부터,몇개
select*from mvcboard2 order by bno desc limit 10,20;
select*from mvcboard2 order by bno desc limit 20,10;
paging 3- Controller ) BoardController 사용

2) 전체 게시글 갯수
select count(*) from mvcboard2;

paging 2-Model 2) PagingUil

paging 3 - Controller) BoardController 사용 

paging 4-jsp) View 사용
