package com.harmonengineering.oop;

/*
 *
 in vechile:
- create two methods - run() and stop()
- create three methods of public void fuel - 1st method will take int / 2nd method will float and string  / 3rd method will take char and int
- declare two variables - int speed and long distance
- create two constructors also- default and parametrized
2W:
- oveeride the two methods - run() and stop()
- create default constructor
- declare two variables - int speed and long distance with different values from the parent vechile
- decalre one more variable as int nos_of_tyre = 2
- create methods here also as display() --> this will print the three variables of 2W  + all the variable of the parent Vechile

from Virendra to All Participants:
3W:
- oveeride the two methods - run() and stop()
- - create default constructor
- declare two variables - int speed and long distance with different values from the parent vechile
- decalre one more variable as int nos_of_tyre = 3
- create methods here also as display() --> this will print the three variables of 3W  + all the variable of the parent Vechile
4W:
- oveeride the two methods - run() and stop()
- create default constructor
- declare two variables - int speed and long distance with different values from the parent vechile
- decalre one more variable as int nos_of_tyre = 4
- create methods here also as display() --> this will print the three variables of 4W  + all the variable of the parent Vechile

from Virendra to All Participants:
8W:
- oveeride the two methods - run() and stop()
- create default constructor
- declare two variables - int speed and long distance with different values from the parent vechile
- decalre one more variable as int nos_of_tyre = 8
- create  methods here also as display() --> this will print the three variables of 8W  + all the variable of the parent Vechile
  Main()
  call all the methods using runtime polymorphism here...+ all the methods of class Vechile
 * */


class Vehicle
{
    //	 - create two methods - run() and stop()
//	 - create three methods of public void fuel - 1st method will take int / 2nd method will float and string  / 3rd method will take char and int
    // - declare two variables - int speed and long distance
    // - create two constructors also- default and parametrized
    public Vehicle( )
    {
        speed = 0 ;
        distance = 0 ;
    }
    public Vehicle( int s, long d )
    {
        speed = s ;
        distance = d ;

    }
    int speed ;
    long distance ;
    void run() {}
    void stop() {}
    public void fuel( int fuel ) {}
    public void fuel( float fuel ) {}
    public void fuel( double fuel ) {}
    public void display()
    {
        System.out.println("Vehicle(speed) = "+ speed ) ;
        System.out.println("Vehicle(distance) = "+ distance ) ;
    }
}

class TwoWheeler extends Vehicle
{
    /*	 - oveeride the two methods - run() and stop()
         - create default constructor
         - declare two variables - int speed and long distance with different values from the parent vechile
         - decalre one more variable as int nos_of_tyre = 2
         - create methods here also as display() --> this will print the three variables of 2W  + all the variable of the parent Vechile
    */
    public void run() {}
    public void stop() {}

    int speed ;
    long distance ;
    int number_of_tires = 2 ;
    // @Override
    public void display()
    {
        System.out.println("2W(speed) = "+ this.speed ) ;
        System.out.println("2W(distance) = "+ this.distance ) ;
        System.out.println("2W(number_of_tires) = "+ this.number_of_tires ) ;
        //System.out.println("Vehicle(speed) = "+ super.speed ) ;
        //System.out.println("Vehicle(distance) = "+ super.distance ) ;
        super.display() ;
    }
}
//class ThreeWheeler extends Vehicle
//{
/*	 3W:
		 - oveeride the two methods - run() and stop()
		 - - create default constructor
		 - declare two variables - int speed and long distance with different values from the parent vechile
		 - decalre one more variable as int nos_of_tyre = 3
		 - create methods here also as display() --> this will print the three variables of 3W  + all the variable of the parent Vechile
*/
class ThreeWheeler extends Vehicle
{
    ThreeWheeler(  )
    {
        super( ) ;
    }
    public void run() {}
    public void stop() {}
    public int speed ;
    public long distance ;
    int number_of_tires = 3 ;

    public void display()
    {
        System.out.println("3W(speed) = "+ this.speed ) ;
        System.out.println("3W(distance) = "+ this.distance ) ;
        System.out.println("3W(number_of_tires) = "+ this.number_of_tires ) ;
        //System.out.println("Vehicle(speed) = "+ super.speed ) ;
        //System.out.println("Vehicle(distance) = "+ super.distance ) ;
        super.display() ;
    }
}

/*	 4W:
		 - oveeride the two methods - run() and stop()
		 - create default constructor
		 - declare two variables - int speed and long distance with different values from the parent vechile
		 - decalre one more variable as int nos_of_tyre = 4
		 - create methods here also as display() --> this will print the three variables of 4W  + all the variable of the parent Vechile
*/
class FourWheeler extends Vehicle
{
    void run() {}
    void stop() {}
    public FourWheeler()
    {
        speed = 51 ;
        distance = 50 ;
    }
    int speed ;
    long distance ;
    int number_of_tires = 4 ;
    public void display()
    {
        System.out.println("3W(speed) = "+ this.speed ) ;
        System.out.println("3W(distance) = "+ this.distance ) ;
        System.out.println("3W(number_of_tires) = "+ this.number_of_tires ) ;
        //System.out.println("Vehicle(speed) = "+ super.speed ) ;
        //System.out.println("Vehicle(distance) = "+ super.distance ) ;
        super.display() ;
    }
}

/*	 8W:
		 - oveeride the two methods - run() and stop()
		 - create default constructor
		 - declare two variables - int speed and long distance with different values from the parent vechile
		 - decalre one more variable as int nos_of_tyre = 8
		 - create  methods here also as display() --> this will print the three variables of 8W  + all the variable of the parent Vechile
		   Main()
		   call all the methods using runtime polymorphism here...+ all the methods of class Vechile
*/
class EighteenWheeler extends Vehicle
{
    public void run() {}
    public void stop() {}
    public EighteenWheeler()
    {
        speed = 1050 ;
        distance = 1543 ;
    }
    int speed ;
    long distance ;
    int number_of_tires = 18 ;
    public void display()
    {
        System.out.println("18W(speed) = "+ this.speed ) ;
        System.out.println("18W(distance) = "+ this.distance ) ;
        System.out.println("18W(number_of_tires) = "+ this.number_of_tires ) ;
        //System.out.println("Vehicle(speed) = "+ super.speed ) ;
        //System.out.println("Vehicle(distance) = "+ super.distance ) ;
        super.display() ;
    }
}
public class VehiclePolymorphism {
    public static void main ( String args[] )
    {

        TwoWheeler tw = new TwoWheeler() ;
        System.out.println( "Displaying 2 Wheeler via 2 Wheeler ref" ) ;
        tw.display();

        System.out.println( "Displaying 2 Wheeler via Vehicle(parent) ref" ) ;
        Vehicle n = tw ;
        n.display();

        ThreeWheeler threeW = new ThreeWheeler() ;
        System.out.println( "Displaying 3 Wheeler via 3 Wheeler ref" ) ;
        threeW.display();

        System.out.println( "Displaying 3 Wheeler via Vehicle(parent) ref" ) ;
        n = threeW ;
        n.display();

        FourWheeler fourW = new FourWheeler() ;
        System.out.println( "Displaying 4 Wheeler via 3 Wheeler ref" ) ;
        fourW.display();

        System.out.println( "Displaying 4 Wheeler via Vehicle(parent) ref" ) ;
        n = fourW ;
        n.display();

        EighteenWheeler eighteenW = new EighteenWheeler() ;
        System.out.println( "Displaying 18 Wheeler via 3 Wheeler ref" ) ;
        eighteenW.display();

        System.out.println( "Displaying 18 Wheeler via Vehicle(parent) ref" ) ;
        n = eighteenW ;
        n.display();
    }
}


