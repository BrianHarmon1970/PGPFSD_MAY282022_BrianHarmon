package CaseProblems.SammysRentals;
/*
  b.  Create a class to hold Rental data for Sammy's Seashore Supplies. The class
        contains:

            Two public final static fields that hold the number of minutes in an
            hour and the hourly rental rate ($40)

            Four private fields that hold a contract number,  number of hours for
            the rental, number of minutes over an hour, and the price. The contract
            number is stores as a String because Sammy plans to assign contract
            numbers such as K681.

            Two public set methods. One sets the contract number
            (setContractNumber()). The other is named setHoursAndMinutes(),
            and it accepts the number of minutes for the rental and then sets the
            hours, extra minutes over an hour, ahd the total price. Recall from
            Chapter 2 that the price is $40 per hour plus $1 for every extra minute.

            Four public get methods that return the values in the four nonstatic
            fields.
        Save the file as Rental.java.

 */
/*

2.  a.  Sammy's Seashore Supplies rents beach equipment such as kayaks, canoes,
        beach chairs, and umbrellas to tourists. In Chapter 3, you created a Rental
        class for the company. The Rental class contains two public final static
        fields that hold the n umber of minutes in an hour and the hourly rental rate
        ($40), and four private fields that hold a contract number, number of hours
        for the rental, number of minutes over an hour, and teh price. It also contains
        two public set methods and four public get methods.

        Now, modify the Rental class to contain two overloaded constructors.
        One constructor accepts a contract number and number of minutes

        as parameters. Pass these values to the setContractNumber() and
        setHoursAndMinutes() methods, respectively. The setHoursAndMinutes()
        method will automatically calculate the hours, extra minutes, and price.

        The other constructor is a default constructor that passes "A000" and 0 to the
        two-parameter constructor.

        Save the file as Rental.java

    b.  In Chapter 3, you also created a REntalDemo class to demonstrate a REntal
        object. Now, modify that class to instantiate two REntal objects.

        Instantiate on object to retain the constructor default values.

        Accept user data for the contract number and minutes fields and use this data
        set to instantiate th second object. Display all the details for both objects.

        Save the file as RentalDemo.java.

 */
public class Rental
{
    public static final double HOUR_RATE = 50.00 ;
    public static final double MINUTE_RATE = 1.00 ;
    final int MINUTES_PER_HOUR = 60 ;

    private String ContractNumber = "" ;
    private int hours ;
    private int minutes ;
    private int minutesRented ;

    private double TotalPrice ;

    public Rental()
    {
        this( "A001" , 0 ) ;
    }
    public Rental( String contractNumber, int minutesRented )
    {
        setContractNumber( contractNumber ) ;
        setHoursAndMinutes( minutesRented ) ;
    }
    public void setContractNumber(String contractNumber) { ContractNumber = contractNumber; }
    public void setHoursAndMinutes(int minutes_rented )
    {
        this.minutesRented = minutes_rented;
        hours = minutes_rented / MINUTES_PER_HOUR ;
        minutes = minutes_rented % MINUTES_PER_HOUR ;
        TotalPrice = ((hours * HOUR_RATE)+(minutes * MINUTE_RATE )) ;
    }

    public String getContractNumber() { return ContractNumber; }
    public int getHours() { return hours; }
    public int getMinutes() { return minutes; }
    public int getMinutesRented() { return minutesRented; }
    public double getTotalPrice() { return TotalPrice; }
}
