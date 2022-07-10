package CaseProblems.SammysRentals;

import java.util.Scanner;

import static java.lang.System.in;

/*
2.  a.  Sammy's Seashore Supplies rents beach equipment such as kayaks, canoes,
        beach chairs, and umbrellas to tourists.  In Chapter 2, you wrote an application
        that prompts the user for the number of minutes a piece of sports equipment
        was rented, displays the company motto with a border, and displays the price
        for the rental. Now modify the program so that the main()  method contains
        only three executable statements that each call a method as follows:

            The firs executable statement calls a method that prompts the user for
            the rental time in minutes and returns the value to the main() method.

            The second executable statement calls a method that displays the
            company motto with the border.

            The last executable statement passes the number of minutes to a method
            that computes the hours, extra minutes and price for the rental, and then
            displays all the details.

        Save the file as SammysRentalPriceWithMethods.java.

 */
public class SammysRentalPriceWithMethods
{
    public static void main( String[] args )
    {

        int minutesRented  = getUserMinutes() ;
        printMottoWithBorders() ;
        printInvoice( minutesRented ) ;

    }
    static void printMottoWithBorders()
    {
        System.out.println( " SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS" ) ;
        System.out.println( "S                                        S" ) ;
        System.out.println( "S    Sammy's makes it fun in the sun     S" ) ;
        System.out.println( "S                                        S" ) ;
        System.out.println( " SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS" ) ;
    }
    static int getUserMinutes( )
    {
        Scanner input = new Scanner( in ) ;
        System.out.print( "Enter number of minutes rented>" ) ;
        return input.nextInt() ;
    }
    static void printInvoice( int rented_minutes )
    {
        final double HOUR_RATE = 50.00 ;
        final double MINUTE_RATE = 1.00 ;
        final int MINUTES_PER_HOUR = 60 ;

        int hours ;
        int minutes ;
        double TotalPrice ;

        hours = rented_minutes / MINUTES_PER_HOUR ;
        minutes = rented_minutes % MINUTES_PER_HOUR ;
        TotalPrice = ((hours * HOUR_RATE)+(minutes * MINUTE_RATE )) ;

        System.out.println( rented_minutes + " minutes rented - " +
                hours + " hours @$" + HOUR_RATE + "/hr and " +
                minutes + " additional minutes @" + MINUTE_RATE+ "/min " +
                "for a total price of $" + TotalPrice ) ;
    }
}
