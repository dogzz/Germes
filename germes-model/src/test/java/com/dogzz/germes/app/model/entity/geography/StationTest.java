package com.dogzz.germes.app.model.entity.geography;

import com.dogzz.germes.app.model.entity.transport.TransportType;
import com.dogzz.germes.app.model.search.criteria.StationCriteria;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Verifies functionality of the {@link Station} domain entity
 * Created by afon on 06.04.2016.
 */
public class StationTest {
    @Test(expected=NullPointerException.class)
    public void testMatchCriteriaNotInitialized() {
        City city = new City("Odessa");
        Station station = new Station(city, TransportType.AUTO);

        station.match(null);
    }

    @Test
    public void testMatchByNameSuccess() {
        City city = new City("Odessa");
        Station station = new Station(city, TransportType.AUTO);

        assertTrue(station.match(StationCriteria.byName("Odessa")));
    }

    @Test
    public void testMatchByNameNotFound() {
        City city = new City("Odessa");
        Station station = new Station(city, TransportType.AUTO);

        assertFalse(station.match(StationCriteria.byName("Kiev")));
    }
}