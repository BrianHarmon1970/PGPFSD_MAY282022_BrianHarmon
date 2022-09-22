import org.junit.After;
import org.junit.jupiter.api.*;

public class ParentClass

{
    public int factorial( int n )  { return 120 ; }
    public int Sum( int n )
    {

    }

    @BeforeAll
    public static void beforeAll() { System.out.println("Before All") ; }
    @Test
    @BeforeEach
    public void beforeEach() { System.out.println("Before Each") ; }

    @Test
    AssertEqual( factorial(5), 120 ) ;
    @Test
    AssertEqual( Sum( 20 ), 210 )

    @Test
    @AfterEach
    public void afterEach() { System.out.println("After Each") ; }

    @AfterAll
    public static void afterAll() { System.out.println("After All") ; }


}
