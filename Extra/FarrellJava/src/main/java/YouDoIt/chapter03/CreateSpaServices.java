// Java Programming, by Joyce Farrell - Chapter 3 - You Do It p. 148
package YouDoIt.chapter03;

import java.util.Scanner;

public class CreateSpaServices
{
    public static void main( String[] args )
    {

        SpaService firstService = new SpaService() ;
        SpaService secondService = new SpaService() ;

        firstService = getData( firstService ) ;
        secondService = getData( secondService ) ;
        System.out.println( "First service details: " ) ;
            System.out.println( firstService.getServiceDescription() +
                    " $" + firstService.getPrice() ) ;

        System.out.println( "Second service details: " ) ;
            System.out.println( secondService.getServiceDescription() +
                " $" + secondService.getPrice() ) ;
    }
    public static SpaService getData( SpaService service )
    {
        String serviceDescription ;
        double price ;

        Scanner     keyboard = new Scanner( System.in ) ;
        System.out.print( "enter service >>" ) ;
        serviceDescription = keyboard.nextLine() ;
        System.out.print( "enter price >>" ) ;
        price = keyboard.nextDouble() ;

        service.setServiceDescription( serviceDescription ) ;
        service.setPrice( price ) ;

        return service ;
    }
}
