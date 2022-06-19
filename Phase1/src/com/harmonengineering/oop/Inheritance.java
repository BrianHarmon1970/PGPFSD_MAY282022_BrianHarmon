package com.harmonengineering.oop;
class Product
{
    protected Integer productNo ;
    protected String  productName ;
    Product()
    {
        productNo = 78 ;
        productName = "Amul" ;
    }
    Product( int pno, String pname )
    {
        productNo = pno ;
        productName = new String( pname ) ;
    }
    public void display()
    {
        System.out.println( "" ) ;
        System.out.println( "Product Number: " + productNo ) ;
        System.out.println( "Product Name: " + productName ) ;
    }
}
class A extends Product
{
    protected static final Integer  count = 50 ;
    protected static final String category = "Butter" ;
    public void display()
    {
        //System.out.println( "Product Number: " + productNo ) ;
        //System.out.println( "Product Name: " + productName ) ;
        super.display() ;
        System.out.println( "count: " + count ) ;
        System.out.println( "category: " + category ) ;
    }
}
class B extends Product
{
    protected  static final Integer  count = 90 ;
    protected static final String category = "Milk" ;

    public void display()
    {
       super.display() ;
        System.out.println( "count: " + count ) ;
        System.out.println( "category: " + category ) ;
    }

}
class C extends Product
{
    protected static final Integer  count = 56 ;
    protected static final String category = "Chocolate" ;

    public void display()
    {
        super.display() ;
        System.out.println( "count: " + count ) ;
        System.out.println( "category: " + category ) ;
    }


}
class subA extends A
{
    protected static final Double price = 30.00 ;
    public void display()
    {
        //System.out.println( "Product Number: " + productNo ) ;
        //System.out.println( "Product Name: " + productName ) ;
        //System.out.println( "count: " + count ) ;
        //System.out.println( "category: " + category ) ;
        super.display() ;
        System.out.println( "total price: " +  price * count ) ;
    }

}
class subB extends B
{
    private static final Double price = 10.00 ;
    public void display()
    {
       super.display() ;
        System.out.println( "total price: " + price * count ) ;
    }
}
public class Inheritance
{
    public static void main( String[] args )
    {
        A a = new A() ;
        B b = new B() ;
        C c = new C() ;

        subA suba = new subA() ;
        subB subb = new subB() ;

        a.display() ;
        b.display() ;
        c.display() ;
        suba.display();
        subb.display() ;

    }
}
