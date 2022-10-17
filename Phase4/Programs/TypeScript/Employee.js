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
var Employee = /** @class */ (function () {
    function Employee(id, name, age) {
        if (id === void 0) { id = 0; }
        if (name === void 0) { name = ""; }
        if (age === void 0) { age = 0; }
        this.id = id;
        this.name = name;
        this.age = age;
    }
    Employee.prototype.displayInfo = function () {
        console.log("Id is: " + this.id);
        console.log("Name is: " + this.name);
        console.log("Age is: " + this.age);
    };
    return Employee;
}());
var emp1 = new Employee(100, "Ravi", 21);
var emp2 = new Employee(101, "Lokesh", 24);
var emp3 = new Employee(102, "Ajay");
var emp4 = new Employee(103);
var emp5 = new Employee();
emp1.displayInfo();
emp2.displayInfo();
emp3.displayInfo();
emp4.displayInfo();
emp5.displayInfo();
