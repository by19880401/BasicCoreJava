package com.example.mock;

import java.io.File;

public class MockFileExistNewObjDemo {

    /**
     * mock a method, but there new an object in the method
     * @param filePath
     * @return
     */
    public boolean invokeMethodToCheckFileExistNewObj(String filePath){
        File file = new File(filePath);
        return file.exists();
    }
}
