public class BeerSong
{
    public static void main( String[] args )
    {
        int bottlesOfBeer = 99 ;
        String word = "bottles" ;

        while ( bottlesOfBeer > 0 )
        {
            if ( bottlesOfBeer == 1 )
                word = "bottle" ;

            System.out.println( bottlesOfBeer + " " + word + " of beer on the wall," ) ;
            System.out.println( bottlesOfBeer + " " + word + " of beer." ) ;
            System.out.println( bottlesOfBeer + " Take one down, pass it around, " ) ;

            bottlesOfBeer = bottlesOfBeer - 1 ;
            System.out.println( bottlesOfBeer + " " + word + " of beer on the wall." ) ;
        }
    }
}
