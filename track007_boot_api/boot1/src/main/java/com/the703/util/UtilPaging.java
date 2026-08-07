package com.the703.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UtilPaging { 
   private  int  listtotal;   // 전체글 예)193  
   private  int  onepagelist;  //한 페이지에 보여줄 게시물의 수 10
   private  int  pagetotal;    // 총 페이지 193/10  19페이지 +3글 =20개
   private  int  bottomlist;    // 하단페이지 수 10
   private  int  pstartno;    //페이지 시작번호(1) 0,10 (2) 11,10 (oracle ver) db조회시 시작 글 번호
   private  int  current;    //현재번호
   private  int  start;       //시작번호
   private  int  end;        //끝나는 번호
    
    public UtilPaging (int listtotal,int pageNo) {
    	this(listtotal,pageNo,10,10);
    }
    public UtilPaging(int listtotal, int pageNo , int onepagelist , int  bottomlist) { 
      this.listtotal   = (listtotal<=0)? 1: listtotal;
      this.onepagelist = onepagelist;   
      this.pagetotal   = (int) Math.ceil(this.listtotal/ (double)onepagelist); 
      //193/10 ->19.3 ->올림->20
      //200/10 ->20.0 -> 올림 -> 20
      this.bottomlist  = bottomlist;   
      this.current     = pageNo;    
      this.start       = ((current-1)/bottomlist)*bottomlist + 1;   
      //21->(21-1)/10->앞자리 2줄 *10+1
      //30->(30-1)/10->앞자리 2로 *10 +1
      this.end         = start + bottomlist -1;  
      if(end > pagetotal ) {  end = pagetotal; }   //30>26 마지막은 26으로 

             this.pstartno = (pageNo - 1) * onepagelist + 1;
   }      
}
