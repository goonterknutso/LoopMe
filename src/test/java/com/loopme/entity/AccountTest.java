package com.loopme.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A class to test the Account class'
 *
 * @author Gunther Knutson
 */
public class AccountTest {

    Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account("testusername", "testpassword", 0);
        account.setAccountId(0);
    }

    @Test
    public void getAccountId() throws Exception {
        assertEquals("Error: getAccount() did not return correctly. Expected: 0.", account.getAccountId(), 0);
    }

    @Test
    public void setAccountId() throws Exception {
        account.setAccountId(1);
        assertEquals("Error: setAccount() did not set correctly. Expected: 1.", account.getAccountId(), 1);
    }

    @Test
    public void getUsername() throws Exception {
        assertEquals("Error: getUsername() did not return correctly. Expected: 'testusername'.", account.getUsername(), "testusername");
    }

    @Test
    public void setUsername() throws Exception {
        account.setUsername("changedusername");
        assertEquals("Error: setUsername() did not set correctly. Expected: 'changedusername'.", account.getUsername(), "changedusername");
    }

    @Test
    public void getPassword() throws Exception {
        assertEquals("Error: getPassword() did not return correctly. Expected: 'testpassword'.", account.getPassword(), "testpassword");
    }

    @Test
    public void setPassword() throws Exception {
        account.setPassword("changedpassword");
        assertEquals("Error: setPassword() did not set correctly. Expected: 'changedpassword'.", account.getPassword(), "changedpassword");
    }

    @Test
    public void getUserId() throws Exception {
        assertEquals("Error: getUserId() did not return correctly. Expected: 0.", account.getUserId(), 0);
    }

    @Test
    public void setUserId() throws Exception {
        account.setUserId(1);
        assertEquals("Error: setUserId() did not set correctly. Expected: 1.", account.getUserId(), 1);
    }

}