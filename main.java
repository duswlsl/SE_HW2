public class main{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		String[][] account = new String[50][3];
		String[] memo = new String[50];
		int accIndex = 0;
		int memoIndex = 0;

		Memo m = new Memo();
		memoIndex = m.MemoFUnc(memo, memoIndex);

		Account acc = new Account();
		accIndex = acc.AccountFunc(account, accIndex);

	}
}
