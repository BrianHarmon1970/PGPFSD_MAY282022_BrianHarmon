package CaseProblems.CarlysCatering;
/*
Chapter 3
b.  Create a class to hold Event data for Carly's Catering. The class contains:

            Two public final static fields that hold the price per guest ($35) and
            the cutoff value for a large event (50 guests)

            Three private fields that hold an event number, number of guests for
            the event, and the price. The event n umber is stored as a String because
            Carly plans to assign event numbers such as M312.

            Two public set methods that set the event number (setEventNumber())
            and the number of guests (setGuests()). The price does not have a set
            method because the setGuests() method will calculate the price as the
            number of guests multiplied by the price per guest every time the number
            of guests is set.

            Three public get methods that return teh values in the three nonstatic
            fields.

        Save the file as Event.java
 */
/*
    Chapter 4
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
public class Event
{
    public final static int LARGE_EVENT_TIER_THRESHOLD = 50 ;
    public final static double PRICE_PER_PERSON = 35.00 ;

    private String EventNumber = "" ;
    private int NumberOfGuests =  0 ;
    private double TotalPrice = 0.0 ;

    public Event( )
    {
        this( "A000" , 0 ) ;
    }
    public Event( String eventNumber, int numberOfGuests )
    {
        setEventNumber( eventNumber ) ;
        setNumberOfGuests( numberOfGuests ) ;
    }
    public void setEventNumber(String eventNumber) { EventNumber = eventNumber; }
    public void setNumberOfGuests(int numberOfGuests)
    { NumberOfGuests = numberOfGuests; TotalPrice = numberOfGuests * PRICE_PER_PERSON ; }

    public String getEventNumber() { return EventNumber; }
    public int getNumberOfGuests() { return NumberOfGuests; }
    public double getTotalPrice() { return TotalPrice; }
}
