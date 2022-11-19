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
function setSelectedExpenseItemStatus( status )
{
    SelectedExpenseItem.setStatus( status ) ;
}