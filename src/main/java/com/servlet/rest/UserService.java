package com.servlet.rest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import com.hibernate.model.UserModel;
import com.servlet.dao.UserDaoImplement;
import com.utility.common.DebugUtility;
import com.utility.common.DeleteUtility;
import com.utility.common.ReadUtility;

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
    @Path("/operateCache")
    @Produces("application/json;charset=utf-8")
    public Response operateCache(@PathParam("param") String param) {
        Map<String, String> globalSettingMap = ReadUtility.readProperties("global");
        String cacheFilePath = globalSettingMap.get("Cache.DB.Path") + "User";
        String output = "";
        
        System.out.println(cacheFilePath);
        
        output = String.valueOf(DeleteUtility.deleteFile(cacheFilePath));
        
        return Response.status(200).entity(output).build();
    }
}
