import java.util.Scanner;

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
                    {
                        input = sc.nextLine();
                    }
                    break;
                case "2":
                    input = sc.nextLine();
                    while(!input.equals("Back"))
                    {

                        input = sc.nextLine();
                    }

                    break;
                default:


                    break;
            }


            System.out.printf("\nSelect the command\n1) String generator\n2) String Checker\n-> ");
            cmd = sc.nextLine();


        }


    }
}