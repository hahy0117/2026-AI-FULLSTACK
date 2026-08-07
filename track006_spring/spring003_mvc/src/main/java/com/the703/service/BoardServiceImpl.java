package com.the703.service;


import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.the703.dao.BoardMapper;
import com.the703.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired BoardMapper  dao; //db 관련

	@Override
	public List<BoardDto> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public int insert(BoardDto dto,MultipartFile file) {
		
		
		if(! file.isEmpty()) {
			String fileName=file.getOriginalFilename();
			String uploadPath="C:/file/";
			File demp =new File(uploadPath+fileName);
			try {
				file.transferTo(demp);
			}
			 catch (IOException e) {		
				e.printStackTrace();
			}
			
			dto.setBfile(fileName);
			
		}
		try{
			dto.setBip(InetAddress.getLocalHost().getHostAddress());
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
		return dao.insert(dto);
	}

	@Override
	public BoardDto detail(int bno) {
		//조회수 올리기
		dao.updateHit(bno);
		return dao.select(bno);
	}

	@Override
	public BoardDto editView(int bno) {
		return dao.select(bno);
	}

	@Override
	public int edit(BoardDto dto,MultipartFile file) {
		//비번 맞으면 수정
		int result=-1; //비번 안 맞음
		BoardDto find=dao.select(dto.getBno());
		if(find.getBpass().equals(dto.getBpass())) {
			String fileName=dto.getBfile();
			if(!file.isEmpty()) {
				fileName=file.getOriginalFilename(); //기본 파일명으로 들어간거 넣고놓고
				String uploadPath="C:/file/";
				File demp= new File(uploadPath+fileName);
				try {
					file.transferTo(demp);
				} catch (IOException e) {					
					e.printStackTrace();
				}
				dto.setBfile(fileName); //파일명 셋팅
				result=dao.update(dto);
			}
		}
		
		return result;
	}

	@Override
	public int delete(BoardDto dto) {
		//비번 맞으면 삭제
		int result=-1; //비번 안 맞음
		BoardDto find = dao.select( dto.getBno() ); 
		if(find.getBpass().equals( dto.getBpass() )) {
			result = dao.delete(dto.getBno());
		}
		
		return result;
		
	}
	@Override
	public List<BoardDto> select10(int pstartno){
		HashMap<String,Integer> map =new HashMap<>();
		map.put("start", (pstartno-1)*10);
		map.put("end",10);
		return dao.select10(map);
		
	}
	@Override
	public int selectCnt() {
		return dao.selectCnt();
	}

	
}
