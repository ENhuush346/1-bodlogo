import java.util.*;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return "NO";
                char top = stack.pop();
                if ((c == '}' && top != '{') ||
                    (c == ']' && top != '[') ||
                    (c == ')' && top != '(')) {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            String s = scanner.nextLine();
            System.out.println(isBalanced(s));
        }
        scanner.close();
    }
}
