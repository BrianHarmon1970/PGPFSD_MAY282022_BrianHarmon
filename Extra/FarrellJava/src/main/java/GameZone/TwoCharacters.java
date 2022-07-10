package GameZone;
/*
2.  Computer games often contain different characters or creatures. For example,
    you might design a game in which alien beings possess specific characteristics
    such as color, number of eyes, or number of lives. Design a character for a game,
    creating a class to hold at least three attributes for the character. Include methods
    to get and set each of the character's attributes. Save the file as MyCharacter.java.
    Then write an application in which you create at least two characters.
    In turn, pass each character to a display method that displays the character's
    attributes. Save the application as TwoCharacters.java.

 */
public class TwoCharacters
{
    public static void main( String[] args )
    {
        MyCharacter bisMark = new MyCharacter() ;
        MyCharacter charkBit = new MyCharacter() ;
        MyCharacter sarsByte = new MyCharacter() ;

        charkBit.setCharacterName( "CharkBit" ) ;
        charkBit.setCharacterRace( "Human" ) ;
        charkBit.setCharacterClass( "Fighter" ) ;

        charkBit.setAgility( 14 ) ;
        charkBit.setIntelligence( 9 ) ;
        charkBit.setStrength( 20 ) ;
        charkBit.setHitpoints( 110 ) ;


        sarsByte.setCharacterName( "SarsByte" ) ;
        sarsByte.setCharacterRace( "Elf") ;
        sarsByte.setCharacterClass( "Rogue" ) ;

        sarsByte.setAgility( 20 ) ;
        sarsByte.setIntelligence( 12 ) ;
        sarsByte.setStrength( 15 ) ;
        sarsByte.setHitpoints( 65 ) ;

        ShowCharacter( charkBit ) ;
        ShowCharacter( sarsByte ) ;
    }
    public static void ShowCharacter( MyCharacter character )
    {
        System.out.println( "\n <===> "+ character.getCharacterName() +" <===>  " ) ;
        System.out.println( " Race:\t\t" + character.getCharacterRace() ) ;
        System.out.println( " Class:\t\t" + character.getCharacterClass() ) ;
        System.out.println( "<--- Abilities --->" ) ;
        System.out.println( " Strength:\t\t" + character.getStrength() ) ;
        System.out.println( " Intelligence:\t" + character.getIntelligence() ) ;
        System.out.println( " Agility:\t\t" + character.getAgility() ) ;
        System.out.println( ">--- Stats ---<" ) ;
        System.out.println( " Hit Points:\t" + character.getHitpoints() ) ;
    }
}
