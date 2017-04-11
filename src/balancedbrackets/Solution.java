package balancedbrackets;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean isBalanced(String expression) {
        Stack stack = new Stack();
        String previousBracket = null;
        while(expression.length() > 0) {
            //Get the first bracket in the String
            String currentBracket = expression.substring(0, 1);                    

            if(matchesPrevious(currentBracket, previousBracket)) {
                stack.pop();
                previousBracket = (stack.empty()) ? null: (String) stack.peek();
                expression = expression.substring(1);
            }
            //If the matchingBracket is null then it not a bracket that can be match
            else if(currentBracket.equals("}") || currentBracket.equals(")") || currentBracket.equals("]")) {
                return false;
            }
            else {
                stack.push(currentBracket);
                /*Set the expression as everything but the first bracket, thus 
                trimming off the first bracket*/
                expression = expression.substring(1);
                previousBracket = currentBracket;
            }
            //previousBracket = matchesPrevious(currentBracket);
            
        }
        return stack.empty(); 
   }

    public static boolean matchesPrevious(String currentBracket, String previousBracket) {
        if(previousBracket == null) return false;
        else if (currentBracket.equals(")") && !previousBracket.equals("(")) return false;
        else if(currentBracket.equals("]") && !previousBracket.equals("[")) return false;
        else if(currentBracket.equals("}") && !previousBracket.equals("{")) return false;
        else return true;
        
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream is = new FileInputStream(new File("test.txt"));
        System.setIn(is);
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
