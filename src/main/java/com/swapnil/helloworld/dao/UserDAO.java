package com.swapnil.helloworld.dao;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 9/26/12
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */

import com.swapnil.helloworld.entity.user.User;
import com.swapnil.helloworld.entity.user.UserStatus;
import com.swapnil.helloworld.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Date;

public class UserDAO {
    public User add(User user) {
        System.out.println("UserDAO: add");
        System.out.println("UserDAO: START - adding user to the database");

        user.setUserStatus(UserStatus.PENDING);
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println("UserDAO: END - adding user to the database");

        return user;
    }

    public User update(Long userID, User user) {
        System.out.println("UserDAO: update");
        System.out.println("UserDAO: START - updating user to the database");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        User fetchedUser = fetch(userID);

        if(user.getNameFirst() != null && !fetchedUser.getNameFirst().equals(user.getNameFirst())) {
            fetchedUser.setNameFirst(user.getNameFirst());
        }
        if(user.getNameMiddle() != null && !fetchedUser.getNameMiddle().equals(user.getNameMiddle())) {
            fetchedUser.setNameMiddle(user.getNameMiddle());
        }
        if(user.getNameLast() != null && !fetchedUser.getNameLast().equals(user.getNameLast())) {
            fetchedUser.setNameLast(user.getNameLast());
        }
        if(user.getPassword() != null && !fetchedUser.getPassword().equals(user.getPassword())) {
            fetchedUser.setPassword(user.getPassword());
        }
        if(user.getUserStatus() != null && fetchedUser.getUserStatus() != user.getUserStatus()) {
            fetchedUser.setUserStatus(user.getUserStatus());
        }
        if(user.getDateOfBirth() != null && fetchedUser.getDateOfBirth() != user.getDateOfBirth()) {
            fetchedUser.setDateOfBirth(user.getDateOfBirth());
        }
        if(user.getMonthOfBirth() != null && fetchedUser.getMonthOfBirth() != user.getMonthOfBirth()) {
            fetchedUser.setMonthOfBirth(user.getMonthOfBirth());
        }
        if(user.getYearOfBirth() != null && fetchedUser.getYearOfBirth() != user.getYearOfBirth()) {
            fetchedUser.setYearOfBirth(user.getYearOfBirth());
        }
        fetchedUser.setUpdatedAt(new Date());

        session.update(fetchedUser);
        session.getTransaction().commit();
        System.out.println("UserDAO: END - updating user to the database");

        return fetchedUser;
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
