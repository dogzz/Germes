package com.dogzz.germes.app.model.entity.geography;

import com.dogzz.germes.app.model.entity.transport.TransportType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for {@link City} class
 * Created by afon on 02.04.2016.
 */
public class CityTest {

    private City city;

    @Before
    public void setup() {
        city = new City("Portland");
    }

    @Test
    public void testAddValidStationSuccess() {
        Station station = city.addStation(TransportType.AUTO);
        assertTrue(containsStation(city, station));
        assertEquals(city, station.getCity());
    }

    @Test (expected = NullPointerException.class)
    public void testAddStationNullTransportTypeFailure() {
        city.addStation(null);
        assertTrue(false);
    }

    @Test
    public void testRemoveStationSuccess() {
        Station station = city.addStation(TransportType.RAILWAY);
        city.removeStation(station);
        assertFalse(city.getStations().contains(station));
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveNullStationFailure() {
        city.removeStation(null);
        assertTrue(false);
    }

    private boolean containsStation(City city, Station station) {
        return city.getStations().contains(station);
    }

}