package com.dogzz.germes.app.rest.dto;

import com.dogzz.germes.app.model.entity.geography.City;
import com.dogzz.germes.app.rest.dto.base.BaseDTO;

/**
 * Holds city state for the client-server communication
 * Created by afon on 05.04.2016.
 */
public class CityDTO extends BaseDTO<City> {
    private String name;

    private String district;

    private String region;

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
}
