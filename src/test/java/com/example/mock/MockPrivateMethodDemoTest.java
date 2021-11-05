package com.example.mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class MockPrivateMethodDemoTest {

    /**
     * @PrepareForTest注解里写的类是私有方法所在的类
     * @throws Exception
     */
    @Test
    @PrepareForTest(MockPrivateMethodDemo.class)
    public void testInvokePrivateMethod() throws Exception {
        MockPrivateMethodDemo demo = PowerMockito.mock(MockPrivateMethodDemo.class);
        PowerMockito.when(demo.invokePrivateMethod()).thenCallRealMethod();
        PowerMockito.when(demo, "isAlive").thenReturn(true);
        Assert.assertTrue(demo.invokePrivateMethod());

    }
}
