package YouDoIt.chapter02;// Java Programming, by Joyce Farrell - Chapter 2 - You Do It p. 93
import java.util.Scanner ;

import static java.lang.System.in;

public class ArithmeticDemo
{
    public static void main( String[] args )
    {
        int firstNumber ;
        int secondNumber ;
        int sum ;
        int difference ;
        int average ;

        Scanner input = new Scanner( in ) ;

        System.out.print( "PLease enter an integer >>" ) ;
        firstNumber = input.nextInt() ;
        System.out.print( "PLease enter another integer >>" ) ;
        secondNumber = input.nextInt() ;

        difference = firstNumber - secondNumber ;
        sum = firstNumber + secondNumber ;
        average = sum / 2 ;

        System.out.println( firstNumber + " + " + secondNumber +" = " + sum ) ;
        System.out.println( firstNumber + " - " + secondNumber + " = " + difference ) ;
        System.out.println( "The average of " + firstNumber +" and " + secondNumber + " is " + average ) ;
    }
}
