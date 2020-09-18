package pearson;

import java.util.Stack;

public class TestStack {
public static void main(String[] args) {
  Stack<String> testStack = new Stack();
  testStack.push("D");
  testStack.push("B");
  testStack.push("A");
  
 testStack.stream().forEach(s -> System.out.println(s));
 System.out.println("poping:::::"+testStack.pop());
 
 Stack newStack = new Stack<>();
 newStack.addAll(testStack);
 newStack.stream().forEach(s -> System.out.println(s));
 
  
}
}
