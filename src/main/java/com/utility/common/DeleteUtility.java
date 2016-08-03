package com.utility.common;

import java.io.File;

public class DeleteUtility {
    public static int deleteFile(String _path) {
        int result = 1;
        
        try {
            File file = new File(_path);
            
            if (!file.exists() || file.isDirectory()) {
                result = -1;
            } else if (!file.delete()) {
                result = -2;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = -99;
        }
        
        return result;
    }
}
