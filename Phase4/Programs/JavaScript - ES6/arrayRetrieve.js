let num1 = [100,200,300,400,500,600] ;
document.write( "<br>" + num1 ) ;
document.write( "<br>" + num1.join("->")) ;

for ( let i = 0 ; i < num1.length ; ++i)
for ( let i in num1 )
{
    document.write( "Element " + i + " is " + num1[i] ) ;
}

for ( let n of num1 )
{
    document.write( "Element  is " + n ) ;
}

document.write( "<br> Using callback" ) ;
num1.forEach( display) ;
function display(n)
{
    document.write( "<br>"+n) ;
}
document.write( "<br> forEach listings " ) ;
num1.forEach( function display(n) {  document.write( "<br>"+n) ; })
num1.forEach( function(n) {  document.write( "<br>"+n) ; }) ;
num1.forEach( function(n) {  document.write( "<br>"+n) ; }) ;
num1.forEach( n=>document.write("<br>"+n)) ;
