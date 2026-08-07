package com.the703.basic014_ex;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class UserInfo2{
	private int no;
	private String name;
	private int age;
	public UserInfo2() {
		super();
		
	}
	public UserInfo2(int no, String name, int age) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserInfo2 [no=" + no + ", name=" + name + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, name, no);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo2 other = (UserInfo2) obj;
		return age == other.age && Objects.equals(name, other.name) && no == other.no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	 
}
public class SetEx001 {

	

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		String find=""; double avg=0;
		Set<UserInfo2> set1=new HashSet<>();
		set1.add(new UserInfo2(1,"아이언맨",50));
		set1.add(new UserInfo2(2,"헐크",40));
		set1.add(new UserInfo2(3,"캡틴",120));
		
		for(UserInfo2 u:set1) {
			System.out.println(u.getNo()+"-"+u.getName()+"-"+u.getAge());
			avg+=u.getAge(); //유저 나이 누적
		}
		
		System.out.println("찾을 유저이름>");
		find = scanner.next();
		
				
		for(UserInfo2 u:set1) {
			if(u.getName().equals(find)) {
				System.out.println(u);			
			}
		}
		double avg1=0;
		avg1 = avg/set1.size();
		System.out.println("나이평균:"+(double)avg/set1.size());
		System.out.println("나이평균:"+ avg1);

	}

}
