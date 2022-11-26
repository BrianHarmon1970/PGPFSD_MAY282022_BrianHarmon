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
        updateSelectedVendor( vRow ) ;
        
        
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
