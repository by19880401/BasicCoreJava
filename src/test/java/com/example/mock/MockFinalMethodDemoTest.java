package com.example.mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class MockFinalMethodDemoTest {

    /**
     * 当需要mock final方法的时候，必须加注解@PrepareForTest和@RunWith。注解@PrepareForTest里写的类是final方法所在的类
     */
    @Test
    @PrepareForTest(ParameterObj.class)
    public void testInvokeFinalMethod() {
        ParameterObj parameterObj = PowerMockito.mock(ParameterObj.class);
        PowerMockito.when(parameterObj.isAlive()).thenReturn(true);

        MockFinalMethodDemo demo = new MockFinalMethodDemo();
        Assert.assertTrue(demo.invokeFinalMethod(parameterObj));
    }
}
