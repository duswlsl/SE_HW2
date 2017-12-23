import java.io.*;
import java.util.Scanner;

public class Memo {

	Scanner scanner = new Scanner(System.in);
	int searchnum;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;

	String[] memo = new String[10];// 메모를 저장할 배열 생성
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
				makeMemo();
				memoIndex++;
				break;

			case 2:
				while (!modMemo())
					; // 매개변수로 메모 인덱스 번호 전달
				break;

			case 3:
				while (!delMemo())
					;
				break;
			}
		} // while
	}// void MemoFun

	void showMemo() {

		
		for (int i = 0; i < memo.length; i++) { // 전체 메모 출력*******
			if (memo[i] != null) {
				System.out.println("[" + (i + 1) + "] " + memo[i]);
				
			}
		}
	}

	void makeMemo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 내용의 메모를 입력하고 엔터를 누르세요.");
		String a = scanner.nextLine();
		memo[memoIndex] = a;
		fileWrite();
		System.out.println("메모 저장 완료");
	}

	boolean modMemo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("수정할 메모의 번호를 입력하세요.(메뉴로 돌아가려면 0입력)");
		searchnum = scanner.nextInt();
		scanner.nextLine();

		if (searchnum == 0)
			return true;

		if (memo[searchnum - 1] == null) {
			System.out.println("잘못된 번호입니다.");
			return false;
		} else {
			System.out.println("수정할 메모는 \"" + memo[searchnum - 1] + "\"입니다.");
			System.out.println("수정할 메모의 내용을 새로 입력하세요.");
			String str = scanner.nextLine();
			memo[searchnum - 1] = str;
			fileWrite();
			return true;
		}

	}

	boolean delMemo() {
		System.out.println("삭제할 메모의 번호를 입력하세요.(메뉴로 돌아가려면 0 입력)");
		searchnum = scanner.nextInt();
		scanner.nextLine();

		if (searchnum == 0)
			return true;

		if (memo[searchnum - 1] == null) {
			System.out.println("잘못된 번호입니다.");
			return false;
		} else {
			memo[searchnum - 1] = null; // 메모삭제
			fileWrite();
			System.out.println("삭제 완료");
			return true;
		}
	}

	void fileWrite() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream("memo.dat"));
			oos.writeObject(memo);
			oos.close();
		} catch (Exception e) {
			System.out.println("입출력오류");
		}
	}
}
