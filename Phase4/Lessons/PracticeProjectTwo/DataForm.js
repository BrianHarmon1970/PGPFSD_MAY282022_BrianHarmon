class DataElement
{
    constructor( id , name, description )
    {
        this.id = id ;
        this.name = name ;
        this.description = description ;
    }
    getId() { return this.id ; }
    getName() { return this.name ; }
    getDescription( ) { return this.description } ;
    setId( id ) { this.id = id ; }
    setName( name ) { this.name = name ; }
    setDescription( description ) { this.description = description; }

} 

class DataElementList
{
    constructor( RowDescriptor )
    {
        this.count = 0 ;
        this.ElementMap = new Map() ;
        this.RowDescriptor = RowDescriptor ;
    }
    addElement( dataElement )
    {
        this.count++ ;
        dataElement.id = this.count ;
        this.ElementMap.set( this.count, dataElement ) ;
        return this.ElementMap.get( this.count ) ;
    }
    setMap( map ) { this.ElementMap = map  ; count = map.size ;  }
    getMap() { return this.ElementMap ; }
}
