// Java Programming, by Joyce Farrell - Chapter 3 - You Do It p. 144
package YouDoIt.chapter03;

public class SpaService
{
    private String serviceDescription ;
    private double price ;
    public SpaService()
    {
        serviceDescription = "XXXXXX" ;
        price = 0.00 ;
    }
    public void setServiceDescription( String description )
    {
        serviceDescription = description ;
    }

    public void setPrice( double servicePrice )
    {
        price = servicePrice ;
    }
    public String getServiceDescription( )
    {
        return serviceDescription ;
    }
    public double getPrice( )
    {
        return price ;
    }
}
