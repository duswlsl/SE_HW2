import java.util.*;

public class Calculator {
   Scanner scanner = new Scanner(System.in);
   
   public void CalFunc(){ 
      while (true) {
         System.out.println("===CALCULATOR===");
         System.out.println("1. 사칙연산");
         System.out.println("2. 단위변환");
         System.out.println("3. 메인메뉴로 이동");
         System.out.println("================");
         System.out.print("원하는 메뉴의 번호를 입력하세요.>> ");
         
         int cmenu = scanner.nextInt();

         if (cmenu == 3)
            break;

         if ((cmenu < 0) || (cmenu > 2))
            System.out.println("잘못된 숫자입니다.");
         
         switch(cmenu) {
         
         case 1:  //사칙연산
             int i=0;
             double[]num=new double[2];
            scanner.nextLine();
            System.out.println("식을 입력하세요. (숫자 연산자 숫자 순서대로)");
            String operation = scanner.nextLine().trim();
            String[] operator = { "+", "-", "/", "*" };
            
            for (String k : operator) {
               StringTokenizer st = new StringTokenizer(operation, k);
               if (st.countTokens() == 2) {
                  while(st.hasMoreTokens()) {
                     num[i]=Double.parseDouble(st.nextToken().trim());
                     i++;
                  }
                  calculate(num[0],k,num[1]);
                  break;
               }
            }
            break;
            
         case 2: //단위변환
            unitConvert();
            break;
         }
      }
   }

   void calculate(double num1,String operator,double num2) {
      switch(operator) {
         case "+":
            System.out.println("답: "+(num1+num2));
            break;
         case "-":
            System.out.println("답: "+(num1-num2));
            break;
         case "/":
            System.out.println("답: "+(num1/num2));
            break;
         case "*":
            System.out.println("답: "+(num1*num2));
            break;
      }
   }

   void unitConvert() {
      double input;
      while(true){
      System.out.println("===단위변환===");
       System.out.println("1.pound를 kg으로");
       System.out.println("2.kg을 pound로");
       System.out.println("3.inch를 cm로");
       System.out.println("4.cm를 inch로");
       System.out.println("5.°F를 °C로");
       System.out.println("6.°C를 °F로");
       System.out.println("7. 계산기메뉴로 이동");
       System.out.println("================");
       System.out.print("원하는 메뉴의 번호를 입력하세요.>> ");
      
      int umenu = scanner.nextInt();

       if (umenu == 7)
          break;

       if ((umenu < 0) || (umenu > 7))
          System.out.println("잘못된 숫자입니다.");
       
       switch(umenu) {
       
       case 1: //pound를 kg으로
          System.out.print("pound입력:");
          input=scanner.nextDouble();
          System.out.println(input+"pound는 "+(input*0.453592)+"kg입니다.");
          break;
       case 2: //kg을 pound로
          System.out.print("kg입력:");
          input=scanner.nextDouble();
          System.out.println(input+"kg은 "+(input*2.20462)+"pound입니다.");
          break;
       case 3: //inch를 cm로
          System.out.print("inch입력:");
          input=scanner.nextDouble();
          System.out.println(input+"inch는 "+(input*2.54)+"cm입니다.");
          break;
       case 4: //cm를 inch로
          System.out.print("cm입력:");
          input=scanner.nextDouble();
          System.out.println(input+"cm는 "+(input*0.393701)+"inch입니다.");
          break;
       case 5: //°F를 °C로
          System.out.print("°F입력:");
          input=scanner.nextDouble();
          System.out.println(input+"°F는 "+((input-32)/1.8)+"°C입니다.");
          break;
       case 6: //°C를 °F로
          System.out.print("°C입력:");
          input=scanner.nextDouble();
          System.out.println(input+"°C는 "+((input*1.8)+32)+"°F입니다.");
          break;
       }
      }
     }
}