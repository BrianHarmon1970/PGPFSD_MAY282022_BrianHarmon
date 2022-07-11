package exercises.chapter04;

import java.time.LocalDate;
import java.util.Scanner;

/*

9.  Write an application that computes and displays the day on which you become
    (or became) 10,000 days old. Save the application as TenThousandDaysOld.java

 */
public class TenThousandDaysOld
{
    public static void main( String[] args )
    {
        LocalDate birthDate = getUserBirthDate() ;
        show10000thDay( birthDate ) ;
    }
    static void show10000thDay( LocalDate birth_date )
    {
        System.out.println( "Your 1st day is\t\t\t" + birth_date ) ;
        System.out.println( "Your 10,000th day is\t" + birth_date.plusDays(10_000)) ;
    }
    static LocalDate getUserBirthDate()
    {
        int month, day, year ;
        Scanner input = new Scanner( System.in ) ;
        System.out.println("Enter date of birth") ;
        System.out.print( "Month>" ) ;
        month = input.nextInt() ;

        System.out.print( "Day>" ) ;
        day = input.nextInt() ;

        System.out.print( "Year>" ) ;
        year = input.nextInt() ;

        return LocalDate.of(year, month, day) ;
    }
}
