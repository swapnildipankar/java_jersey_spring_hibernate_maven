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
import org.hibernate.criterion.Restrictions;

public class UserDAO {
    public User add(User user) {
        System.out.println("UserDAO: add");
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
        System.out.println("UserDAO: START - fetching user from the database by user ID");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        User fetchedUser = (User) session.get(User.class, userID);
        System.out.println("UserDAO: END - fetching user from the database by user ID");

        return fetchedUser;
    }

    public User fetchByUsername(String username) {
        System.out.println("UserDAO: fetchByUsername");
        System.out.println("UserDAO: START - fetching user from the database by username");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        User fetchedUser = (User) session.createCriteria(User.class).
                add(Restrictions.eq("username", username)).
                uniqueResult();
        System.out.println("UserDAO: END - fetching user from the database by username");

        return fetchedUser;
    }

    public User delete(Long userID, User user) {
        System.out.println("UserDAO: delete");
        return user;
    }
}
