// literal object creation
let emp1= {id:100, name:"Ravi", age:21 } ;
document.write( "<br> literal object notation" ) ;
document.write( "<br>id: " + emp1.id ) ;
document.write( "<br>name: " + emp1.name ) ;
document.write( "<br>age: " + emp1.age ) ;
// ES5 function style object access
document.write( "<br> function object notation" ) ;
/*function Employee()
{
    this.id = 101 ;
    this.name = "Rajesh" ;
    this.age = 34 ; 
    
    this.display = function() {
    document.write( "<br>id: " + this.id ) ;
    document.write( "<br>name: " + this.name ) ;
    document.write( "<br>age: " + this.age ) ;
    }
    this.displayDetails = ()=>document.write( "<br>Welcome, " + this.name ) ;
}
emp2 = new Employee() ;
emp2.display() ;
emp2.displayDetails() ;
*/
/*
function Employee( id , name , age )
{
    //this.id = 101 ;
    //this.name = "Rajesh" ;
    //this.age = 34 ; 
    
    this.display = function() {
    document.write( "<br>id: " + this.id ) ;
    document.write( "<br>name: " + this.name ) ;
    document.write( "<br>age: " + this.age ) ;
    }
    //this.displayDetails = ()=>document.write( "<br>Welcome, " + this.name ) ;
}
emp3 = new Employee( 102, "Lokesh", 1000 ) ;
emp3.display() ;
emp3.displayDetails() ;

emp4 = new Employee( 103, "Mahesh", 1000 ) ;
emp4.display() ;
emp4.displayDetails() ;
*/
/// ES6 class style

class CEmployee
{
    id = 101 ;
    name = "Rajesh" ;
    age = 34 ; 
    
    display = function() {
    document.write( "<br>id: " + this.id ) ;
    document.write( "<br>name: " + this.name ) ;
    document.write( "<br>age: " + this.age ) ;
    }
    //this.displayDetails = ()=>document.write( "<br>Welcome, " + this.name ) ;
}
emp5 = new CEmployee() ;
emp5.display() ;
//emp5.displayDetails() ;
class CEmployee2
{
    constructor( id, name, age )
    {
        this.id = id  ;
        this.name = name ;
        this.age = age ;
    }
    
    
    display = function() {
    document.write( "<br>id: " + this.id ) ;
    document.write( "<br>name: " + this.name ) ;
    document.write( "<br>age: " + this.age ) ;
    }
    //this.displayDetails = ()=>document.write( "<br>Welcome, " + this.name ) ;
}
emp6 = new CEmployee2( 200, "Seeta", 30000 )  ;
emp6.display() ;

emp7 = new CEmployee2( 300, "Raju", 40000 )  ;
emp7.display() ;

emp8 = new CEmployee2() ;


