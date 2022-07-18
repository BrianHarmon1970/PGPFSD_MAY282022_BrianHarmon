package YouDoIt.chapter05;

public class TestDogs3
{
    public static void main( String[] args )
    {
        DogTriathlonParticipant3 dog1 =
                new DogTriathlonParticipant3( "Bowser", 2, 85, 89, 0 ) ;
        dog1.display();

        DogTriathlonParticipant3 dog2 =
                new DogTriathlonParticipant3( "Rush", 3, 78, 72, 80 ) ;
        //new DogTriathlonParticipant( "Rush", 0, 78, 72, 80 ) ;
        dog2.display();

        DogTriathlonParticipant3 dog3 =
                new DogTriathlonParticipant3( "Ginger", 3, 90, 86, 72 ) ;
        dog3.display();

        System.out.println("<====================================>");
        dog2.display();
    }
}


