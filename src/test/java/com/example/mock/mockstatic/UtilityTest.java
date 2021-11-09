package com.example.mock.mockstatic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Do not suggest writing such test cases
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utility.class)
public class UtilityTest {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testListIsNullOrEmpty_ParamsIsnull() {
        PowerMockito.mockStatic(Utility.class);
        PowerMockito.when(Utility.listIsNullOrEmpty(Mockito.anyList())).thenReturn(true);
        Assert.assertTrue(Utility.listIsNullOrEmpty(new ArrayList<>()));
    }

    @Test
    public void testListIsNullOrEmpty_ParamsIsNotNull() {
        PowerMockito.mockStatic(Utility.class);
        PowerMockito.when(Utility.listIsNullOrEmpty(Mockito.anyList())).thenReturn(false);
        Assert.assertFalse(Utility.listIsNullOrEmpty(Arrays.asList("1", "2", "3")));
    }

}
