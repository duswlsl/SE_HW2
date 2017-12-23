import org.junit.*; 
import static org.junit.Assert.*;

import org.junit.Test;

public class Test_1410391 {
	
	@Test
	public void testAdd() {
		Calculator cal=new Calculator();
		assertTrue(cal.add(2,3)==5);
	}
	
	@Test
	public void testToInch() {
		Calculator cal=new Calculator();
		assertTrue(cal.toinch(10)== 25.4);
	}
}
