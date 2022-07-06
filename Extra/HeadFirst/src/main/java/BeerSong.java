public class BeerSong
{
    public static void main( String[] args )
    {
        int bottlesOfBeer = 99 ;
        String word = "bottles" ;

        while ( bottlesOfBeer > 0 )
        {

            System.out.println( bottlesOfBeer + " " + word + " of beer on the wall," ) ;
            System.out.println( bottlesOfBeer + " " + word + " of beer." ) ;
            System.out.println( " Take one down, pass it around, " ) ;

            bottlesOfBeer = bottlesOfBeer - 1 ;
            if ( bottlesOfBeer == 1 ) // bug fix - moved from prior to bottlesOfBeer value change
                word = "bottle" ;
            else word = "bottles" ;  // for zero bottles

            System.out.println( bottlesOfBeer + " " + word + " of beer on the wall." ) ;
        }
    }
}
