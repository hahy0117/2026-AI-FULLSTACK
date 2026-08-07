package com.the703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.BoardDto;
import com.the703.service.BoardService;
import com.the703.util.PagingUtil;

@Controller
public class BoardController {
	@Autowired
	BoardService service;

	// ■ 전체 리스트
	@RequestMapping("/board/list.do")
	public String list(Model model,@RequestParam(value="pstartno",defaultValue="1")int pstartno) {
		model.addAttribute("paging", new PagingUtil(service.selectCnt(),pstartno));
		model.addAttribute("list",service.select10(pstartno));
		return "board/list";
	}

	public String list() {
		return "board/list";
	}

	// ■ 글쓰기 폼경로
	@RequestMapping(value = "/board/write.do", method = RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("list", service.selectAll());
		return "/board/write";
	}

	// ■ 글 쓰기 기능
	@RequestMapping(value = "/board/write.do", method = RequestMethod.POST)
	public String write_post(BoardDto dto,
			@RequestParam("file") MultipartFile file,
			RedirectAttributes rttr) {
		String result = "글쓰기 실패";

		if (service.insert(dto,file) > 0) {
			result = "글쓰기 성공";
		}
		rttr.addFlashAttribute("result", result);
		return "redirect:/board/list.do";
	}
	// ■ 글 상세보기

	@RequestMapping("/board/detail.do")
	public String detail(int bno, Model model) {
		model.addAttribute("dto", service.detail(bno));
		return "board/detail";
	}

	public String detail() {
		return "/board/detail";
	}

	// ■ 글 수정 폼경로
	@RequestMapping(value = "/board/edit.do", method = RequestMethod.GET)
	public String edit(int bno, Model model) {
		// 넘겨받는 bno , edit.jsp
		model.addAttribute("dto", service.editView(bno));
		return "board/edit";

	}

	// ■ 글 수정 기능
	@RequestMapping(value = "/board/edit.do", method = RequestMethod.POST)
	public String edit_post(BoardDto dto, RedirectAttributes rttr,
			@RequestParam("file")MultipartFile file
			) {
		String result = "비밀번호 확인";

		if (service.edit(dto,file) > 0) {
			result = "수정성공";
		}
		rttr.addFlashAttribute("result", result);

		return "redirect:/board/detail.do?bno=" + dto.getBno();
	}

	// ■ 글 삭제 폼경로
	@RequestMapping(value = "/board/delete.do", method = RequestMethod.GET)
	public String delete(int bno) {
//		model.addAttribute("dto",service.delete(bno));
		return "board/delete";

	}

	// ■ 글 삭제 기능
	@RequestMapping(value = "/board/delete.do", method = RequestMethod.POST)
	public String delete_post(BoardDto dto, RedirectAttributes rttr) {

		

		String result = "비밀번호 확인";
		if (service.delete(dto) > 0) {
			result = "삭제 성공";
		}
		rttr.addFlashAttribute("result", result);
		return "redirect:/board/list.do";
	}

}
