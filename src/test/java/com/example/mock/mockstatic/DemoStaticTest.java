package com.example.mock.mockstatic;

import cn.hutool.log.StaticLog;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.management.*")
public class DemoStaticTest {

    @BeforeClass
    public static void setUp() {
        StaticLog.info("Executing setUp()....");
        PowerMockito.mockStatic(DemoStatic.class);
    }

    @Test
    @PrepareForTest({DemoStatic.class})
    public void testNextInt() {
        StaticLog.info("Test testNextInt()...");
        PowerMockito.when(DemoStatic.nextInt(12)).thenReturn(7);
        Assert.assertEquals(7, DemoStatic.nextInt(12));
    }
}
