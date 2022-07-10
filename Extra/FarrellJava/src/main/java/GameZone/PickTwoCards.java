package GameZone;
/*
1.  Playing cards are used in many computer games, including verson fo such
    classics as solitaire, hearts, and poker. Design a Card class that contains a
    character data field to hold a suit ( s for spade, h fo hearts, d for diamonds,
    or c for clubs) and an integer data field for a value from 1 to 13. (When you
    learn more about string handling in the chapter "Characters, Strings, and the
    StringBuilder", you can modify the class to hold words for the  suits, such as
    spades or hearts, as well as words for some fo the values - for example, ace or
    king.) Include get and set methods for each field. Save the class Cards.Java.

    Write an application that randomly selects two playing cards and displays their
    values. Simply assign a suit to each of the cards, but generate a random number
    for each card's value. Appendix D contains information about generating random
    numbers. To fully understand the process, you must learn more about Java
    classes and methods. However, for now , you can copy the following statements to
    generate a random number between 1 and 13 and assign it to a variable:

    final int CARDS_IN_SUIT = 13 ;
    myValue = ((int)(Math.random() *100) % CARDS_IN_SUIT + 1 ) ;

    After reading the chapter "Making Decisions", you will be able to have the game
    determine the higher card. For now, just observe ho the card values change as you
    execute the program multiple times. Save the application as PickTwoCards.java.

 */
public class PickTwoCards
{
    public static void main( String[] args )
    {
        Card card1 = new Card() ;
        Card card2 = new Card() ;

        card1.setSuit( 'H' ) ;
        card1.setOrdinal( selectRandomCardNumber());

        card2.setSuit( 'S' ) ;
        card2.setOrdinal( selectRandomCardNumber() ) ;

        System.out.print( "[ Card 1 ]" ) ;
        ShowCard( card1 ) ;
        System.out.print( "[ Card 2 ]" ) ;
        ShowCard( card2 ) ;
    }
    static int selectRandomCardNumber( )
    {
        final int CARDS_IN_SUIT = 13 ;
        return  ((int)(Math.random() *100) % CARDS_IN_SUIT + 1 ) ;
    }
    static void ShowCard( Card card )
    {
        System.out.print( "\tSuit: " + card.getSuit()) ;
        System.out.print( "\tCard Number: " + card.getOrdinal()) ;
        System.out.print( "\n" ) ;
    }
}
