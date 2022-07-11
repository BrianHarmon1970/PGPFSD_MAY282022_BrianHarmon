package exercises.chapter04;
/*

5.  a. Creat a class to hold data about a high school sports team. The Team
        class holds data fields for high school name (such as Roosevelt High), sport
        (such as Girl's Basketball), and team name ( such as Dolphins). Include a
        constructor that takes parameters for each field, and include get methods
        that return the values of the fields. Also include a public fina static
        String named MOTTO and initialize it to Sportsmanship!. Write an application
        named TestTeam to instantiate three Team objects with different values, and
        then display all the data, including the mott, for ache object. Save both the
        Team.java and TestTeam.java files.

    b. Create a class named Game. Include two Team fields that hold data about
        the teams participating in the game. Also include a field for game time ( for
        example, 7PM). Include a constructor that takes parameters for two Team
        objects and a time. Write an application named TestGame to instantiate a
        Game object, then pass the Game to a method that displays the details about
        the Game.

 */
public class TestTeam
{
    public static void main( String[] args )
    {
        Team CHS = new Team( "Canadian High School", "Football" , "Wildcats" ) ;
        Team CHSgirls = new Team( "Canadian High School",
                "Girls Basketball" ,
                "Lady Cats" ) ;
        Team RHS = new Team( "Vince Lombardi High School",
                "Rock and Roll" ,
                "Pinheads" ) ;

        displayTeam( CHS ) ;
        displayTeam( CHSgirls ) ;
        displayTeam( RHS ) ;



    }
    static void displayTeam( Team t )
    {
        System.out.println( "School:\t" + t.getSchoolName()) ;
        System.out.println( "Team:\t" + t.getTeamName()) ;
        System.out.println( "Game:\t" + t.getNameOfTheGame()) ;
        System.out.println( "Motto:\t" + t.MOTTO ) ;
        System.out.println() ;
    }
}
