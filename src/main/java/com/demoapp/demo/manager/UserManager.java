package com.demoapp.demo.manager;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 9/26/12
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */

import com.demoapp.demo.dao.UserDAO;
import com.demoapp.demo.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserManager {
    @Autowired
    UserDAO userDAO;

    public User add(User user) throws Exception {
        System.out.println("UserManager: add");
        User newUser = userDAO.add(user);
        return newUser;
    }

    public User update(Long userID, User user) throws Exception {
        System.out.println("UserManager: update");

        if(Long.valueOf(userID) != Long.valueOf(user.getId())) {
            System.out.println("User ID from URI [" + userID + "], User ID from JSON [" +  user.getId() + "]");
            throw new Exception("User ID Mismatch In Update Operation");
        }

        User updatedUser = userDAO.update(userID, user);
        return updatedUser;
    }

    public User fetch(Long userID) {
        System.out.println("UserManager: fetch");
        User fetchedUser = userDAO.fetch(userID);
        return fetchedUser;
    }

    public User fetchByUsername(String username) {
        System.out.println("UserManager: fetchByUsername");
        User fetchedUser = userDAO.fetchByUsername(username);
        return fetchedUser;
    }

    public List<User> fetchAll(boolean includeAll) {
        System.out.println("UserManager: fetchAll");
        List<User> fetchedUsers = userDAO.fetchAll(includeAll);
        return fetchedUsers;
    }

    public User delete(Long userID, User user) throws Exception {
        System.out.println("UserManager: delete");

        if(Long.valueOf(userID) != Long.valueOf(user.getId())) {
            System.out.println("User ID from URI [" + userID + "], User ID from JSON [" +  user.getId() + "]");
            throw new Exception("User ID Mismatch In Delete Operation");
        }

        User deletedUser = userDAO.delete(userID);
        return deletedUser;
    }
}
