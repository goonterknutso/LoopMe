package com.loopme.persistence;

import com.loopme.entity.Leg;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * A data access object class for the Leg entity
 *
 * @author Gunther Knutson
 */
public class LegDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Returns a list of all legs
     *
     * @return all legs
     */
    public List<Leg> getAllALegs() {
        List<Leg> legs = new ArrayList<Leg>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        legs = session.createCriteria(Leg.class).list();
        return legs;
    }

    /**
     * Adds a leg
     *
     * @param leg the new leg
     * @return the id of the inserted record
     */
    public int addLeg(Leg leg) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(leg);

        tx.commit();
        session.close();

        int id = leg.getLegId();
        return id;
    }

    /**
     * Deletes a leg by id
     *
     * @param legId the leg id
     */
    public void deleteLeg(int legId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Leg route = (Leg) session.get(Leg.class, legId);
        session.delete(legId);
        tx.commit();
        session.close();
    }

    /**
     * Updates the leg
     *
     * @param leg the leg to update
     */
    public void updateLeg(Leg leg) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(leg);
        tx.commit();
        session.close();
    }
}
