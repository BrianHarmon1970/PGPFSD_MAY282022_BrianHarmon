package CaseProblems.CarlysCatering;

import java.util.Scanner;

import static java.lang.System.in;

/*
1.  Carly's Catering provides meals for parties and special events.
    Write a program that prompts the user for the number of guests attending an event and then
    computes teh total price, which is $35 pre person. Display the company motto
    with the border that you created in the CarlysMotto2 class in Chapter 1,
    and then display the number of guest, pricer pre guest, and total price. Also
    display  a message that indicates true or false depending on whether the job
    is classified as a large event -- and event with 50 or more guests. Save the file as
    CarlysEventPrice.java.

 */
public class CarlysEventPrice
{

    public static void main(String[] args )
    {
        double PRICE_PER_PERSON = 35.0 ;
        int NumberOfGuests =  0 ;
        double TotalPrice ;
        Scanner input = new Scanner( in ) ;


        System.out.print( "How many guests will be attending> " ) ;
        NumberOfGuests = input.nextInt() ;
        TotalPrice = NumberOfGuests * PRICE_PER_PERSON ;

        CarlysMotto2.main( new String[0] ) ;
        System.out.println( NumberOfGuests + " guests will be attending at $" +
                PRICE_PER_PERSON + " / Person for a total of $" + TotalPrice ) ;
        System.out.println( "This is a large event: " + ( NumberOfGuests >= 50 )) ;
    }
}
