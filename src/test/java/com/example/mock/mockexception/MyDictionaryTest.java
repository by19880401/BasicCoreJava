package com.example.mock.mockexception;

import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

/**
 * More details please refer to:[PowerMock Spy], the following ULR in yinxiangbiji
 * https://app.yinxiang.com/shard/s6/nl/16357279/c213e4e0-d94b-4c66-a86b-4588f78170fd
 */
public class MyDictionaryTest {

    /**
     * void method
     * for void method, we should use doThrow to mock its exception
     */
    @Test(expected = IllegalStateException.class)
    public void testAdd() {
        MyDictionary myDictionary = PowerMockito.mock(MyDictionary.class);
        PowerMockito.doThrow(new IllegalStateException()).when(myDictionary).addWord(Mockito.anyString(), Mockito.anyString());

        myDictionary.addWord("key", "value");
    }

    /**
     * non-void method
     * for non-void method, we use when().thenThrow() to test
     * <p>
     * as we DO NOT put anything to wordMap of MyDictionary before test, so when we use 'NPE' as key to get something, an exception will occur
     */
    @Test(expected = NullPointerException.class)
    public void testGetValue() {
        MyDictionary myDictionary = PowerMockito.mock(MyDictionary.class);
        PowerMockito.when(myDictionary.getValue(Mockito.anyString())).thenThrow(NullPointerException.class);

        myDictionary.getValue("NPE");
    }

    /**
     * Another way, we use spy to mock object, spy will really call the method 'getValue(....)'
     */
    @Test(expected = NullPointerException.class)
    public void testGetValueWithSpy() {
        MyDictionary myDictionary = PowerMockito.spy(new MyDictionary());
        PowerMockito.when(myDictionary.getValue(Mockito.anyString())).thenThrow(NullPointerException.class);

        myDictionary.getValue("HelloNPE");
    }
}
