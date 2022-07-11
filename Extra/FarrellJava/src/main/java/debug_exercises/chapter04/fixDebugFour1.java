package debug_exercises.chapter04;

// This program assigns values to two variables
// and performs mathematical operations with them
public class fixDebugFour1
{
    //public static main(String args[])
    public static void main(String[] args)
    {
        //int x = 5
        int x = 5 ;
        int y = 8;
        //System.out.println("adding " + x + y);
        System.out.println("adding " + (x + y));

        int z = 19;
        //System.out.println("subtracting "  + z - y);
        System.out.println("subtracting "  + (z - y));

        System.out.println("dividing " + z / x);
        //System.out.println("multiplying " + x / z);
        System.out.println("multiplying " + x * z);
    }
}

