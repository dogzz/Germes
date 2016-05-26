package com.dogzz.germes.app.model.search.criteria;

import com.dogzz.germes.app.model.entity.geography.Address;
import com.dogzz.germes.app.model.entity.transport.TransportType;

import java.util.Objects;

/**
 * Filtering criteria for search stations operation
 * Created by afon on 03.04.2016.
 */
public class StationCriteria {
    private String name;
    private TransportType transportType;
    private Address address;
    /**
     * Returns filtering criteria to search stations that
     * contains specified name parameter
     * @param name
     * @return
     */
    public static StationCriteria byName(String name) {
        return new StationCriteria(name);
    }

    public StationCriteria() {
    }

    private StationCriteria(final String name) {
        this.name = Objects.requireNonNull(name);
    }

    public StationCriteria(final TransportType transportType) {
        this.transportType = Objects.requireNonNull(transportType);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
