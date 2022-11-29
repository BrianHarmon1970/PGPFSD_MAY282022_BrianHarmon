class ExpenseItem
{
    // int id
    // int teamId
    // int vendorId
    // string description
    // Date date ; 
    // int units 
    // double unitPrice
    // double totalPrice
    // double discountAmount
    // double netCost
    // string status 

    constructor( id, Team, vendor, description, date )
    {
        this.id = id  ;
        this.teamId = Team.id ;
        this.vendorId = vendor.id ;
        this.description = description ;
        this.date = date ;
        this.status = "pending" ;
        //this.calculateCost() ;
    }

    getStatus() { return this.status ; }
    setStatus(status) { this.status = status ; }
    getDescription() { return this.description ; }
    setUnitCount( numUnits ) { this.units = numUnits ; this.calculateCost() ; }
    setUnitPrice( unitPrice ) { this.unitPrice = unitPrice ; this.calculateCost() ; }
    calculateCost() 
    {
        this.totalPrice = this.units * Math.floor( (this.unitPrice+.005)*100)/100 ;
        this.netCost = this.totalPrice - this.discountAmount  ; 
    }
    getId() { return this.id ; }
    getTeamId() { return this.teamId ; }
    getVendorId() { return this.vendorId ; }
    getUnitCount() { return this.units ; }
    getUnitPrice() { return this.unitPrice ; }
    getTotalPrice() {  return this.totalPrice ; }
    getTotalExpense() {  return this.netCost ; }
    getDiscountAmount() { return this.discountAmount ; }
    applyProduct( product ) 
    {
        this.vendorId = product.vendorId ;
        this.setUnitPrice( product.offeringPrice ) ;
        this.description = product.description ; 
        this.calculateCost() ;
    }
    applyDiscount( discount ) 
    {
        discount.ApplyTotal( this.unitPrice /* this.unitPrice * this.units */ ) ;
        this.discountAmount = (Math.floor( (discount.discountAmount*100)) * this.units)/100 ;
        //this.netCost = this.totalPrice - this.discountAmount * this.units ;
        this.netCost = this.totalPrice - this.discountAmount  ;
        console.log( this ) ;
    }
    applyTeam( team ) 
    {
        this.teamId = team.id ;
    }
    
}
class ExpenseItemList
{
    constructor()
    {   
        this.ItemMap = new Map() ;
        this.count = 0 ;

    }
    addItem( item )
    {
        this.count++ ;
        item.id = this.count ;
        this.ItemMap.set( this.count, item ) ;
    }
    
    listItems()
    {
        document.write("=== ITEMS ===<br>")
        let i = 0 ;
        //for( i = 0 ; i < this.ItemMap.size ; ++i )
        //    display( this.ItemMap.get( i+1 )) ;
        this.ItemMap.forEach( ( item ) =>{ this.display( item ) ;  })        
    }
    testFunction( status )
    {
        let str = event.target.getAttribute("data-v")  ;
        let vRow = Expenses.getMap().get( eval(str) ) ;
        updateSelectedExpenseItem( vRow, status ) ;       
    }
    writeListToElement( targetElement, status, teamid )
    {
        targetElement.innerText = "" ;
        //let s = new Element() ;
        this.ItemMap.forEach( 
            ( item )=> 
                
            {
                    // int id
    // int teamId
    // int vendorId
    // string description
    // Date date ; 
    // int units 
    // double unitPrice
    // double totalPrice
    // double discountAmount
    // double totalCost
        if( (teamid == undefined || item.getStatus() == teamid ) &&
                (status == undefined || item.getStatus() == status))
        {
                  let s = document.createElement( "span" ) ;
                  let s1 = document.createElement( "span" ) ;
                  let s2 = document.createElement( "span" ) ;
                  let s3 = document.createElement( "span" ) ;
                  let s4 = document.createElement( "span" ) ;
                  //let s5 = document.createElement( "span" ) ;
                  let s6 = document.createElement( "span" ) ;
                  let s7 = document.createElement( "span" ) ;
                  let s8 = document.createElement( "span" ) ;
                  let s9 = document.createElement( "span" ) ;
                  let s10 = document.createElement( "span" ) ;

                  s.addEventListener("click",
                    ()=>
                    {
                        s.setAttribute("data-v", item.id ) ;
                        s1.setAttribute("data-v", item.id ) ;
                        s2.setAttribute("data-v", item.id ) ;
                        s3.setAttribute("data-v", item.id ) ;
                        s4.setAttribute("data-v", item.id ) ;
                        //s5.setAttribute("data-v", item.id ) ;
                        s6.setAttribute("data-v", item.id ) ;
                        s7.setAttribute("data-v", item.id ) ;
                        s8.setAttribute("data-v", item.id ) ;
                        s9.setAttribute("data-v", item.id ) ;
                        s10.setAttribute("data-v", item.id ) ;
                        
                        this.testFunction( status ) ;
                    })

                  s1.innerText = item.id ;
                  s2.innerText = item.teamId ;
                  s3.innerText = item.vendorId ;
                  s4.innerText = item.description ;
                  //s5.innerText = item.date ;
                  s6.innerText = item.units ;
                  s7.innerText = item.unitPrice ;
                  s8.innerText = item.totalPrice ;
                  s9.innerText = item.discountAmount ;
                  s10.textContent = item.netCost ;

                  s1.class = "" ;
                  s1.classList.add( "w5" ) ;
                  s2.classList.add( "w5" ) ;
                  s3.classList.add( "w5" ) ;
                  //s4.classList.replace("width", "w25") ;
                  s4.classList.add( "w50" ) ;
                  s6.classList.add( "w5" ) ;
                  s7.classList.add( "w10" ) ;
                  s8.classList.add( "w10" ) ;
                  s9.classList.add( "w10" ) ;
                  s10.classList.add( "w10" ) ;



                  console.log( item ) ;
                  console.log( "itemId: " + item.id ) ;
                  console.log( "netCost: " + item.netCost ) ;

                  s.append( s1 ) ;
                  s.append( s2 ) ;
                  s.append( s3 ) ;
                  s.append( s4 ) ;
                  //s.append( s5 ) ;
                  s.append( s6 ) ;
                  s.append( s7 ) ;
                  s.append( s8 ) ;
                  s.append( s9 ) ;
                  s.append( s10 ) ;
                  
                  if ( item.id == SelectedExpenseItem.getId() )
                  s.classList.add( "selected-row" );

                  // s.innerText = ( id + " " + team.id + " "+ team.name+"\n") ;
                  targetElement.appendChild( s ) ;             
                }
            }
        ) ;
    } 
    Summarize()
    {
        let sum = 0.0 ;

        this.ItemMap.forEach( 
            ( item )=> 
            {
                sum += Math.floor(item.netCost*100) ;
            }
        ) ;
        return sum /100  ;
    }
    SummarizeTeamId( teamid, status )
    {
        let sum = 0.0 ;

        this.ItemMap.forEach( 
            ( item )=> 
            {
                if (( status == undefined || status == item.getStatus()) &&
                 ( item.teamId == teamid ))
                    sum += Math.floor(item.netCost*100) ;
            }
        ) ;
        return sum /100  ;
    }
    getItemById( id ) 
    {
        return this.ItemMap.get( id ) ;
    }
    setMap( map ) { this.ItemMap = map  ; this.count = map.size ;  }
    getMap() { return this.ItemMap ; }

    replacer(key, value) {
        if(value instanceof Map) {
          return {
            dataType: 'Map',
            value: Array.from(value.entries()) 
          };
        } else {
          return value;
        }
      }
    storeItems()
    {
        let str = JSON.stringify( this.getMap(), replacer ) ;
        window.localStorage.setItem('ItemList', str ) ;
        document.write( "str: " + str +"<br>") ;
        //console.log( str ) ;
            
    }
    restoreItems()
    {
        let str = window.localStorage.getItem('ItemList' ) ;
        document.write( "str: " + str + "<br>") ;
        let item =  JSON.parse( str ) ;
        this.setMap( new Map( item.value )) ;
        //this.ItemMap = new ( item.value ) ;
    
        //let map = new Map( item.value )  ;
        //this = new ExpenseItemList() ;
        //this.setMap( map ) ; 
        //console.log( JSON.parse( window.sessionStorage.getItem("TeamList"))) ;
        console.log( Teams ) ;
    }
    

    display( item ) 
    { 
        document.write( item.id + " " + 
                        item.teamId  + " " + 
                        item.vendorId + " " +
                        item.description + " " +
                        item.date + " " + 
                        item.units + " " +
                        item.unitPrice + " " +
                        item.getTotalPrice()+ "<br>" ) ;
    }
    getList()
    {
        let str =  "=== ITEMS ===\n"
        this.ItemMap.forEach( ( item ) =>{ str += this.getExpenseItemString( item ) ;  }) ;
        return str ;
    }
    getExpenseItemString( item )
    {
        let str = "" ;
        str += item.id + " " + 
        item.teamId  + " " + 
        item.vendorId + " " +
        item.description + " " +
        item.date + " " + 
        item.units + " " +
        item.unitPrice + " " +
        item.getTotalPrice()+ "\n"
        return str ;

    }
}
