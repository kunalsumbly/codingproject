package pearson;

import java.util.HashMap;
import java.util.Stack;

/**
 * This class handles the logic of Balancing brackets
 * @author kusu
 *
 */
public class BalancedBrackets {
  
  //This stack is used to push opening brackets and pop when encountering closing brackets
  private Stack<Character> containerStack = new Stack<Character>();
  
  //This map is used to keep the track of bracket pairs
  private static HashMap<Character, Character> openingBracketsMap = new HashMap();

  static {

    openingBracketsMap.put('(', ')');
    openingBracketsMap.put('{', '}');
    openingBracketsMap.put('[', ']');
  }

  /**
   * This method validates the input string to check if the string is balanced or not
   * 
   * @param inputString
   * @return true for balanced string and false otherwise
   */
  public boolean validateBalancedString(String inputString) {
    boolean isBalancedString = false;
    try {
      if (inputString.length() % 2 != 0) {
        throw new RuntimeException();
      }
      isBalancedString = processInputString(inputString, true, 0);

    } catch (Exception ex) {
      // exception can be logged to an error log
      isBalancedString = false;
    }
    return isBalancedString;
  }

  /**
   * This function iterates through the inputstring in a recursive way
   * @param inputString
   * @param isBalancedString
   * @param currentIndex
   * @return
   */
  private boolean processInputString(String inputString, boolean isBalancedString, int currentIndex) {
    if (currentIndex == inputString.length()) {
      return !containerStack.isEmpty() ? false : isBalancedString;
    } else {
      isBalancedString = process(inputString, isBalancedString, currentIndex);
      currentIndex++;
      return processInputString(inputString, isBalancedString, currentIndex);
    }
  }

  /**
   * The logic to process the input string to check for balanced string
   * @param inputString
   * @param isBalancedString
   * @param currentIndex
   * @return
   */
  private boolean process(String inputString, boolean isBalancedString, int currentIndex) {
    if (openingBracketsMap.get(inputString.charAt(currentIndex)) != null) {// the case when we encounter opening brackets
      containerStack.push(inputString.charAt(currentIndex));
    } else {// case when we encounter closing bracket
        Character pop = containerStack.pop();
        if (openingBracketsMap.get(pop) == inputString.charAt(currentIndex)) {
          isBalancedString = true;
        } else {
          isBalancedString = false;
        }
    }
    return isBalancedString;
  }
}
