package com.the703.basic013_ex;

interface Animal {
	   public void sound();
	} 
	class Dog implements Animal {
	   @Override
	   public void sound() {
	      System.out.println("멍멍!");
	   }
	   public void playFetch() {
	      System.out.println("강아지가 공을 물어옵니다.");
	   }
	}
	class Cat implements Animal {
	   @Override
	   public void sound() {
	      System.out.println("야옹~");
	   }
	   public void scratch() {
	      System.out.println("고양이가 발톱을 세웁니다.");
	   }
	}
	class Bird implements Animal {
	   @Override
	   public void sound() {
	      System.out.println("짹짹!");
	   }
	   public void fly() {
	      System.out.println("새가 하늘을 납니다.");
	   }
	}
	class ZooKeeper{
		public void show(Animal a) {
			a.sound();
			if(a instanceof Dog) {
				((Dog)a).playFetch();
							
			}else if(a instanceof Cat) {
				((Cat) a).scratch();
			}else if(a instanceof Bird) {
				((Bird) a).fly();
			}
			 //animal {sound}=[1번지] Dog{@sound(),playFetch()}-{----}
	         //animal {sound}=[2번지] Cat{@sound(),scratch()}-{----}
	         //animal {sound}=[3번지] Bird{@sound(),fly() }-{----}
		}
	}



public class InterfaceEx003 {

	public static void main(String[] args) {
		 java.util.Scanner sc = new java.util.Scanner(System.in);
		 Animal[] menu= {new Dog(),new Cat(),new Bird()};
		 ZooKeeper keeper =new ZooKeeper();
		 
		 while (true) {
	         System.out.println("=== 동물원 메뉴판 ===");
	         System.out.println("1. 강아지");  //choice 1 menu[0]
	         System.out.println("2. 고양이"); // choice 2 menu[1]
	         System.out.println("3. 새");   //  choice 3  menu[2]
	         System.out.println("0. 종료");
	         System.out.print("선택: ");
	         int choice = sc.nextInt();

	         if (choice == 0) {
	            System.out.println("동물원 관람을 종료합니다.");
	            break;
	         }
	         if(choice>=1 && choice<=menu.length) {
	        	 Animal a =menu[choice-1]; //배열에서 꺼내오기 menu[0]
	        	 keeper.show(a);
	        	 //리턴값 메서드명 (파라미터)
	        	 //void make(Drink drink)
	         }else {
	        	 System.out.println("잘못된 선택입니다");
	         }

	         Animal animal = null;
	         switch (choice) {
	            case 1: animal = new Dog(); break; // 부모=자식 (Dog,Cat,
	            case 2: animal = new Cat(); break; // 업캐스팅
	            case 3: animal = new Bird(); break;// 부모타입으로 메서드호출시 오버라이드된 최신 자식 메서드가 호출
	            default: System.out.println("잘못된 선택입니다."); continue;
	         }
	         
	         

	         // ZooKeeper 클래스의 show() 메서드 호출
	        
	         
	         keeper.show(animal);
	         System.out.println();
	      }
	      sc.close();

	}

}
//if (choice >= 1 && choice <= menu.length) {
//    Drink drink = menu[choice - 1]; // 배열에서 꺼내오기
//    barista.make(drink);
// } else {
//    System.out.println("잘못된 선택입니다.");
// }
// System.out.println();
//}
