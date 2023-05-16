import java.awt.*;
import java.io.Console;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String cmd = "default";
        while(!cmd.equals("Exit"))
        {
            System.out.printf("Select the command\n1) String generator\n2) String Checker\n-> ");
            cmd = sc.nextLine();
            String input;
            switch (cmd)
            {
                case "1":
                    input = "default";
                    while(!input.equals("Back"))
                    {
                        System.out.printf("\u001B[36m" + "Enter the m and n or \"back\" to return to menu -> " + "\u001B[0m");
                        input = sc.nextLine();

                        String[] arguments = input.split(",");

                        try {
                            System.out.println("\u001B[35m" + "The result of this language is: " + "\u001B[0m" + "\u001B[36m" +
                                    stringGenerator(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1])) + "\u001B[0m");

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }


                    }
                    break;
                case "2":
                    input = "default";
                    while(!input.equals("Back"))
                    {
                        System.out.printf("\u001B[35m" + "Enter the string or \"back\" to return to menu -> " + "\u001B[0m");
                        input = sc.nextLine();

                        try {


                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                default:
                    break;
            }


            System.out.printf("\nSelect the command\n1) String generator\n2) String Checker\n-> ");
            cmd = sc.nextLine();


        }

    }


    public static String stringGenerator(int n , int m) throws Exception{
        Stack <String> stack = new Stack<>();

        String result = "";
        stack.push("$");

        if (n > 0)
        {
            stack.push("a");
            for (int i = 0; i < n-1 ; ++i)
            {
                result += stack.pop();
                stack.push("a");
            }
        }
        if (m > 0 )
        {

            result += stack.pop();
            stack.push("b");

            for (int i = 0; i < m-1 ; ++i)
            {
                stack.push("b");
                result += stack.peek();
            }

            result += stack.pop();
            result += "c";

            for(int i = 0 ; i < m-1 ; ++i)
            {
                stack.pop();
                result += "c";
            }


        }else
            result += stack.pop();


        if(! stack.pop().equals("$"))
            throw new Exception("Something went wrong !");

        return result;
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
                                                       │       b, λ ➝ b                                  │
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