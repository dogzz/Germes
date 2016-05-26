package com.dogzz.germes.app.service.impl;

import com.dogzz.germes.app.model.entity.geography.City;
import com.dogzz.germes.app.model.entity.geography.Station;
import com.dogzz.germes.app.model.entity.transport.TransportType;
import com.dogzz.germes.app.model.search.criteria.StationCriteria;
import com.dogzz.germes.app.model.search.criteria.range.RangeCriteria;
import com.dogzz.germes.app.service.GeographicService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * tests for {@link GeographicServiceImpl} class
 * Created by afon on 02.04.2016.
 */
public class GeographicServiceImplTest {
    private static final int DEFAULT_CITY_ID = 1;
    private GeographicService service;

    @Before
    public void setup() {
        service = new GeographicServiceImpl();
    }

    @Test
    public void testNoDataReturnedAtStart() {
        List<City> cities = service.findCities();
        assertTrue(cities.isEmpty());
    }

    @Test
    public void testSaveNewCitySuccess() {
        City city = new City("Portland");
        service.saveCity(city);
        List<City> cities = service.findCities();
        assertEquals(cities.size(), 1);
        assertEquals(cities.get(0).getName(), "Portland");
    }


    @Test
    public void testFindCityByIdSuccess() {
        City city = new City("Odessa");
        city.setId(DEFAULT_CITY_ID);
        service.saveCity(city);

        Optional<City> foundCity = service.findCityById(DEFAULT_CITY_ID);
        assertTrue(foundCity.isPresent());
        assertEquals(foundCity.get().getId(), DEFAULT_CITY_ID);
    }

    @Test
    public void testFindCityByIdNotFound() {
        Optional<City> foundCity = service.findCityById(DEFAULT_CITY_ID);
        assertFalse(foundCity.isPresent());
    }

    @Test
    public void testSearchStationsByNameSuccess() {
        City city = new City("Odessa");
        city.setId(DEFAULT_CITY_ID);
        city.addStation(TransportType.AUTO);
        city.addStation(TransportType.RAILWAY).setId(2);
        service.saveCity(city);

        List<Station> stations = service.searchStations(StationCriteria.byName("Odessa"), new RangeCriteria(1, 5));
        assertNotNull(stations);
        assertEquals(1, stations.size());
        assertEquals(stations.get(0).getCity(), city);
    }

    @Test
    public void testSearchStationsByNameNotFound() {
        List<Station> stations = service.searchStations(StationCriteria.byName("Odessa"), new RangeCriteria(1, 5));
        assertNotNull(stations);
        assertTrue(stations.isEmpty());
    }

    @Test
    public void testSearchStationsByTransportTypeSuccess() {
        City city = new City("Odessa");
        city.addStation(TransportType.AUTO);
        service.saveCity(city);
        City city2 = new City("Kiev");
        city2.setId(2);
        city2.addStation(TransportType.AUTO).setId(2);
        service.saveCity(city2);

        List<Station> stations = service.searchStations(new StationCriteria(TransportType.AUTO), new RangeCriteria(1, 5));
        assertNotNull(stations);
        assertEquals(2, stations.size());
    }

    @Test
    public void testSearchStationsByTransportTypeNotFound() {
        City city = new City("Odessa");
        city.addStation(TransportType.AUTO);
        service.saveCity(city);
        City city2 = new City("Kiev");
        city2.setId(2);
        city2.addStation(TransportType.RAILWAY);
        service.saveCity(city2);

        List<Station> stations = service.searchStations(new StationCriteria(TransportType.AVIA), new RangeCriteria(1, 5));
        assertNotNull(stations);
        assertTrue(stations.isEmpty());
    }

}