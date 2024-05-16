import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.stream.Stream;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith({ExtensionExample.class,ResolverExtension.class})
public class SecondClassTest {

    public static Stream<Integer> numberProvider() {
        return Stream.of(1,2,3);
    }

    @Test
    @EnabledIf("customCondition")
    public void test1(){
        System.out.println("In test 1 second class");
        Assertions.assertTrue(true);
    }

//    @ParameterizedTest
//    @ValueSource(ints = {1,2,3})
//    public void test2(int param){
//        System.out.println("In test2 second class "+param);
//        Assertions.assertTrue(true);
//    }
//    @ParameterizedTest
//    @MethodSource("numberProvider")
//    public void test3(int param){
//        System.out.println("In test3 second class "+param);
//        Assertions.assertTrue(true);
//    }

    @Test
    public void test4(int param){
        System.out.println("In test4 second class "+param);
        Assertions.assertTrue(true);
    }

    @Test
    public void test5(int param){
        System.out.println("In test5 second class "+param);
        Assumptions.assumeTrue(true);
//        Assertions.assertTrue(true);
    }

    boolean customCondition(){
        return false;
    }
    
}
