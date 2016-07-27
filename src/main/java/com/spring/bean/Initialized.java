package com.spring.bean;

import java.util.Map;

import com.utility.common.ReadUtility;

public class Initialized {
    public Map<String, String> getGlobalSitting() {
        Map<String, String> resultMap = ReadUtility.readProperties("global");
        return resultMap;
    }
}
