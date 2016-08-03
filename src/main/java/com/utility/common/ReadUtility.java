package com.utility.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class ReadUtility {
    public static String readFile(String _targetPath) {
        String content = null;
        
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(_targetPath));
            String buffer = null;

            while ((buffer = bufferedReader.readLine()) != null) {
                content += buffer;
            }
        } catch (Exception e) {
            content = "";
        }
        
        return content;
    }
    public static Map<String, String> readProperties(String _filename) {
        Properties properties = new Properties();
        String filePath = "/" + _filename + ".properties";
        InputStream inputStream = ReadUtility.class.getClassLoader().getResourceAsStream(filePath);
        Map<String, String> resultMap = new TreeMap<String, String>();
        
        try {
            if (inputStream != null) {
                properties.load(inputStream);
                for (String key : properties.stringPropertyNames()) {
                    resultMap.put(key, properties.getProperty(key));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resultMap;
    }
}
