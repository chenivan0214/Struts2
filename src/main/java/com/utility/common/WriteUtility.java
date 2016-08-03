package com.utility.common;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public class WriteUtility {
    public static int writeToFile(String _targetPath, String _context) {
        Charset.forName("UTF-8").newEncoder();
        int result = 1;
        
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(_targetPath);
            Writer writer = new OutputStreamWriter(fileOutputStream, "UTF8");
            writer.write(_context);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            result = -99;
        }
        
        return result;
    }
}
