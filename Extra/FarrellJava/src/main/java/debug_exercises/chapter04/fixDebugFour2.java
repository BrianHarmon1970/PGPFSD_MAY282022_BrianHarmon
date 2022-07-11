package debug_exercises.chapter04;

// Some circle statistics
public class fixDebugFour2
{
    public static void main(String args[])
    {
        double radius = 12.6;
        System.out.println("Circle statistics");
        //double area = java.Math.PI * radius * radius;
        double area = Math.PI * radius * radius;
        System.out.println("area is " + area);
        //double diameter = 2 - radius;
        double diameter = 2 * radius;
        System.out.println("diameter is " + diameter);
    }
}
