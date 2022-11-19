class employee
{
	private String name ;
	private String number ;
	employee( String name, String number ) 
	{
		this.name = name ;
		this.number = number ;
	}
	void Welcome()
	{ 
		System.out.println( "Welcome... " ) ;
		System.out.println( "Employee name:\t" + name ) ;
		System.out.println( "Employee number:\t" + number ) ;
	}

}
