package com.example.mock;

import java.io.File;

public class MockFileExistDemo {

    /**
     * Normal mock case
     * <p>
     * 普通Mock不需要加@RunWith和@PrepareForTest注解
     *
     * @param file
     * @return
     */
    public boolean invokeMethodToCheckFileExist(File file) {
        return file.exists();
    }
}
