import java.io.*;
import java.util.Scanner;

public class Account {
	Scanner scanner = new Scanner(System.in);
	int searchnum;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;

	int accIndex = 0;

	public int AccountFunc(String[][] account) {
		try {
			ois = new ObjectInputStream(new FileInputStream("account.dat"));
			account = (String[][]) ois.readObject();
			ois.close();
			for (int i = 0; i < account.length; i++) {
				if (account[i][0] != null)
					accIndex = (i + 1);
			}
		} catch (

		Exception e) {
		}

		while (true) {
			for (int i = 0; i < account.length; i++) {
				if (account[i] != null)
					accIndex = (i + 1);
			}

			for (int i = 0; i < accIndex; i++) { // 전체 내역 출력*******
				if (account[i][0] != null) {
					System.out.print("[" + (i + 1) + "] ");
					System.out.print(" 날짜: " + account[i][0]);
					System.out.print(" 항목: " + account[i][1]);
					System.out.println(" 가격: " + account[i][2]);
				}
			}

			System.out.println("=====ACCOUNT=====");
			System.out.println("1. 가계부 작성");
			System.out.println("2. 가계부 수정");
			System.out.println("3. 가계부 삭제");
			System.out.println("4. 메인메뉴로 돌아가기");
			System.out.println("==============");
			System.out.print("원하는 기능의 번호를 입력하세요.>> ");

			int acc_menu = scanner.nextInt();

			if (acc_menu == 4) {
				System.out.println("메인메뉴로 이동");
				break;
			}

			if ((acc_menu > 4) || (acc_menu < 1))
				System.out.println("잘못된 숫자입니다.");

			switch (acc_menu) {

			case 1:
				System.out.println("가계부작성");
				accIndex = makeAcc(account);
				break;

			case 2:
				while (!modAcc(account))
					;
				break;

			case 3:
				while (!delAcc(account))
					;
				break;
			}
		} // while
		return accIndex;
	}// AccountFunc

	int makeAcc(String[][] account) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("가계부의 날짜를 입력하세요.");

		account[accIndex][0] = scanner.nextLine();

		System.out.println("가계부의 항목을 입력하세요. ");
		account[accIndex][1] = scanner.nextLine();

		System.out.println("가계부의 가격을 입력하세요. ");
		account[accIndex][2] = scanner.nextLine();

		fileWrite(account);
		System.out.println("가계부 저장 완료");

		return accIndex + 1;
	}

	boolean modAcc(String[][] account) {
		System.out.println("수정하고자 하는 가계부의 번호를 입력하세요. 이전단계0");
		int searchnum = scanner.nextInt() - 1;

		if (searchnum == -1)
			return true;

		if (account[searchnum][0] == null) {
			System.out.println("잘못된 번호입니다. ");
			return false;
		} else {
			System.out.println("찾으시는 가계부는");
			System.out.println(account[searchnum][1] + "입니다.");

			String[] info = new String[3];
			scanner.nextLine();
			System.out.println("가계부의 날짜를 입력하세요.");
			info[0] = scanner.nextLine();

			System.out.println("가계부의 항목을 입력하세요. ");
			info[1] = scanner.nextLine();

			System.out.println("가계부의 가격을 입력하세요. ");
			info[2] = scanner.nextLine();

			modifyAcc(account, searchnum, info);
			fileWrite(account);
			System.out.println("가계부 수정 완료");
			return true;
		}
	}

	void modifyAcc(String[][] account, int searchnum, String[] info) {
		account[searchnum][0] = info[0];
		account[searchnum][1] = info[1];
		account[searchnum][2] = info[2];
	}

	boolean delAcc(String[][] account) {

		System.out.println("수정하고자 하는 가계부의 번호를 입력하세요. 이전단계0");
		searchnum = scanner.nextInt() - 1;

		if (searchnum == -1)
			return true;

		if (account[searchnum][0] == null) {
			System.out.print("잘못된 번호입니다. ");
			return false;
		} else {
			deleteAcc(account, searchnum);

			System.out.println("delete");
			fileWrite(account);
			return true;
		}
	}

	void deleteAcc(String[][] account, int searchnum) {
		for (int i = 0; i < 3; i++)
			account[searchnum][i] = null;
	}
	void fileWrite(String[][] account) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream("account.dat"));
			oos.writeObject(account);
			oos.close();
		} catch (Exception e) {
			System.out.println("입출력오류");
		}
	}

}
