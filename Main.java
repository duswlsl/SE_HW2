import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[][] account = new String[10][3];// ���¸� ������ �迭 ����
		int accIndex = 0;

		while (true) {

			System.out.println("===MAIN MENU===");
			System.out.println("1. �޸�");
			System.out.println("2. ����");
			System.out.println("3. �����");
			System.out.println("4. ����");
			System.out.println("===============");
			System.out.print("���ϴ� �޴��� ��ȣ�� �Է��ϼ���.>> ");

			int menu = scanner.nextInt();

			if ((menu > 4) || (menu < 1))
				System.out.println("���ϴ� ����� �����ϴ�.");

			switch (menu) {

			case 1: // �޸���
				Memo m = new Memo();
				m.MemoFunc();
				break;

			case 2: // ������
				Calculator cal = new Calculator();
				cal.CalFunc();
				break;

			case 3: // ����α��
				Account acc = new Account();
				acc.AccountFunc(account);
				break;

			case 4:
				return;
			}// menu switch

		} // while

	}// main

}// class