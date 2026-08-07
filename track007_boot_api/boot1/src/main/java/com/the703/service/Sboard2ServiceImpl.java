 package com.the703.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.the703.dao.Sboard2Dao;
import com.the703.dto.Sboard2Dto;
import com.the703.util.UtilUpload;

@Service
public class Sboard2ServiceImpl implements Sboard2Service {
@Autowired UtilUpload upload;
@Autowired  Sboard2Dao  dao;	
	//전체페이징 (페이징)
	@Override
	public List<Sboard2Dao> list10(int pageNo) { //(1) 0,10 (2) 10,10
		HashMap<String,Object> para=new HashMap<>();
		  para.put("start",   (pageNo-1)*10);
		para.put("end",10);
		return dao.selectPaging(para);
	}
	//갯수 카운트
	@Override
	public int selectCnt() {
		return dao.selectCnt();
	}
	//상세조회
	@Transactional
	@Override
	public Sboard2Dto detail(Sboard2Dto dto) {
		dao.updateHit(dto);
		return dao.selectById(dto) ;
	}
	//입력기능
	@Override
	public int insert(MultipartFile file, Sboard2Dto dto) {
		if(!file.isEmpty()) {
			try {
				dto.setBfile(upload.fileUpload(file));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		 
			try {
				dto.setBip(InetAddress.getLocalHost().getHostAddress());
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		
		return dao.insert(dto);
	}
	//수정폼
	@Override
	public Sboard2Dto updateForm (Sboard2Dto dto) {
		return dao.selectById(dto);
	}
	//수정기능(이미지 올리기)
	@Override
	public int update(MultipartFile file, Sboard2Dto dto) {
		if(!file.isEmpty()) {
			try {
				dto.setBfile(upload.fileUpload(file));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return dao.update(dto);
	}
	//삭제기능
	@Override
	public int delete(Sboard2Dto dto) {
		return dao.delete(dto);
	}

}
