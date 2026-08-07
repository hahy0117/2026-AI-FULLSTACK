package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
class BookDTO{
	private String title;
	private String author;
	public BookDTO() {
		super();
		
	}
	public BookDTO(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	@Override
	public String toString() {
		return "BookDTO [title=" + title + ", author=" + author + "]";
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

public class MapEx003 {

	public static void main(String[] args) {
		Map<String, Map<String, BookDTO>> library = new HashMap<>();
		

	}

}
