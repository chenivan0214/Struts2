package com.interceptor;

import com.action.login.IndexAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SenseInterceptor implements Interceptor {
    private static final long serialVersionUID = 1L;

    @Override
    public void destroy() {
        //System.out.println("Sense - destroy");
    }

    @Override
    public void init() {
        //System.out.println("Sense - init");
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("Sense - intercept");
        IndexAction indexAction = (IndexAction)invocation.getAction();
        System.out.println(indexAction.g().getParameter("type"));
        String invokeName = invocation.invoke();
        System.out.println(invokeName);
        return invokeName;
    }
    
}
