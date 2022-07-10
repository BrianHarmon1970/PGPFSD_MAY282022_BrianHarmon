package CaseProblems.CarlysCatering;
/*
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
public class Event
{
    public final static int LARGE_EVENT_TIER_THRESHOLD = 50 ;
    public final static double PRICE_PER_PERSON = 35.00 ;

    private String EventNumber = "" ;
    private int NumberOfGuests =  0 ;
    private double TotalPrice = 0.0 ;

    public void setEventNumber(String eventNumber) { EventNumber = eventNumber; }
    public void setNumberOfGuests(int numberOfGuests)
    { NumberOfGuests = numberOfGuests; TotalPrice = numberOfGuests * PRICE_PER_PERSON ; }

    public String getEventNumber() { return EventNumber; }
    public int getNumberOfGuests() { return NumberOfGuests; }
    public double getTotalPrice() { return TotalPrice; }
}
