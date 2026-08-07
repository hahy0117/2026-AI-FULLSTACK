package com.the703.days;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class MilkDto{
	private String mname;
	private int mprice;
	public MilkDto() {
		super();
		
	}
	public MilkDto(String mname, int mprice) {
		super();
		this.mname = mname;
		this.mprice = mprice;
	}
	@Override
	public String toString() {
		return "MilkDto [mname=" + mname + ", mprice=" + mprice + "]";
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getMprice() {
		return mprice;
	}
	public void setMprice(int mprice) {
		this.mprice = mprice;
	}
	@Override
	public int hashCode() {
		return Objects.hash(mname, mprice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MilkDto other = (MilkDto) obj;
		return Objects.equals(mname, other.mname) && mprice == other.mprice;
	}
	
}

public class Day028 {

	public static void main(String[] args) {
			List<MilkDto> milks=new ArrayList<>();
			milks.add(new MilkDto("바나나우유",1300));
			milks.add(new MilkDto("메론맛우유", 1800));
			milks.add(new MilkDto("커피맛우유", 1500));
			milks.add(new MilkDto("커피맛우유", 1500));
			
			for(int i=0; i<milks.size();i++) {
				System.out.println((i+1)+milks.get(i).getMname()+"\t"+milks.get(i).getMprice()+"\t");
			}
			//오름차순
			System.out.println("가격순으로 오름차순");
			
			
			//1.익명적객체
			milks.sort(new Comparator<MilkDto>() {

				@Override
				public int compare(MilkDto o1, MilkDto o2) {					
					return Integer.compare(o1.getMprice(), o2.getMprice()) ;
				};
				
			});
			//2.람다식
			//milks.sort((o1,o2)->Integer.compare(o1.getMprice(),o2.getMprice()) );
			
			//3.참조형 Integer 부품객체에 compare라는 기능박스
			//error:(Integer::compare); Milk 객체에서 가격 꺼내야함.
			milks.sort(Comparator.comparingInt(MilkDto::getMprice));
			
			
			Set<MilkDto> milks1=new HashSet<>();
			milks1.add(new MilkDto("바나나우유",1300));
			milks1.add(new MilkDto("메론맛우유",1800));
			milks1.add(new MilkDto("커피맛우유",1500));
			milks1.add(new MilkDto("커피맛우유",1500));
			
			System.err.println();
			
			Iterator<MilkDto> milks2=milks1.iterator();
			int count=0;
			while(milks2.hasNext()) {
				MilkDto a=milks2.next();
				System.out.println(++count+a.getMname()+"\t"+a.getMprice());
			}
			
			Map<String, MilkDto> maps = new HashMap<>();
		      maps.put("banana", new MilkDto("바나나우유", 1300));  
		      maps.put("melon", new MilkDto("메론맛우유", 1800));  
		      maps.put("coffee", new MilkDto("커피우유", 1500));  
		      maps.put("coffee2", new MilkDto("커피우유", 1500));        

		      for(String key : maps.keySet()) {
		         System.out.println(key + " " + maps.get(key).getMname() + " " + maps.get(key).getMprice());
		      }
			
			

	}

}


/*
Q1. 빈칸 채우기
1.  List는 순서가 [있음 ] 구조로 데이터를 관리하며, 중복을 [허용한다]
    - 주요 메서드: add, get, size, remove, contains
2. Set은 순서가[없음] 구조로 데이터를 관리하며,  중복을 [허용 안 한다]
    - 주요 메서드: 
3. Map은 [_key___]와 [_value___]의 쌍으로 데이터를 관리한다. 
    - 주요 메서드: 
 
---

Q2. ArrayList, HashSet, HashMap을 작성하시오.  

1. Milk Dto 클래스 만들기  
   - 속성 : private String mname; private int mprice  

2. milks 이름으로 ArrayList 만들기  
3. 다음의 데이터 넣기  
   new Milk("바나나우유", 1300),  
   new Milk("메론맛우유", 1800),  
   new Milk("커피우유", 1500),  
   new Milk("커피우유", 1500)  
4. for + size 이용해서 데이터 출력  
```
1     바나나우유       1300
2     메론맛우유       1800
3     커피우유         1500
4     커피우유         1500
```
 
5. sets 이름으로 HashSet 만들기  
6. 다음의 데이터 넣기  
   new Milk("바나나우유", 1300),  
   new Milk("메론맛우유", 1800),  
   new Milk("커피우유", 1500),  
   new Milk("커피우유", 1500)  
7. Iterator 이용해서 데이터 출력   
```
1     바나나우유       1300
2     메론맛우유       1800
3     커피우유         1500
```
 
8. maps 이름으로 HashMap 만들기  
9. 다음의 데이터 넣기 (Key-Value 구조)  
   maps.put("banana", new Milk("바나나우유", 1300));  
   maps.put("melon", new Milk("메론맛우유", 1800));  
   maps.put("coffee", new Milk("커피우유", 1500));  
   maps.put("coffee2", new Milk("커피우유", 1500));  

10. for-each + keySet 이용해서 데이터 출력  
```
banana    바나나우유       1300
melon     메론맛우유       1800
coffee    커피우유         1500
coffee2   커피우유         1500
``` 

*/