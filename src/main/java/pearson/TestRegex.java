package pearson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

  static String regex1 = "(?<=[A-Z]+)([0-9]+)"; // looking back 
  static String regex2 = "([A-Z]+)([0-9]+)"; // this is non-capturing group
  
  public static void main(String[] args) {
    Pattern p = Pattern.compile(regex1);
    Matcher m = p.matcher("ABC123AB456789HJ1");
    while (m.find()) {
     //System.out.println( m.groupCount());
     //System.out.println(m.group());
     System.out.println(m.group(0));
     System.out.println("***********");
     System.out.println(m.group(1));
     System.out.println("--------------");
     //System.out.println(m.group(3));
    }
  }
  
  
}
