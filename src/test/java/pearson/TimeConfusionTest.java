package pearson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TimeConfusionTest {

  private TimeConfusion timeConfusion;
  
  @Before
  public void setUp() throws Exception {
    timeConfusion = new TimeConfusion();
  }

  @Test
  public void testALookAtTheSun() {
    int numberOfCases = 1;
    List<String> timeSamples = new ArrayList<String>();
    timeSamples.add("12:00 4:00 8:00");
    Map<String, String> determineActualTime = timeConfusion.determineActualTime(numberOfCases,timeSamples);
    Assert.assertNotEquals(1, determineActualTime.size());
    
  }
  
  @Test
  public void testBGoodCase() {
    int numberOfCases = 1;
    List<String> timeSamples = new ArrayList<String>();
    timeSamples.add("5:00 12:00 10:00");
    Map<String, String> determineActualTime = timeConfusion.determineActualTime(numberOfCases,timeSamples);
    Assert.assertEquals(1, determineActualTime.size());
    Assert.assertEquals("5:00", determineActualTime.entrySet().stream().map(Map.Entry::getKey).findAny().get());
  }
  
  @Test
  public void testCLookAtSun() {
    int numberOfCases = 1;
    List<String> timeSamples = new ArrayList<String>();
    timeSamples.add("5:00 11:00 10:00");
    Map<String, String> determineActualTime = timeConfusion.determineActualTime(numberOfCases,timeSamples);
    Assert.assertEquals(0, determineActualTime.size());
  }
  
  @Test
  public void testDGoodCase() {
    int numberOfCases = 1;
    List<String> timeSamples = new ArrayList<String>();
    timeSamples.add("11:59 12:30 1:01");
    Map<String, String> determineActualTime = timeConfusion.determineActualTime(numberOfCases,timeSamples);
    Assert.assertEquals(1, determineActualTime.size());
    Assert.assertEquals("12:30", determineActualTime.entrySet().stream().map(Map.Entry::getKey).findAny().get());
  }
  
  @Test
  public void testEGoodCase() {
    int numberOfCases = 1;
    List<String> timeSamples = new ArrayList<String>();
    timeSamples.add("6:00 12:00 3:00");
    Map<String, String> determineActualTime = timeConfusion.determineActualTime(numberOfCases,timeSamples);
    Assert.assertEquals(1, determineActualTime.size());
    Assert.assertEquals("3:00", determineActualTime.entrySet().stream().map(Map.Entry::getKey).findAny().get());
  }
  
  @Test(expected=RuntimeException.class)
  public void testFInputValidationException() {
    int numberOfCases = 3;
    List<String> timeSamples = new ArrayList<String>();
    timeSamples.add("6:00 12:00 3:00");
    Map<String, String> determineActualTime = timeConfusion.determineActualTime(numberOfCases,timeSamples);
    Assert.assertEquals(1, determineActualTime.size());
    Assert.assertEquals("3:00", determineActualTime.entrySet().stream().map(Map.Entry::getKey).findAny().get());
  }
  

}
