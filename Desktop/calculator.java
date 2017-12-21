import java.util.*;

public class Calculator {
	Scanner scanner = new Scanner(System.in);

	public void CalFunc() {
		while (true) {
			System.out.println("===CALCULATOR===");
			System.out.println("1. ��Ģ����");
			System.out.println("2. ������ȯ");
			System.out.println("3. ���θ޴��� �̵�");
			System.out.println("================");
			System.out.print("���ϴ� �޴��� ��ȣ�� �Է��ϼ���.>> ");

			int cmenu = scanner.nextInt();

			if (cmenu == 3)
				break;

			if ((cmenu < 0) || (cmenu > 2))
				System.out.println("�߸��� �����Դϴ�.");

			switch (cmenu) {

			case 1: // ��Ģ����
				int i = 0;
				double[] num = new double[2];
				scanner.nextLine();
				System.out.println("���� �Է��ϼ���. (���� ������ ���� �������)");
				String operation = scanner.nextLine().trim();
				String[] operator = { "+", "-", "/", "*" };

				for (String k : operator) {
					StringTokenizer st = new StringTokenizer(operation, k);
					if (st.countTokens() == 2) {
						while (st.hasMoreTokens()) {
							num[i] = Double.parseDouble(st.nextToken().trim());
							i++;
						}
						calculate(num[0], k, num[1]);
						break;
					}
				}
				break;

			case 2: // ������ȯ
				unitConvert();
				break;
			}
		}
	}

	void calculate(double num1, String operator, double num2) {
		switch (operator) {
		case "+":
			System.out.println("��: " + add(num1, num2));
			break;
		case "-":
			System.out.println("��: " + sub(num1, num2));
			break;
		case "/":
			System.out.println("��: " + div(num1, num2));
			break;
		case "*":
			System.out.println("��: " + multi(num1, num2));
			break;
		}
	}

	void unitConvert() {
		double input;
		while (true) {
			System.out.println("===������ȯ===");
			System.out.println("1.pound�� kg����");
			System.out.println("2.kg�� pound��");
			System.out.println("3.inch�� cm��");
			System.out.println("4.cm�� inch��");
			System.out.println("5.��F�� ��C��");
			System.out.println("6.��C�� ��F��");
			System.out.println("7. ����޴��� �̵�");
			System.out.println("================");
			System.out.print("���ϴ� �޴��� ��ȣ�� �Է��ϼ���.>> ");

			int umenu = scanner.nextInt();

			if (umenu == 7)
				break;

			if ((umenu < 0) || (umenu > 7))
				System.out.println("�߸��� �����Դϴ�.");

			switch (umenu) {

			case 1: // pound�� kg����
				System.out.print("pound�Է�:");
				input = scanner.nextDouble();
				System.out.println(input + "pound�� " + tokg(input) + "kg�Դϴ�.");
				break;
			case 2: // kg�� pound��
				System.out.print("kg�Է�:");
				input = scanner.nextDouble();
				System.out.println(input + "kg�� " + topound(input) + "pound�Դϴ�.");
				break;
			case 3: // inch�� cm��
				System.out.print("inch�Է�:");
				input = scanner.nextDouble();
				System.out.println(input + "inch�� " + tocm(input) + "cm�Դϴ�.");
				break;
			case 4: // cm�� inch��
				System.out.print("cm�Է�:");
				input = scanner.nextDouble();
				System.out.println(input + "cm�� " + toinch(input) + "inch�Դϴ�.");
				break;
			case 5: // ��F�� ��C��
				System.out.print("��F�Է�:");
				input = scanner.nextDouble();
				System.out.println(input + "��F�� " + tocelcius(input) + "��C�Դϴ�.");
				break;
			case 6: // ��C�� ��F��
				System.out.print("��C�Է�:");
				input = scanner.nextDouble();
				System.out.println(input + "��C�� " + tofahr(input) + "��F�Դϴ�.");
				break;
			}
		}
	}

	double add(double num1, double num2) {return num1 + num2;}
	double sub(double num1, double num2) { return num1 - num2;}
	double multi(double num1, double num2) {return num1 * num2;}
	double div(double num1, double num2) {return num1 / num2;}
	double tokg(double input){return input * 0.453592;}
	double topound(double input){return input * 2.20462;}
	double toinch(double input){return input * 2.54; }
	double tocm(double input){ return input * 0.393701;}
	double tocelcius(double input){ return ((input - 32) / 1.8); }
	double tofahr(double input){return (input * 1.8) + 32;}
	
	

}