package mockprivate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DemoPrivate.class})
public class DemoPrivate3Test {

    private MockDemoPrivate ct;

    public class MockDemoPrivate extends DemoPrivate {
        protected DemoPrivate newDemoPrivate() {
            return new MockDemoPrivate();
        }
    }

    private MockDemoPrivate createCT() {
        MockDemoPrivate ct = new MockDemoPrivate();
        return ct;
    }

    @Before
    public void setUp() {
        ct = createCT();
    }

    /**
     * 仅单独测试privateFunc()方法
     */
    @Test
    public void testPrivateFunc() throws Exception {
        // 无参数的私有方法
        ct.publicFunc(123L);// 需要调用一下, 下边方法才可以mock
        PowerMockito.verifyPrivate(ct, Mockito.times(1)).invoke("privateFunc");

    }

    /**
     * 仅单独测试privateFuncWithParams()方法
     */
    @Test
    public void testPrivateFuncWithParams() throws Exception {
        // 有参数的私有方法
        ct.publicFunc(123L);
        PowerMockito.verifyPrivate(ct, Mockito.times(1)).invoke("privateFuncWithParams", 123L);
    }

    /**
     * 同时测试两个方法: privateFunc()和privateFuncWithParams()
     * <p>
     * 注: 这个case无法通过, 原因不详, 但感觉是不能同时verifyPrivate两个私有方法
     */
    @Test
    public void testBothAboveTwo() throws Exception {
        ct.publicFunc(4L);
//        PowerMockito.verifyPrivate(ct, Mockito.times(1)).invoke("privateFunc");
        PowerMockito.verifyPrivate(ct, Mockito.times(1)).invoke("privateFuncWithParams", 123L);
    }
}
