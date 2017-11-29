public class main{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		String[][] account = new String[50][3];
		int accIndex = 0;

		Account acc = new Account();
		accIndex = acc.AccountFunc(account, accIndex);

	}
}
