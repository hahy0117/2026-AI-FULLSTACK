package com.the703;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.the703.dao.Sboard2Dao;
import com.the703.dao.TestDao;
import com.the703.dto.Sboard2Dto;
import com.the703.service.Sboard2Service;

@SpringBootTest
class Boot1ApplicationTests {
@Autowired TestDao dao;
@Autowired Sboard2Dao sboard2dao;
@Autowired Sboard2Service sboard2Service;


@Test
public void test09_update() {
	
}

@Test
public void test08_detail() {
	Sboard2Dto dto=new Sboard2Dto();
	dto.setId(1);
	assertEquals(1,sboard2Service.detail(dto).getId());
}


@Disabled @Test
public void test07_service_paging() {
	assertEquals(3,sboard2Service.list10(1).size());
	
	assertEquals(3,sboard2Service.selectCnt());
}

@Disabled @Test
public void test06_service_insert() {
	Sboard2Dto dto = new Sboard2Dto();
	dto.setAppUserId(1);
	dto.setBtitle("title"); dto.setBcontent("content");
	dto.setBpass("1111");
	
	MockMultipartFile file= new MockMultipartFile("file","test.txt","test/plain","data".getBytes());
	//import org.springframework.mock.web.MockMultipartFile;
	
	int result=sboard2Service.insert(file,dto);
	assertEquals(1,result);
}


@Disabled @Test
public void test05_delete() {
	Sboard2Dto dto=new Sboard2Dto();
	dto.setId(0);
	int result=sboard2dao.delete(dto);
	assertEquals(0, result);
}

@Disabled  @Test
public void test04_update() {
	Sboard2Dto dto=new Sboard2Dto();
	dto.setBtitle("title-new"); dto.setBcontent("content-new");
	dto.setBfile("1.png"); dto.setId(2);
}


@Disabled @Test
	public void test03_byId() {
		Sboard2Dto dto =new Sboard2Dto();
		dto.setId(2);
		Sboard2Dto result = sboard2dao.selectById(dto);
		assertEquals(2, result.getId());
		
	}


	@Disabled @Test
	public void test02_paging() {
		HashMap<String,Object> para=new HashMap<>();
		para.put("start", 0);
		para.put("end",10);
        List<Sboard2Dao> list10=sboard2dao.selectPaging(para);
        assertEquals(6,list10.size());//6숫자는 지금 있는 list 의 갯수로 (예상되는 결과,해당코드)
        assertNotNull(list10);
        
        
        
	}
	
	//@Test
	public void test01_insert() throws UnknownHostException {	
		Sboard2Dto dto= new Sboard2Dto();
		dto.setAppUserId(1); dto.setBtitle("title"); dto.setBcontent("content");
		dto.setBpass("1111"); dto.setBfile("1.png"); dto.setBip(InetAddress.getLocalHost().getHostAddress());
		
		
		
		
	
	int result=sboard2dao.insert(dto);
	System.out.println("......1>"+result);
	assertEquals(1, result);
	
	}

	
}
