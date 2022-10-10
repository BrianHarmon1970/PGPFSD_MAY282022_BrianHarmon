// normal function
// expresssion style
// arrow style 


function greeting( fname, callback )
{
    return( "<br> Welcome user, " + callback(fname) ) ;
}
function maleInfo( fname )
{
    return( " Mister " + fname ) ;
}
let femaleInfo = (fname)=>"Miss "+fname ;
document.write( greeting( "Raj", maleInfo  )) ;
document.write( greeting( "Seeta", femaleInfo  )) ;
document.write( greeting( "John", function(fname) { return "Mr. " + fname ; })) ;
document.write( greeting( "Neena", (fname)=>"Miss" + fname )) ;


