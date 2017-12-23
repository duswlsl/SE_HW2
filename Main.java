import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[][] account = new String[10][3];// 계좌를 저장할 배열 생성
		int accIndex = 0;

		while (true) {

			System.out.println("===MAIN MENU===");
			System.out.println("1. 메모");
			System.out.println("2. 계산기");
			System.out.println("3. 가계부");
			System.out.println("4. 종료");
			System.out.println("===============");
			System.out.print("원하는 메뉴의 번호를 입력하세요.>> ");

			int menu = scanner.nextInt();

			if ((menu > 4) || (menu < 1))
				System.out.println("원하는 기능이 없습니다.");

			switch (menu) {

			case 1: // 메모기능
				Memo m = new Memo();
				m.MemoFunc();
				break;

			case 2: // 계산기기능
				Calculator cal = new Calculator();
				cal.CalFunc();
				break;

			case 3: // 가계부기능
				Account acc = new Account();
				acc.AccountFunc(account);
				break;

			case 4:
				return;
			}// menu switch

		} // while

	}// main

}// class