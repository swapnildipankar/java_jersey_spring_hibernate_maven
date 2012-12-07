package com.swapnil.helloworld.manager;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 9/26/12
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */

import com.swapnil.helloworld.dao.UserDAO;
import com.swapnil.helloworld.entity.user.User;

public class UserManager {
    private final UserDAO userDAO = new UserDAO();

    public User add(User user) {
        System.out.println("UserManager: add");
        User newUser = userDAO.add(user);
        return newUser;
    }

    public User update(String userID, User user) throws Exception {
        System.out.println("UserManager: update");

        String userIDFromJSON = user.getId();
        if(userID.equals(userIDFromJSON) == false) {
            throw new Exception("User ID Mismatch In Update Operation");
        }

        User updatedUser = userDAO.update(userID, user);
        return updatedUser;
    }

    public User fetch(String userID) {
        System.out.println("UserManager: fetch");
        User fetchedUser = userDAO.fetch(userID);
        return fetchedUser;
    }

    public User delete(String userID, User user) throws Exception {
        System.out.println("UserManager: delete");

        String userIDFromJSON = user.getId();
        if(userID.equals(userIDFromJSON) == false) {
            throw new Exception("User ID Mismatch In Delete Operation");
        }

        User deletedUser = userDAO.delete(userID, user);
        return deletedUser;
    }
}
