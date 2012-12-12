package com.swapnil.helloworld.ws;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 9/24/12
 * Time: 2:45 PM
 * To change this template use File | Settings | File Templates.
 */

import com.swapnil.helloworld.entity.user.User;
import com.swapnil.helloworld.manager.UserManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserService {
    UserManager userManager = new UserManager();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User addUser(User user) {
        return userManager.add(user);
    }

    @PUT
    @Path("/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(@PathParam("param") Long userID, User user) throws Exception {
        return userManager.update(userID, user);
    }

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public User fetchUser(@PathParam("param") Long userID) {
        return userManager.fetch(userID);
    }

    @DELETE
    @Path("/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User deleteUser(@PathParam("param") Long userID, User user) throws Exception {
        return userManager.delete(userID, user);
    }

    /*
    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "Jersey Says [" + msg + "]\n";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/json/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public WSResponse getWSResponse(@PathParam("param") String input) {
        WSResponse wsResponse = new WSResponse();
        wsResponse.setCode("200");
        wsResponse.setMessage(input);

        List<String> responseAdditionalData = new ArrayList<String>();
        responseAdditionalData.add("Kookie");
        responseAdditionalData.add("Lulu");
        responseAdditionalData.add("Biltu");
        responseAdditionalData.add("Bilwa");
        wsResponse.setAdditionalData(responseAdditionalData);

        return wsResponse;
    }

    @POST
    @Path("/json")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public WSResponse postWSRequest(WSRequest wsRequest) {
        WSResponse wsResponse = new WSResponse();
        wsResponse.setCode(wsRequest.getCode());
        wsResponse.setMessage(wsRequest.getMessage());
        wsResponse.setAdditionalData(wsRequest.getAdditionalData());

        return wsResponse;
    }
    */
}