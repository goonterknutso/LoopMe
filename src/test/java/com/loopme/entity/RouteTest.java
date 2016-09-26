package com.loopme.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gunther on 9/25/16.
 */
public class RouteTest {

    Route route;

    @Before
    public void setUp() throws Exception {
        route = new Route("MyRoute", 15.0, "Miles", 50.5, "Feet", 0, 0);
        route.setRouteId(0);
    }

    @Test
    public void getRouteId() throws Exception {
        assertEquals("Error: getRouteId() did not return correctly. Expected: 0.", route.getRouteId(), 0);
    }

    @Test
    public void setRouteId() throws Exception {
        route.setRouteId(1);
        assertEquals("Error: setRouteId() did not set correctly. Expected: 1.", route.getRouteId(), 1);
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Error: getName() did not return correctly. Expected: 'MyRoute'.", route.getName(), "MyRoute");
    }

    @Test
    public void setName() throws Exception {
        route.setName("Set New Name");
        assertEquals("Error: setName() did not set correctly. Expected: 'Set New Name'.", route.getName(), "Set New Name");
    }

    @Test
    public void getDistance() throws Exception {
        assertTrue("Error: getDistance() did not return correctly. Expected: 15.0.", route.getDistance() == 15.0);
    }

    @Test
    public void setDistance() throws Exception {
        route.setDistance(20.5);
        assertTrue("Error: setDistance() did not set correctly. Expected: 20.5.", route.getDistance() == 20.5);
    }

    @Test
    public void getDistanceUnit() throws Exception {
        assertEquals("Error: getDistanceUnit() did not return correctly. Expected: 'Miles'.", route.getDistanceUnit(), "Miles");
    }

    @Test
    public void setDistanceUnit() throws Exception {
        route.setDistanceUnit("Kilometers");
        assertEquals("Error: setDistanceUnit() did not set correctly. Expected: 'Kilometers'.", route.getDistanceUnit(), "Kilometers");
    }

    @Test
    public void getElevation() throws Exception {
        assertTrue("Error: getElevation() did not return correctly. Expected: 50.5.", route.getElevation() == 50.5);
    }

    @Test
    public void setElevation() throws Exception {
        route.setElevation(75.0);
        assertTrue("Error: setElevation() did not set correctly. Expected: 75.0.", route.getElevation() == 75.0);
    }

    @Test
    public void getElevationUnit() throws Exception {
        assertEquals("Error: getElevationUnit() did not return correctly. Expected: 'Feet'.", route.getElevationUnit(), "Feet");
    }

    @Test
    public void setElevationUnit() throws Exception {
        route.setElevationUnit("Meters");
        assertEquals("Error: getElevationUnit() did not set correctly. Expected: 'Meters'.", route.getElevationUnit(), "Meters");
    }

    @Test
    public void getAddressStartId() throws Exception {
        assertEquals("Error: getAddressStartId() did not return correctly. Expected: 0.", route.getAddressStartId(), 0);
    }

    @Test
    public void setAddressStartId() throws Exception {
        route.setAddressStartId(5);
        assertEquals("Error: setAddressStartId() did not set correctly. Expected: 5.", route.getAddressStartId(), 5);
    }

    @Test
    public void getUserId() throws Exception {
        assertEquals("Error: getUserId() did not return correctly. Expected: 0.", route.getUserId(), 0);
    }

    @Test
    public void setUserId() throws Exception {
        route.setUserId(5);
        assertEquals("Error: setUserId() did not set correctly. Expected: 5.", route.getUserId(), 5);
    }
}