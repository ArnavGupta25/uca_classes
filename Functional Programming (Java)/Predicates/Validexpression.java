import java.util.function.*;
import java.util.Stack;

public class Validexpression {
    public static Predicate<String> isValidExpression = str -> {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch); 
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false; 
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    };
    public static void main(String[] args) {
        System.out.println(isValidExpression.test("(,)"));
        System.out.println(isValidExpression.test("([{}])"));
        System.out.println(isValidExpression.test("(]"));
    }
}
