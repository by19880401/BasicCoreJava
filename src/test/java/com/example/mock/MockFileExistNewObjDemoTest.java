package com.example.mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

/**
 * 当使用PowerMockito.whenNew方法时，必须加注解@PrepareForTest和@RunWith。注解@PrepareForTest里写的类是需要mock的new对象代码所在的类
 */
@RunWith(PowerMockRunner.class)
public class MockFileExistNewObjDemoTest {

    @Test
    @PrepareForTest(MockFileExistNewObjDemo.class)
    public void testInvokeMethodToCheckFileExistNewObj() {
        File file = PowerMockito.mock(File.class);
        try {
            PowerMockito.whenNew(File.class).withArguments("Willis").thenReturn(file);
            PowerMockito.when(file.exists()).thenReturn(true);

            MockFileExistNewObjDemo demo = new MockFileExistNewObjDemo();
            Assert.assertTrue(demo.invokeMethodToCheckFileExistNewObj("Willis"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
