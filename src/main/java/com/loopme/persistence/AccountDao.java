package com.loopme.persistence;

import com.loopme.entity.Account;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * A data access object class for the Account entity
 *
 * @author Gunther Knutson
 */
public class AccountDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Returns a list of all accounts
     *
     * @return all accounts
     */
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<Account>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        accounts = session.createCriteria(Account.class).list();
        log.debug(accounts.size());


        return accounts;
    }

    /**
     * Adds an account
     *
     * @param account the new account
     * @return the id of the inserted record
     */
    public int addAccount(Account account) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(account);
        tx.commit();
        session.close();

        int id = account.getAccountId();
        return id;
    }

    /**
     * Deletes an Account by id
     *
     * @param accountId the account id
     */
    public void deleteAccount(int accountId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Account route = (Account) session.get(Account.class, accountId);
        session.delete(accountId);
        tx.commit();
        session.close();
    }

    /**
     * Updates the account
     *
     * @param account the account to update
     */
    public void updateAddress(Account account) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(account);
        tx.commit();
        session.close();
    }

}
