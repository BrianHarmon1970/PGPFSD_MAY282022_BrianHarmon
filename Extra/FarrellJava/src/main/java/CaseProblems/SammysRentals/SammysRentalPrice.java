package CaseProblems.SammysRentals;

import java.util.Scanner;

import static java.lang.System.in;

/*

2.  Sammy's Seashore Supplies rents beach equipment such as kayaks, canoes, beach
    chairs, and umbrellas to tourist. Write a program that prompts the user for the
    number of minutes  he rented a piece of sports equipment. Compute the rental
    cost as $50 per hour plus $1 per additional minute. ( YOu might have surmised
    already that this rate has a logical flaw, but for now, calculate rates as described
    here. YOu can fix the problem after you read teh chapter on decision making.)
    Display Sammy's motto with the border that you created in th SammysMotto2
    class in Chapter 1. Then display the hours, minutes, and total price. Save the file
    as SammysRentalPrice.java.
 */
public class SammysRentalPrice
{
    public static void main( String[] args )
    {
        final double HOUR_RATE = 50.00 ;
        final double MINUTE_RATE = 1.00 ;
        final int MINUTES_PER_HOUR = 60 ;
        int NumberOffMinutesRented = 0 ;
        int hours ;
        int minutes ;
        double TotalPrice ;

        Scanner input = new Scanner( in ) ;
        System.out.print( "Enter number of minutes rented>" ) ;
        NumberOffMinutesRented = input.nextInt() ;
        hours = NumberOffMinutesRented / MINUTES_PER_HOUR ;
        minutes = NumberOffMinutesRented % MINUTES_PER_HOUR ;
        TotalPrice = ((hours * HOUR_RATE)+(minutes * MINUTE_RATE )) ;

        SammysMotto2.main( new String[0] ) ;
        System.out.println( NumberOffMinutesRented + " minutes rented - " +
                                hours + " hours @$" + HOUR_RATE + "/hr and " +
                                minutes + " additional minutes @" + MINUTE_RATE+ "/min " +
                               "for a total price of $" + TotalPrice ) ;
    }
}
