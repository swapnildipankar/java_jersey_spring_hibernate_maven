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

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserService {
    UserManager userManager = new UserManager();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User addUser(User user) throws Exception {
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

    @GET
    @Path("/username/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public User fetchUserByUsername(@PathParam("param") String username) {
        return userManager.fetchByUsername(username);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> fetchAllUsers(@QueryParam("include_all") boolean includeAll) {
        return userManager.fetchAll(includeAll);
    }

    @DELETE
    @Path("/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User deleteUser(@PathParam("param") Long userID, User user) throws Exception {
        return userManager.delete(userID, user);
    }
}
