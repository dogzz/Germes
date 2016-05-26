package com.dogzz.germes.app.model.entity.geography;

import com.dogzz.germes.app.model.entity.base.AbstractEntity;
import com.dogzz.germes.app.model.entity.transport.TransportType;
import com.dogzz.germes.app.model.search.criteria.StationCriteria;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 *Station where passengers can get off or take specific kind
 * of transport. Multiple stations compose route of the trip.
 * Created by afon on 02.04.2016.
 */
public class Station extends AbstractEntity{
    private City city;

    private Address address;

    /**
     * (Optional) Phone of the inquiry office
     */
    private String phone;

    private Coordinate coordinate;

    private TransportType transportType;

    /**
     * You shouldn't create station object directly. Use
     * {@link City} functionality instead
     * @param city which station belongs to
     * @param transportType of the station
     */
    public Station (final City city, final TransportType transportType) {
        this.city = Objects.requireNonNull(city);
        this.transportType = Objects.requireNonNull(transportType);
    }

    /**
     * Verifies if current station matches specified criteria
     * @param criteria
     * @return
     */
    public boolean match(final StationCriteria criteria) {
        Objects.requireNonNull(criteria, "Station criteria is not initialized");
        if(!StringUtils.isEmpty(criteria.getName())) {
            if(!city.getName().equals(criteria.getName())) {
                return false;
            }
        }

        if(criteria.getTransportType() != null) {
            if(transportType != criteria.getTransportType()) {
                return false;
            }
        }

        return true;
    }

    public City getCity() {
        return city;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public TransportType getTransportType() {
        return transportType;
    }

}
