package com.spring.bean.login;

import java.util.Map;
import java.util.TreeMap;

import com.spring.bean.login.LoginIndexService;
import com.utility.common.Debug;

public class LoginIndexImplement implements LoginIndexService {
    private Map<String, String> mapDefineParam;
    
    public LoginIndexImplement() {
        mapDefineParam = new TreeMap<String, String>();
        mapDefineParam.put("type", "1");
    }

    @Override
    public boolean checkType(String _type) {
        return _type.equals(mapDefineParam.get("type")) ? true : false;
    }

}
