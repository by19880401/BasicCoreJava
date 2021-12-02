package com.example.mock.mocklist;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class MockListDemoTest {

    @Mock
    List<Integer> list;

    public void setup(){
        /**
         * enable mock annotation
         */
        MockitoAnnotations.initMocks(this);
    }
    public void testGetFirstElementFromList(){
        Mockito.when(list);
    }
}
