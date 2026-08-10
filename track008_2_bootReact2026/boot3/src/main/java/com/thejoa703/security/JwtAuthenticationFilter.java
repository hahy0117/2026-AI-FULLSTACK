package com.thejoa703.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.thejoa703.oauth2.CustomOAuth2User;

//import com.thejoa703.oauth2.CustomOAuth2User;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

 //보안게이트
//jwt 인증필터
//jwtprovider 로 claims 파싱
//customOAuth2User 기반 Principal 생성 후 SecurityContext 에 저장
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	//jwt 토큰 발급 /검증
    private final JwtProvider jwtProvider;
    //생성자 -jwt
    public JwtAuthenticationFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }
    // /uploads/ 로 시작하는 요청은 Jwt 필터 타지 않게 통과
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return path.startsWith("/uploads/");
    }
    
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {
    	// Step1:주소와 헤더가 백엔드 필터까지 전송되고 있는 지 확인
        String header = request.getHeader("Authorization");
  

        if (StringUtils.hasText(header) && header.startsWith("Bearer ")) {
            String token = header.substring(7); //7자 빼고 
            try { 
                System.out.println("====== [Filter] 추출된 토큰: " + token);

                Claims claims = jwtProvider.parse(token).getBody();  
                Long userId = Long.parseLong(claims.getSubject());
                String role = claims.get("role", String.class);
                 
                System.out.println("====== [Filter] 파싱 성공 -> userId: " + userId + ", role: " + role);
                
                 CustomOAuth2User userPrincipal = new CustomOAuth2User(userId, role);

                 UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(
                                userPrincipal, null, userPrincipal.getAuthorities()
                 );

                 SecurityContextHolder.getContext().setAuthentication(auth);
                  
                 System.out.println("====== [Filter] SecurityContext에 인증 정보 저장 완료! ======");
 
            } catch (Exception e) { 
            	//토근 파싱,검증시 에러나는지 확인
                System.out.println("에러 원인: " + e.getMessage());
                e.printStackTrace(); 
                
                SecurityContextHolder.clearContext();
            }
        } else { 
            System.out.println("  [Filter] Authorization 헤더가 누락되었거나 Bearer 형식이 아닙니다.");
        }

        chain.doFilter(request, response);
    }
}
