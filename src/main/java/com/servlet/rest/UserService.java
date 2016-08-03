package com.servlet.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import com.hibernate.model.UserModel;
import com.servlet.dao.UserDaoImplement;

@Path("/user")
public class UserService {
    private UserDaoImplement userDaoImplement = new UserDaoImplement();
    
    @GET
    @Path("/list")
    @Produces("application/json;charset=utf-8")
    public Response getMsg(@PathParam("param") String msg) {
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
}
