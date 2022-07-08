package exercises.chapter02;

public class fixDebugTwo3
{
    public static void main(String args[] ) // missing closing parn --fixed B>S>H> 7/7/2020
    {
        int a = 99, b = 8, result; //missing comma after decl a --fixed B>S>H> 7/7/2020
        long c = 7777777777777L;  // const long value expressed as default int --fixed B>S>H> 7/7/2020
        result = a % b ; // missing semicolong --fixed B>S>H> 7/7/2020
        System.out.println("Divide " + a + " by " + b);
        System.out.println("remainder is " + result);
        System.out.print("c is a very large number: ");
        System.out.println(c);
    }
}
