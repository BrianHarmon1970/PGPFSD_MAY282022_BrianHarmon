package exercises.chapter04;
/*
2.  Create a class named Billing that includes three overloaded computeBill()
    methods for a photo book store.

        When computeBill() receives a single parameter, it represents the price of
        one photo book ordered. Add 8% tax, and return the total due.

        When computeBill() receives two parameters, they represent the price of
        a photo book and the quantity ordered. Multiply the two values, add 8% tax and
        return the total due.

        When computeBill() receives three parameters, they represent the price of a
        photo book, the quantity ordered, and a coupon value. Multiply the quantity
        and price, reduce the result by the coupon value,  and then add 8% tax and
        return the total due.

    Write a main() method that test all three overloaded methods. Save the
    application as Billing.java

 */

public class Billing
{
    public static void main( String[] args )
    {
        final double bookPrice = 45.00 ;

        System.out.println( "One book order - $" + computeBill( bookPrice )) ;
        System.out.println( " 20 book order - $" + computeBill(bookPrice, 20 )) ;
        System.out.println( " 20 book order with $100 coupon discount - $" +
                computeBill( bookPrice, 20, 100.00)) ;
    }
    public static double computeBill( double book_price )
    {
        return book_price * 1.08 ;
    }
    public static double computeBill( double book_price, int book_quantity )
    {
        return ( book_price * book_quantity) * 1.08 ;
    }
    public static double computeBill( double book_price, int book_quantity, double coupon_discount )
    {
        return ((book_price*book_quantity)-coupon_discount) * 1.08 ;
    }
}
