package com.loopme.persistence;

import com.loopme.entity.Account;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by gunther on 9/25/16.
 */
public class AccountDaoTest {

    AccountDao dao;

    @Before
    public void setup(){
        dao = new AccountDao();
    }

    @Test
    public void getAllAccounts() throws Exception {
        List<Account> accounts = dao.getAllAccounts();

        assertTrue("Error: getAllAccounts() returns with size of 0.", accounts.size() > 0);
    }

    @Test
    public void addAccount() throws Exception {
        Account account = new Account("testusername", "testpassword", 0);
        int newAccountId = dao.addAccount(account);
        assertNotNull("Error: adding account unsuccessful", newAccountId);
    }

    @Test
    public void deleteAccount() throws Exception {

    }

    @Test
    public void updateAddress() throws Exception {

    }

}