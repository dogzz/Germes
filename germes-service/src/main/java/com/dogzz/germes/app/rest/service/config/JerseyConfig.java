package com.dogzz.germes.app.rest.service.config;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * REST web-service configuration for Jersey
 * Created by afon on 04.04.2016.
 */
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig{
    public JerseyConfig() {
        packages("com.dogzz.germes.app.rest");
    }
}
