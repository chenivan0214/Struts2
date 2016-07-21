package com.action.login;

import java.net.HttpCookie;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

//import javax.servlet.http.HttpServletRequest;
//import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    
    private ActionContext actionContext = ActionContext.getContext();
    private HttpServletRequest httpServletRequest = ServletActionContext.getRequest();
    private HttpServletResponse httpServletResponse = ServletActionContext.getResponse();
    private HttpSession httpSession = httpServletRequest.getSession();
    private static int count = 0;
    private String type;
    private String name;
    private String[] hobby;
    private Map<String, String> hobbyMap = new TreeMap<String, String>();
    
    //@Override
    //public String execute() throws Exception {
    //    return ActionSupport.SUCCESS;
    //}
    
    public HttpServletRequest g() {
        return httpServletRequest;
    }
    
    public void setType(String _type) {
        type = _type;
    }
    
    public String getType() {
        return type;
    }
    
    public String getName() {
        return name;
    }
    
    public String[] getHobby() {
        return hobby;
    }
    
    public void setHobby(String[] _hobby) {
        hobby = _hobby;
    }
    
    public void setName(String _name) {
        name = _name;
    }
    
    public Map<String, String> getHobbyMap() {
        return hobbyMap;
    }
    
    public String index() throws Exception {
        //System.out.println(httpSession.getId());
        System.out.println(getType());
        //System.out.println(hobby);
        
        if (httpServletRequest.getParameter("hobby") != null) {
            for (int a = 0; a < hobby.length; a++) {
                System.out.println(hobby[a]);
                hobbyMap.put(Integer.toString(a), hobby[a]);
            }
            System.out.println(hobbyMap);
        }
        
        IndexAction.count++;
        //System.out.println(IndexAction.count);
        
        actionContext.getSession().put("type", getType());
        //same as
        //httpSession.setAttribute("type", getType());
        
        if (type.equals("1")) {
            return "index_success";
        } else {
            throw new Exception("Type為2");
        }
    }
    
    public String before() {
        System.out.println("before action");
        return "before_success";
    }
    
    public String after() {
        return "after_success";
    }
    
}
