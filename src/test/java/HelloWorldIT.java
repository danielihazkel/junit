import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloWorldIT {

    @Test
    public void test1(){
        System.out.println("hello");
        Assertions.assertTrue(true,"test failed");
    }
}
