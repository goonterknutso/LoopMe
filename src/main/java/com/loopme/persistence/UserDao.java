package com.loopme.persistence;

import com.loopme.entity.User;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * A data access object class for the User entity
 *
 * @author Gunther Knutson
 */
public class UserDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Returns a list of all users
     *
     * @return all users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(User.class).list();
        return users;
    }

    /**
     * Adds a user
     *
     * @param user the new user
     * @return the id of the inserted record
     */
    public int addUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(user);

        tx.commit();
        session.close();

        int id = user.getUserId();
        return id;
    }

    /**
     * Deletes a user by id
     *
     * @param userId the user id
     */
    public void deleteUser(int userId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        User user = (User) session.get(User.class, userId);
        session.delete(user);

        tx.commit();
        session.close();
    }

    /**
     * Updates the user
     *
     * @param user the user to update
     */
    public void updateUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
    }
}
