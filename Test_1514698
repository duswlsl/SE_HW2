import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class Test_1514698 {

	String[][] test = {{"2017/12/20", "사탕", "200"}, {"2017/12/25", "케이크", "25000"}};

	@Test
	public void testModifyAcc() {
		String[] info = {"2017/12/21", "초콜렛", "4000"};
		Account acc = new Account();
		acc.modifyAcc(test, 0, info);
		assertArrayEquals(info, test[0]);
	}
	
	@Test
	public void testDeleteAcc() {
		Account acc = new Account();
		acc.deleteAcc(test, 1);
		assertNull(test[1][0]);
		assertNull(test[1][1]);
		assertNull(test[1][2]);
	}
}
