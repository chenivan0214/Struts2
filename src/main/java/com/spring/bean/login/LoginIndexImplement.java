package com.spring.bean.login;

import java.util.Map;
import java.util.TreeMap;

import com.spring.bean.login.LoginIndexService;
import com.utility.common.DebugUtility;

public class LoginIndexImplement implements LoginIndexService {
    private Map<String, Integer> mapDefineParam;
    
    public LoginIndexImplement() {
        mapDefineParam = new TreeMap<String, Integer>();
        mapDefineParam.put("type", new Integer(1));
    }

    @Override
    public boolean checkType(int _type) {
        return new Integer(_type).equals(mapDefineParam.get("type")) ? true : false;
    }

}
