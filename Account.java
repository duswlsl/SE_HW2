import java.util.Scanner;

public class Account {
   Scanner scanner = new Scanner(System.in);
   int searchnum;

   public int AccountFunc(String[][] account, int accIndex) {
      while (true) {

         for (int i = 0; i < accIndex; i++) { // ��ü ���� ���*******
            if (account[i][0] != null) {
               System.out.print("[" + (i + 1) + "] ");
               System.out.print(" ��¥: " + account[i][0]);
               System.out.print(" �׸�: " + account[i][1]);
               System.out.println(" ����: " + account[i][2]);
            }
         }

         System.out.println("=====ACCOUNT=====");
         System.out.println("1. ����� �ۼ�");
         System.out.println("2. ����� ����");
         System.out.println("3. ����� ����");
         System.out.println("4. ���θ޴��� ���ư���");
         System.out.println("==============");
         System.out.print("���ϴ� ����� ��ȣ�� �Է��ϼ���.>> ");

         int acc_menu = scanner.nextInt();

         if (acc_menu == 4) {
            System.out.println("���θ޴��� �̵�");
            break;
         }

         if ((acc_menu > 4) || (acc_menu < 1))
            System.out.println("�߸��� �����Դϴ�.");

         switch (acc_menu) {

         case 1:
            System.out.println("������ۼ�");
            accIndex = makeAcc(account, accIndex);// �޸� �迭 ����?
            break;

         case 2:
            while (!modAcc(account));
            break;

         case 3:
            while (!delAcc(account));
            break;
         }
      } // while
      return accIndex;
   }// AccountFunc

   int makeAcc(String[][] account, int indexnum) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("������� ��¥�� �Է��ϼ���.");
      account[indexnum][0] = scanner.nextLine();

      System.out.println("������� �׸��� �Է��ϼ���. ");
      account[indexnum][1] = scanner.nextLine();

      System.out.println("������� ������ �Է��ϼ���. ");
      account[indexnum][2] = scanner.nextLine();

      System.out.println("����� ���� �Ϸ�");

      return indexnum + 1;
   }

   boolean modAcc(String[][] account) {
      
      System.out.println("�����ϰ��� �ϴ� ������� ��ȣ�� �Է��ϼ���. �����ܰ�0");
      searchnum = scanner.nextInt() - 1;
      
      if(searchnum==-1)
         return true;
      
      if (account[searchnum][0] == null) {
         System.out.println("�߸��� ��ȣ�Դϴ�. ");
         return false;
      } else {
         System.out.println("ã���ô� ����δ�");
         System.out.println(account[searchnum][1] + "�Դϴ�.");

         scanner.nextLine();
         System.out.println("������� ��¥�� �Է��ϼ���.");
         account[searchnum][0] = scanner.nextLine();

         System.out.println("������� �׸��� �Է��ϼ���. ");
         account[searchnum][1] = scanner.nextLine();

         System.out.println("������� ������ �Է��ϼ���. ");
         account[searchnum][2] = scanner.nextLine();

         System.out.println("����� ���� �Ϸ�");
         return true;
      }
   }

   boolean delAcc(String[][] account) {
      
      System.out.println("�����ϰ��� �ϴ� ������� ��ȣ�� �Է��ϼ���. �����ܰ�0");
      searchnum = scanner.nextInt() - 1;
   
      if(searchnum==-1)
         return true;
      
      if (account[searchnum][0] == null) {
         System.out.print("�߸��� ��ȣ�Դϴ�. ");
         return false;
      }else {
         for(int i=0; i<3; i++)
            account[searchnum][i]=null;
         System.out.println("delete");

         return true;
      }

   }
}