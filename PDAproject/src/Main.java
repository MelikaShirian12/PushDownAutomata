import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PushDownAutomaton pda = new PushDownAutomaton();

        System.out.print("Enter the input string: ");
        String input = sc.nextLine();
        System.out.print("The string '" + input + "' is ");
        if (pda.accept(input)) System.out.println("Accepted");
        else System.out.println("Rejected");
    }
}

class PushDownAutomaton {
    public boolean accept(String input) {
        Stack<Character> stack = new Stack<>();

        if (!input.startsWith("a")) return false;

        stack.push('a');
        int i = 1;
        while (i < input.length()) {
            char ch = input.charAt(i);

            if (stack.isEmpty()) return false;

            if (ch == 'a' && stack.peek() == 'a') {
                i++;

            } else if (ch == 'b') {

                if (stack.peek() == 'a') {
                    stack.pop();
                    stack.push(ch);
                    i++;
                } else if (stack.peek() == 'b') {
                    stack.push(ch);
                    i++;
                } else return false;

            } else if (ch == 'c') {

                if (stack.peek() != 'b') return false;

                stack.pop();
                i++;

            } else return false;
        }

        return stack.isEmpty();
    }
}