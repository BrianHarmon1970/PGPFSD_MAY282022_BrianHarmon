let empObject = { id:100, name:"Ravi", salary:"20000", result:true } ;
document.write( "<br> Object in literal style." ) ;
document.write( "<br>id is " + empObject.id ) ;
document.write( "<br>name is " + empObject.name ) ;
document.write( "<br>salary is " + empObject.salary ) ;
document.write( "<br>result is " + empObject.result ) ;

let empString = JSON.stringify( empObject ) ;
document.write( "<br> Object in string style." ) ;
document.write( "<br>id is " + empString.id ) ;
document.write( "<br>name is " + empString.name ) ;
document.write( "<br>salary is " + empString.salary ) ;
document.write( "<br>result is " + empString.result ) ;
document.write( "<br>[" + empString + "]<br>")

let empJSON = JSON.parse( empString ) ;

document.write( "<br> Object in JSON style." ) ;
document.write( "<br>id is " + empJSON.id ) ;
document.write( "<br>name is " + empJSON.name ) ;
document.write( "<br>salary is " + empJSON.salary ) ;
document.write( "<br>result is " + empJSON.result ) ;

empString = JSON.stringify( empJSON ) ;
