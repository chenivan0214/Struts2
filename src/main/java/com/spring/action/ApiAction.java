package com.spring.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.ObjectMapper;

public class ApiAction {
    public String execute() throws IOException {
        HttpServletResponse httpServletResponse;
        PrintWriter printWriter;
        ObjectMapper objectMapper = new ObjectMapper();
        Map<Integer, String> returnMap = new HashMap<Integer, String>();
        
        httpServletResponse = ServletActionContext.getResponse();
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/html; charset=UTF-8");
        printWriter = httpServletResponse.getWriter();
        
        for (int a = 0; a < 10; a++) {
            returnMap.put(Integer.valueOf(a), String.valueOf(a));
        }
        
        printWriter.println(objectMapper.writeValueAsString(returnMap));
        printWriter.flush();
        
        return "success";
    }
}
