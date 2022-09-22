import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;


@DisplayName( "ParentClass Test")
@RunWith(JUnitPlatform.class)
public class ParentClassTest
{
    @Nested
    class A
    {
        @BeforeEach
        void beforeEach() { System.out.println( "beforeEach class A") ; }
        @AfterEach
        void afterEach() { System.out.println( "afterEach class A") ; }



    }
    @Test
    @DisplayName( "Example Test for method A")
    @RepeatedTest( 5 )
    void TestForA() { System.out.println( "Example Test for method A") ; }
    @Nested
    class B
    {
        @BeforeEach
        void beforeEach() { System.out.println( "beforeEach class B") ; }
        @AfterEach
        void afterEach() { System.out.println( "afterEach class B") ; }


        @Test
        @DisplayName( "Example Test for method B")
        void TestForB() { System.out.println( "Example Test for method B") ; }


    }
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void RunOnWindows() { System.out.println("Run on windows") ; }
    @Test
    @EnabledOnOs(OS.LINUX)
    void RunOnLinux() { System.out.println("Run on Linux") ; }

    @Test
    @EnabledIfEnvironmentVariable(named = "JRE_HOME", matches = "e:/Program Files/Java/jdk-18.0.2" )
    void RunMyJKD()
    {
        System.out.println( "MyJDK env 18.0.2") ;
    }

}
