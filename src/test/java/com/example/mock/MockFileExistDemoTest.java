package com.example.mock;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.File;

public class MockFileExistDemoTest {

    /**
     * normal mock
     */
    @Test
    public void testInvokeMethodToCheckFileExist(){
        // mock file object
        File file = PowerMockito.mock(File.class);
        // when meet file.exist() then return true
        PowerMockito.when(file.exists()).thenReturn(true);

        MockFileExistDemo demo = new MockFileExistDemo();
        Assert.assertTrue(demo.invokeMethodToCheckFileExist(file));
    }
}
