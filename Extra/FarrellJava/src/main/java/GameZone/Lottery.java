package GameZone;


import java.time.LocalDateTime;
import java.util.Scanner;

/*

2.  Create a lottery game application. Generate three random numbers (see
    Appendix D for help in doing so), each between 0 and 9. Allow the user to guess
    three numbers. Compare each of the user's guesses to the three random numbers
    and display a message that includes the user's guess, the randomly determined
    three-digit number, and the amount of money the user has won as follows:
    -----------------------------------------
    Matching Numbers                Award($)
    -----------------------------------------
    Any one matching                       10
    Two matching                          100
    Three matching, not in order        1,000
    Three matching in exact order   1,000,000
    No matches                              0
    -----------------------------------------
    Make certain that your application accommodates repeating digits. For exampl,
    if a user guesses 1, 2, and 3, and the randomly generated digits are 1, 1, and 1,
    do not give the user credit for three correct guesses--just one. Save teh file as
    Lottery.java

 */
class Lottery
{
    public static void main( String[] args )
    {
        LotteryHandler lottery = new LotteryHandler() ;
        lottery.Main( args ) ;
       // lottery.
    }
}