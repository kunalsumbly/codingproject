package pearson;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CsvParserTest {

  private CsvParser csvParser;
  
  @Before
  public void setUp(){
    csvParser = new CsvParser();
  }
 
  @Test
  public void testA() {
    String line = "\",\",1,2,3,\",,,\",\"hoge\"\"hoge\",abc,\"\"";
    assertEquals(8, csvParser.find(line).size());
    csvParser.find(line).stream().forEach(s-> System.out.println(s));
  }
  
  @Test
  public void testB() {
    String line =  "1,\"Que?\",\"Kay?\",2,\"Si.\",\"Sea? Kay, sea?\",\"No, no, no. Que... ‘what’.\",234,\"Kay Watt?\",\"Si, que ‘what’.\",\"C.K. Watt?\",3,\"Yes!\",\"comma,comma, comma , :)\"";
    csvParser.find(line).stream().forEach(s-> System.out.println(s));
    assertEquals(14, csvParser.find(line).size());
  }
  
  @Test
  public void testC() {
    String line = "2,6,3,2,5";
    csvParser.find(line).stream().forEach(s-> System.out.println(s));
    assertEquals(5, csvParser.find(line).size());
  }
  
  @Test
  public void testD() {
    String line ="\"pears\",\"apples\",\"walnuts\",\"grapes\",\"cheese,cake\"";
    csvParser.find(line).stream().forEach(s-> System.out.println(s));
    assertEquals(5, csvParser.find(line).size());
  }

}
