
class TeamBudgetItem // ExpenseBudgetItem
{
    constructor( teamItemId, teamItemExpense, teamItemBudget )
    {
        // this.id = ( id == undefined ? 0 : id ) ;
        this.id = undefined ;
        this.teamId = ( teamItemId == undefined ? 0 : teamItemId ) ;
        this.teamItemExpense = ( teamItemExpense == undefined ? 0.00 : teamItemExpense ) ;
        this.teamItemBudget = ( teamItemBudget == undefined ? 0.00 : teamItemBudget ) ;
        this.description = "" ;
    }  
    buildFromTeam( team ) 
    {
        this.id = team.id ;
        this.teamId = team.id ;
        this.teamItemExpense = 0.00 ;
        this.teamItemBudget = 0.00 ;
        this.description = team.getName() ;
    }
    getId() { return this.id ; }
    getItemId() { return this.teamId ; }
    getItemExpense() { return this.teamItemExpense ; }
    getItemBudget() { return this.teamItemBudget ; }
    getDescription() { return this.description ; }

    setId( id ) { this.id = id ; }
    setItemId( itemId ) { this.teamId = itemId ; }
    setItemExpense( itemExpense ) { this.teamItemExpense = itemExpense ; }
    setItemBudget( itemBudget ) { this.teamItemBudget = itemBudget ; }
    setDescription( description ) { this.description = description ; }
}
class TeamBudget // ExpenseBudgetItemList
{
    constructor()
    {
        this.count = 0 ;
        this.ItemMap = new Map() ;
    }
    getMap( ) { return this.ItemMap ; }
    addTeam( team )
    {
        let newItem = new TeamBudgetItem() ;
        newItem.buildFromTeam( team ) ;
        this.count++ ;
        this.ItemMap.set( this.count, newItem ) ;
        return this.ItemMap.get( this.count ) ;
    }
    getItemArray()
    {
        //return Array.toArray( this.itemMap ) ;
        //console.log( Array.from( this.ItemMap,([id, item]) => ({ id, item}))) ;
        //return Array.from( this.ItemMap,([id, item]) => ({ id, item})) ;
        let array = [{description: 0, teamItemBudget: 0 }] ;
        let i = 0 ;
        this.ItemMap.forEach( (item)=>{
            array[i] = { name: item.description, value: item.teamItemBudget }
            ++i ;
        })
        console.log( "budget", array ) ;
        return array ; 
    }
    testFunction( )
    {
        let str = event.target.getAttribute("data-v")  ;
        
        let vRow = this.getMap().get(  eval(str) ) ;
        //let p = document.getElementById("id_expense-budget-list" ) ;
        //p.textContent = vRow.name ;
        let p = document.getElementById("id_selected_budgetitem" ) ;
        p.textContent = vRow.getItemId() + " " +
                        vRow.getDescription() ;
                        // + " " + 
                    //    vRow.getItemExpense() + " " +
                    //    vRow.getItemBudget()  ;
        SelectedBudgetItem = vRow ;
        let inp = document.getElementById("id_selected_budgetitem_input") ;
        inp.value=vRow.getItemBudget() ;
        ListBudgetItems( document.getElementById("expense-list") ) ;
    }
    writeItemsToElement( targetElement )
    {
        targetElement.innerText = "" ;
        //let s = new Element() ;
        this.ItemMap.forEach( 
            ( item )=> 
                
            {
                  let s = document.createElement( "span" ) ;
                  //let s1 = document.createElement( "span" ) ;
                  let s2 = document.createElement( "p" ) ;
                  let s3 = document.createElement( "p" ) ;
                  let s4 = document.createElement( "p" ) ;
                  let s5 = document.createElement( "p" ) ;

                  s.className="iRow" ;

                  
                  //s.innerText = item.getId() ;
                  s2.textContent = item.getItemId() ; 
                  s4.textContent = item.getItemExpense() ;
                  s5.textContent = item.getItemBudget() ;
                  s3.textContent = item.getDescription() ;
                  
                  s.addEventListener("click",
                  //targetElement.addEventListener("click",
                    ()=>{ 
                        s.setAttribute("data-v", item.id ) ;
                    //    s1.setAttribute("data-v", item.id ) ;
                        s2.setAttribute("data-v", item.id ) ;
                        s3.setAttribute("data-v", item.id ) ;
                        s4.setAttribute("data-v", item.id ) ;
                        s5.setAttribute("data-v", item.id ) ;
                        
                        this.testFunction() ;
                        
                    },false ) ;
                

                
                // s2.classList.add("rowElement") ;
                // s3.classList.add("rowElement") ;
                // s4.classList.add("rowElement") ;
                // s5.classList.add("rowElement") ;

                  //s1.class="twozero" ;
                  s2.classList.add("w10") ;
                  s3.classList.add("w40") ;
                  s4.classList.add("w30") ;
                  s5.classList.add("w30") ;

                  


                  //s1.id = "teams-id";
                  //s2.id = "teams-name" ;
                  //s.append( s1 ) ;
                  s.append( s2 ) ;
                  s.append( s3 ) ;
                  s.append( s4 ) ;
                  s.append( s5 ) ;

                  if ( item.id == SelectedBudgetItem.getId() )
                  s.classList.add( "selected-row" );

                  targetElement.appendChild( s ) ;             
            } 
        ) ;
    }
}

class Team
{
    constructor( id, name ) 
    {
        this.id = id ; 
        this.name = name ;
    }
    getId() { return this.id ; }
    getName() { return this.name ; }
    //toJSON()    {        return( {id: this.id,  name:this.name}) ;    }
}

class TeamList
{
    constructor() 
    {
        this.count = 0 ;
        this.TeamMap = new Map() ;
    }
    addTeam( team )
    {
        this.count++ ;
        this.TeamMap.set( this.count, team ) ;
        return this.TeamMap.get( this.count ) ;
    }
    addTeamByName( name )
    {
        ++this.count ;
        let newTeam = new Team( this.count, name ) ;
        this.TeamMap.set( this.count, newTeam ) ; 
        return this.TeamMap.get( this.count ) ;
    }
    listTeams()
    {
        document.write("=== TEAMS ===<br>")
        this.TeamMap.forEach( (team, id )=>{ document.writeln( id + " " + team.id + " "+ team.name+"<br>") ;  })        
    }
    testFunction( targetElement )
    {
        let str = event.target.getAttribute("data-v")  ;
        
        let vRow = Teams.getMap().get(  eval(str) ) ;
        let p = document.getElementById("id_selected_team" ) ;
        p.textContent = vRow.name ;
        SelectedTeam = vRow ;
        ListTeams() ;
        
    }
    writeTeamsToElement( targetElement )
    {
        targetElement.innerText = "" ;
        //let s = new Element() ;
        this.TeamMap.forEach( 
            (team, id)=> 
                
            {
                  let s = document.createElement( "span" ) ;
                  let s1 = document.createElement( "span" ) ;
                  let s2 = document.createElement( "span" ) ;
                  s.className="iRow" ;
                  s1.innerText = team.id ;
                  s2.innerText = team.name ;
                  
                  s.addEventListener("click",
                  //targetElement.addEventListener("click",
                    ()=>{ 
                        s.setAttribute("data-v", team.id ) ;
                        s1.setAttribute("data-v", team.id ) ;
                        s2.setAttribute("data-v", team.id ) ;
                        
                        this.testFunction( targetElement ) ;
                        
                    },false ) ;
                

                  s1.class = "rowElement" ;
                  s2.class = "rowElement" ;

                  s1.id = "teams-id";
                  s2.id = "teams-name" ;
                  s.append( s1 ) ;
                  s.append( s2 ) ;

                if ( team.id == SelectedTeam.getId() )
                    s.classList.add( "selected-row" );
                targetElement.appendChild( s ) ;             
            } 
        ) ;
        /* let s = document.createElement( "span") ;
        let t = document.createTextNode( "Hello." ) ;
         s.appendChild( t ) ;

        //targetElement.appendChild( t ) ;
        targetElement.appendChild( s ) ; */
        
    }
    getTeamList() 
    {
        let str = "=== TEAMS ===\n" ;
        this.TeamMap.forEach( (team, id )=>{ str+=( id + " " + team.id + " "+ team.name+"\n") ;  }) ; 
        return str ;
    }
    setMap( map ) { this.TeamMap = map  ; this.count = map.size ;  }
    getMap() { return this.TeamMap ; }
}

class Vendor
{
    constructor( id, name ) 
    {
        this.id = id ;
        this.name = name ;
    }
    getId() { return this.id ; }
    getName() { return this.name ; }
}
class VendorList
{   
    constructor( id, name )
    {
        this.id = id ;
        this.name = name ;
        this.count = 0 ;
        //let VendorMap = new Map() ;
        this.VendorMap = new Map() ;
    }
    getId() { return this.id ; }
    getName() { return this.name ; }
    addVendor( item )
    {
        this.count++ ;

        item.id =  this.count  ;
        this.VendorMap.set( this.count, item ) ;
        //this.addVendorByName( item.getName() ) ;
        
        return this.VendorMap.get( this.count ) ;
    }
    addVendorByName( name )
    {
        this.count++ ;
        let newVendor = new Vendor( this.count, name ) ;
        //this.addVendor( newVendor) ;
        this.VendorMap.set( this.count, newVendor ) ; 
        return this.VendorMap.get( this.count )         
    }
    
    listVendors()
    {
        document.write("=== VENDORS ===<br>")
        let i = 0 ;
        //for( i = 0 ; i < this.ItemMap.size ; ++i )
        //    display( this.ItemMap.get( i+1 )) ;
        this.VendorMap.forEach( (v) =>{ this.display( v ) ;  })        

    }
    getList()
    {
        let str = "" ;
        str += "=== VENDORS ===\n" ;
        this.VendorMap.forEach( (v) =>{ str += this.getDisplayString( v ) ;  })  ;
        return str ;      
    }
    testFunction( )
    {
        let str = event.target.getAttribute("data-v")  ;
        
        let vRow = Vendors.getMap().get(  eval(str) ) ;
        let p = document.getElementById("id_selected_vendor" ) ;
        p.textContent = vRow.name ;
        SelectedVendor = vRow ;
        SelectedProduct = null ;
        document.getElementById( "id_selected_product").textContent = "[product]" ;
        ListVendors() ;
        ListVendorProducts() ;
    }
    writeListToElement( targetElement )
    {
        targetElement.innerText = "" ;
        //let s = new Element() ;
        this.VendorMap.forEach( 
            ( v )=>  
            {
                
                    let s = document.createElement( "span" ) ;
                    s.className = "iRow" ;
                    let s1 = document.createElement( "span" ) ;
                    let s2 = document.createElement( "span" ) ;
                    s1.innerText = v.id ;
                    s2.innerText = v.name ;

                    s.addEventListener("click",
                    ()=>
                    {
                        s.setAttribute("data-v", v.id ) ;
                        s1.setAttribute("data-v", v.id ) ;
                        s2.setAttribute("data-v", v.id ) ;
                        
                        this.testFunction() ;
                    })

                    s1.id = "vendors-id" ;
                    s2.id = "vendors-name" ;
                    
                    s.append( s1 ) ;
                    s.append( s2 ) ;

                    if ( v.id == SelectedVendor.getId() )
                    s.classList.add( "selected-row" );
                  
                    targetElement.appendChild( s ) ;             
                }
            
        ) ;
    }
  
    setMap( map ) { this.VendorMap = map  ; this.count = map.size ;  }
    getMap() { return this.VendorMap ; }

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
    storeVendors()
    {
        let str = JSON.stringify( this.getMap(), replacer ) ;
        window.localStorage.setItem('VendorList', str ) ;
        document.write( "str: " + str +"<br>") ;
        //console.log( str ) ;
    }
    restoreVendors()
    {
        let str = window.localStorage.getItem('VendorList' ) ;
        document.write( "str: " + str + "<br>") ;
        let item =  JSON.parse( str ) ;
        this.setMap( new Map( item.value )) ;
        console.log( Teams ) ;
    }
    display( item ) 
    { 
        document.write( item.id + " " + 
                        item.name + "<br>"  ) ;
    }
    getDisplayString( item ) 
    { 
        let str = "" ;
        str +=  item.id + " " + item.name + "\n"   ;
        return str ;
    }
}
/* class VendorOffering // product or service
{
    // int id
    // int vendorId
    // string description
    // int unitBundle ;
    // double unitPrice
    // int termMonths
    // double subscriptionPrice ; 
    // double offeringPrice

    constructor()
    {
        this.initObject() ;
    }
    initObject()
    {
        this.id = 0 ;
        this.vendorId = 0 ;
        this.description = "" ;
        this.offeringType = "" ;
        this. unitBundle=1  ;
        this.unitPrice = 0.0 ;
        this.termMonths = 0 ;
        this.subscriptionPrice = 0.0; 
        this.offeringPrice = 0.0 ;
    }
    setId( id ) { this.id = id ; }
    getId( ) { return this.id ; }
    
    /// ----- Builders
    baseBuilder( vendorId, description )
    {
        this.initObject() ;
        this.vendorId = vendorId ; this.description = description ; 
    }
    simpleProductBuilder( itemPrice ) 
    { 
        this.unitPrice = itemPrice ;
        this.offeringPrice = itemPrice ;
        this.offeringType = "product" ;
    }
    multiUnitProductBuilder( itemPrice, unitcount ) 
    {
        this.simpleProductBuilder( itemPrice ) ;
        this.unitBundle = unitcount ;
        this.offeringPrice = itemPrice * unitcount ;
    }
    monthlySubscriptionBuilder( monthlyPrice, termMonths )
    {
        this.unitPrice = monthlyPrice ;
        this.termMonths = termMonths ;
        this.offeringPrice = this.unitPrice * termMonths ;
        this.offeringType = "subscription" ;
    }
    yearlySubscriptionBuilder( yearlyPrice, years )
    {
        this.monthlySubscriptionBuilder( yearlyPrice / 12.0, 12*years ) ;
    }

    /// ----- Getters
    getId() { return this.id ; }
    getVendorId() { return this.vendorId ; }
    getDescription() { return this.description ; }
    //getUnitBundle ;
    //getUnitPrice
    //getTermMonths
    //getSubscriptionPrice ; 
    getPrice() { return this.offeringPrice ; }
    // --- document Display
    display() 
    {
        document.write( this.id + " " + this.vendorId + " " 
                        + this.description + " " + this.getPrice() + "<br>" ) ;
    }

}
function testFunction( val  )
    {
        let str = event.target.getAttribute("data-v")  ;
        
        //alert("testFunction() called:" + str ) ;
        //callingElement.appendChild( document.createTextNode("TestFunction() called")) ;
        //let vProduct = Offerings.getMap().get(  eval(str) ) ;
        //let p = document.getElementById("id_selected_team" ) ;
        //p.textContent = vProduct.description ;
    }
class VendorOfferingList
{
    constructor() 
    {
        this.count = 0 ;
        this.OfferingMap = new Map() ;
    }
    setMap( map ) { this.OfferingMap = map  ; this.count = map.size ;  }
    getMap() { return this.OfferingMap ; }
    addOffering( offering )
    {
        this.count++ ;
        offering.setId( this.count ) ;
        this.OfferingMap.set( this.count, offering ) ;
    }
    testFunction(  )
    {
        let str = event.target.getAttribute("data-v")  ;
        
        //alert("testFunction() called:" + str ) ;
        //callingElement.appendChild( document.createTextNode("TestFunction() called")) ;
        let vProduct = Offerings.getMap().get(  eval(str) ) ;
        let p = document.getElementById("id_selected_product" ) ;
        p.textContent = vProduct.description ;
        SelectedProduct = vProduct ;
        
    }
    //
    //addTeamByName( name )
    //{
    //    ++this.count ;
    //    let newOffering = new Offering( this.count, name ) ;
    //    this.OfferingMap.set( this.count, newOffering ) ; 
    //}
    listOfferings()
    {
        document.write("=== OFFERINGS ===<br>")
        //let i = 0 ;
        //for( i = 0 ; i < this.ItemMap.size ; ++i )
        //    display( this.ItemMap.get( i+1 )) ;
        this.OfferingMap.forEach( (offering)=>{ this.display( offering ) ;  })        
    }
    getList()
    {
        let str1 =  "=== OFFERINGS ===\n" ;
        this.OfferingMap.forEach( 
            (offering)=>{ str1 += this.getDisplayString( offering ) ;  }) ;       
        return str1 ;
    }
    
    writeListToElement( targetElement )
    {
        targetElement.innerText = "" ;
        //let s = new Element() ;
        this.OfferingMap.forEach( 
            ( item )=> 
                
            {
                let v = new Vendor( item ) ;
                if ( item.vendorId == SelectedVendor.getId())
                {
                let s = document.createElement( "span" ) ;
                //s.className = "iRow" ;
                //s.setAttribute( "capture", "true" ) ;
                //s.setAttribute("data-v", item.id) ;
                
                  let s1 = document.createElement( "span" ) ;
                  let s2 = document.createElement( "span" ) ;
                  let s3 = document.createElement( "span" ) ;
                  let s4 = document.createElement( "span" ) ;
                  //targetElement.className ="i4" ;
                  s.addEventListener("click",
                  //targetElement.addEventListener("click",
                    ()=>{ 
                        s.setAttribute("data-v", item.id ) ;
                        s1.setAttribute("data-v", item.id ) ;
                        s2.setAttribute("data-v", item.id ) ;
                        s3.setAttribute("data-v", item.id ) ;
                        s4.setAttribute("data-v", item.id ) ;
                        
                        this.testFunction() ;
                        
                    },false ) ;
                

                  s1.innerText = item.id ;
                  s2.innerText = item.vendorId ;
                  s3.innerText = item.description ;
                  s4.innerText = item.offeringPrice ;
                  s1.class = "rowElement" ;
                  s2.class = "rowElement" ;
                  s3.class = "rowElement" ;
                  s4.class = "rowElement" ;

                  s1.id = "product-id" ;
                  s2.id = "product-vid" ;
                   s3.id = "product-description" ;
                   s4.id = "product-price" ;
                  
                  s.append( s1 ) ;
                  s.append( s2 ) ;
                  s.append( s3 ) ;
                  s.append( s4 ) ;

                  if ( item.id == SelectedProduct.getId() )
                  s.classList.add( "selected-row" );

                targetElement.appendChild( s ) ;
                }
            } 
        ) ;
    }
  
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
    storeOfferings()
    {
        let str = JSON.stringify( this.getMap(), replacer ) ;
        window.localStorage.setItem('OfferingList', str ) ;
        document.write( "str: " + str +"<br>") ;
        //console.log( str ) ;
    }
    restoreOfferings()
    {
        let str = window.localStorage.getItem('OfferingList' ) ;
        document.write( "str: " + str + "<br>") ;
        let item =  JSON.parse( str ) ;
        this.setMap( new Map( item.value )) ;
       
    }
    display( offering ) 
    { 
        //document.write( item.id + " " + 
        //                item.name + "<br>"  ) ;
        //item.display() ;
        //offering.display() ;
        document.write( offering.id + " " + offering.vendorId + " " 
        + offering.description + " " + offering.offeringPrice + "<br>" ) ;

    }   
    getDisplayString( offering ) 
    {
        let str = "" ;
        str +=  offering.id + " " + offering.vendorId + " "   + offering.description + " " + offering.offeringPrice + "\n"  ;
        return str ;

    }
}
 */
/* class ExpenseItem
{
    // int id
    // int teamId
    // int vendorId
    // string description
    // Date date ; 
    // int units 
    // double unitPrice
    // double totalCost

    constructor( id, Team, vendor, description, date )
    {
        this.id = id  ;
        this.teamId = Team.getId() ;
        this.vendorId = vendor.getId() ;
        this.description = description ;
        this.date = date ;
    }

    setUnitCount( numUnits ) { this.units = numUnits ; calculateCost ; }
    setUnitPrice( unitPrice ) { this.unitPrice = unitPrice ; calculateCost ; }
    calculateCost() {this.totalCost = this.units * this.unitPrice ; }
    getId() { return this.id ; }
    getUnitCount() { return this.units ; }
    getUnitPrice() { return this.unitPrice ; }
    getTotalExpense() {  calculateCost() ; return this.totalCost ; }
    
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
    // writeItemsToElement( targetElement )
    //{
    //    targetElement.innerText = "" ;
    //    //let s = new Element() ;
    //    this.ItemMap.forEach( 
    //        (team, id)=> 
    //            
    //        {
    //              let s = document.createElement( "span" ) ;
         //         let s1 = document.createElement( "span" ) ;
         //         let s2 = document.createElement( "span" ) ;
         //         s1.innerText = team.id ;
         //         s2.innerText = team.name ;
         //         s.append( s1 ) ;
         //         s.append( s2 ) ;
         //           // s.innerText = ( id + " " + team.id + " "+ team.name+"\n") ;
         //           targetElement.appendChild( s ) ;             
        //    } 
      //  ) ;
    //} 
  
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
                        item.totalCost+ "<br>" ) ; 
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
        item.totalCost+ "\n"
        return str ;

    }
}
 */
/* let Offerings = new VendorOfferingList() ;
let Vendors = new VendorList() ;
let Expenses = new ExpenseItemList() ;
let CreatedTeams = new TeamList() ;  
let Teams = new TeamList() ;
let SelectedVendor = new Vendor() ;
let SelectedTeam = new Team() ;
let SelectedProduct = new VendorOffering() ;
 */
function replacer(key, value) {
    if(value instanceof Map) {
      return {
        dataType: 'Map',
        value: Array.from(value.entries()) 
      };
    } else {
      return value;
    }
  }
function storeTeamList()
{
    let str = JSON.stringify(CreatedTeams.getMap(), replacer ) ;
    window.localStorage.setItem('TeamList', str ) ;
    document.write( "str: " + str +"<br>") ;
    //console.log( str ) ;
    /*let db = window.indexedDB.open( "TeamList" ) ;
    db.onsuccess = (event) => {
        //note.innerHTML += '<li>Database initialized.</li>';
      
        alert("Open DB: Success") ;
        // store the result of opening the database in the db variable.
        // This is used a lot below
        db = DBOpenRequest.result;
      
        let transaction = db.transaction(["TeamList"], "readwrite") ;
        db.transaction.objectStore().put(Teams, "TeamList" ) ;
      };*/
}
function restoreTeamList()
{
    let str = window.localStorage.getItem('TeamList' ) ;
    document.write( "str: " + str + "<br>") ;
    let item =  JSON.parse( str ) ;
    let map = new Map( item.value )  ;
    Teams = new TeamList() ;
    Teams.setMap( map ) ; 
    //console.log( JSON.parse( window.sessionStorage.getItem("TeamList"))) ;
    console.log( Teams ) ;
    /*let db = window.indexedDB.open( "TeamList" ) ;
    db.onsuccess = (event) => {
        alert("Open DB: Success") ;
        //note.innerHTML += '<li>Database initialized.</li>';     
        // store the result of opening the database in the db variable.
        // This is used a lot below
        db = DBOpenRequest.result;
        getData() ;
    };*/
}
/*
function getData() 
{
    transaction = db.transaction.objectStore().get(Teams, "TeamList" ) ;
        transaction.oncomplete = (event) => {
            Teams = window.indexedDB.objectStore.get(["TeamList"]) ;
            //note.innerHTML += '<li>Transaction completed.</li>';
            alert("Get Object Store ( Teams ): Transaction Complete" ) ;
        };
    
        transaction.onerror = (event) => {
            //note.innerHTML += `<li>Transaction not opened due to error: ${transaction.error}</li>`;
            alert("Get Object Store ( Teams ):  Transaction not opened due to error: ${transaction.error}") ; 
        }
}*/
