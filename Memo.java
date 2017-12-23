import java.util.*;

public class Memo {
   Scanner scanner = new Scanner(System.in);
   int searchnum;
   
   public int MemoFunc(String[] memo, int memoIndex){
      
      while (true) {
         
         for(int i=0;i<memo.length;i++) {  // ��ü �޸� ���*******
            if(memo[i] != null) {
               System.out.println("[" + (i+1) + "] "+ memo[i]);}
         }
            
         
         System.out.println("=====MEMO=====");
         System.out.println("1. �޸� �ۼ�");
         System.out.println("2. �޸� ����");
         System.out.println("3. �޸� ����");
         System.out.println("4. ���θ޴��� ���ư���");
         System.out.println("==============");
         System.out.print("���ϴ� ����� ��ȣ�� �Է��ϼ���.>> ");

         int mmenu = scanner.nextInt();
         
         if (mmenu == 4) {
            break;
         }
         
         if ((mmenu > 4) || (mmenu < 1))
            System.out.println("�߸��� �����Դϴ�.");

         switch (mmenu) {

         case 1:
            makeMemo(memo,memoIndex);//�޸� �迭 ����?
            memoIndex++;
            break;

         case 2:
            while(!modMemo(memo)); //�Ű������� �޸� �ε��� ��ȣ ����
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
      System.out.println("���ϴ� ������ �޸� �Է��ϰ� ���͸� ��������.");
      String a = scanner.nextLine();
      memo[memoIndex] = a;
      System.out.println("�޸� ���� �Ϸ�");
      return memoIndex+1;
   }
   
   boolean modMemo(String[] memo) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("������ �޸��� ��ȣ�� �Է��ϼ���.(�޴��� ���ư����� 0�Է�)");
      searchnum = scanner.nextInt();
      scanner.nextLine();
      
       if(searchnum==0)
            return true;
      
      if (memo[searchnum - 1] == null) {
         System.out.println("�߸��� ��ȣ�Դϴ�.");
         return false;
      } else {
         System.out.println("������ �޸�� \"" + memo[searchnum - 1] + "\"�Դϴ�.");
         System.out.println("������ �޸��� ������ ���� �Է��ϼ���.");
         memo[searchnum - 1] = scanner.nextLine();
         return true;
      }

   }
   
   boolean delMemo(String[] memo) {
      System.out.println("������ �޸��� ��ȣ�� �Է��ϼ���.(�޴��� ���ư����� 0 �Է�)");
      searchnum = scanner.nextInt();
      scanner.nextLine();
      
      if(searchnum==0)
         return true;
      
      if (memo[searchnum-1] == null) {
         System.out.println("�߸��� ��ȣ�Դϴ�.");
         return false;}
      else {
         memo[searchnum-1] = null; //�޸����
         System.out.println("���� �Ϸ�");
         return true;
      }
      }
   }
   


   