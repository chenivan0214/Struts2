package com.utility.common;

public class CheckUtility {
    //for string
    public static boolean stringIsInteger(String _str) {
        return _str.matches("^-?\\d+$");
    }
    
    public static boolean stringIsNumber(String _str) {
        return _str.matches("-?\\d+(\\.\\d+)?");
    }
    
    public static boolean stringIsCustomFormat(String _str, String _reg) {
        return _str.matches(_reg);
    }
}
