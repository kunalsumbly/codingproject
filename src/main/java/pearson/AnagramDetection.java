package pearson;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramDetection {
  
  // just to be thread safe
  private AtomicInteger counter = new AtomicInteger(0);
  
  public  int findAnagramCount(String queryString, String parentString) {
    String querySortedString = Stream.of(queryString.split("")).sorted().collect(Collectors.joining());
     for ( int index = 0; index < parentString.length()-queryString.length()+1; index++) {
       String substring = parentString.substring(index, index + queryString.length());
       String collect = Stream.of(substring.split("")).sorted().collect(Collectors.joining());
       if (collect.equals(querySortedString)) {
          counter.incrementAndGet();
       }
     }
     return counter.get();
  }
}
