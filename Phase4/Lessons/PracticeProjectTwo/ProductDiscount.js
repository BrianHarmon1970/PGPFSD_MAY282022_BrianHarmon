class ProductDiscount
{
    // id 
    // productId
    // VendorId
    // TeamId
    // name
    // description
    // fractionalDiscount
    // couponDiscount
    // discountAmount
    constructor()
    {
        let id = 0 ;
        let productId = 0 ;
        let vendorId = 0 ;
        let teamId = 0 ;
        let name = "" ;
        let description = "" ;
        let fractionalDiscount = 0.00 ;
        let couponDiscount = 0.00 ;
        let discountAmount = 0.00 ;
    }
    getId() { return this.id ; }
    getProductId() { return this.productId ; }  
    getVendorId() { return this.vendorId ; }   
    getTeamId() { return this.teamId ; }   
    getName() { return this.name ; }
    getDescription() { return this.description ; }
    getFractionalDiscount() { return this.fractionalDiscount ; }   
    getCouponDiscount() { return this.couponDiscount ; }  
    getDiscountAmount() { return this.discountAmount ; }   

    setId( id ) { this.id = id ; }
    setProductId( productId ) { this.productId = productId ; }  
    setVendorId( vendorId ) { this.vendorId = vendorId ; }   
    setTeamId( teamId ) { this.teamId = teamId ; }   
    setName( name ) { this.name = name ; }
    setDescription( description ) { this.description = description ; }
    setFractionalDiscount( fractionalDiscount ) { this.fractionalDiscount = fractionalDiscount ; }   
    setCouponDiscount( couponDiscount ) { this.couponDiscount = couponDiscount ; }  
    setDiscountAmount( discountAmount ) { this.discountAmount = discountAmount ; } 
    ApplyTotal(  total )
    {
        this.fractionalDiscount = (
            this.fractionalDiscount == null || 
            this.fractionalDiscount == undefined || 
            this.fractionalDiscount == NaN 
            ? 0.00 : this.fractionalDiscount ) ;

        this.couponDiscount = (
            this.couponDiscount == null || 
            this.couponDiscount == undefined || 
            this.couponDiscount == NaN 
            ? 0.00 : this.couponDiscount ) ;

        
        total = Math.floor((total)*100)  ;
        let totalDiscount = 0.0 ;
        totalDiscount += (total * Math.floor(this.fractionalDiscount*100)/100) ;
        totalDiscount += Math.floor(this.couponDiscount * 100)  ;
        this.discountAmount = Math.floor(totalDiscount) /100 ;
    }  
    ApplyProduct( product )
    {
        this.ApplyTotal( product.offeringPrice) ;
    }
}

class ProductDiscountList
{
    constructor( id, name )
    {
        this.id = id ;
        this.name = name ;
        this.count = 0 ;
        this.DiscountMap = new Map() ;
    }
    getId() { return this.id ; }
    getName() { return this.name ; }
    addDiscount( item )
    {
        this.count++ ;
        item.id =  this.count  ;
        this.DiscountMap.set( this.count, item ) ;        
        return this.DiscountMap.get( this.count ) ;
    }
    addDiscountByName( name )
    {
        this.count++ ;
        let newDiscount = new Discount( this.count, name ) ;
        
        this.DiscountMap.set( this.count, newDiscount ) ; 
        return this.DiscountMap.get( this.count ) ;
    }
    
    listDiscounts()
    {
        document.write("=== DISCOUNTS ===<br>")
        this.DiscountMap.forEach( (discount) =>{ this.display( discount ) ;  })        

    }
    getList()
    {
        let str = "" ;
        str += "=== DISCOUNTS ===\n" ;
        this.VendorMap.forEach( (v) =>{ str += this.getDisplayString( v ) ;  })  ;
        return str ;      
    }
    testFunction( selectedRowElement )
    {
        
        /* 
        let ndxElement = event.target.parentElement.firstElementChild ;
        while ( ndxElement != null )
        {
            ndxElement.classList.remove("selected-row" );
            ndxElement = ndxElement.nextElementSibling ;
        } */
        //ListDiscounts() ;
        //event.target.parentElement.class =  "selected-row" ;
        //selectedRowElement.class = "selected-row" ;
        
        let str = event.target.getAttribute("data-v")  ;
        
        let vRow = Discounts.getMap().get(  eval(str) ) ;
        let p = document.getElementById("id_selected_discount" ) ;
        p.textContent = vRow.name + " - " + vRow.getDescription() ;
        
        SelectedDiscount = vRow ;
        
    }
    writeListToElement( targetElement, vendorId, productId, teamId )
    {
        targetElement.innerText = "" ;
        //let s = new Element() ;
        this.DiscountMap.forEach( 
            ( discount )=>  
            {
                console.log( discount, vendorId, productId, teamId ) ;
                if(
                    (   discount.getTeamId() == undefined || 
                            discount.getTeamId() == 0 || 
                            discount.getTeamId() == teamId  ) &&
                    (   discount.getVendorId() == undefined || 
                            discount.getVendorId() == 0 ||
                            discount.getVendorId() == vendorId ) &&
                    (   discount.getProductId() == undefined || 
                            discount.getProductId() == 0 ||
                            discount.getProductId() == productId ))
                {
        
                    let s = document.createElement( "span" ) ;
                    s.className = "iRow" ;
                    let s1 = document.createElement( "span" ) ;
                    let s2 = document.createElement( "span" ) ;
                    s1.innerText = discount.id ;
                    s2.innerText = discount.name ;

                    s.addEventListener("click",
                    ()=>
                    {
                        s.setAttribute("data-v", discount.id ) ;
                        s1.setAttribute("data-v", discount.id ) ;
                        s2.setAttribute("data-v", discount.id ) ;
                        
                        this.testFunction( s ) ;
                    })

                    s1.id = "discounts-id" ;
                    s2.id = "discounts-name" ;
                    
                    s.append( s1 ) ;
                    s.append( s2 ) ;

                    if ( discount.id == SelectedDiscount.getId() )
                    s.classList.add( "selected-row" );
     
                    targetElement.appendChild( s ) ;             
                }
            }
        ) ;
    }
  
    setMap( map ) { this.DiscountMap = map  ; this.count = map.size ;  }
    getMap() { return this.DiscountMap ; }

    display( item ) 
    { 
        document.write( item.id + " " + 
                        item.name + " " +
                        item.description + "<br>"  ) ;
    }
    getDisplayString( item ) 
    { 
        let str = "" ;
        str +=  item.id + " " + item.name + 
                item.description + "\n"   ;
        return str ;
    }
}