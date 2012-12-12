package com.swapnil.helloworld.dao;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 9/26/12
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */

import com.swapnil.helloworld.entity.user.User;
import com.swapnil.helloworld.util.HibernateUtil;
import org.hibernate.Session;

public class UserDAO {
    public User add(User user) {
        System.out.println("UserDAO: add");

        //user.setId(Integer.toString(new Object().hashCode()));
        System.out.println("UserDAO: START - adding user to the database");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println("UserDAO: END - adding user to the database");

        return user;
    }

    public User update(Long userID, User user) {
        System.out.println("UserDAO: update");
        return user;
    }

    public User fetch(Long userID) {
        System.out.println("UserDAO: fetch");

        User fetchedUser = new User();
        fetchedUser.setId(userID);
        return fetchedUser;
    }

    public User delete(Long userID, User user) {
        System.out.println("UserDAO: delete");
        return user;
    }
}
