package GameZone;

import java.util.Scanner;

import static java.lang.System.in;

/*

3.  In the "Game Zone" section in Chapter 1, you learned how to obtain a random
    number. For example, the following statement generates a random number
    between the constants MIN and MAX inclusive and assigns it to a variable named
    random:

    random = MIN + (int)(Math.random() * MAX) ;

    Write a program that selects a random number between 1 and 5 and asks
    the user to guess the number. Display a message that indicates the difference
    between the random number and the user's guess. Display another message that
    displays the random number and the boolean value true or false depending
    on whether the user's guess equals the random number. Save the file as
    RandomGuessMatch.java
 */
public class RandomGuessMatch
{
    public static void main( String[] args )
    {
        int number = 1 + (int)(Math.random() * 5 ) ;
        int guess ;
        Scanner input = new Scanner( in ) ;
        System.out.println( "I have selected a number between 1 and 5" ) ;
        System.out.print( "Enter your guess>" ) ;
        guess = input.nextInt() ;
        System.out.println( "Your guess is off by " + Math.abs( number - guess )) ;
        System.out.println( "your guess matches number? " + (guess == number)) ;
        System.out.println( "number is " + number ) ;
    }
}
