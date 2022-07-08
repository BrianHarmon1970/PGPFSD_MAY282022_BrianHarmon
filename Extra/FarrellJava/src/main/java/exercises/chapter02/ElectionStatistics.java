package exercises.chapter02;

import java.util.Scanner;

import static java.lang.System.in;

/*
 *  16. Write a program that accepts the names fo three political parties and the number
 *       of votes each received in the last mayoral election. Display teh percentage of the
 *       vote each party received. Save the program as ElectionStatistics.java.
 */
public class ElectionStatistics
{
    public static void main( String[] args )
    {
        int party_one_votes ;
        int party_two_votes ;
        int party_three_votes ;
        double total_votes ;

        String party_one_name ;
        String party_two_name ;
        String party_three_name ;

        double party_one_percentage ;
        double party_two_percentage ;
        double party_three_percentage ;

        Scanner input = new Scanner( in ) ;

        System.out.print( "Enter party name>" ) ;
        party_one_name = input.next() ;
        System.out.print( "Enter party name>" ) ;
        party_two_name = input.next() ;
        System.out.print( "Enter party name>" ) ;
        party_three_name = input.next() ;

        System.out.print( "Enter number of votes for " + party_one_name + ">" ) ;
        party_one_votes = input.nextInt() ;

        System.out.print( "Enter number of votes for " + party_two_name + ">" ) ;
        party_two_votes = input.nextInt() ;

        System.out.print( "Enter number of votes for " + party_three_name + ">" ) ;
        party_three_votes = input.nextInt() ;

        total_votes = party_one_votes + party_two_votes + party_three_votes ;

        party_one_percentage = (party_one_votes / total_votes ) * 100 ;
        party_two_percentage = (party_two_votes / total_votes ) * 100 ;
        party_three_percentage = (party_three_votes / total_votes ) * 100 ;

        System.out.println( "Voter Distribution" ) ;
        System.out.println( "Total votes: " + (int)total_votes ) ;
        System.out.println( party_one_name + " " + party_one_votes + " (" + party_one_percentage + "%)" ) ;
        System.out.println( party_two_name + " " + party_two_votes + " (" + party_two_percentage + "%)" ) ;
        System.out.println( party_three_name + " " + party_three_votes + " (" + party_three_percentage + "%)" ) ;
    }
}
