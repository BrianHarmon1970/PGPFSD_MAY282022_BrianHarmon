// Array is a pre-defined object
// literal style object creation
let num1 = [] ;

// object creation using - new
let num2 = new Array() ;

document.writeln( "<br>Size of Array 1 is " + num1.length ) ;
document.writeln( "<br>Size of Array 2 is " + num2.length ) ;

let num3 = [100,200,300,400] ;
document.writeln( "<br>Size of Array 3 is " + num3.length ) ;
document.writeln( "<br>Elements of 3 are " + num3 ) ;

num3.push(10) ; // add to end
num3.push(20) ;

num3.unshift(1) ; // add to beginning
num3.unshift(2) ;

document.writeln( "<br>Elements of 3 are " + num3 ) ;

num3.pop() ; // remove element
num3.shift() // remove from end

document.writeln( "<br>Elements of 3 are " + num3 ) ;

num3.splice( 2, 2, 1000, 2000, 3000) // remove 2 items at position 2 and replace with 1000, 2000, 3000
document.writeln( "<br>Elements of 3 are " + num3 ) ;


