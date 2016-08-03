package com.utility.common;

import java.net.URL;

public class FileUtility {
    public static String getWEBINFPath() {
        String webinf = "WEB-INF";
        String filePath = "";
        
        URL url = FileUtility.class.getResource("FileUtility.class");
        String className = url.getFile();
        filePath = className.substring(0, className.indexOf(webinf) + webinf.length());
        
        return filePath;
    }
}
