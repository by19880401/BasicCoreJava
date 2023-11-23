package mockstatic;

import cn.hutool.log.StaticLog;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class) // 使用PowerMockRunner进行测试
@PowerMockIgnore("javax.management.*") // 为了解决使用powermock后，提示classloader错误
public class DemoStaticTest {

    @BeforeClass
    public static void setUp() {
        StaticLog.info("Executing setup().....");
        PowerMockito.mockStatic(DemoStatic.class);
    }

    /*@Test
    public void testMockPrivate() throws Exception {
        PowerMockito.spy(DemoStatic.class);
        PowerMockito.when(DemoStatic.class, "getMyWord").thenReturn("Nothing to say");
        DemoStatic.sayAgain(); //Nothing to say
    }*/

    @Test
    @PrepareForTest({DemoStatic.class}) // 静态类，测试类本身（需要mock构造方法时）
    public void testNextInt() {
        StaticLog.info("Test testNextInt()...");
        PowerMockito.when(DemoStatic.nextInt(12)).thenReturn(7);
        Assert.assertEquals(7, DemoStatic.nextInt(12));
    }
}
