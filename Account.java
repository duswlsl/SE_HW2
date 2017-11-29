import java.util.Scanner;

public class Account {
   Scanner scanner = new Scanner(System.in);
   int searchnum;

   public int AccountFunc(String[][] account, int accIndex) {
      while (true) {

         for (int i = 0; i < accIndex; i++) { // ÀüÃ¼ ³»¿ª Ãâ·Â*******
            if (account[i][0] != null) {
               System.out.print("[" + (i + 1) + "] ");
               System.out.print(" 11¯Â¥: " + account[i][0]);
               System.out.print(" Ç×¸ñ: " + account[i][1]);
               System.out.println(" °¡°Ý: " + account[i][2]);
            }
         }

         System.out.println("=====ACCOUNT=====");
         System.out.println("1. °¡°èºÎ ÀÛ¼º");
         System.out.println("2. °¡°èºÎ ¼öÁ¤");
         System.out.println("3. °¡°èºÎ »èÁ¦");
         System.out.println("4. ¸ÞÀÎ¸Þ´º·Î µ¹¾Æ°¡±â");
         System.out.println("==============");
         System.out.print("¿øÇÏ´Â ±â´ÉÀÇ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä.>> ");

         int acc_menu = scanner.nextInt();

         if (acc_menu == 4) {
            System.out.println("¸ÞÀÎ¸Þ´º·Î ÀÌµ¿");
            break;
         }

         if ((acc_menu > 4) || (acc_menu < 1))
            System.out.println("Àß¸øµÈ ¼ýÀÚÀÔ´Ï´Ù.");

         switch (acc_menu) {

         case 1:
            System.out.println("°¡°èºÎÀÛ¼º");
            accIndex = makeAcc(account, accIndex);// ¸Þ¸ð ¹è¿­ ¸®ÅÏ?
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
      System.out.println("°¡°èºÎÀÇ ³¯Â¥¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
      account[indexnum][0] = scanner.nextLine();

      System.out.println("°¡°èºÎÀÇ Ç×¸ñÀ» ÀÔ·ÂÇÏ¼¼¿ä. ");
      account[indexnum][1] = scanner.nextLine();

      System.out.println("°¡°èºÎÀÇ °¡°ÝÀ» ÀÔ·ÂÇÏ¼¼¿ä. ");
      account[indexnum][2] = scanner.nextLine();

      System.out.println("°¡°èºÎ ÀúÀå ¿Ï·á");

      return indexnum + 1;
   }

   boolean modAcc(String[][] account) {
      
      System.out.println("¼öÁ¤ÇÏ°íÀÚ ÇÏ´Â °¡°èºÎÀÇ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä. ÀÌÀü´Ü°è0");
      searchnum = scanner.nextInt() - 1;
      
      if(searchnum==-1)
         return true;
      
      if (account[searchnum][0] == null) {
         System.out.println("Àß¸øµÈ ¹øÈ£ÀÔ´Ï´Ù. ");
         return false;
      } else {
         System.out.println("Ã£À¸½Ã´Â °¡°èºÎ´Â");
         System.out.println(account[searchnum][1] + "ÀÔ´Ï´Ù.");

         scanner.nextLine();
         System.out.println("°¡°èºÎÀÇ ³¯Â¥¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
         account[searchnum][0] = scanner.nextLine();

         System.out.println("°¡°èºÎÀÇ Ç×¸ñÀ» ÀÔ·ÂÇÏ¼¼¿ä. ");
         account[searchnum][1] = scanner.nextLine();

         System.out.println("°¡°èºÎÀÇ °¡°ÝÀ» ÀÔ·ÂÇÏ¼¼¿ä. ");
         account[searchnum][2] = scanner.nextLine();

         System.out.println("°¡°èºÎ ¼öÁ¤ ¿Ï·á");
         return true;
      }
   }

   boolean delAcc(String[][] account) {
      
      System.out.println("¼öÁ¤ÇÏ°íÀÚ ÇÏ´Â °¡°èºÎÀÇ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä. ÀÌÀü´Ü°è0");
      searchnum = scanner.nextInt() - 1;
   
      if(searchnum==-1)
         return true;
      
      if (account[searchnum][0] == null) {
         System.out.print("Àß¸øµÈ ¹øÈ£ÀÔ´Ï´Ù. ");
         return false;
      }else {
         for(int i=0; i<3; i++)
            account[searchnum][i]=null;
         System.out.println("delete");

         return true;
      }

   }
}
