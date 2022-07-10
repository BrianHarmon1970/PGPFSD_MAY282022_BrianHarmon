package CaseProblems.CarlysCatering;

import java.util.Scanner;

import static CaseProblems.CarlysCatering.CarlysEventPriceWithMethods.printMottoWithBorders;

/*
c.  Use the CarlysEventPriceWithMethods class you created in Step 1a as a
        starting point for a program that demonstrates the Event class you created in
        Step 1b, but make the following changes:

            You already have a method that gets a number of guests from a user, now
            add a method that gets an event number. The main() method should
            declare an Event object, call the two data entry methods, and use their
            returned values to set the fields in the Event object.

            Call the method from teh CarlysEventPriceWithMethods class that
            displays the company motto with border, The method is accessible
            because it is public, but you must fully qualify the name because it is in
            another class.

            Revise the method that displays the event details so that it accepts
            the newly created Event object. The method should display the event
            number, and it should  still display the number of guests, the price per
            guest, the total price, and whether the event is a large event.

        Save the program as EventDemo.java
 */
public class EventDemo
{
    public static void main(String[] args )
    {
        Event event = new Event() ;

        event.setEventNumber( getUserEventNumber()) ;
        event.setNumberOfGuests( getUserGuestCount()) ;
        printMottoWithBorders() ;
        printTotal( event ) ;

    }
    public static String getUserEventNumber()
    {
        String eventnum ;
        Scanner input = new Scanner( System.in ) ;
        System.out.print( "Enter Event number> " ) ;
        eventnum = input.nextLine() ;
        return eventnum ;
    }
    public static int getUserGuestCount()
    {
        int count ;
        Scanner input = new Scanner( System.in ) ;
        System.out.print( "How many guests will be attending> " ) ;
        count = input.nextInt() ;
        return count ;
    }
    public static void printTotal( Event e )
    {
        //double TotalPrice  = guest_count * PRICE_PER_PERSON ;
        System.out.println( e.getNumberOfGuests() + " guests will be attending at $" +
                Event.PRICE_PER_PERSON + " / Person for a total of $" + e.getTotalPrice() ) ;
        System.out.println( "This is a large event: " +
                ( e.getNumberOfGuests() >= Event.LARGE_EVENT_TIER_THRESHOLD )) ;
    }
}
