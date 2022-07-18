package YouDoIt.chapter05;
// Java Programming, by Joyce Farrell - Chapter 4 - You Do It p. 202
import YouDoIt.chapter04.DogTriathlonParticipant;

public class TestDogs2
{
    public static void main( String[] args )
    {
        DogTriathlonParticipant2 dog1 =
                new DogTriathlonParticipant2( "Bowser", 2, 85, 89, 0 ) ;
        dog1.display();

        DogTriathlonParticipant2 dog2 =
                new DogTriathlonParticipant2( "Rush", 2, 78, 72, 80 ) ;
        //new DogTriathlonParticipant( "Rush", 0, 78, 72, 80 ) ;
        dog2.display();

        DogTriathlonParticipant2 dog3 =
                new DogTriathlonParticipant2( "Ginger", 4, 90, 86, 72 ) ;
        dog3.display();

        System.out.println("<====================================>");
        dog2.display();
    }
}


