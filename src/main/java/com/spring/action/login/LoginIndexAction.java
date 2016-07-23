package com.spring.action.login;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import com.hibernate.dao.UserDaoImplement;
import com.hibernate.model.UserModel;
import com.opensymphony.xwork2.ModelDriven;
import com.spring.bean.login.LoginIndexService;
import com.utility.common.DebugUtility;

public class LoginIndexAction implements ModelDriven<UserModel>, ServletContextAware {
    private int type;
    private String name;
    LoginIndexService loginIndexService;
    //for hibernate
    private ServletContext servlentContext;
    UserModel userModel = new UserModel();
    UserDaoImplement userDaoImplement = new UserDaoImplement(null);
    
    public int getType() {
        return type;
    }
    
    public void setType(int _type) {
        type = _type;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String _name) {
        name = _name;
    }
    
    public void setLoginIndexService(LoginIndexService _loginIndexService) {
        loginIndexService = _loginIndexService;
    }

    @Override
    public void setServletContext(ServletContext _servlentContext) {
        servlentContext = _servlentContext;
    }
    
    @Override
    public UserModel getModel() {
        return userModel;
    }
    
    public String execute() throws Exception {
        if (getType() != 0) {
            DebugUtility.simpleOutput(loginIndexService.checkType(getType()));
            DebugUtility.simpleOutput(getType());
            DebugUtility.simpleOutput(getName());
        }
        
        //for hibernate
        SessionFactory sessionFactory = (SessionFactory)servlentContext.getAttribute("SessionFactory");
        UserDaoImplement userDaoImplement = new UserDaoImplement(sessionFactory);
        
        //List<UserModel> listUserModel = userDaoImplement.getById(11);
        
        //if (listUserModel.size() != 0) {
        //    DebugUtility.simpleOutput(listUserModel);
        //    System.out.println("Select one:" + listUserModel.get(0).getId());
        //}
        
        //List<UserModel> listUserModel = userDaoImplement.getAll();
        
        //if (listUserModel != null) {
        //    System.out.println("select all");
        //    for (UserModel _userModel : listUserModel) {
        //        System.out.println(_userModel.getId() + "-" + _userModel.getName());
        //    }
        //}
        
        //System.out.println("update result:" + userDaoImplement.updateById(11, "update"));
        
        //System.out.println("delete result:" + userDaoImplement.deleteById(11));
        
        System.out.println("insert one result:" + userDaoImplement.insertOne("I am insert..."));
        
        return "success";
    }
}
