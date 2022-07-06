class Movie
{
    String title ;
    String genre ;
    int rating ;

    void playIt()
    {
        System.out.println("Playing the movie." ) ;
    }
}
public class MovieTestDrive
{
    public static void main( String[] args )
    {
        Movie one = new Movie() ;
        one.title = "Gone with the Stock" ;
        one.genre = "Tragic" ;
        one.rating = -2 ;

        Movie two = new Movie() ;
        one.title = "Lost in Cubicle Space" ;
        one.genre = "Comedy" ;
        one.rating = 5 ;
        two.playIt();

        Movie three = new Movie() ;
        one.title = "Byte Club" ;
        one.genre = "Tragic but ultimately uplifting" ;
        one.rating = 127 ;

    }
}
