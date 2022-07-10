package debug_exercises;

// This class calculates a waitperson's tip as 15% of the bill
public class fixDebugThree1
{
    //public static void main(String args[])
    public static void main(String[] args)
    {
        double myCheck = 50.00;
        double yourCheck = 19.95;
        System.out.println("Tips are");
        calcTip(myCheck);
        // calctip(yourcheck);
        calcTip(yourCheck) ;
    }
    //public void calcTip(double bill)
    public static void calcTip(double check)
    {
        final double RATE = 0.15;
        double tip;
        tip = check * RATE;
        System.out.println( "The check is: $" + check ) ;
        System.out.println("The tip should be at least " + tip);
    }
}