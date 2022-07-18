package YouDoIt.chapter05;

public class DogTriathlonParticipant3
{
    private final int NUM_EVENTS ;
    private static int totalCumulativeScore = 0 ;
    //private int totalCumulativeScore = 0 ;

    private String name ;
    private int obedienceScore ;
    private int conformationScore ;
    private int agilityScore ;
    private int total ;
    private double avg ;
    private boolean doScoresAgree ;

    public DogTriathlonParticipant3( String name,
                                     int numEvents, int score1, int score2, int score3 ) {
        this.name = name;
        NUM_EVENTS = numEvents;

        //int totalNot0 = 0;
        if (score1 != 0) --numEvents ;
        if (score2 != 0) --numEvents ;
        if (score3 != 0) --numEvents ;


        if ( numEvents == 0)
        {
            obedienceScore = score1;
            conformationScore = score2;
            agilityScore = score3;
        }
        else
        {
            obedienceScore = 0 ;
            conformationScore = 0 ;
            agilityScore = 0 ;
        }
        total = obedienceScore +
                conformationScore + agilityScore ;
        if ( NUM_EVENTS == 0 )
            avg = 0 ;
        else
            avg = (double) total / NUM_EVENTS ;

        totalCumulativeScore = totalCumulativeScore + total ;
    }
    public void display( )
    {
        if( NUM_EVENTS != 0 && avg == 0 )
            System.out.println("\n**** Notice! Number of events for " +
                    name + " does not agree with reported scores. ****" ) ;

        System.out.println( name + " participated in " +
                NUM_EVENTS +
                " events and has an average score of " + avg ) ;
        System.out.println( " " + name +
                " has a total score of " + total +
                " bringing the total cumulative score to " +
                totalCumulativeScore ) ;


        //NUM_EVENTS = 5150 ;
    }
}


