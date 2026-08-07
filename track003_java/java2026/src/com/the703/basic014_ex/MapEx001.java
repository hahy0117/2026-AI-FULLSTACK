package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MapEx001 {

	public static void main(String[] args) {
		Map<String,String> maps=new HashMap<>();
		maps.put("피구왕","통키");
		maps.put("제빵왕","김탁구");
		maps.put("요리왕","비룡");
		
		System.out.println("==============================");
		System.out.println("KING   NAME");
		System.out.println("==============================");
		
		for(Entry<String, String> u:maps.entrySet()) {
			String key =u.getKey();
			String value=u.getValue();
			System.out.println(key+"\t"+value);
			System.out.println("---------------------");
						
		}
		
		
		
		System.out.println("KING의 정보를 제공중입니다");
		System.out.println("이름을 입력하세요>");
		Scanner scanner=new Scanner(System.in);
		String name="";
		name=scanner.next();
		
		if(maps.containsKey(name)) {
			System.out.println("▣"+name+":"+maps.get(name));
		}else {
			System.err.println("찾으시는 왕이 없습니다.");
		}
		

	}

}
