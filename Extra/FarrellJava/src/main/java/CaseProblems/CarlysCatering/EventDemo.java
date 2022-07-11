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
/*

1.  a.  Carly's Catering provides meals for parties and special events. In Chapter 3,
        you created an Event class for the company. The Event class contains two
        public final static fields that hold the price per guest($35) and the
        cutoff value for a large event (50 guests), and three private fields that hold
        an event number, number of guest for the event, and the price. It also
        contains two public set methods and three public get methods.

        Now, modify the Event class to contain two overloaded constructors.

        One constructor accepts an event number and number of guests as parameters.
        Pass these values to the setEventNumber() and setGuests() methods,
        respectively. The setGuests() method will automatically calculate the event price.

        The other constructor is a default constructor that passes "A000" and 0 to the
        two-parameter constructor.

        Save the file as Event.java.

    b.  In Chapter 3, you also created an EvenDemo class to demonstrate using two
        Event objects. Now, modify that class to instantiate two Event objects, and
        include the following new methods in the class:

        Instantiate on object to retain the constructor default values.

        Accept user data for the event number and guests fields, and use this data set
        to instantiate the second object. Display all the details for both objects.

        Save the file as EventDemo.java

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
        System.out.println( " = Chapter 4 = " ) ;

        //Event newEvent = new Event() ;
        printTotal( new Event() ) ;

        //Event userEvent = getUserEvent() ;
        printTotal( getUserEvent() ) ;


    }
    public static Event getUserEvent()
    {
        return new Event( getUserEventNumber(), getUserGuestCount() ) ;
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
        System.out.println( "Event number: (" + e.getEventNumber() + ")\t" +
                            e.getNumberOfGuests() + " guests will be attending at $" +
                            Event.PRICE_PER_PERSON + " / Person for a total of $" +
                                    e.getTotalPrice() ) ;
        System.out.println( "This is a large event: " +
                ( e.getNumberOfGuests() >= Event.LARGE_EVENT_TIER_THRESHOLD )) ;
        System.out.println() ;
    }
}
