class BudgetPlannerApp
{
  constructor()
  {
    //this.dataModel = new BudgetPlannerDataModel()
  }
  InitializeApplication()
  {
    InitializeData() ;        
    ListDiscounts() ;
    this.UpdateCharts() ;
    
    this.ListTeams() ;
  }
  UpdateCharts()
  {
    SummarizeExpenses( document.getElementById('expense-summary'));
    ListBudgetSummary( document.getElementById('budget-summary')) ;
    chartExpenseBudget('expenseVsBudgetChart');
  }
  ListTeams()
  {
    ListTeams() ;
  }
  ListVendors()
  {
    ListVendors() ;
  }
  ListExpensesByStatus( status )
  {
    ListExpensesByStatus( status ) ;
  }
  ListBudgetItems( domElement )
  {
    ListBudgetItems( domElement ) ;
  }
  PendingTabSelected()
  {
    this.ListExpensesByStatus('pending'); SelectedStatus='pending' ;
    this.showSelectedExpenseItem( true ) ;
    this.showSelectedBudgetItem( false ) ;

  }
  ApprovedTabSelected()
  {
    this.ListExpensesByStatus('approved'); SelectedStatus='approved' ;
    this.showSelectedExpenseItem( true ) ;
    this.showSelectedBudgetItem( false ) ;

  }
  RejectedTabSelected()
  {
    this.ListExpensesByStatus('rejected'); SelectedStatus='rejected' ;
    this.showSelectedExpenseItem( true ) ;
    this.showSelectedBudgetItem( false ) ;
  }
  BudgetTabSelected()
  {
    this.ListBudgetItems(document.getElementById('expense-list')); SelectedStatus='' ;
    this.showSelectedBudgetItem( true ) ;
    this.showSelectedExpenseItem( false ) ;

  }
  showSelectedBudgetItem( show )
  {
    let element = document.getElementById("selected_budgetitemx") ;
    ( show ? element.classList.remove("noshow") : element.classList.add("noshow")) ;
    ( show ? element.classList.add("dialog") : element.classList.remove("dialog")) ;
  }
  showSelectedExpenseItem( show )
  {
    let element = document.getElementById("selected_expenseitem") ;
    ( show ? element.classList.remove("noshow") : element.classList.add("noshow")) ;
    ( show ? element.classList.add("dialog") : element.classList.remove("dialog")) ;
  }
  updateSelectedBudgetItem()
  {
    updateSelectedBudgetItem() ;
    this.ListBudgetItems(document.getElementById('expense-list'))
    ListBudgetSummary( document.getElementById('budget-summary')) ;
    this.UpdateCharts() ;
  }
  updateSelectedExpenseItemStatus( status ) 
  {
    setSelectedExpenseItemStatus( status ) ;
    ListExpensesByStatus( SelectedStatus ) ;
  }
  HomeClicked() 
  {
    this.UpdateCharts() ;
  }
  TeamsClicked() 
  {
    this.ListExpensesByStatus('pending') ;
    ListTeamPurchaseRequests() ;

  }
  FinanceClicked()
  {
    this.ListExpensesByStatus( SelectedStatus ) ;
  }
  ProjectClicked() 
  {

  }
}
        
class TeamSumElement 
{
    constructor(name, value)
    { 
        this.name = name; 
        this.value = value;
    }
}
