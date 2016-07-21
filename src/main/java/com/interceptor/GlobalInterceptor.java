package com.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class GlobalInterceptor implements Interceptor {
    private static final long serialVersionUID = 1L;

    @Override
    public void destroy() {
        //System.out.println("Global - destroy");
    }

    @Override
    public void init() {
        //System.out.println("Global - destroy");
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("Global - intercept");
        return invocation.invoke();
    }

}
