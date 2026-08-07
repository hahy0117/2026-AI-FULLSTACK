package com.the703.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.AppUserDto;
import com.the703.security.CustomUserDetails;
import com.the703.service.AppUserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired AppUserService service;
	
	
	
	@ResponseBody
	@GetMapping("/iddouble")
	public Map<String,Object> iddouble(@RequestParam("email") String email){
		Map<String,Object> result=new HashMap<>();
		
		result.put("exists", service.selectEmail(email, "local") !=null);
		
		return result;
		
	}
	
	
	@GetMapping("/join") public String joinForm() {
		return "users/join";
	}
	
	@PostMapping("/join") public String join(@RequestParam(value="file",required=false) MultipartFile file
			,AppUserDto dto,RedirectAttributes rttr) {
		dto.setMbtiTypeId(1);
		dto.setProviderId("1");
		try {
			int result=service.insert(file, dto);
			rttr.addFlashAttribute("successMessage",result>0? "회원가입 성공!":"회원가입 실패!");
			return "redirect:/users/login";
			
		}catch(Exception e) {
			rttr.addFlashAttribute("errorMessage","회원가입 실패!"+e.getMessage());
			return "redirect:/users/join";
		}
		
		
	}
	
	@GetMapping("/login") public String loginForm() {
		return "users/login";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/mypage") public String mypage(Authentication authentication,Model model) {
		String email=null,provider=null;
		Object principal=authentication.getPrincipal();
		
		//1.local
		if(principal instanceof CustomUserDetails) {
			CustomUserDetails users=(CustomUserDetails)principal;
			email=users.getUser().getEmail();
			provider=users.getUser().getProvider();
			
		}						
		//2.social
		model.addAttribute("dto",service.selectEmail(email, provider));
		
		return "users/mypage";
	}
	
	
	@GetMapping("/update") public String updateForm( Authentication authentication,Model model) {
		String email=null,provider=null;
		Object principal=authentication.getPrincipal();		
		
		if(principal instanceof CustomUserDetails) {
			CustomUserDetails users=(CustomUserDetails)principal;
			email=users.getUser().getEmail();
			provider=users.getUser().getProvider();
		}
			model.addAttribute("dto",service.selectEmail(email, provider));
		return "users/update";
	}
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/update") public String update(@RequestParam(value="file",required=false)
	MultipartFile file,AppUserDto dto,RedirectAttributes rttr
			) {
		int result=service.update(file, dto);
		rttr.addFlashAttribute("successMessage",result>0 ? "회원정보 수정 수정" : " 회원정보 수정 실패");
		return "redirect:/users/mypage";
	}
	
	@GetMapping("/delete") public String deleteForm() {
		return "users/delete";
	}
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/delete") public String delete(HttpServletRequest request, HttpServletResponse response ,Authentication authentication ,AppUserDto dto,RedirectAttributes rttr) {
		//사용자 정보-appUserId / email/provider(local:the703 , social:kakao-naver)
		String email=null,provider=null; int appUserId=-1;
		Object principal=authentication.getPrincipal();		
		
		if(principal instanceof CustomUserDetails) {
			CustomUserDetails users=(CustomUserDetails)principal;
			email=users.getUser().getEmail();
			provider=users.getUser().getProvider();
			appUserId=users.getUser().getAppUserId();
		}

		System.out.println(".............................1 > "+dto);
		
		//비밀번호 틀렸는 지 확인 
		if(! service.matchesPassword(email, provider, dto.getPassword())) {
			rttr.addFlashAttribute("errorMesage", "사용자 정보를 확인해주세요.");
			
		}

		System.out.println(".............................2 > "+dto);
		//탈퇴 - 유저정보삭제
		dto.setEmail(email); dto.setAppUserId(appUserId); dto.setProvider(provider);
		int result=service.delete(dto, true);

		System.out.println(".............................3 > "+result);
		if(result>0) {
			Authentication auth=SecurityContextHolder.getContext().getAuthentication();
			if(auth !=null) {
				new SecurityContextLogoutHandler().logout(request,response,auth);
			}rttr.addFlashAttribute("successMessage",result>0 ? "회원 탈퇴 완료" : "회원정보 탈퇴 실패");
			return "redirect:/users/login";
		}else {
			rttr.addFlashAttribute("errorMessage","회원탈퇴 실패");
			return "redirect:/users/delete";
		}
		
	}
	
	@GetMapping("/fail") public String failForm(Model model) {
		model.addAttribute("errorMEssage", "로그인 실패: 아이디 또는 비밀번호를 확인해주세요.");
		return "users/delete";
	}
}
