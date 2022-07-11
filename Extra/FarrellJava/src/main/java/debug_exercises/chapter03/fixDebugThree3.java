package debug_exercises.chapter03;
// This application gets a user's name and displays a greeting
import java.util.Scanner;
public class fixDebugThree3
{
    //public static void main(String args[])
    public static void main(String[] args)
    {
        String name;
        //name = getName()
        name = getName() ;

        //displayGreeting(namme);
        displayGreeting(name);
    }
    //public static String getName(void)
    public static String getName()
    {
        String name;
        Scanner input = new Scanner(System.in);
        //System.in.print("Enter name ");
        System.out.print("Enter name> ");

        //name = input.nexlLine();
        name = input.nextLine();

        //return namer;
        return name;
    }
    //public static displayGreeting(String name)
    public static void displayGreeting(String name)
    {
        //System.outprintln("YouDoIt.chapter01.Hello, " + name + "!");
        System.out.println("Hello, " + name + "!");
    }
}
