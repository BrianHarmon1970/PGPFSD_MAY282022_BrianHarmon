package exercises.chapter03;

import java.util.Scanner;

/*
5.  a.  Create an application named Percentages whose main() method holds
        two double variables. Assign values to the variables. Pass both variables to
        a method named computerPercent() that displays the two values and the
        value of the first number as a percentage of the second one. For example, if
        the numbers are 2.0 and 5.0, the method should display a statement similar
        to "2.0 is 40 percent of 5.0". Then call the method a second time, passing the
        values in revers order. Save the application as Percentages.java.

    b.  Modify the Percentages class to accept the values of the twp doubles from a
        user at the keyboard. Save the file as Percentages2.java.

 */
public class Percentages2
{
    public static void main( String[] args )
    {
        double d1 = 10 ;
        double d2 = 200 ;

        d1 = getNumber( "(1st of 2)Enter number>") ;
        d2 = getNumber( "(2nd of 2)Enter number>") ;

        computePercent( d1, d2 ) ;
        computePercent( d2, d1 ) ;
    }
    public static void computePercent( double part, double whole )
    {
        double percentage = part / whole * 100 ;
        System.out.println( part + "\tis\t" + percentage + "%\tof\t" + whole ) ;
    }
    public static double getNumber( String prompt )
    {
        Scanner kb = new Scanner( System.in ) ;
        System.out.print( prompt ) ;
        return  kb.nextDouble() ;
    }
}
