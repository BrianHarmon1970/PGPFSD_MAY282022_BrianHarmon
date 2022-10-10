var a = 10 ;
a = 20 ;
var a = 30 ;

document.write( a ) ;

let b = 10 ;
b = 20 ;
//let b = 30 ;

document.write( b ) ;

for ( var i = 0 ; i < 1000 ; ++i ) 
{

}
document.write( "<br" + i ) ;
for (let j=0 ; j< 1000 ; ++j ) 
{

}

//document.write( "<br>" + j ) ;
const c=3000 ; // should error
//c = 1000 ;