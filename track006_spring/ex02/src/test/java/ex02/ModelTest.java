package ex02;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.BoardMapper;
import com.the703.dao.TestMapper;
import com.the703.dto.BoardDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/root-context.xml")
public class ModelTest {
	@Autowired
	ApplicationContext context;
	@Autowired
	DataSource dataSource;
	@Autowired
	SqlSession sqlSession;
	@Autowired
	TestMapper testMapper;
	@Autowired BoardMapper boardMapper;
	/*
	 * @Test public void test1() { System.out.println(context); }
	 */

	@Ignore // @Test
	public void test2() {
		System.out.println(sqlSession);
	}

	@Ignore // @Test
	public void test3() {
		System.out.println(testMapper.now());
	}
	 @Test
	public void test4() throws UnknownHostException {
		//삭제
		System.out.println(boardMapper.delete(1));
		//수정
		BoardDto dto2=new BoardDto();
		dto2.setBname("first");
		dto2.setBtitle("첫번째 글쓰기"); 
		dto2.setBcontext("내용");
		System.out.println(boardMapper.update(dto2));
		//검색
		System.out.println(boardMapper.select(1));
		
		//삽입
		BoardDto dto= new BoardDto();
		dto.setBname("first");
		dto.setBpass("1111");
		dto.setBtitle("첫번재 글쓰기");
		dto.setBcontext("내용");
		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		System.out.println(boardMapper.insert(dto));
		System.out.println(boardMapper.selectAll());
	}
	@Ignore // @Test
	public void test5() {
		BoardDto dto2=new BoardDto();
		dto2.setBtitle("first");
		dto2.setBcontext("첫번째 글쓰기"); 
		dto2.setBno(2);
		System.out.println(boardMapper.update(dto2));
	}
	
}
