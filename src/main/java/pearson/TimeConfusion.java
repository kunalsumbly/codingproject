package pearson;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeConfusion {
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");
  
  Map<String, Boolean> correctWatch = new HashMap();

  public List<String> determineActualTime(int numOfCases, List<String> timeSamples) {
    List<String> responseList = new ArrayList();
    try {
      // basic input check
      validateInputs(numOfCases, timeSamples);
      for (String timeEntry : timeSamples) {
        String[] split = timeEntry.split(" ");
        List<String> asList = Arrays.asList(split);
        int size = asList.size();
        try {
          permute(asList, 0, size - 1);
        }catch (Exception ex) {
          correctWatch.put(timeEntry, false);
        }
      }
      System.out.println(correctWatch);
    } catch (Exception ex) {
      // log.error("failed in validation step"+ex.getMessage());
      responseList.add(ex.getMessage());
    } finally {
      return responseList;
    }
  }

  private void validateInputs(int numOfCases, List<String> timeSamples) {
    if (numOfCases != timeSamples.size()) {
      throw new RuntimeException(
          "Number of cases dont match with number of samples passed in sampleList");
    }

  }
  
  public  void permute(List<String> list, int left, int right) {
    if (left == right) {
      calculateTimeDifferenceForAllPermutations(list);
    }
    for (int j = left; j <= right; j++) {
        Collections.swap(list, left, j);
        permute(list, left + 1, right);
        Collections.swap(list, left, j);
    }
}

  private void calculateTimeDifferenceForAllPermutations(List<String> list) {
    int correctTimeFoundCounter = 0;
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
      setCorrectTimeValue(time1);
    }
    // adding 12h+b
    b = b.plusHours(12);
    
    until1 = Math.abs(a.until(b, ChronoUnit.MINUTES)); 
    
    if (until1 == until2) {
      setCorrectTimeValue(time1);
    }
    // adding 12h+c
    c = c.plusHours(12);
    until2 = Math.abs(c.until(a, ChronoUnit.MINUTES));
    if (until1 == until2) {
      setCorrectTimeValue(time1);
    }
    
    System.out.println(Arrays.toString(list.toArray()));
  }
  
  private void setCorrectTimeValue(String time) {
    if (correctWatch.get(time) == null) {
      correctWatch.put(time, true);
    } 

  }

}
