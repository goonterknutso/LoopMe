package com.loopme.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A class to test the Leg class
 *
 * @author Gunther Knutson
 */
public class LegTest {

    Leg leg;

    @Before
    public void setUp() throws Exception {
        leg = new Leg(1.0, "Miles", 6.0, "Feet", 0, 1, 0);
        leg.setLegId(0);
    }

    @Test
    public void getLegId() throws Exception {
        assertEquals("Error: getLegId() did not return correctly. Expected: 0.", leg.getLegId(), 0);
    }

    @Test
    public void setLegId() throws Exception {
        leg.setLegId(1);
        assertEquals("Error: setRouteId() did not set correctly. Expected: 1.", leg.getLegId(), 1);
    }

    @Test
    public void getDistance() throws Exception {
        assertTrue("Error: getDistance() did not return correctly. Expected: 1.0.", leg.getDistance() == 1.0);

    }

    @Test
    public void setDistance() throws Exception {
        leg.setDistance(20.5);
        assertTrue("Error: setDistance() did not set correctly. Expected: 20.5.", leg.getDistance() == 20.5);
    }

    @Test
    public void getDistanceUnit() throws Exception {
        assertEquals("Error: getDistanceUnit() did not return correctly. Expected: 'Miles'.", leg.getDistanceUnit(), "Miles");
    }

    @Test
    public void setDistanceUnit() throws Exception {
        leg.setDistanceUnit("Kilometers");
        assertEquals("Error: setDistanceUnit() did not set correctly. Expected: 'Kilometers'.", leg.getDistanceUnit(), "Kilometers");
    }

    @Test
    public void getElevation() throws Exception {
        assertTrue("Error: getElevation() did not return correctly. Expected: 50.5.", leg.getElevation() == 6.0);
    }

    @Test
    public void setElevation() throws Exception {
        leg.setElevation(75.0);
        assertTrue("Error: setElevation() did not set correctly. Expected: 75.0.", leg.getElevation() == 75.0);
    }

    @Test
    public void getElevationUnit() throws Exception {
        assertEquals("Error: getElevationUnit() did not return correctly. Expected: 'Feet'.", leg.getElevationUnit(), "Feet");
    }

    @Test
    public void setElevationUnit() throws Exception {
        leg.setElevationUnit("Meters");
        assertEquals("Error: getElevationUnit() did not set correctly. Expected: 'Meters'.", leg.getElevationUnit(), "Meters");
    }

    @Test
    public void getAddressStartId() throws Exception {
        assertEquals("Error: getAddressStartId() did not return correctly. Expected: 0.", leg.getAddressStartId(), 0);
    }

    @Test
    public void setAddressStartId() throws Exception {
        leg.setAddressStartId(5);
        assertEquals("Error: setAddressStartId() did not set correctly. Expected: 5.", leg.getAddressStartId(), 5);
    }

    @Test
    public void getAddressEndId() throws Exception {
        assertEquals("Error: getAddressStartId() did not return correctly. Expected: 1.", leg.getAddressEndId(), 1);
    }

    @Test
    public void setAddressEndId() throws Exception {
        leg.setAddressEndId(5);
        assertEquals("Error: setAddressStartId() did not set correctly. Expected: 5.", leg.getAddressEndId(), 5);
    }

    @Test
    public void getRouteId() throws Exception {
        assertEquals("Error: getAddressStartId() did not return correctly. Expected: 0.", leg.getRouteId(), 0);
    }

    @Test
    public void setRouteId() throws Exception {
        leg.setRouteId(8);
        assertEquals("Error: setAddressStartId() did not return correctly. Expected: 8.", leg.getRouteId(), 8);
    }

}