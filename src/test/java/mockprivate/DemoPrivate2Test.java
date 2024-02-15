package mockprivate;

import cn.hutool.log.StaticLog;
import com.objectiva.mockprivate.DemoPrivate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DemoPrivate.class})
public class DemoPrivate2Test {

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
    public void testPrivateFunc() {
        // 无参数的私有方法
        PowerMockito.stub(PowerMockito.method(DemoPrivate.class, "privateFunc")).toReturn("456");
        Assert.assertEquals("456private func, param:123", ct.publicFunc(123L));

    }

    /**
     * 仅单独测试privateFuncWithParams()方法
     */
    @Test
    public void testPrivateFuncWithParams() {
        /**
         * 注意: stub会阻断被mock的类里的真实方法, 比如下述, 我们mock了DemoPrivate中的privateFuncWithParams(Long value)方法
         * 使用stub之后, 程序不会执行privateFuncWithParams(Long value)方法里的真实逻辑(真实应该根据传入的参数, 返回"'private func, param:' + value"), 而是直接返回789
         */
        // 有参数的私有方法
        PowerMockito.stub(PowerMockito.method(DemoPrivate.class, "privateFuncWithParams", Long.class)).toReturn("789");
        Assert.assertEquals("private func789", ct.publicFunc(123L));
    }

    /**
     * 同时测试两个方法: privateFunc()和privateFuncWithParams()
     */
    @Test
    public void testBothAboveTwo() {
        PowerMockito.stub(PowerMockito.method(DemoPrivate.class, "privateFunc")).toReturn("Willis01");
        PowerMockito.stub(PowerMockito.method(DemoPrivate.class, "privateFuncWithParams", Long.class)).toReturn("Cola09");
        Assert.assertEquals("Willis01Cola09", ct.publicFunc(9999L));
    }
}
