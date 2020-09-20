package pearson;

import java.util.ArrayList;
import java.util.List;
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
  public void testA() {
    int numberOfCases = 4;
    List<String> timeSamples = new ArrayList();
    timeSamples.add("5:00 12:00 10:00");
    timeSamples.add("5:00 11:00 10:00");
    timeSamples.add("11:59 12:30 1:01");
     timeSamples.add("12:00 4:00 8:00"); 
    timeConfusion.determineActualTime(numberOfCases,timeSamples);
  }

}
