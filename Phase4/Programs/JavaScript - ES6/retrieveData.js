function retrieveData()
{
    let name1 = localStorage.getItem("item1") ;
    let name2 = sessionStorage.getItem("item2") ;
    alert( "session storage value: " + name2 + " local storage value: " + name1 ) ;
}