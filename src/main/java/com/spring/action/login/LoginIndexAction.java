package com.spring.action.login;

import com.spring.bean.login.LoginIndexService;
import com.utility.common.Debug;

public class LoginIndexAction {
    private String type;
    LoginIndexService loginIndexService;
    
    public String getType() {
        return type;
    }
    
    public void setType(String _type) {
        type = _type;
    }
    
    public void setLoginIndexService(LoginIndexService _loginIndexService) {
        loginIndexService = _loginIndexService;
    }
    
    public String execute() throws Exception {
        if (getType() != null && !getType().equals("")) {
            Debug.simpleOutput(loginIndexService.checkType(getType()));
            Debug.simpleOutput(getType());
        }
        
        return "success";
    }
}
