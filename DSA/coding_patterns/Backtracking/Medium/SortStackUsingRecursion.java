// https://takeuforward.org/plus/dsa/problems/sort-a-stack

package medium;

import java.util.Stack;

public class SortStackUsingRecursion {

   static  void sort(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;

        int temp = stack.pop();
        sort(stack);
        insertAtCorrectPos(stack, temp);
    }

    static void insertAtCorrectPos(Stack<Integer> stack, int temp) {
        if(stack.isEmpty() || stack.peek()<temp){
            stack.push(temp);
              return;
        }

        int eleToRemoveFirst = stack.pop();

        insertAtCorrectPos(stack, temp);
        stack.push(eleToRemoveFirst);
    }
    public static void main(String[] args) {
      Stack<Integer> stack = new Stack<>();
      stack.push(3);   
      stack.push(1);   
      stack.push(2);   
      stack.push(5);   
      sort(stack);
      System.out.println(stack);
    }
}