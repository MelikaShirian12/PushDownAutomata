import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.printf("Select the command\n1) String generator\n2) String Checker\n-> ");
        String cmd = sc.nextLine();
        while(!cmd.equals("Exit"))
        {
            String input;
            switch (cmd)
            {
                case "1":
                    input = sc.nextLine();
                    while(!input.equals("Back"))
                        input = sc.nextLine();

                    break;
                case "2":
                    input = sc.nextLine();
                    while(!input.equals("Back"))
                        input = sc.nextLine();


                    break;
                default:
                    break;
            }


            System.out.printf("\nSelect the command\n1) String generator\n2) String Checker\n-> ");
            cmd = sc.nextLine();


        }

    }


    public static String stringGenerator(int n , int m){
        Stack <String> stack = new Stack<>();

        String result = "";
        stack.push("$");

        if (n > 0) {
            stack.push("a");
            for (int i = 0; i < n-1 ; ++i) {
                result += stack.pop();
                stack.push("a");
            }
        }
        if (m > 0 ){

            result += stack.pop();
            stack.push("b");

            for (int i = 0; i < m-1 ; ++i) {
                stack.push("b");
                result += stack.peek();
            }
        }else
            result += stack.pop();



        return result;
    }
}