package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;
class BookDto{
	private String title;
	private String author;
	public BookDto() {
		super();
		
	}
	public BookDto(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	@Override
	public String toString() {
		return "BookDto [title=" + title + ", author=" + author + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(author, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDto other = (BookDto) obj;
		return Objects.equals(author, other.author) && Objects.equals(title, other.title);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}

public class MapEx002 {

	public static void main(String[] args) {
		Map<String,BookDto> maps=new HashMap<>();
		maps.put("978-11111",new BookDto("자바의 완성","가길동"));
		maps.put("978-22222",new BookDto("파이썬기초","홍길동"));
		maps.put("978-33333",new BookDto("자료구조와 알고리즘","나길동"));
		
		System.out.println("==============================");
		System.out.println("ISBN        TITLE        AUTHOR");
		System.out.println("==============================");
		
		for(Entry<String,BookDto> u:maps.entrySet()) {
			String key =u.getKey();
			String title=u.getValue().getTitle();
			String Author=u.getValue().getAuthor();
			System.out.println(key+"|"+title+"|"+Author);
		}
		
		System.out.println("도서 정보를 제공중입니다");
		System.out.println("ISBN을 입력하세요>");
		Scanner scanner=new Scanner(System.in);
		String num="";
		num=scanner.next();
		
		if(maps.containsKey(num)) {
			System.out.println("선택한 도서정보:"+maps.get(num).getTitle()+"/ 저자:"+maps.get(num).getAuthor());
		}else {
			System.err.println("찾으시는 도서가 없습니다.");
		}
		
		

	}

	private static String getAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	private static String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

}
