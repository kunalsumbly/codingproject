package pearson;

import java.util.HashMap;
import java.util.Stack;

public class BalancedBrackets {
  
  private static Stack<Character> containerStack = new Stack<Character>();
  private static Stack<Character> tempStack = new Stack<Character>();
  private static Stack<Character> matchNotFound = new Stack<Character>();
  private static HashMap<Character,Character> bracketMap = new HashMap();
  private static boolean isBalancedString = false;
  private static HashMap errorCode = new HashMap();
  
  static {
    
    bracketMap.put('(', ')');
    bracketMap.put('{', '}');
    bracketMap.put('[', ']');
    bracketMap.put(')', '(');
    bracketMap.put('}', '{');
    bracketMap.put(']', '[');
    
  }
  
  //private static String INPUT_STRING = "()[]{}";
  //private static String INPUT_STRING = "((()))[]{}";
  //private static String INPUT_STRING = "()[]{}(([])){[()][]}";
  private static String INPUT_STRING = "(((({[[}))))";
  
  public static void main(String[] args) {
    if (validateBalancedString()) {
      System.out.println("String is balanced");
    } else {
      System.out.println("String is not balanced");
    }
  }

  private static boolean validateBalancedString() {
    try {
      if (INPUT_STRING.length() % 2 != 0) {
        throw new RuntimeException();
      }

      for (int i = 0; i < INPUT_STRING.length(); i++) {
        containerStack.push(INPUT_STRING.charAt(i));
      }

      while (!containerStack.isEmpty()) {
        tempStack.push(containerStack.pop());
      }

      char current = ' ', target;
      while (!tempStack.isEmpty()) {
        if (current == ' ') {
          current = tempStack.pop();
        }
        // check if current is the matching pair for the char in the matchNotFound stack
        if (!matchNotFound.isEmpty()) {
          Character readNotFound = matchNotFound.peek();
          Character object = bracketMap.get(readNotFound);
          if (object.equals(current)) {
            matchNotFound.pop(); // pop the stack , as the matching pair was found
            current = ' ';
            continue;
          }
        }
        // pop the next one
        if (tempStack.isEmpty()) {
          break;
        }
        target = tempStack.pop();
        if (bracketMap.get(current).equals(target)) {
          isBalancedString = true;
          current = ' ';
        } else {
          matchNotFound.push(current);
          current = target;
          isBalancedString = false;
        }

      } // while ends

      if (!matchNotFound.isEmpty()) {
        isBalancedString = false;
      }

      return isBalancedString;
    } catch (RuntimeException ex) {
      isBalancedString = false;
    } finally {
    return isBalancedString;
    }
  }
}
