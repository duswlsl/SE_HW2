import java.io.*;
import java.util.Scanner;

public class Memo {

   Scanner scanner = new Scanner(System.in);
   int searchnum;
   ObjectOutputStream oos = null;
   ObjectInputStream ois = null;

   String[] memo = new String[10];// �޸� ������ �迭 ����
   int memoIndex = 0;

   public Memo() {
      try {
         ois = new ObjectInputStream(new FileInputStream("memo.dat"));
         memo = (String[]) ois.readObject();
         ois.close();
      } catch (Exception e) {
      }
   }

   public void MemoFunc() {

      for (int i = 0; i < memo.length; i++) {
         if (memo[i] != null)
            memoIndex = (i + 1);
      }

      while (true) {
         showMemo();
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
            makeMemo();
            memoIndex++;
            break;

         case 2:
            while (!modMemo())
               ; // �Ű������� �޸� �ε��� ��ȣ ����
            break;

         case 3:
            while (!delMemo())
               ;
            break;
         }
      } // while
   }// void MemoFun

   void showMemo() {

      for (int i = 0; i < memo.length; i++) { // ��ü �޸� ���*******
         if (memo[i] != null) {
            System.out.println("[" + (i + 1) + "] " + memo[i]);
         }
      }
   }

   int makeMemo() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("���ϴ� ������ �޸� �Է��ϰ� ���͸� ��������.");
      String a = scanner.nextLine();
      memo[memoIndex] = a;
      fileWrite();
      System.out.println("�޸� ���� �Ϸ�");
      return memoIndex;
   }

   boolean modMemo() {
      
      Scanner scanner = new Scanner(System.in);
      System.out.println("������ �޸��� ��ȣ�� �Է��ϼ���.(�޴��� ���ư����� 0�Է�)");
      searchnum = scanner.nextInt()-1;
      scanner.nextLine();

      if (searchnum == -1)
         return true;

      if (memo[searchnum] == null) {
         System.out.println("�߸��� ��ȣ�Դϴ�.");
         return false;
      } else {
         System.out.println("������ �޸�� \"" + memo[searchnum] + "\"�Դϴ�.");
         System.out.println("������ �޸��� ������ ���� �Է��ϼ���.");
         String str = scanner.nextLine();
         //memo[searchnum - 1] = str;
         modifyMemo(memo,searchnum,str);
         fileWrite();
         return true;
      }
   }
   
   void modifyMemo(String[] memo, int searchnum, String str) {
      memo[searchnum] = str;
   }

   boolean delMemo() {
      System.out.println("������ �޸��� ��ȣ�� �Է��ϼ���.(�޴��� ���ư����� 0 �Է�)");
      searchnum = scanner.nextInt()-1;
      scanner.nextLine();

      if (searchnum == -1)
         return true;

      if (memo[searchnum] == null) {
         System.out.println("�߸��� ��ȣ�Դϴ�.");
         return false;
      } else {
         deleteMemo(memo, searchnum); // �޸����
         fileWrite();
         System.out.println("���� �Ϸ�");
         return true;
      }
   }
   
   void deleteMemo(String[] memo, int searchnum) {
      memo[searchnum]=null;
   }

   void fileWrite() {
      try {
         oos = new ObjectOutputStream(new FileOutputStream("memo.dat"));
         oos.writeObject(memo);
         oos.close();
      } catch (Exception e) {
         System.out.println("����¿���");
      }
   }
}