package exercises.chapter04;
/*
6.  a.  Create a class named Circle with fields named radius, diameter, and area.
        Include a constructor that sets the radius to 1 and calculates the other two
        values. Also include methods named setRadius() and getRadius(). The
        setRadius() method not only sets the radius, but it also calculates the other
        two values. (The diameter of a circle is twice the radius, and the area of a circle
        is pi multiplied by the square of the radius. Use the Math class PI constant
        for this calculation.) Save the class as Circle.java.

    b.  Create a class named TestCircle whose main() method declares several
        Circle objects. Using the setRadius() method, assign one Circle a
        small radius value, and assign another a larger radius value. Do not assign
        a value to the radius of the third circle; instead, retain the value assigned
        at construction. Display all the values for all the Circle objects. Save the
        application as TestCircle.java

 */
public class TestCircle
{
    public static void main( String[] args )
    {
        Circle smallCircle = new Circle();
        Circle largeCircle = new Circle();
        Circle unitCircle = new Circle();

        smallCircle.setRadius( 3 ) ;
        largeCircle.setRadius( 120 ) ;
        //unitCircle.setRadius( 1 ) ; // default construction
        displayCircle( smallCircle, "smallCircle"  ) ;
        displayCircle( largeCircle, "largeCircle" ) ;
        displayCircle( unitCircle, "unitCircle" ) ;
    }
    static void displayCircle( Circle c, String preFix )
    {
        System.out.println( preFix +
                ":\t\tradius = " + c.getRadius() +
                "\t\tdiameter = "  + c.getDiameter() +
                "\t\tarea = "  + c.getArea()
        ) ;
    }
    void displayCircle( Circle c ) { displayCircle( c, "" ) ; }

}
