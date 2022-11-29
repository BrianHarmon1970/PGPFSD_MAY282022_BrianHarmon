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
// function testFunction( val  )
//     {
//         let str = event.target.getAttribute("data-v")  ;
//
//         //alert("testFunction() called:" + str ) ;
//         //callingElement.appendChild( document.createTextNode("TestFunction() called")) ;
//         //let vProduct = Offerings.getMap().get(  eval(str) ) ;
//         //let p = document.getElementById("id_selected_team" ) ;
//         //p.textContent = vProduct.description ;
//     }
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
    getProductById( id )
    {
        return this.getMap().get( id ) ;
    }
    testFunction(  )
    {
        let str = event.target.getAttribute("data-v")  ;
        
        //alert("testFunction() called:" + str ) ;
        //callingElement.appendChild( document.createTextNode("TestFunction() called")) ;
        let vProduct = Offerings.getMap().get(  eval(str) ) ;
        updateSelectedProduct( vProduct ) ;
        
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

                  if ( SelectedProduct != null)
                  // && 
                  {
                    if ( item.id == SelectedProduct.getId() )
                        s.classList.add( "selected-row" );
                  }

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
