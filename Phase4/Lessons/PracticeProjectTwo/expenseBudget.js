

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
        return this.VendorMap.get( this.count ) ;
        
    }
    
    listVendors()
    {
        document.write("=== VENDORS ===<br>")
        let i = 0 ;
        //for( i = 0 ; i < this.ItemMap.size ; ++i )
        //    display( this.ItemMap.get( i+1 )) ;
        this.VendorMap.forEach( (v) =>{ this.display( v ) ;  })        
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
}
class VendorOffering // product or service
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
    /*
    addTeamByName( name )
    {
        ++this.count ;
        let newOffering = new Offering( this.count, name ) ;
        this.OfferingMap.set( this.count, newOffering ) ; 
    }*/
    listOfferings()
    {
        document.write("=== OFFERINGS ===<br>")
        //let i = 0 ;
        //for( i = 0 ; i < this.ItemMap.size ; ++i )
        //    display( this.ItemMap.get( i+1 )) ;
        this.OfferingMap.forEach( (offering)=>{ this.display( offering ) ;  })        
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
}

class ExpenseItem
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
}

let Offerings = new VendorOfferingList() ;
let Vendors = new VendorList() ;
let Expenses = new ExpenseItemList() ;
let CreatedTeams = new TeamList() ;  
let Teams = new TeamList() ;

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
