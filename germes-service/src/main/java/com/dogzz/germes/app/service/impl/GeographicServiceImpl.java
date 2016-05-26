package com.dogzz.germes.app.service.impl;

import com.dogzz.germes.app.infra.util.CommonUtil;
import com.dogzz.germes.app.model.entity.geography.City;
import com.dogzz.germes.app.model.entity.geography.Station;
import com.dogzz.germes.app.model.search.criteria.StationCriteria;
import com.dogzz.germes.app.model.search.criteria.range.RangeCriteria;
import com.dogzz.germes.app.service.GeographicService;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Default implementation of the {@link GeographicService}
 * Created by afon on 02.04.2016.
 */
public class GeographicServiceImpl implements GeographicService {

    private final List<City> cities;

    public GeographicServiceImpl () {
        cities = new ArrayList<City>();
    }

    @Override
    public List<City> findCities() {
        return CommonUtil.getSafeList(cities);
    }

    @Override
    public void saveCity(City city) {
        if (!cities.contains(city)) {
            cities.add(city);
        }
    }

    @Override
    public Optional<City> findCityById(final int id) {
        return cities.stream().filter((city) -> city.getId() == id).findFirst();
    }

    @Override
    public List<Station> searchStations(StationCriteria criteria, RangeCriteria rangeCriteria) {
        Set<Station> stations = new HashSet<>();
        for (City city : cities) {
            stations.addAll(city.getStations());
        }

        return stations.stream().filter((station) -> station.match(criteria)).collect(Collectors.toList());
    }
}
