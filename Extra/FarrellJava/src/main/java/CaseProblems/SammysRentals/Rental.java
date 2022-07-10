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
