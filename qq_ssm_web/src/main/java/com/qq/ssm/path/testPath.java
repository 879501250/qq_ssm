package com.qq.ssm.path;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * CLASS Simple Description //TODO <br><br>
 *
 * <p>
 * Class detailed description, effection, usage,etc. //TODO
 * </p >
 * <br>
 * author: qiqin 2022/9/20 17:11
 */
@Path("/test")
public class testPath {
    @GET
    @Path("/{message}")
    public Response getMsg(@PathParam("message") String msg){
        String str = "msg:" + msg;
        System.out.println("Hi！Jersey");
        return Response.status(200).entity(str).build();
    }
}
