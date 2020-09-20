package pearson;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class handles the logic to parse CSV using regex
 * @author kusu
 *
 */
public class CsvParser {
  
  // This is the pattern used to find the match in the input string
  private static  Pattern p = Pattern.compile("[^,\"]+|\"(?:[^\"]|\"\")*\"");

  /**
   * The method find() takes input line as argument and runs the pattern match
   * and returns all the matching groups in a list
   * @param line
   * @return
   */
  public List<String> find(String line) {
    List<String> matchList = new ArrayList<>();
    Matcher m = p.matcher(line);
    while (m.find()) {
      matchList.add(m.group());
    }
    return matchList;
  }
}