package exercises.chapter02;

import java.util.Scanner;

import static java.lang.System.in;

/*
1.  Mad Libs is a children's game in which they provide a few words that are then
    incorporated into a silly story. The game helps children understand different
    parts of speech because they are asked to provide specific typs of words. For
    example, you might ask a child for a noun, another nmoun, and adjective , and a
    past tense verb. The child might reply with such answers as tabler, book, silly,
    and studied. The newly crated Mad LIb might be:

    Mary had a little table
    Its book was silly as snow
    And everywhere that Mary studied
    The table was sure to go.

2.  Create a Mad Libs program that asks the user to provide at least four or five
    words, and then create and display a short story or nursery rhyme that uses them.
    Save the file as MadLib.java.

 */
public class MadLib
{
    public static void main( String[] args )
    {
        String person_name ;
        String verb ;
        String adjective ;
        String noun ;
        String noun2 ;
        String verb2 ;

        Scanner input = new Scanner( in ) ;
        System.out.print( "Enter a person's name>" ) ;
        person_name = input.next() ;
        System.out.print( "Enter a verb>" ) ;
        verb = input.next() ;

        System.out.print( "Enter an adjective>" ) ;
        adjective = input.next() ;

        System.out.print( "Enter a noun>" ) ;
        noun = input.next() ;

        System.out.print( "Enter a noun>" ) ;
        noun2 = input.next() ;

        System.out.print( "Enter a verb>" ) ;
        verb2 = input.next() ;

        System.out.println() ;
        System.out.println( "Little " + person_name + " " + verb + "ed in a corner" ) ;
        System.out.println( "eating " + adjective + " pie."  ) ;
        System.out.println( " she " + verb2 + "ed in her " + noun + " and said what a good " ) ;
        System.out.println( noun2 + " am I!" ) ;
    }
}
