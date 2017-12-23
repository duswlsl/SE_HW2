import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MemoTest {

	@BeforeClass
	public static void testMemoFunc() throws Exception  {
		Memo m = new Memo();
		m.makeMemo();
		m.showMemo();
	}

	@Test
	public void testModMemo() {
		Memo m = new Memo();
		assertTrue(m.modMemo());
	}

	@Test
	public void testDelMemo() {
		Memo m = new Memo();
		assertTrue(m.delMemo());
	}

	@AfterClass
	public static void memo() throws Exception {
		Memo m = new Memo();
		m.showMemo();
	}

}
