
let TeamBudgetItems = new TeamBudget() ;
let Offerings = new VendorOfferingList() ;
let Vendors = new VendorList() ;
let Discounts = new ProductDiscountList() ;
//let CreatedTeams = new TeamList() ;
let Teams = new TeamList() ;

let SelectedBudgetItem = new TeamBudgetItem() ;
let SelectedVendor = new Vendor() ;
let Expenses = new ExpenseItemList() ;
let SelectedTeam = new Team() ;
let SelectedProduct = new VendorOffering() ;
let SelectedDiscount = new ProductDiscount() ;
let SelectedExpenseItem = new ExpenseItem( 0, new Team(), new Vendor(), "", new Date()) ;
let SelectedStatus = 'pending' ;
let NullDiscount = new ProductDiscount() ;
let NullVendor = new Vendor() ;
let NullProduct = new VendorOffering() ;

function setSelectedExpenseItemStatus( status )
{
    SelectedExpenseItem.setStatus( status ) ;
}
function updateSelectedTeam( team )
{
    //SelectedVendor = NullVendor ;
    //document.getElementById( "id_selected_vendor").textContent = "[vendor]" ;
    updateSelectedVendor( NullVendor ) ;
    document.getElementById( "id_selected_vendor").textContent = "[vendor]" ;

    SelectedTeam = team ;

    let p = document.getElementById("id_selected_team" ) ;
    p.textContent = team.getName() ;
    
    ListTeams() ;
    ListDiscounts() ;
    
}
function updateSelectedVendor( vendor ) 
{
    //SelectedProduct = NullProduct ;
    //document.getElementById( "id_selected_product").textContent = "[product]" ;
    updateSelectedProduct( NullProduct ) ;
    document.getElementById( "id_selected_product").textContent = "[product]" ;

    SelectedVendor = vendor ; 
        
        ListVendors() ;
        ListVendorProducts() ;
        ListDiscounts() ;
    
}
function updateSelectedProduct( product ) 
{
    SelectedDiscount = NullDiscount ;
    document.getElementById( "id_selected_discount").textContent = "[discount]" ;

    SelectedProduct = product ; 

    let p = document.getElementById("id_selected_product" ) ;
    p.textContent = product.description ;
    
    ListVendorProducts() ;
    ListDiscounts() ;
}
function updateSelectedExpenseItem( expenseItem, status ) 
{
/*
    let p = document.getElementById("id_selected_expenseitem" ) ;
    p.textContent = "" ;
    let s1l = document.createElement( "span" );
    s1l.textContent = "ID:" ; p.append( s1l) ;
    let s1v = document.createElement( "span" );
    s1v.textContent = expenseItem.getId() ; p.append( s1v ) ;

    let s2l = document.createElement( "span" );
    let s2v = document.createElement( "span" );
    s2l.textContent="TEAM ID:" ; s2v.textContent = expenseItem.getTeamId() ;
    p.append( s2l ) ; p.append( s2v ) ;
*/


    let element = document.getElementById("selected_expenseitem_id" ) ;
    element.textContent = expenseItem.getId() ;
    element = document.getElementById("selected_expenseitem_teamid" ) ;
    element.textContent = expenseItem.getTeamId() ;
    element = document.getElementById("selected_expenseitem_quantity" ) ;
    element.textContent = expenseItem.getUnitCount() ;
    element = document.getElementById("selected_expenseitem_description" ) ;
    element.textContent = expenseItem.getDescription() ;
    element = document.getElementById("selected_expenseitem_totalprice" ) ;
    element.textContent = expenseItem.getTotalPrice() ;
    element = document.getElementById("selected_expenseitem_discountprice" ) ;
    element.textContent = expenseItem.getDiscountAmount();
    element = document.getElementById("selected_expenseitem_netprice" ) ;
    element.textContent = expenseItem.getTotalExpense() ;
    //p.textContent = expenseItem.getId() + " " +
    //                expenseItem.getTeamId() + " " +
    //                expenseItem.getVendorId() +  " - " + expenseItem.getDescription() ;
       
    SelectedExpenseItem = expenseItem ;
    ListExpensesByStatus(status) ; 
    ListExpensesByStatus( SelectedStatus ) ;
}

function InitializeData()
{
    
    Teams.addTeamByName("Heroes") ;
    Teams.addTeamByName( "ATeam" ) ;
    Teams.addTeamByName( "BTeam" ) ;
    let killerTeam = Teams.addTeamByName( "Villains" ) ;
    
    let butcherSupply = Vendors.addVendorByName( "ButcherSupply" ) ;
    
    //let vendor = new Vendor( 0, "Vendor M") ;
    let vendor = new Vendor( 0, "Vendor M (The Tax Man's Shop)") ;
    let product = new VendorOffering() ;
    
    product.baseBuilder(  1, "Basic PitchFork" ) ;
    product.simpleProductBuilder( 19.99 ) ; 
    Offerings.addOffering( product ) ;

    product = new VendorOffering() ;
    product.baseBuilder( 1, "Double Bubble 1000 count box" ) ;
    product.multiUnitProductBuilder( 0.02, 1000 ) ;
    Offerings.addOffering( product ) ;
    Vendors.addVendor( vendor ) ;

    vendor = new Vendor( 0, "Vendor N") ;
   
    product = new VendorOffering() ;
    product.baseBuilder( 2, "Taxman's Insurance Policy (1 Month)" ) ;
    product.monthlySubscriptionBuilder( 66.66, 1 ) ;
    Offerings.addOffering( product ) ;

    product = new VendorOffering() ;
    product.baseBuilder( 2, "Taxman's Insurance Policy (6 Months)" ) ;
    product.monthlySubscriptionBuilder( 33.33, 6 ) ;
    Offerings.addOffering( product ) ;

    product = new VendorOffering() ;
    product.baseBuilder( 2, "Taxman's Insurance Policy (1 Year)" ) ;
    product.yearlySubscriptionBuilder( 99.99, 1 ) ;
    Offerings.addOffering( product ) ;
    Vendors.addVendor( vendor ) ;

    Vendors.addVendorByName( "Vendor O" ) ;
    
    let discount = new ProductDiscount() ;
    //discount.setVendorId( 1 ) ;
    //discount.setProductId( 1 ) ;
    discount.setName( "TEST_DISCOUNT_GENERAL_50%" ) ;
    discount.setDescription( "First ever instance of ProductDiscount" ) ;
    discount.setFractionalDiscount( 0.50 ) ;
    discount.setCouponDiscount( 0.00 ) ;
    Discounts.addDiscount( discount ) ;

    discount = new ProductDiscount() ;
    //discount.setVendorId( 1 ) ;
    //discount.setProductId( 2 ) ;
    discount.setName( "TEST_DISCOUNT_TWO_GENERAL_5.00" ) ;
    discount.setDescription( "Second instance of ProductDiscount" ) ;
    discount.setFractionalDiscount( 0.0 ) ;
    discount.setCouponDiscount( 5.00 ) ;
    Discounts.addDiscount( discount ) ;


    discount = new ProductDiscount() ;
    discount.setVendorId( 2 ) ;
    //discount.setProductId(  ) ;
    discount.setName( "Vendor M - 10% OFF ANY" ) ;
    discount.setDescription( "10% OFF ANY PRODUCT" ) ;
    discount.setFractionalDiscount( 0.10 ) ;
    discount.setCouponDiscount( 0.00 ) ;
    Discounts.addDiscount( discount ) ;

    discount = new ProductDiscount() ;
    discount.setVendorId( 2 ) ;
    discount.setProductId( 5 ) ;
    discount.setTeamId( 1 ) ;
    discount.setName( "Vendor M - $45.00 off 1 Year" ) ;
    discount.setDescription( "Hero Special" ) ;
    discount.setFractionalDiscount( 0.0 ) ;
    discount.setCouponDiscount( 45.00 ) ;
    Discounts.addDiscount( discount ) ;

    discount = new ProductDiscount() ;
    discount.setVendorId( 1 ) ;
    discount.setProductId( 1 ) ;
    discount.setName( "PITCHFORK_SPECIAL_25%" ) ;
    discount.setDescription( "25% off any pitchfork" ) ;
    discount.setFractionalDiscount( 0.25 ) ;
    discount.setCouponDiscount( 0.00 ) ;
    Discounts.addDiscount( discount ) ;

    discount = new ProductDiscount() ;
    discount.setVendorId( 1 ) ;
    discount.setProductId( 2 ) ;
    discount.setName( "DOUBLEBUBBLE_4.00_DISCOUNT" ) ;
    discount.setDescription( "double bubble slashed by $4.00" ) ;
    discount.setFractionalDiscount( 0.00 ) ;
    discount.setCouponDiscount( 4.00 ) ;
    Discounts.addDiscount( discount ) ;


    Teams.addTeamByName( "TeamC" ) ;
    Teams.addTeamByName( "TeamD" ) ;

    Teams.getMap().forEach((team)=>{ TeamBudgetItems.addTeam( team) ; }) ;
    TeamBudgetItems.getMap().get(1).setItemBudget( 123 ) ;
    TeamBudgetItems.getMap().get(2).setItemBudget( 234 ) ;
    TeamBudgetItems.getMap().get(3).setItemBudget( 345 ) ;
    TeamBudgetItems.getMap().get(4).setItemBudget( 456 ) ;
    TeamBudgetItems.getMap().get(5).setItemBudget( 567 ) ;
    TeamBudgetItems.getMap().get(6).setItemBudget( 678 ) ;

    let newReq = new ExpenseItem( 0, killerTeam, butcherSupply ) ;

    //discount.ApplyProduct( product ) ;

    newReq.applyTeam( killerTeam ) ;
    newReq.setUnitCount( 10 ) ;
    newReq.applyProduct( Offerings.getProductById(1) ) ;
    newReq.applyDiscount( discount ) ;
    Expenses.addItem( newReq ) ;

    newReq = new ExpenseItem( 0, Teams.getMap().get(1), butcherSupply ) ;
    newReq.applyTeam( Teams.getMap().get(1) ) ;
    newReq.setUnitCount( 10 ) ;
    newReq.applyProduct( Offerings.getProductById(2) ) ;
    newReq.applyDiscount( discount ) ;
    Expenses.addItem( newReq ) ;

    let vendorM = Vendors.getMap().get(2) ;
    newReq = new ExpenseItem( 0, Teams.getMap().get(2), vendorM  ) ;
    newReq.applyTeam( Teams.getMap().get(2) ) ;
    newReq.setUnitCount( 10 ) ;
    newReq.applyProduct( Offerings.getProductById(5) ) ;
    newReq.applyDiscount( discount ) ;
    Expenses.addItem( newReq ) ;

    newReq = new ExpenseItem( 0, Teams.getMap().get(3), vendorM  ) ;
    newReq.applyTeam( Teams.getMap().get(3)  ) ;
    newReq.setUnitCount( 100 ) ;
    newReq.applyProduct( Offerings.getProductById(1) ) ;
    newReq.applyDiscount( discount ) ;
    Expenses.addItem( newReq ) ;

    newReq = new ExpenseItem( 0, Teams.getMap().get(4), vendorM ) ;
    newReq.applyTeam( Teams.getMap().get(4) ) ;
    newReq.setUnitCount( 10 ) ;
    newReq.applyProduct( Offerings.getProductById(4) ) ;
    newReq.applyDiscount( discount ) ;
    Expenses.addItem( newReq ) ;

    newReq = new ExpenseItem( 0, Teams.getMap().get(5), vendorM ) ;
    newReq.applyTeam( Teams.getMap().get(5) ) ;
    newReq.setUnitCount( 10 ) ;
    newReq.applyProduct( Offerings.getProductById(4) ) ;
    newReq.applyDiscount( discount ) ;
    Expenses.addItem( newReq ) ;


    newReq = new ExpenseItem( 0, Teams.getMap().get(6), vendorM  ) ;
    newReq.applyTeam( Teams.getMap().get(6) ) ;
    newReq.setUnitCount( 10 ) ;
    newReq.applyProduct( Offerings.getProductById(3) ) ;
    newReq.applyDiscount( discount ) ;
    Expenses.addItem( newReq ) ;

}