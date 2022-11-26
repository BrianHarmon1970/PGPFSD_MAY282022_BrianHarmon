    let TeamSum = [{name: "", value: 0 }]  ; //= SummarizeExpenses();
    let budgetArray = [{name: "", value: 0}] ;
    
    function ListBudgetSummary( pageElement )
    {
        pageElement.textContent = "" ;
        let h = document.createElement( "h6" ) ;
        h.textContent = "Budget" ;
        pageElement.appendChild( h ) ;
        pageElement.appendChild( document.createElement("br")) ;
        let Total = 0 ;
        TeamBudgetItems.getMap().forEach((item)=>
        {
            let br = document.createElement( "br" ) ;
            let s = document.createElement( "span" ) ;
            s.textContent = item.getDescription() + ": " + item.getItemBudget() ;
            s.append( br ) ;
            pageElement.appendChild( s ) ;
            Total += item.getItemBudget() ;
        }) ;
        let br = document.createElement( "br" ) ;
        let s = document.createElement( "span" ) ;
        s.textContent = "Total" + ": " + Total ;
        s.append( br ) ;
        pageElement.appendChild( s ) ;
    
        
        budgetArray = TeamBudgetItems.getItemArray() ;
        console.log( budgetArray ) ;
        chart( "budgetItemChart", budgetArray, "name", ["value"], ['value'] ) ;
    }
    function SummarizeExpenses( div ) 
    {
        //let sum = Expenses.Summarize() ;
        //let div = document.getElementById( "expense-summary" ) 
        
        div.innerHTML = "" ;
        let h = document.createElement( "h6" ) ;
        h.textContent = "Expense" ;
        
        div.appendChild( h ) ;
        div.appendChild( document.createElement("br")) ;

        //let br = document.createElement( "br" ) ; 

        let i = 0 ;
        Teams.getMap().forEach( ( team ) =>
        {
            //++i ;
            //let tsum = Expenses.SummarizeTeamId( team.id, "approved" ) ;
            let tsum = Expenses.SummarizeTeamId( team.id ) ;
            let name = team.name ;
            TeamSum[ i ] = { name: team.name, value: tsum}  ;
            let br = document.createElement( "br" ) ; 
            let s = document.createElement( "span" ) ; 
            s.textContent = team.name + ": " +  tsum + " "  ;
            s.append( br ) ;
            div.appendChild( s ) ;
            ++i ;
        }) ;
        s = document.createElement( "span" ) ; 
        s.textContent = " Total: " + Expenses.Summarize()  ;
        //TeamSum[ 0 ] = { name: 'Total', value: Expenses.Summarize() } ;
        //TeamSum[ 0 ] = { name: 'Total', value: 0.00 } ;
        div.appendChild( s ) ;

        //console.log( TeamSum ) ;
        //i = 0  ;
        //TeamSum.forEach( (entry)=> { data[i++] =  entry  ;}) ;
        //console.log( "data", data ) ;
        chart( "expenseBudgetChart", TeamSum, "name", ["value"],['expense'] ) ;

        //return TeamSum ;
    }
    function ListBudgetItems( div )
    {
        //let div = document.getElementById("teams-list") ;
        TeamBudgetItems.writeItemsToElement( div ) ;

    }
    let expenseBudgetData = [{name:"",expense:0,budget:0}] ;
    function chartExpenseBudget( pageElementID ) 
    {
        
        let data = [] ;
        
        //budgetArray = TeamBudgetItems.getItemArray() ;
        //console.log( 'budgetArray', budgetArray ) ;
        console.log( 'DATA1', data ) ;
     /*    for ( let i = 0 ; i < budgetArray.length ; ++i )
        {
            data[i] = {name: TeamSum[i].name, 
                expense: TeamSum[i].value,
                budget: budgetArray[i].value} ;
                console.log( TeamSum[i].name) ;
            console.log( "budget:", budgetArray[i].value)  ;
            
        } */
        data = buildExpenseBudgetArray( data ) ;
        console.log( 'DATA2', data ) ;
        
        chart( pageElementID, data, "name" , [ "budget","expense"],["budget","expense"]) ;
    }
    function buildExpenseBudgetArray(data2)
    {
        //console.log( 'expbudget1', data2 ) ;
        budgetArray = TeamBudgetItems.getItemArray() ;
        console.log( 'TeamSum', TeamSum ) ;
        console.log( 'budgetArray', budgetArray ) ;
        for ( let i = 0 ; i < budgetArray.length ; ++i )
        {
            data2[i] = {name: TeamSum[i].name, 
                expense: TeamSum[i].value,
                budget: budgetArray[i].value} ;
            
        }
        console.log( 'expbudget2', data2 ) ;
        return data2 ;
    }
    function chart( pageElementID, data, keyname, [valuenames], [labelnames ] )
    {
        el = document.getElementById(pageElementID).textContent = "" ;
        let d = 
            {element: pageElementID, 
                data: data, 
                xkey: keyname, 
                ykeys: [valuenames], 
                labels: [labelnames] } ;
        new Morris.Bar( d ) ;
        }

    function ListTeams()
    {
        let div = document.getElementById("teams-list") ;
        Teams.writeTeamsToElement( div ) ;
    }
    function ListExpensesByStatus( status )
    {
        let div = document.getElementById("expense-list") ;
        //div.innerText = Expenses.getList() ;    
        switch( status )
        {
            case 'pending':
            Expenses.writeListToElement( div, "pending" ) ;
            break ;
            case 'approved':
                Expenses.writeListToElement( div, "approved" ) ;
                break ;
            case 'rejected':
                Expenses.writeListToElement( div , 'rejected') ;
                break ;
        }
    }
    function ListOfferings()
    {
        let div = document.getElementById("teams-list") ;
        Offerings.writeListToElement( div ) ;
    }
    function ListVendors()
    {
        let div = document.getElementById("teams-list") ;
        Vendors.writeListToElement( div ) ;
    }
    function ListVendorProducts()
    {
        let div = document.getElementById("product-list") ;
        Offerings.writeListToElement( div ) ;
    }
    function ListDiscounts()
    {
        let div = document.getElementById("product-discount-list") ;
        Discounts.writeListToElement( div, 
            SelectedVendor.getId() ,
            SelectedProduct.getId() , 
            SelectedTeam.getId() ) ;
        }
    function ListTeamPurchaseRequests( teamId )
    {
        let div = document.getElementById("team-request-list") ;
        //div.innerText = Expenses.getList() ;    
        Expenses.writeListToElement( div, "pending", teamId ) ;
    }



    function SubmitPurchaseRequest( team, vendor, product, discount ) 
    {
        let newReq = new ExpenseItem( 0, team, vendor, product.description, new Date()) ;
        
        discount.ApplyProduct( product ) ;

        newReq.applyTeam( team ) ;
        newReq.setUnitCount( 10 ) ;
        newReq.applyProduct( product ) ;
        newReq.applyDiscount( discount ) ;
        console.log( newReq ) ;
        Expenses.addItem( newReq ) ;

    }
    
    function updateSelectedBudgetItem()
    {
        let input = document.getElementById("id_selected_budgetitem_input")
        SelectedBudgetItem.setItemBudget( eval(input.value) ) ;
    }