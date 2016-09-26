package com.loopme.persistence;

import com.loopme.entity.Address;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * A data access object class for the Address entity
 *
 * @author Gunther Knutson
 */
public class AddressDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Returns a list of all addresses
     *
     * @return all addresses
     */
    public List<Address> getAllAddresses() {
        List<Address> addresses = new ArrayList<Address>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        addresses = session.createCriteria(Address.class).list();
        return addresses;
    }

    /**
     * Adds an address
     *
     * @param address the new address
     * @return the id of the inserted record
     */
    public int addAddress(Address address) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(address);
        tx.commit();
        session.close();

        int id = address.getAddressId();
        return id;
    }

    /**
     * Deletes an address by id
     *
     * @param addressId the address id
     */
    public void deleteAddress(int addressId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Address route = (Address) session.get(Address.class, addressId);
        session.delete(addressId);
        tx.commit();
        session.close();
    }

    /**
     * Updates the address
     *
     * @param address the address to update
     */
    public void updateAddress(Address address) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(address);
        tx.commit();
        session.close();
    }
}
