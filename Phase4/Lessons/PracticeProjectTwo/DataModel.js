let TeamBudgetItems = new TeamBudget() ;
let Offerings = new VendorOfferingList() ;
let Vendors = new VendorList() ;
let Discounts = new ProductDiscountList() ;
let CreatedTeams = new TeamList() ;  
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
    let p = document.getElementById("id_selected_expenseitem" ) ;
    p.textContent = expenseItem.getId() + " " +
                    expenseItem.getTeamId() + " " +
                    expenseItem.getVendorId() +  " - " + expenseItem.getDescription() ;
       
    SelectedExpenseItem = expenseItem ;
    ListExpensesByStatus(status) ; 
    ListExpensesByStatus( SelectedStatus ) ;
}

function InitializeData()
{
    
    Teams.addTeamByName("Team1") ; 
    Teams.addTeamByName( "ATeam" ) ;
    Teams.addTeamByName( "BTeam" ) ;
    killerTeam = Teams.addTeamByName( "Killers" ) ;
    
    butcherSupply = Vendors.addVendorByName( "ButcherSupply" ) ;
    
    let vendor = new Vendor( 0, "Vendor M") ;
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
    discount.setVendorId( 1 ) ;
    discount.setProductId( 1 ) ;
    discount.setName( "TEST_DISCOUNT" ) ;
    discount.setDescription( "First ever instance of ProductDiscount" ) ;
    discount.setFractionalDiscount( 0.50 ) ;
    discount.setCouponDiscount( 0.00 ) ;
    Discounts.addDiscount( discount ) ;

    discount = new ProductDiscount() ;
    discount.setVendorId( 1 ) ;
    discount.setProductId( 2 ) ;
    discount.setName( "TEST_DISCOUNT_TWO" ) ;
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

    Teams.addTeamByName( "TeamC" ) ;
    Teams.addTeamByName( "TeamD" ) ;

    Teams.getMap().forEach((team)=>{ TeamBudgetItems.addTeam( team) ; }) ;
    TeamBudgetItems.getMap().get(1).setItemBudget( 123 ) ;
    TeamBudgetItems.getMap().get(2).setItemBudget( 234 ) ;
    TeamBudgetItems.getMap().get(3).setItemBudget( 345 ) ;
    TeamBudgetItems.getMap().get(4).setItemBudget( 456 ) ;
    TeamBudgetItems.getMap().get(5).setItemBudget( 567 ) ;
    TeamBudgetItems.getMap().get(6).setItemBudget( 678 ) ;
}