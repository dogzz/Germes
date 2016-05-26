package com.dogzz.germes.app.service;

import com.dogzz.germes.app.model.entity.geography.City;
import com.dogzz.germes.app.model.entity.geography.Station;
import com.dogzz.germes.app.model.search.criteria.StationCriteria;
import com.dogzz.germes.app.model.search.criteria.range.RangeCriteria;

import java.util.List;
import java.util.Optional;

/**
 * Entry point to perform operations
 * over geographic entities
 * Created by afon on 02.04.2016.
 */
public interface GeographicService {

    /**
     * Returns list of existing cities
     * @return
     */
    List<City> findCities();

    /**
     * Saves specified city instance
     * @param city
     */
    void saveCity(City city);

    /**
     * Returns city with specified identifier. If no city is found then empty optional is
     * returned
     *
     * @param id
     * @return
     */
    Optional<City> findCityById(int id);

    /**
     * Returns all the stations that match specified criteria
     * @param criteria
     * @param rangeCriteria
     * @return
     */
    List<Station> searchStations(StationCriteria criteria, RangeCriteria rangeCriteria);

}
