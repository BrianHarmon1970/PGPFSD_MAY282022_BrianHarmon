package debug_exercises.chapter03;

// This program calculates tutition bills
// as credits times rate per credit hour
public class fixDebugThree4
{
    //public static void main(String args[])
    public static void main(String[] args)
    {
        int myCredits = 13;
        int yourCredits = 17;
        double rate = 75.84;
        //System.out.println(My tuition:");
        System.out.println("My tuition:");
        tuitionBill(myCredits, rate);
        System.out.println("Your tuition:");
        //tuitionBill(yourCredits, myCredits);
        tuitionBill(yourCredits, rate );
    }
    //public static void TuitionBill(int c, double r)
    public static void tuitionBill(int c, double r)
    {
        //System.out.println("Total due  + (r / c));
        System.out.println("Total due " + (r * c));
    }
}
