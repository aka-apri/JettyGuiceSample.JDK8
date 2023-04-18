package org.example.startup;

import org.example.api.HalloResource;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;

//@ApplicationPath("/api")
public class ApplicationConfig extends ResourceConfig {

    @Inject
    public ApplicationConfig(ServiceLocator serviceLocator) {
        ResourceConfig config = new ResourceConfig();
        config.register(HalloResource.class);
        config.packages("org.example.api", "org.example.service");
    }

}