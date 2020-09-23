package pearson;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeConfusion {
  
  Map<String, String> correctWatch = new HashMap<String, String>();

  public  Map<String, String> determineActualTime(int numOfCases, List<String> timeSamples) {
      // basic input check
      validateInputs(numOfCases, timeSamples);
      timeSamples.stream().forEach(s-> {
        String[] split = s.split(" ");
        List<String> asList = Arrays.asList(split);
        int size = asList.size();
        correctWatch.clear();
        processCalculations(asList, 0, size - 1);
        
      });
      
    return correctWatch; 
  }

  private void validateInputs(int numOfCases, List<String> timeSamples) {
    if (numOfCases != timeSamples.size()) {
      throw new RuntimeException(
          "Number of cases dont match with number of samples passed in sampleList");
    }

  }
  
  public void processCalculations(List<String> list, int left, int right) {
    if (left == right) {
       findTimeDifferenceForAllPermutations(list);
    }
    for (int j = left; j <= right; j++) {
        Collections.swap(list, left, j);
         processCalculations(list, left + 1, right);
        Collections.swap(list, left, j);
    }
}

  private void findTimeDifferenceForAllPermutations(List<String> list) {
    String time1 = list.get(0);
    String time2 = list.get(1);
    String time3 = list.get(2);
    
    LocalTime a = LocalTime.now();
    a = a.of(Integer.valueOf(time1.split(":")[0]), Integer.valueOf(time1.split(":")[1]));
    
    LocalTime b = LocalTime.now();
    b = b.of(Integer.valueOf(time2.split(":")[0]), Integer.valueOf(time2.split(":")[1]));
    
    LocalTime c = LocalTime.now();
    c = c.of(Integer.valueOf(time3.split(":")[0]), Integer.valueOf(time3.split(":")[1]));
    
    // a-b or b-a
    long until1 = Math.abs(a.until(b, ChronoUnit.MINUTES));
    // c-a or a-c
    long until2 = Math.abs(c.until(a, ChronoUnit.MINUTES));
    
    // c->a->b  
    if (until1 == until2) {
      correctWatch.put(time1,time1+"is the correct time" );
    }
    // adding 12h+b to cover the other side of the diff
    b = b.plusHours(12);
    
    until1 = Math.abs(a.until(b, ChronoUnit.MINUTES)); 
    
    if (until1 == until2) {
      correctWatch.put(time1,time1+"is the correct time" );
    }
    // adding 12h+c to cover the other side of the diff
    c = c.plusHours(12);
    until2 = Math.abs(c.until(a, ChronoUnit.MINUTES));
    
    if (until1 == until2) {
      correctWatch.put(time1,time1+"is the correct time" );
    }
    
  }
  

}
