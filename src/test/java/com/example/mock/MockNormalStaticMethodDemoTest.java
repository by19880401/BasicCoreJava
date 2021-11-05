package com.example.mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class MockNormalStaticMethodDemoTest {

    /**
     * 当需要mock静态方法的时候，必须加注解@PrepareForTest和@RunWith。注解@PrepareForTest里写的类是静态方法所在的类
     */
    @Test
    @PrepareForTest(StaticParameterObj.class)
    public void testInvokeStaticMethod() {
        PowerMockito.mockStatic(StaticParameterObj.class);
        PowerMockito.when(StaticParameterObj.isAlive()).thenReturn(true);

        MockNormalStaticMethodDemo demo = new MockNormalStaticMethodDemo();
        Assert.assertTrue(demo.invokeStaticMethod());
    }
}
