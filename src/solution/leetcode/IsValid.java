package solution.leetcode;

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '('){
                stack.push(')');
            }else if (c == '{'){
                stack.push('}');
            }else if (c == '['){
                stack.push(']');
            }else if (stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}
