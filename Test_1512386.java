import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class Test_1512386(){

	@Test
	public void Convert_test(){
		Calculator cal = new Calculator();
		assterTrue(cal.tokg(10)==4.53592);
	}

	@Test
	public void Multiple_test(){
		Calculator cal2 = new Calculator();
		assterTrue(cal.multi(2,5)==10);
	}
}

