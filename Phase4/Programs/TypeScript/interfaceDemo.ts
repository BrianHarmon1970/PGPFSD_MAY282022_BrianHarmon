/// interface with variables and functions
//interface IEmployee
//{
//    id:number ;
//    name:string ;
//    salary:number ;
//    dis(): void ;
//}

//class EmployeeImpl implements IEmployee
//{
//    id:number ;
//    name:string ;
//    salary:number ;
//    dis(): void {} 
//}

// interface with only variables 
interface IEmployee
{
    id:number ;
    name:string ;
    age:number ;
}
let employee1:IEmployee = {id:100,name:"Ravi", age:21 } ;

//interface with only funcions
/// interface with variables and functions
//interface IEmployee
//{
//    id:number ;
//    name:string ;
//    salary:number ;
//    dis(): void ;
//}
interface IBank
{
    withdraw():void ;
    deposit():void :
}

class HdfcBank implements IBank
{
    withdraw(): void {
        
    }
    deposit(): void {
        
    }

}
class HsbcBank implements IBank
{
    withdraw(): void {
        
    }
    deposit(): void {
        
    }       
}