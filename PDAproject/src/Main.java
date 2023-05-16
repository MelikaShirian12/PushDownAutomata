import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Select the command\n1) String generator\n2) String Checker\n-> ");
        String cmd = sc.nextLine();

        while (!cmd.equals("Exit")) {


            String input;

            switch (cmd) {
                case "1" -> {
                    System.out.print("\u001B[36m" + "Enter the m and n seperated with ',' ; or \"back\" to return to the menu -> " + "\u001B[0m");
                    input = sc.nextLine();
                    while (!input.equals("back")) {


                        String[] arguments = input.split(",");

                        try {
                            System.out.println("\u001B[35m" + "The result of this language is: " + "\u001B[0m" + "\u001B[36m" +
                                    PushDownAutomaton.stringGenerator(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1])) + "\u001B[0m");

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.print("\u001B[36m" + "Enter the m and n seperated with ',' ; or \"back\" to return to the menu -> " + "\u001B[0m");
                        input = sc.nextLine();
                    }
                }

                case "2" -> {
                    System.out.print("\u001B[35m" + "Enter the string or \"back\" to return to the menu -> " + "\u001B[0m");
                    input = sc.nextLine();
                    while (!input.equals("back")) {


                        try {
                            if (PushDownAutomaton.accept(input))
                                System.out.println("\u001B[36m" + "The automata accepts this string" + "\u001B[0m");
                            else
                                System.out.println("\u001B[36m" + "The automata rejects this string" + "\u001B[0m");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.print("\u001B[35m" + "Enter the string or \"back\" to return to the menu -> " + "\u001B[0m");
                        input = sc.nextLine();
                    }
                }
            }

            System.out.print("\nSelect the command\n1) String generator\n2) String Checker\n-> ");
            cmd = sc.nextLine();




        }

    }


}

class PushDownAutomaton {
    public static boolean accept(String input) {
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
    public static String stringGenerator(int n, int m) throws Exception {
        Stack<String> stack = new Stack<>();

        StringBuilder result = new StringBuilder();
        stack.push("$");

        if (n > 0) {
            stack.push("a");
            for (int i = 0; i < n - 1; ++i) {
                result.append(stack.pop());
                stack.push("a");
            }
        }
        if (m > 0) {

            result.append(stack.pop());
            stack.push("b");

            for (int i = 0; i < m - 1; ++i) {
                stack.push("b");
                result.append(stack.peek());
            }

            result.append(stack.pop());
            result.append("c");

            for (int i = 0; i < m - 1; ++i) {
                stack.pop();
                result.append("c");
            }


        } else
            result.append(stack.pop());


        if (!stack.pop().equals("$"))
            throw new Exception("Something went wrong !");

        return result.toString();
    }
}

/*
                                                    a , a ➝ a                b , λ ➝ b              c , b ➝ λ
                                                      ┌---┐                    ┌---┐                   ┌---┐
                                                      |   |                    |   |                   |   |
                                                      |   ⬇                    |   ⬇                   |   ⬇
    ┌────┐     λ , λ ➝ λ    ┌────┐     a , λ ➝ a    ┌────┐    b , a ➝ b     ┌────┐    c , b ➝ λ     ┌────┐
    │ q0 │-----------------➝│ q1 │-----------------➝│ q2 │-----------------➝│ q3 │-----------------➝│ q4 │
    └────┘                   └────┘                  └────┘                   └────┘                  └────┘
                                │                      │                        ⬆                         │
                                │                      │                        │                         │
                                └----------------------│------------------------┘                         │
                                                       │       b, λ ➝ b                                   │
                                                       │                                                  │
                                                       │                      ┌────┐                      │
                                                       └---------------------⟶│ q5 │⟵---------------------┘
                                                              a , a ➝ λ      └────┘      λ , $ ➝ $
                                                                            Final state

     -- UNIVERSITY OF ISFAHAN --
LANGUAGES AND AUTOMATA THEORY COURSE

              AUTHORS:
          MELIKA  SHIRIAN
          ZAHRA   MASOUMI
          KIANOOSH VADAEI


 */