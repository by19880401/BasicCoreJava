package com.example.mock.mockexception;

import java.util.HashMap;
import java.util.Map;

/**
 * Now we have a following class, we try to use mockito to test it
 */
public class MyDictionary {
    private Map<String, String> wordMap;

    public MyDictionary() {
        wordMap = new HashMap<>();
    }

    public void addWord(String key, String value) {
        wordMap.put(key, value);
    }

    public String getValue(String key) {
        return wordMap.get(key);
    }
}
