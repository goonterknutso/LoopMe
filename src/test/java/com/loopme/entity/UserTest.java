package com.loopme.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A class to test the User class
 *
 * @author Gunther Knutson
 */

public class UserTest {

    User user;

    @Before
    public void setup() {
        user = new User("UserFirstName", "UserLastName", "user@email.com", 0);
        user.setUserId(0);
    }

    @Test
    public void getUserId() throws Exception {
        assertEquals("Error: getUserId() did not return correctly. Expected: 0.", user.getUserId(), 0);
    }

    @Test
    public void setUserId() throws Exception {
        user.setUserId(1);
        assertEquals("Error: setUserId() did not set correctly. Expected: 1.", user.getUserId(), 1);
    }

    @Test
    public void getFirstName() throws Exception {
        assertEquals("Error: getFirstName() did not return correctly. Expected: 'UserFirstName'.", user.getFirstName(), "UserFirstName");

    }

    @Test
    public void setFirstName() throws Exception {
        user.setFirstName("Tom");
        assertEquals("Error: setFirstName() did not set correctly. Expected: 'Tom'.", user.getFirstName(), "Tom");
    }

    @Test
    public void getLastName() throws Exception {
        assertEquals("Error: getLastName() did not return correctly. Expected: 'UserLastName'.", user.getLastName(), "UserLastName");
    }

    @Test
    public void setLastName() throws Exception {
        user.setLastName("Jones");
        assertEquals("Error: setLastName() did not set correctly. Expected: 'Jones'.", user.getLastName(), "Jones");
    }

    @Test
    public void getEmail() throws Exception {
        assertEquals("Error: getEmail() did not return correctly. Expected: 'user@email.com'.", user.getEmail(), "user@email.com");
    }

    @Test
    public void setEmail() throws Exception {
        user.setEmail("tomjones@gmail.com");
        assertEquals("Error: setEmail() did not set correctly. Expected: 'tomjones@gmail.com'.", user.getEmail(), "tomjones@gmail.com");
    }

    @Test
    public void getHomeAddressId() throws Exception {
        assertEquals("Error: getHomeAddressId() did not return correctly. Expected: 0.", user.getHomeAddressId(), 0);

    }

    @Test
    public void setHomeAddressId() throws Exception {
        user.setHomeAddressId(5);
        assertEquals("Error: setHomeAddressId() did not set correctly. Expected: 5.", user.getHomeAddressId(), 5);
    }

}