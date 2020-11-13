import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Example 5:
 * Input: s = "{[]}"
 * Output: true
 */
public class _20_ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char c;
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            if(stack.empty() || c != getCouple(stack.peek())){
                stack.push(c);
            }else {
                stack.pop();
            }
        }

        return stack.empty();
    }

    private char getCouple(char a){
        switch (a){
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';

        }
        return 0;
    }

}
