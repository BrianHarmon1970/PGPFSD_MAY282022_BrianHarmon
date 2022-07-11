package exercises.chapter04;

import java.time.LocalDate;

/*
10. The LocalDate class includes an instance method named lengthOfMonth() that
    returns the number of days in the month. Write an application that uses methods
    in the LocalDate class to calculate how many days are left until the first day of
    next month. Display the result, including the name of the next month. Save the
    file as DaysTilNextMonth.java.

 */
public class DaysUntilNextMonth
{
    public static void main( String[] args )
    {
        LocalDate today = LocalDate.now() ;
        int remainingDays = today.lengthOfMonth() - today.getDayOfMonth() + 1 ;
        LocalDate firstOfNextMonth = today.plusDays( remainingDays ) ;

        System.out.println( "There are " + remainingDays + " days remaining until " +
                firstOfNextMonth + " (" +  firstOfNextMonth.getMonth().name() + ")" ) ;
    }
}
