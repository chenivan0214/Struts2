package com.servlet.rest;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import com.hibernate.model.UserModel;
import com.servlet.dao.UserDaoImplement;
import com.utility.common.DeleteUtility;
import com.utility.common.FileUtility;
//import com.utility.common.FileUtility;
import com.utility.common.ReadUtility;
import com.utility.common.WriteUtility;

@Path("/user")
public class UserService {
    private UserDaoImplement userDaoImplement = new UserDaoImplement();
    
    @GET
    @Path("/list")
    @Produces("application/json;charset=utf-8")
    public Response getAll() {
        ObjectMapper objectMapper = new ObjectMapper();
        String output = "";
        List<UserModel> userModelList = userDaoImplement.getAll();
        
        try {
            output = objectMapper.writeValueAsString(userModelList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return Response.status(200).entity(output).build();
    }
    
    @GET
    @Path("/cache/{param}")
    @Produces("application/json;charset=utf-8")
    public Response opCache(@PathParam("param") String param) {
        String targetPath = FileUtility.getWEBINFPath() + "/cache/db/user";
        String output = "";
        
        if (param.equals("delete")) {
            output = String.valueOf(DeleteUtility.deleteFile(targetPath));
        }
        
        if (param.equals("update")) {
            ObjectMapper objectMapper = new ObjectMapper();
            List<UserModel> userModelList = userDaoImplement.getAll();
            String content = null;
            
            try {
                content = objectMapper.writeValueAsString(userModelList);
                output = String.valueOf(WriteUtility.writeToFile(targetPath, content));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        if (param.equals("view")) {
            output = ReadUtility.readFile(targetPath);
        }
        
        return Response.status(200).entity(output).build();
    }
    
    @POST
    @Path("/searchByPost")
    @Produces("application/json;charset=utf-8")
    public String searchByPost(@FormParam("name") String name) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> returnMap = new TreeMap<String, Object>();
        Map<String, String> parameterMap = new TreeMap<String, String>();
        String output = "";
        
        parameterMap.put("name", name);
        returnMap.put("result", true);
        returnMap.put("parameter", parameterMap);
        
        try {
            output = objectMapper.writeValueAsString(returnMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return output;
    }
    
    @POST
    @Path("/serarchByRawData")
    @Produces("application/json;charset=utf-8")
    public String serarchByRawData(String rawData) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> returnMap = new TreeMap<String, Object>();
        Map<String, String> parameterMap = new TreeMap<String, String>();
        UserModel userModel = null;
        String output = "";
        
        try {
            userModel = objectMapper.readValue(rawData, UserModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        parameterMap.put("name", userModel.getName());
        returnMap.put("result", true);
        returnMap.put("parameter", parameterMap);
        
        try {
            output = objectMapper.writeValueAsString(returnMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return output;
    }
}
