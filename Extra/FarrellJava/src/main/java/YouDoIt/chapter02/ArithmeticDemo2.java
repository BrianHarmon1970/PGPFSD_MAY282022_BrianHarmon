package YouDoIt.chapter02;// Java Programming, by Joyce Farrell - Chapter 2 - You Do It p. 93

import java.util.Scanner ;
import static java.lang.System.in;

public class ArithmeticDemo2
{
    public static void main( String[] args )
    {
        double firstNumber ;
        double secondNumber ;
        double sum ;
        double difference ;
        double average ;

        Scanner input = new Scanner( in ) ;

        System.out.print( "PLease enter a number >>" ) ;
        firstNumber = input.nextDouble() ;
        System.out.print( "PLease enter another number >>" ) ;
        secondNumber = input.nextDouble() ;


        difference = firstNumber - secondNumber ;
        sum = firstNumber + secondNumber ;
        average = sum / 2 ;

        System.out.println( firstNumber + " + " + secondNumber +" = " + sum ) ;
        System.out.println( firstNumber + " - " + secondNumber + " = " + difference ) ;
        System.out.println( "The average of " + firstNumber +" and " + secondNumber + " is " + average ) ;
    }
}