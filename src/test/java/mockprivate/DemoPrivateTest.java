package mockprivate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DemoPrivate.class})
public class DemoPrivateTest {

    @Test
    public void testPrivateFunc() throws Exception {
        DemoPrivate demoPrivate = PowerMockito.spy(new DemoPrivate());
        demoPrivate.publicFunc(123L);// 要测试私有方法, 必须要调用一下调用私有方法的公有方法, 后面才能用mock验证
        PowerMockito.when(demoPrivate, "privateFunc").thenReturn("123");
        // 无参数的私有方法
        PowerMockito.verifyPrivate(demoPrivate, Mockito.times(1)).invoke("privateFunc");
        // 有参数的私有方法, 写法1:
        PowerMockito.verifyPrivate(demoPrivate, Mockito.times(1)).invoke("privateFuncWithParams", Mockito.anyLong());
        // 或者, 写法2: (注: 这里的参数123L要写line17里传入的参数一致)
        PowerMockito.verifyPrivate(demoPrivate, Mockito.times(1)).invoke("privateFuncWithParams", 123L);
    }
}
