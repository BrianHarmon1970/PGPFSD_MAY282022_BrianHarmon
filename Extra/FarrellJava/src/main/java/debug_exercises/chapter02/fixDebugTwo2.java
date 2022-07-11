package debug_exercises.chapter02;

public class fixDebugTwo2
{ // missing open brace - fixed B>S>H> 7/7/2022
    // public static void main(String args[]) // C-Style - OK but with warning
    public static void main(String[] args) // Java Style array decl String[] --fixed B>S>H> 7/7/2022
    {
            int a, b;
            a = 7 ; // missing semicolon --fixed B>S>H> 7/7/2022
            b = 4;
            System.out.println("The sum is " + (a + b)); // sum reported as concat of 7 adn 4 due to
                                                        // java interpreted + as String op --fixed B>S>H> 7/7/2022
            System.out.println("The difference is " + (a - b)); // java interpreted - as a string op --fixed B>S>H> 7/7/2022
            System.out.println("The product is " + a * b) ; // missing semicolon --fixed B>S>H> 7/7/2022
    }
}
