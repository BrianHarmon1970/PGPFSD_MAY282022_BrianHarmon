package exercises.chapter02;
import java.util.Scanner;
import static java.lang.System.in;
/*

9. Write an interactive version of the InchesToFeet class that accepts the inches
    value from a user. Save the class as InchesToFeetInteractive.java.

 */
public class InchesToFeetInteractive
{
    public static void main( String[] args )
    {
        final int INCHES_PER_FOOT = 12 ;
        int total_inches = 86 ;

        Scanner input = new Scanner( in ) ;
        System.out.print( "Enter a number of inches>" );
        total_inches = input.nextInt() ;

        int feet = total_inches / INCHES_PER_FOOT ;
        int inches = total_inches % INCHES_PER_FOOT ;

        System.out.println( total_inches + " is " + feet + " feet " + inches + " inches." ) ;
    }
}
