package com.dogzz.germes.app.model.entity.geography;

import com.dogzz.germes.app.infra.util.CommonUtil;
import com.dogzz.germes.app.model.entity.base.AbstractEntity;
import com.dogzz.germes.app.model.entity.transport.TransportType;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Any locality that contains transport stations
 * Created by afon on 02.04.2016.
 */
public class City extends AbstractEntity{
    private String name;

    /**
     * Name of the district where city is placed
     */
    private String district;

    /**
     * Name of the region where district is located.
     * Region is top-level area in the country
     */
    private String region;

    /**
     * Set of transport stations that is linked to this locality
     */
    private Set<Station> stations;

    public City() {
    }

    public City (final String name) {
        this.name = name;
    }

    /**
     * Adds specified station to the city station list
     * @param transportType type of the added station
     */
    public Station addStation(final TransportType transportType) {
        if (stations == null) {
            stations = new HashSet<>();
        }
        Station station = new Station(this, transportType);
        stations.add(station);
        return station;
    }

    /**
     * Removes specified station from city station list
     * @param station
     */
    public void removeStation(Station station) {
        Objects.requireNonNull(station, "station parameter is not initialized");
        if (stations != null) {
            stations.remove(station);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Set<Station> getStations() {
        return CommonUtil.getSafeSet(stations);
    }

    public void setStations(Set<Station> stations) {
        this.stations = stations;
    }


}