function storeData()
{
    let name = "Brian" ;
    localStorage.setItem("item1", name ) ;
    sessionStorage.setItem( "item2", name ) ;
    alert( "Data items stored" ) ;
}