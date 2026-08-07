package com.the703.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PagingUtil {
	private int listtotal; // 전체글 256
	private int onepagelist;// 한페이지에 보여줄 게시물의 수 10
	private int pagetotal; // 총페이지 256/10=26,123/10=13
	private int bottomlist;//하단의 페이지 나누기 이전 11 12 13,,,,19 20
	private int pstartno; // 페이지 시작번호- 스타트 번호

	private int current; //현재 페이지 번호
	private int start; // 시작 11
	private int end; // 마지막 20

	public PagingUtil(int listtotal, int pstartno) {//전체페이지수,시작하는 번호 이전 11 12 13,,,19 20
		super();
		this.listtotal = listtotal;// 전체페이지수
		this.onepagelist=10;  //한페이지에 보여줄 게시물의 수
		this.pagetotal =listtotal <=0 ? 1: 
			(int)Math.ceil(listtotal/(double)onepagelist); //256/10=25
		this.bottomlist=10;
		this.pstartno = (pstartno-1)*onepagelist; //(1) 1 0번째부터,10개 (2) 2 10번째부터,10개 (3) 3 20번째부터 10개
		this.current=pstartno; // <이전 11 12 13 14 15 (현재) 16 17 18 19 20  다음>
		this.start=((this.current-1)/this.bottomlist)*this.bottomlist+1;//15 라면 11로 만들기 20 이라면 11로 만들기
				//15-> 11 앞자리르 1로 (15-1)*10
				//20-> 11 앞자리를 1로 (20-1)*10 + 1=11
		this.end= this.start + this.bottomlist-1 ;//15에서 20으로 ,20에서 20으로
		//15->20 11+10-1=20
		//20->20 11+10-1=20
		if(this.end>this.pagetotal){
			this.end=this.pagetotal;
		}//현재페이지 갯수가 256-> 마지막은 30이 아니라 26
	}
}
