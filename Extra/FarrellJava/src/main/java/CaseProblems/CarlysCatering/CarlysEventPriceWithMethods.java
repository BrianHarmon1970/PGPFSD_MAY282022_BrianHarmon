package CaseProblems.CarlysCatering;

import java.util.Scanner;

import static java.lang.System.in;

/*
1.  a.  Carly's Catering provides meals for parties and special events. In Chapter 2, you
        wrote an application that prompts the user for the number of guests attending
        an event, displays the company motto with a border, and then displays the price
        of the event and whether the event is a large one. Now modify the program so
        that the main() method contains only three executable statements that each
        call a method as follows:

            The first executable statement calls a public static int method that
            prompts the user for the number of guests and returns the values to the
            main() method.

            The second executable statement calls a public static void method
            that displays the company motto with the border.

            The last executable statement passes the number of guests to a public
            static void method that computes the price of the event, displays the
            price, and displays whether the event is a large event.

       Save the file as CarlysEventPriceWithMethods.java.

 */
public class CarlysEventPriceWithMethods
{
    final static double PRICE_PER_PERSON = 35.0 ;
    public static void main(String[] args )
    {
        int NumberOfGuests =  0 ;

        NumberOfGuests = getGuestCount() ;
        printMottoWithBorders() ;
        printTotal( NumberOfGuests ) ;

    }
    public static int getGuestCount()
    {
        int count ;
        Scanner input = new Scanner( System.in ) ;
        System.out.print( "How many guests will be attending> " ) ;
        count = input.nextInt() ;
        return count ;
    }
    public static void printTotal( int guest_count )
    {
        double TotalPrice  = guest_count * PRICE_PER_PERSON ;
        System.out.println( guest_count + " guests will be attending at $" +
                PRICE_PER_PERSON + " / Person for a total of $" + TotalPrice ) ;
        System.out.println( "This is a large event: " + ( guest_count >= 50 )) ;
    }
    public static void printMottoWithBorders()
    {
        System.out.println( "* * * * * * * * * * * * * * * * * * * * * * * * * *" ) ;
        System.out.println( "*                                                 *" );
        System.out.println( "*  Carly's makes the food that makes it a party   *" ) ;
        System.out.println( "*                                                 *" ) ;
        System.out.println( "* * * * * * * * * * * * * * * * * * * * * * * * * *" ) ;
    }
}
