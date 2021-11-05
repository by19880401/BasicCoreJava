package com.example.mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class MockSystemStaticMethodDemoTest {

    /**
     * 和Mock普通对象的静态方法、final方法一样
     */
    @Test
    @PrepareForTest(MockSystemStaticMethodDemo.class)
    public void testInvokeSystemStaticMethod() {
        PowerMockito.mockStatic(System.class);
        PowerMockito.when(System.getProperty("willis")).thenReturn("He-Ju");

        MockSystemStaticMethodDemo demo = new MockSystemStaticMethodDemo();
        Assert.assertEquals(demo.invokeSystemStaticMethod("willis"), "He-Ju");

    }
}
