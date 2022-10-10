function addEmployee()
{
    var name = document.getElementById("n1").value ;
    var age =  document.getElementById( "n2" ).value ;
    var pTag = document.createElement( "p" ) ;
    var pTagContent= document.createTextNode( "Name: " + name + " Age: " + age ) ;
    pTag.appendChild( pTagContent ) ;
    if ( age > 25 ) 
    {        
        pTag.setAttribute("class","myClass1" ) ;       
    }
    else
    {
        pTag.setAttribute("class","myClass2" ) ;
    }
    document.getElementById( "result" ).appendChild( pTag ) ;
    document.getElementById("n1").value = "" ;
    document.getElementById( "n2" ).value = "" ;
}