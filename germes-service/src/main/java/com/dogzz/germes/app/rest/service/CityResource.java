package com.dogzz.germes.app.rest.service;

import com.dogzz.germes.app.model.entity.geography.City;
import com.dogzz.germes.app.model.entity.transport.TransportType;
import com.dogzz.germes.app.rest.dto.CityDTO;
import com.dogzz.germes.app.rest.service.base.BaseResource;
import com.dogzz.germes.app.service.GeographicService;
import com.dogzz.germes.app.service.impl.GeographicServiceImpl;
import com.dogzz.germes.app.service.transform.Transformer;
import com.dogzz.germes.app.service.transform.impl.SimpleDTOTransformer;
import jersey.repackaged.com.google.common.collect.Lists;
import org.apache.commons.lang3.math.NumberUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * {@link CityResource} is REST web-service that handles city-related requests
 * Created by afon on 04.04.2016.
 */
@Path("cities")
public class CityResource extends BaseResource {

    private final GeographicService service;
    private final Transformer transformer;

    public CityResource() {
        transformer = new SimpleDTOTransformer();
        service = new GeographicServiceImpl();
        City city = new City("Odessa");
        city.setId(1);
        city.addStation(TransportType.AUTO);
        service.saveCity(city);
        City city2 = new City("Portland");
        city2.setId(2);
        city2.addStation(TransportType.AVIA);
        service.saveCity(city2);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CityDTO> findCities() {
        return service.findCities().stream().map((city) -> transformer.transform(city, CityDTO.class))
                .collect(Collectors.toList());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCity(CityDTO cityDTO) {
        service.saveCity(transformer.untransform(cityDTO, City.class));
    }
    @Path("/{cityId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCityById(@PathParam("cityId") final String cityId) {
        if(!NumberUtils.isNumber(cityId)) {
            return BAD_REQUEST;
        }

        Optional<City> city = service.findCityById(NumberUtils.toInt(cityId));
        if (!city.isPresent()) {
            return NOT_FOUND;
        }
        return ok(transformer.transform(city.get(), CityDTO.class));
    }
}
