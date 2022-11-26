class BudgetPlannerApp
{
  constructor()
  {

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
/* 
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
    *//*let db = window.indexedDB.open( "TeamList" ) ;
    db.onsuccess = (event) => {
        //note.innerHTML += '<li>Database initialized.</li>';
      
        alert("Open DB: Success") ;
        // store the result of opening the database in the db variable.
        // This is used a lot below
        db = DBOpenRequest.result;
      
        let transaction = db.transaction(["TeamList"], "readwrite") ;
        db.transaction.objectStore().put(Teams, "TeamList" ) ;
      };
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
/*}
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
