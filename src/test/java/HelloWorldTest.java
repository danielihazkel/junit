import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ExtensionExample.class)

public class HelloWorldTest {

    public HelloWorldTest(){
        System.out.println("constractor");
    }


    @BeforeAll
    public static void cleanAll(){
        System.out.println("before All");
    }

    @AfterAll
    public static void cleanAllAfter(){
        System.out.println("before All");
    }

    @BeforeEach
    public void clean(){
        System.out.println("before");
    }
    @AfterEach
    public void cleanAfter(){
        System.out.println("before");
    }
    @Test
    @EnabledOnOs(OS.WINDOWS)
//    @Order(0)
    public void test1(){
        System.out.println("hello");
        Assertions.assertTrue(true,"test success");
    }
}
