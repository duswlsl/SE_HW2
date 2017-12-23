import java.util.*;

public class main{
	public static void main(String []args){
		Scanner scanner = new Scanner(System.in);

		String[] memo = new String[10];
		int memoIndex = 0;

		String[][] account = new String [10][3];
		int accIndex = 0;

		while (true){

			System.out.println("===MAIN MENU===");
			System.out.println("1. 메모");
			System.out.println("2. 계산기");
			System.out.println("3. 가계부");
			System.out.println("4. 종료");
			System.out.println("===============");
			System.out.println("원하는 메뉴의 번호를 입력하세요:>>");

			int menu = scanner.nextInt();

			if((menu>4)||(menu<1))
				System.out.println("원하는 기능이 없습니다.");

			switch(menu){
				case 1:
					Memo m = new Memo();
					memoIndex = m.MemoFunc(memo, memoIndex);
					break;

				case 2:
					Calculator cal = new Calculator();
					cal.CalFunc();
					break;

				case 3:
					Account acc = new Account();
					accIndex = acc.AccountFunc(account, accIndex);
					break;
				case 4:
					return;
			}
		}
	}
}
