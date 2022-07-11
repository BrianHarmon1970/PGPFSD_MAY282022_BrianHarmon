package exercises.chapter04;
/*

5.  a. Creat a class to hold data about a high school sports team. The Team
        class holds data fields for high school name (such as Roosevelt High), sport
        (such as Girl's Basketball), and team name ( such as Dolphins). Include a
        constructor that takes parameters for each field, and include get methods
        that return the values of the fields. Also include a public fina static
        String named MOTTO and initialize it to Sportsmanship!. Write an application
        named TestTeam to instantiate three Team objects with different values, and
        then display all the data, including the motto, for each object. Save both the
        Team.java and TestTeam.java files.

    b. Create a class named Game. Include two Team fields that hold data about
        the teams participating in the game. Also include a field for game time ( for
        example, 7PM). Include a constructor that takes parameters for two Team
        objects and a time. Write an application named TestGame to instantiate a
        Game object, then pass the Game to a method that displays the details about
        the Game.

 */
public class Team
{
    public final static String MOTTO =  "Sportsmanship!" ;

    private String SchoolName ;
    private String NameOfTheGame ;
    private String TeamName ;

    public Team(String school_name, String game_name, String team_name )
    {
        SchoolName = school_name ;
        NameOfTheGame = game_name ;
        TeamName = team_name ;
    }
    public String getSchoolName() { return SchoolName; }
    public String getNameOfTheGame() { return NameOfTheGame; }
    public String getTeamName() { return TeamName; }

}
