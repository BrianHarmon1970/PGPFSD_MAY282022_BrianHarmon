package debug_exercises.chapter03;

// This application displays some math facts
public class fixDebugThree2 {
    //public static void main(String args[])
    public static void main(String[] args) {
        int a = 2, b = 5, c = 10;

        printFacts( a, b ) ;
        printFacts( b, c ) ;
        printFacts( c, a ) ;
    }

    //public static void add(int a,  b)
    public static void add(int a, int b) {
        System.out.println("The sum of " + a +
                " and " + b + " is " + (a + b));
    }

    //public static void subtract(int a, b)
    public static void subtract(int a, int b) {
        //System.out.println("The difference between  +
        //        a + " and " + b + " is " +  (a * b));
        System.out.println("The difference between " +
                a + " and " + b + " is " + (a - b));
    }
    public static void printFacts( int a, int b ) {
        System.out.println("\nFacts of (" + a + ") and (" + b + ")");
        add(a, b);
        add(b, a);
        subtract(a, b);
        subtract(b, a);
    }
} // --B>S>H> 7/9/2022
