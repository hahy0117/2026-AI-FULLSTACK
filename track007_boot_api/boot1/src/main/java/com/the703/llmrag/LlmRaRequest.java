package com.the703.llmrag;

import java.util.List;

import lombok.Value;



@Value 
public class LlmRaRequest {
	String model;
	List<Message> messages;
	
	
}
