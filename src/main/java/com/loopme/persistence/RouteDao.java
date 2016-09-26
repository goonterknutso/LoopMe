package com.loopme.persistence;

import com.loopme.entity.Route;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * A data access object class for the Route entity
 *
 * @author Gunther Knutson
 */
public class RouteDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Returns a list of all routes
     *
     * @return all routes
     */
    public List<Route> getAllRoutes() {
        List<Route> routes = new ArrayList<Route>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        routes = session.createCriteria(Route.class).list();
        return routes;
    }

    /**
     * Adds a route
     *
     * @param route the new route
     * @return the id of the inserted record
     */
    public int addRoute(Route route) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(route);

        tx.commit();
        session.close();

        int id = route.getRouteId();
        return id;
    }

    /**
     * Deletes a route by id
     *
     * @param routeId the user id
     */
    public void deleteRoute(int routeId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Route route = (Route) session.get(Route.class, routeId);
        session.delete(route);
        tx.commit();
        session.close();
    }

    /**
     * Updates the route
     *
     * @param route the route to update
     */
    public void updateRoute(Route route) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(route);
        tx.commit();
        session.close();
    }
}
