package exercises.chapter04;

import java.time.LocalDate;

/*

8.  Write a program that declares two LocalDate object and assign values that
    represent January 31 and December 31 in the curren year. Display output that
    demonstrates the dates displayed when one, two and three months are added to
    each of the objects. Save the application as TestMonthHandling.java.

 */

public class TestMonthHandling
{
    public static void main( String[] args )
    {
        LocalDate date1 = LocalDate.of(  LocalDate.now().getYear(),1, 1) ;
        LocalDate date2 = LocalDate.of( LocalDate.now().getYear(), 12, 1 ) ;

        showDate( "date1\t", date1 ) ;

        showDate( "date1 + 1 month \t" , date1.plusMonths(1)) ;
        showDate( "date1 + 2 months\t" , date1.plusMonths(2)) ;
        showDate( "date1 + 3 months\t" , date1.plusMonths(3)) ;

        showDate( "\ndate2\t", date2 ) ;
        showDate( "date2 + 1 month \t" , date2.plusMonths(1)) ;
        showDate( "date2 + 2 months\t" , date2.plusMonths(2)) ;
        showDate( "date2 + 3 months\t" , date2.plusMonths(3)) ;

    }
    static void showDate( String preFix , LocalDate date )
    {
        System.out.println( preFix + date );
    }
}
