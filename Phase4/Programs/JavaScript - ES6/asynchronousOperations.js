/*document.write("<br>Statement 1" ) ;

setTimeout( ()=>{
document.write("<br>Statement 2" ) ;
},1000 ) ;
setInterval( ()=>{

document.write("<br>Statement 3" ) ;
}, 1000 )
*/
function info()
{
    setInterval( doTask, 1000 ) ;
}
let i = 0 ;
function doTask()
{
    if( i%2 == 0 ) 
    {
        document.getElementById("obj").style.color="RED" ;
        document.getElementById("obj").style.backgroundColor="BLUE" ;

    }
    else 
    {
        document.getElementById("obj").style.color="GREEN" ;
        document.getElementById("obj").style.backgroundColor="ORANGE" ;

    }
    ++i ;
}