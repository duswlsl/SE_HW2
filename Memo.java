import java.util.*;

public class Memo {
   Scanner scanner = new Scanner(System.in);
   int searchnum;
   
   public int MemoFunc(String[] memo, int memoIndex){
      
      while (true) {
         
         for(int i=0;i<memo.length;i++) {  // 전체 메모 출력*******
            if(memo[i] != null) {
               System.out.println("[" + (i+1) + "] "+ memo[i]);}
         }
            
         
         System.out.println("=====MEMO=====");
         System.out.println("1. 메모 작성");
         System.out.println("2. 메모 수정");
         System.out.println("3. 메모 삭제");
         System.out.println("4. 메인메뉴로 돌아가기");
         System.out.println("==============");
         System.out.print("원하는 기능의 번호를 입력하세요.>> ");

         int mmenu = scanner.nextInt();
         
         if (mmenu == 4) {
            break;
         }
         
         if ((mmenu > 4) || (mmenu < 1))
            System.out.println("잘못된 숫자입니다.");

         switch (mmenu) {

         case 1:
            makeMemo(memo,memoIndex);//메모 배열 리턴?
            memoIndex++;
            break;

         case 2:
            while(!modMemo(memo)); //매개변수로 메모 인덱스 번호 전달
            break;

         case 3:
            while(!delMemo(memo));
            break;
         }
      }//while
      return memoIndex;
   }//void MemoFun
   
   int makeMemo(String[] memo,int memoIndex) {
      Scanner scanner =  new Scanner(System.in);
      System.out.println("원하는 내용의 메모를 입력하고 엔터를 누르세요.");
      String a = scanner.nextLine();
      memo[memoIndex] = a;
      System.out.println("메모 저장 완료");
      return memoIndex+1;
   }
   
   boolean modMemo(String[] memo) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("수정할 메모의 번호를 입력하세요.(메뉴로 돌아가려면 0입력)");
      searchnum = scanner.nextInt();
      scanner.nextLine();
      
       if(searchnum==0)
            return true;
      
      if (memo[searchnum - 1] == null) {
         System.out.println("잘못된 번호입니다.");
         return false;
      } else {
         System.out.println("수정할 메모는 \"" + memo[searchnum - 1] + "\"입니다.");
         System.out.println("수정할 메모의 내용을 새로 입력하세요.");
         memo[searchnum - 1] = scanner.nextLine();
         return true;
      }

   }
   
   boolean delMemo(String[] memo) {
      System.out.println("삭제할 메모의 번호를 입력하세요.(메뉴로 돌아가려면 0 입력)");
      searchnum = scanner.nextInt();
      scanner.nextLine();
      
      if(searchnum==0)
         return true;
      
      if (memo[searchnum-1] == null) {
         System.out.println("잘못된 번호입니다.");
         return false;}
      else {
         memo[searchnum-1] = null; //메모삭제
         System.out.println("삭제 완료");
         return true;
      }
      }
   }
   


   