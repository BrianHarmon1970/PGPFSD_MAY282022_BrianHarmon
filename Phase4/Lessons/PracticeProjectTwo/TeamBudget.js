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
