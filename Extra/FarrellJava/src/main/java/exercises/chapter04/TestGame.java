package exercises.chapter04;
/*
5.  a.  Create a class to hold data about a high school sports team. The Team
        class holds data fields for high school name (such as Roosevelt High), sport
        (such as Girl's Basketball), and team name ( such as Dolphins). Include a
        constructor that takes parameters for each field, and include get methods
        that return the values of the fields. Also include a public fina static
        String named MOTTO and initialize it to Sportsmanship!. Write an application
        named TestTeam to instantiate three Team objects with different values, and
        then display all the data, including the mott, for ache object. Save both the
        Team.java and TestTeam.java files.

    b.  Create a class named Game. Include two Team fields that hold data about
        the teams participating in the game. Also include a field for game time ( for
        example, 7PM). Include a constructor that takes parameters for two Team
        objects and a time. Write an application named TestGame to instantiate a
        Game object, then pass the Game to a method that displays the details about
        the Game.
 */
public class TestGame
{
    public static void main( String[] args )
    {

        Game TheGame ;

        String  t1school =  "Vince Lombardi High School",
                t1team =    "Pinheads" ,
                t1game =    "Rock and Roll" ;
        Team VLHS = new Team( t1school, t1game ,t1team ) ;

        String  t2school =  "Rydell High",
                t2team =    "Rangers" ,
                t2game =    "" ;
        Team RHS = new Team( t2school, t2game, t2team ) ;

        String gameTime = "Tonight 7:30PM" ;
        TheGame = new Game( RHS, VLHS, gameTime ) ;
        showGame( TheGame ) ;
    }
    static void showGame( Game g )
    {
        System.out.println( "Game On! " +
                g.getHomeTeam().getSchoolName() + " " + g.getHomeTeam().getTeamName() +
                " vs. " + g.getVisitors().getSchoolName() + " " + g.getVisitors().getTeamName() +
                    "  " + g.getGameTime() );
    }

}
