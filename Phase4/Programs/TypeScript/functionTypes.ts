// function parameters
function add( a , b ) 
{
    console.log( a+" "+ b ) ;
}

function empInfo( id:number, name:string, age:number ) 
{
    console.log( id+" "+name+" "+ age ) ;
}
empInfo( 100, "Ravi", 33 ) ;

// function with no return type
function info():void
{
    return ;
}
// function with return type
function sayHello():string
{
    return "Hello" ;
}
// function with number return type
function getNumber():number
{
    return 100 ;
}

// function with 'any' return type
function greeting():any
{
    return "welcome" ;
}

// optional parameters 
function studentInfo ( sid?:number , sname?:string, age?:number ) 
{

}

// default parameters 
function studentInfo2 ( sid:number=100 , sname?:string, age:number=33 ) 
{
    
}

studentInfo( 100, "Ravi" , 21 ) ;
studentInfo( 101, "Lokesh" ) ;
studentInfo( 102 ) ;
studentInfo() ;

studentInfo2( 100, "Ravi" , 21 ) ;
studentInfo2( 101, "Lokesh" ) ;
studentInfo2( 102 ) ;
studentInfo2() ;