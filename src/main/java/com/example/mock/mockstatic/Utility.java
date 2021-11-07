package com.example.mock.mockstatic;

import java.util.List;

/**
 * There is a utility class, it includes two static methods
 */
public class Utility {
    public static <T> boolean listIsNullOrEmpty(List<T> objectList) {
        return objectList == null || objectList.isEmpty();
    }

    public static <T> boolean listIsNotNullOrEmpty(List<T> objectList) {
        return objectList != null && !objectList.isEmpty();
    }
}
