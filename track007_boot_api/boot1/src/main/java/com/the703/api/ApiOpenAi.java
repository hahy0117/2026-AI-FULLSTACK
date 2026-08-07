package com.the703.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class ApiOpenAi {
	@Value("${openai.api.key}")
	private String apiKey;

	private static final String API_URL = "https://api.openai.com/v1/chat/completions"; //1.주소 고정
	private final ObjectMapper objectMapper = new ObjectMapper();
	private final RestClient restClient;

	public ApiOpenAi(RestClient.Builder restClientBuilder) {
		this.restClient = restClientBuilder.baseUrl(API_URL).build();
	}
	
	public String getAIResponse(String userMessage) {
		Map<String,Object> body=Map.of(
				"model","gpt-4.1",
				"messages",List.of(
						Map.of("role","user","content",userMessage+"내용을 이모티콘으로 요약해줘")
						)
				);
		//user ->당신은 업로드된 문서 내용을 기반으로 답변하는 전문 비서입니다.
		//content -> 00내용을 이모티콘으로 요약해줘
		
		
		
		
		try {
			//2.RestClient 스타일세팅 값 받아오기
			String responseBody = restClient.post()
					.contentType(MediaType.APPLICATION_JSON)
					.header("Authorization","Bearer "+apiKey)
					.body(body)
					.retrieve()
					.body(String.class); // 응답을 String 으로 받기
			
			
			//3.json 파싱
			JsonNode root =objectMapper.readTree(responseBody);
			return root.path("choices").get(0).path("message").path("content").asText();
		}catch(Exception e) {
			throw new RuntimeException("open ai 호출 응답파싱오류",e);
		}
		
	}
}
/*
 * 
 * curl https://api.openai.com/v1/chat/completions \ -H
 * "Content-Type: application/json" \ -H "Authorization: Bearer $OPENAI_API_KEY"
 * \ -d '{ "model": "VAR_chat_model_id", "messages": [ { "role": "developer",
 * "content": "You are a helpful assistant." }, { "role": "user", "content":
 * "Hello!" } ] }'
 * 
 * 
 * 
 * 
 */
