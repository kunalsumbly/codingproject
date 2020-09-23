package pearson;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TwoDArrayAnticlockSpiralTest {
  
  private TwoDArrayAnticlockSpiral  twoDArray;

  @Before
  public void setUp() throws Exception {
    twoDArray = new TwoDArrayAnticlockSpiral();
  }

  @Test
  public void testA() {
    String responseString =
        "13, 8, 7, 12, 17, 18, 19, 14, 9, 4, 3, 2, 1, 6, 11, 16, 21, 22, 23, 24, 25, 20, 15, 10, 5";
    int count = 0;
    List<Integer> counterClockspiralPrint = twoDArray.counterClockSpiral(5, 5, 3, 3);
    for (Integer l_var : counterClockspiralPrint) {
      String[] split = responseString.split(",");
      for (String str : split) {
        if (Integer.valueOf(str.trim()).equals(l_var)) {
          count++;
        }
      }
    }
    Assert.assertEquals(count, counterClockspiralPrint.size());
  }
  
  @Test
  public void testB() {
    String responseString = "12, 7, 6, 11, 16, 17, 18, 13, 8, 3, 2, 1, 21, 22, 23, 24, 19, 14, 9, 4, 25, 20, 15, 10, 5";
    int count = 0;
    List<Integer> counterClockspiralPrint = twoDArray.counterClockSpiral(5, 5, 3, 2);
    for (Integer l_var : counterClockspiralPrint) {
      String[] split = responseString.split(",");
      for (String str : split) {
        if (Integer.valueOf(str.trim()).equals(l_var)) {
          count++;
        }
      }
    }
    Assert.assertEquals(count, counterClockspiralPrint.size());
  }

}
