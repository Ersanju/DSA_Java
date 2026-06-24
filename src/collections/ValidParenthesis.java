package collections;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean validParenthesis(String str) {

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {

            // Opening brackets
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }

            // Closing brackets
            else {

                // No matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (ch == ')' && top != '(') {
                    return false;
                }

                if (ch == ']' && top != '[') {
                    return false;
                }

                if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }

        // Stack should be empty if all brackets matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String str = "[]({})[[]]";

        System.out.println(validParenthesis(str));
    }

}
