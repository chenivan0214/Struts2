package com.servlet.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import com.servlet.dao.TestDaoImplement;

@Path("/test")
public class TestService {
    private TestDaoImplement testDaoImplement = new TestDaoImplement();
    
    @GET
    @Path("/insert")
    @Produces("application/json;charset=utf-8")
    public Response insert() {
        String output = String.valueOf(testDaoImplement.insert());
        
        return Response.status(200).entity(output).build();
    }
    
    @GET
    @Path("/query")
    @Produces("application/json;charset=utf-8")
    public Response query() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<?> result = testDaoImplement.query();
        String output = "";
        
        try {
            output = objectMapper.writeValueAsString(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return Response.status(200).entity(output).build();
    }
}
