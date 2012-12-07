package com.swapnil.helloworld.dao;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 9/26/12
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */

import com.swapnil.helloworld.entity.user.User;

public class UserDAO {
    public User add(User user) {
        System.out.println("UserDAO: add");

        user.setId(Integer.toString(new Object().hashCode()));
        return user;
    }

    public User update(String userID, User user) {
        System.out.println("UserDAO: update");
        return user;
    }

    public User fetch(String userID) {
        System.out.println("UserDAO: fetch");

        User fetchedUser = new User();
        fetchedUser.setId(userID);
        return fetchedUser;
    }

    public User delete(String userID, User user) {
        System.out.println("UserDAO: delete");
        return user;
    }
}
