package pearson;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BalancedBracketsTest {
  
  
  private BalancedBrackets balancedBrackets;

  @Test
  public void testAsimpleValidCase() {
    balancedBrackets = new BalancedBrackets();
    String inputString = "()[]{}";
   Assert.assertTrue( balancedBrackets.validateBalancedString(inputString));
  }
  
  @Test
  public void testBvalidComplexCase() {
    balancedBrackets = new BalancedBrackets();
    String inputString = "((()))[]{}";
   Assert.assertTrue( balancedBrackets.validateBalancedString(inputString));
  }
  
  @Test
  public void testCsimpleUnbalancedCase() {
    balancedBrackets = new BalancedBrackets();
    String inputString = "({{)[]{}";
   Assert.assertFalse( balancedBrackets.validateBalancedString(inputString));
  }
  
  @Test
  public void testDbalancedCase() {
    balancedBrackets = new BalancedBrackets();
    String inputString = "()[]{}(([])){[()][]}";
   Assert.assertTrue( balancedBrackets.validateBalancedString(inputString));
  }

}
