package pearson;

import java.util.HashMap;
import java.util.Stack;

public class BalancedBrackets {
  
  private  Stack<Character> containerStack = new Stack<Character>();
  private  static HashMap<Character,Character> openingBracketsMap = new HashMap();
  
  static {
    
    openingBracketsMap.put('(', ')');
    openingBracketsMap.put('{', '}');
    openingBracketsMap.put('[', ']');
  }
  
  /**
   * This method validates the input string to check if the string is balanced or not
   * @param inputString
   * @return
   */
  public boolean validateBalancedString(String inputString) {
    boolean isBalancedString = false;
    try {
      
      if (inputString.length() % 2 != 0) {
        throw new RuntimeException();
      }

      /**
       * when we face the opening bracket push it to the stack when we see an closing brace , pop
       * the stack and match them
       */
      for (int i = 0; i < inputString.length(); i++) {
        if (openingBracketsMap.get(inputString.charAt(i)) != null) {// the case when we have opening
                                                                    // brackets
          containerStack.push(inputString.charAt(i));
        } else {// case when we have closing bracket
          if (!containerStack.isEmpty()) {
            Character pop = containerStack.pop();
            if (openingBracketsMap.get(pop) == inputString.charAt(i)) {
              isBalancedString = true;
            }
          }
        }
      }

      if (!containerStack.isEmpty()) {
        isBalancedString = false;
      }

    } catch (Exception ex) {
      isBalancedString = false;
    }
    return isBalancedString;
  }
}
