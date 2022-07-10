package exercises.chapter03;
/*

11. a.  Create a class named Sandwich. Data fields include a String for the main
        ingredient(such as tuna), a String for bread type(such as wheat), and a
        double for price(such as 4.99). Include methods to get and set values for
        each of these fields. Save the class as Sandwich.java.

    b.  Create an application named TestSandwich that instantiates one Sandwich
        object and demonstrates the use of the set and get methods. Save this
        application as TestSandwich.java.

 */
public class Sandwich
{
    private String  kind ;
    private String  bread ;
    private double  price ;

    public void setKind(String kind) { this.kind = kind;  }
    public void setBread(String bread) { this.bread = bread; }
    public void setPrice(double price) { this.price = price; }

    public String getKind() { return kind; }
    public String getBread() { return bread; }
    public double getPrice() { return price; }
}
