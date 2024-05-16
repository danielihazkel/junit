import org.junit.jupiter.api.extension.*;

import java.util.Random;


public class ExtensionExample implements
        BeforeAllCallback, BeforeEachCallback, AfterAllCallback,
        AfterEachCallback, BeforeTestExecutionCallback,
        AfterTestExecutionCallback,ExtensionContext.Store.CloseableResource {

    private static boolean didRun = false;

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        if (!didRun){
            didRun = true;
            extensionContext.getRoot().getStore(ExtensionContext.Namespace.GLOBAL).put("somename",this);
            System.out.println("Run only Once in Suite");

        }
            System.out.println("extension Before All Test Callback");
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        System.out.println("extension After All Test Callback");
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        extensionContext.getExecutionException().ifPresent(
                (a) -> System.out.println("test failed: " + a.getMessage()));
        System.out.println("extension After EACH Test Callback");
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("extension After EACH Test Callback");
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        System.out.println("extension before Test execution Callback");
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        System.out.println("extension after Test execution Callback");
    }


//    public static class Ex implements ExtensionContext.Store.CloseableResource{
        @Override
        public void close(){
            System.out.println("Run only once at the end");
        }
//    }

}
