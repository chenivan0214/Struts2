package com.utility.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class ReadUtility {
    public static Map<String, String> readProperties(String _filename) {
        Properties properties = new Properties();
        String filePath = "/" + _filename + ".properties";
        System.out.println(filePath);
        InputStream inputStream = ReadUtility.class.getClassLoader().getResourceAsStream(filePath);
        Map<String, String> resultMap = new TreeMap<String, String>();
        
        try {
            if (inputStream != null) {
                properties.load(inputStream);
                for (String key : properties.stringPropertyNames()) {
                    resultMap.put(key, properties.getProperty(key));
                }
            }
        } catch (IOException e) {
            System.out.println("property file " + filePath + " not found in the classpath");
        }
        
        return resultMap;
    }
}
