package com.spring.action.login;

import java.util.Map;

import java.util.List;

import com.hibernate.model.UserModel;
import com.spring.bean.UseServletContext;
import com.spring.bean.login.LoginIndexService;
import com.spring.bean.login.dao.UserDaoService;
import com.utility.common.DebugUtility;
import com.utility.common.ReadUtility;

public class LoginIndexAction {
    private int type;
    private String word;
    private UserModel userModel;
    private List<UserModel> userModelList;
    private UseServletContext useServletContext;
    private LoginIndexService loginIndexService;
    private UserDaoService userDaoService;
    
    public int getType() {
        return type;
    }
    
    public void setType(int _type) {
        type = _type;
    }
    
    public String getWord() {
        return word;
    }
    
    public void setWord(String _word) {
        System.out.println(_word);
        word = _word;
    }
    
    public UserModel getUserModel() {
        return userModel;
    }
    
    public List<UserModel> getUserModelList() {
        return userModelList;
    }
    
    public void setUseServletContext(UseServletContext _useServletContext) {
        useServletContext = _useServletContext;
    }
    
    public void setLoginIndexService(LoginIndexService _loginIndexService) {
        loginIndexService = _loginIndexService;
    }
    
    public void setUserDaoService(UserDaoService _userDaoService) {
        userDaoService = _userDaoService;
    }
    
    public String execute() {
        if (getType() != 0) {
            DebugUtility.simpleOutput(loginIndexService.checkType(getType()));
            DebugUtility.simpleOutput(getType());
            DebugUtility.simpleOutput(getWord());
        }
        
        userModelList = userDaoService.getById(getType());
        DebugUtility.simpleOutput(userModelList);
        userModel = null;
        
        if (userModelList.size() != 0) {
            userModel = userModelList.get(0);
        }
        
        userModelList = userDaoService.getAll();
        
        if (userModelList != null) {
            System.out.println("select all");
            for (UserModel _userModel : userModelList) {
                System.out.println(_userModel.getId() + "-" + _userModel.getName());
            }
        }
        
        System.out.println("update result:" + userDaoService.updateById(getType(), "update"));
        System.out.println("delete result:" + userDaoService.deleteById(getType()));
        System.out.println("insert one result:" + userDaoService.insertOne("I am 我我我..."));
        
        Map<String, String> resultMap = ReadUtility.readProperties("global");
        DebugUtility.simpleOutput(resultMap);
        DebugUtility.simpleOutput(resultMap.get("User.Name"));
        
        //ServletContext servletContext = ServletActionContext.getServletContext();
        //DebugUtility.simpleOutput(servletContext.getAttribute("defaultUserName"));
        
        System.out.println(useServletContext.getAttribute("defaultUserName"));
        
        return "success";
    }
}
