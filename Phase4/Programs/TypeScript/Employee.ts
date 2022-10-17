//class Employee
//{
//    private id:number= 100 ;
//    private name:string = "Ravi" ;
//    private age:number = 33 ;
//    public displayInfo(): void
//    {
//        console.log( "Id is: " + this.id ) ;
//        console.log( "Name is: " + this.name ) ;
//        console.log( "Age is: " + this.age ) ;
//        
//    }
//    constructor( id:number=0, name:string="", age:number=0 ) 
//    {
//    
//        this.id=id ;
//        this.name=name ;
//        this.age=age ;
//    
//    }
//}

class Employee
{
    constructor( private id:number=0, 
        private name:string="", 
        private age:number=0 ) 
    {}

    public displayInfo(): void
    {
        console.log( "Id is: " + this.id ) ;
        console.log( "Name is: " + this.name ) ;
        console.log( "Age is: " + this.age ) ;
        
    }   
}

let emp1 = new Employee(100, "Ravi", 21 )  ;
let emp2 = new Employee(101, "Lokesh", 24 ) ;
let emp3 = new Employee(102, "Ajay")
let emp4 = new Employee(103)
let emp5 = new Employee() ;

emp1.displayInfo() ;
emp2.displayInfo() ;
emp3.displayInfo() ;
emp4.displayInfo() ;
emp5.displayInfo() ;
