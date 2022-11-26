class RowType
{
    constructor( [columnNames])
    {
        this.columnNames = columnNames ;
        this.columnCount =  columnNames.size ;
        this.columnValues = Array[this.columnCount] ;
    }
}
class TeamRowType extends RowType
{
    constructor()
    {
        super([ 'id','name'] ) ;

    }
    getId() { return this.id ; }
    getName() { return this.name ; }
    
    setId( id ) { this.id = id ; }
    setName( name ) { this.name = name ; }
    
}


class Team extends DataElement
{
    constructor( id, name ) 
    {
        super( id, name, "" ) ;
        
    }
    getId() { return this.id ; }
    getName() { return this.name ; }
}
class TeamList extends DataElementList
{
    constructor() 
    {
        super( new TeamRowType()) ;
        super.count=0 ;
    }
    addTeam( team )
    {
        return super.addElement( team ) ;
    }
    addTeamByName( name )
    {
        //++super.count ;
        let newTeam = new Team( NaN, name ) ;
        //this.TeamMap.set( this.count, newTeam ) ; 
        //return this.TeamMap.get( this.count ) ;
        return this.addTeam( newTeam ) ;
    }
    /* listTeams()
    {
        document.write("=== TEAMS ===<br>")
        this.TeamMap.forEach( (team, id )=>{ document.writeln( id + " " + team.id + " "+ team.name+"<br>") ;  })        
    } */
    testFunction( targetElement )
    {
        let str = event.target.getAttribute("data-v")  ;
        
        //let vRow = Teams.getMap().get(  eval(str) ) ;
        let vRow = this.getMap().get( eval(str) ) ;
        let p = document.getElementById("id_selected_team" ) ;
        p.textContent = vRow.name ; 
        updateSelectedTeam( vRow ) ;
    }
    writeTeamsToElement( targetElement )
    {
        targetElement.innerText = "" ;
            super.getMap().forEach(
            (team)=> 
            {
                  let s = document.createElement( "span" ) ;
                  let s1 = document.createElement( "span" ) ;
                  let s2 = document.createElement( "span" ) ;
                  s.className="iRow" ;
                  s1.innerText = team.id ;
                  s2.innerText = team.name ;
                  
                  s.addEventListener("click",
                  //targetElement.addEventListener("click",
                    ()=>{ 
                        s.setAttribute("data-v", team.id ) ;
                        s1.setAttribute("data-v", team.id ) ;
                        s2.setAttribute("data-v", team.id ) ;
                        
                        this.testFunction( targetElement ) ;
                        
                    },false ) ;
                
                  s1.class = "rowElement" ;
                  s2.class = "rowElement" ;

                  s1.id = "teams-id";
                  s2.id = "teams-name" ;
                  s.append( s1 ) ;
                  s.append( s2 ) ;

                if ( team.id == SelectedTeam.getId() )
                    s.classList.add( "selected-row" );
                targetElement.appendChild( s ) ;             
            } 
        ) ;
    }
    /* getTeamList() 
    {
        let str = "=== TEAMS ===\n" ;
        this.TeamMap.forEach( (team, id )=>{ str+=( id + " " + team.id + " "+ team.name+"\n") ;  }) ; 
        return str ;
    } */
    //setMap( map ) { this.TeamMap = map  ; this.count = map.size ;  }
    //setMap( map ) { super.ElementMap = map  ; super.count = map.size ;  }
    //getMap() { return this.TeamMap ; }
    //getMap() { return super.ElementMap ; }
}