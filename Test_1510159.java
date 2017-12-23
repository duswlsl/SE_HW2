import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class Test_1510159 {

   String[] test = {"ÇĎłŞ", "ľŃ"};

   @Test
   public void testModifyMemo() {
      Memo m = new Memo();
      String memo1 = "žČłçÇĎźźżä";
      m.modifyMemo(test, 0, memo1);
      assertEquals(memo1, test[0]);
   }
   
   @Test 
   public void testDeleteMemo() {
      Memo m = new Memo();
      m.deleteMemo(test, 1);
      assertNull(test[1]);
   }

}
