package com.the703.basic014_ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//아이스크림정보 클래스
class lceCreamDTO {
	private String name;
	private int price;

	// 생성자,필요하다면 추가 ,toString, getters/setters, hashCode/equals
	public lceCreamDTO() {
		super();

	}

	public lceCreamDTO(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public lceCreamDTO(String name2) {
		
		this.name=name2;
		
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		lceCreamDTO other = (lceCreamDTO) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "lceCreamDTO [name=" + name + ", price=" + price + "]";
	}

}

//2. List 사용클래스
public class ListEx003 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name;
		int price = 0;
		List<lceCreamDTO> list = new ArrayList<>();
		System.out.println("❄️🍦 Welcome to the Magical IceCream Land 🍦❄️");
		System.out.println("✨ 오늘도 달콤한 하루가 시작됩니다! ✨");
		System.out.println("🛎️ 손님~ 어떤 아이스크림을 원하시나요?");
		int menu = -1;
		while (true ) {
			
			System.out.println("📋 메뉴판");
			System.out.println("🍧 IceCream Menu 🍧");
			System.out.println("1️ 아이스크림 추가");
			System.out.println("2️ 아이스크림 목록 보기");
			System.out.println("3️ 아이스크림 제거");
			System.out.println("4️ 아이스크림 존재 확인");
			System.out.println("5️ 총 아이스크림 개수");
			System.out.println("0️ 종료");
			menu = scanner.nextInt();
			if (menu == 0) {
				System.out.println("종료");
				break;
			}

			switch (menu) {

			case 1:
				System.out.println("아이스크림 추가");
				System.out.println("아이스크림 이름입력>");
				name = scanner.next();
				System.out.println("아이스크림 가격입력>");
				price = scanner.nextInt();
				list.add(new lceCreamDTO(name, price));
				System.out.println("이름:" + name + "\n" + "가격:" + price + "\n" + "추가완료");
				continue;

			case 2:
				System.out.println("아이스크림 목록보기");
				if (list.size() == 0) {
					System.out.println("현재등록된 아이스크림이 없습니다.");
				} else {
					for (int i = 0; i < list.size(); i++) {
						lceCreamDTO ice = list.get(i);
						System.out.println(ice.getName() + ice.getPrice());
					}
					continue;
				}
				
			case 3:
				System.out.println("아이스크림 제거");
				System.out.println("제거할 아이스크림 이름>");
				name=scanner.next();

				
				lceCreamDTO re = new lceCreamDTO(name);
				list.remove(re);				
				System.out.println("제거완료"); 
				continue;
				
			case 4:
				System.out.println("아이스크림 존재 확인");
				System.out.println("확인 할 아이스크림 이름>");
				name=scanner.next();
				lceCreamDTO co = new lceCreamDTO(name);
				if(list.contains(co)){
					System.out.println("확일 할 아이스크림 이름"+name);
				}else {
					System.out.println("없습니다");
				}continue;
			
			case 5:
				System.out.println("총 아이스크림 개수");
				System.out.println("아이스크림 개수는"+list.size());
				continue;
			}
		}

	}

}
