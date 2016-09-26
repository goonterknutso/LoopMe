package com.loopme.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A class to test the Address class
 *
 * @author Gunther Knutson
 */
public class AddressTest {

    Address address;

    @Before
    public void setUp() throws Exception {
        address = new Address("123 Test St", "Madison", "WI", "12345");
        address.setAddressId(0);
    }

    @Test
    public void getAddressId() throws Exception {
        assertEquals("Error: getAddressId() did not return correctly. Expected: 0.", address.getAddressId(), 0);
    }

    @Test
    public void setAddressId() throws Exception {
        address.setAddressId(1);
        assertEquals("Error: setAddressId() did not set correctly. Expected: 1.", address.getAddressId(), 1);
    }

    @Test
    public void getStreet() throws Exception {
        assertEquals("Error: getStreet() did not return correctly. Expected: '123 Test St'.", address.getStreet(), "123 Test St");
    }

    @Test
    public void setStreet() throws Exception {
        address.setStreet("111 Cool Lane");
        assertEquals("Error: setStreet() did not set correctly. Expected: '111 Cool Lane'.", address.getStreet(), "111 Cool Lane");
    }

    @Test
    public void getCity() throws Exception {
        assertEquals("Error: getCity() did not return correctly. Expected: 'Madison'.", address.getCity(), "Madison");
    }

    @Test
    public void setCity() throws Exception {
        address.setCity("Waunakee");
        assertEquals("Error: setStreet() did not set correctly. Expected: 'Waunakee'.", address.getCity(), "Waunakee");
    }

    @Test
    public void getState() throws Exception {
        assertEquals("Error: getState() did not return correctly. Expected: 'WI'.", address.getState(), "WI");
    }

    @Test
    public void setState() throws Exception {
        address.setState("IL");
        assertEquals("Error: getState() did not set correctly. Expected: 'IL'.", address.getState(), "IL");
    }

    @Test
    public void getZip() throws Exception {
        assertEquals("Error: getZip() did not return correctly. Expected: '12345'.", address.getZip(), "12345");
    }

    @Test
    public void setZip() throws Exception {
        address.setZip("11111");
        assertEquals("Error: setZip() did not set correctly. Expected: '11111'.", address.getZip(), "11111");

    }

}