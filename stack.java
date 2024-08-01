import java.util.Scanner;
import java.util.Stack;

public class stack {
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();
                if ((ch == ')' && last != '(') || (ch == '}' && last != '{') || (ch == ']' && last != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string containing parentheses: ");
        String input = scanner.nextLine();
        scanner.close();

        if (isBalanced(input)) {
            System.out.println("The parentheses are balanced.");
        } else {
            System.out.println("The parentheses are not balanced.");
        }
    }
}
