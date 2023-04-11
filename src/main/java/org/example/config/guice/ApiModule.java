package org.example.config.guice;

import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import org.example.api.HalloResource;
import org.example.config.GuiceBridgeFeature;
import org.example.config.hk2.ApplicationBinder;
import org.example.service.ApiService;
import org.example.service.ApiServiceImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class ApiModule extends ServletModule {

    @Override
    protected void configureServlets() {
        bind(ApiService.class).to(ApiServiceImpl.class).in(Singleton.class);

        serve("/api/*").with(initApiServletContainer());
    }

    private ServletContainer initApiServletContainer() {
        ResourceConfig config = new ResourceConfig();
        config.register(GuiceBridgeFeature.class);
//        config.register(ApplicationBinder.class);
        config.register(HalloResource.class);
//        config.register(ApiBridgeInitializer.class);


        return new ServletContainer(config);
    }
}
