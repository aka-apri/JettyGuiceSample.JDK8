package org.example.config;

import com.google.inject.Injector;
import org.example.startup.StartupServiceListener;
import org.glassfish.hk2.api.ServiceLocator;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;
import java.util.concurrent.ConcurrentHashMap;

@Provider
public class GuiceBridgeFeature implements Feature {

    @Inject
    private ServiceLocator serviceLocator;

    @Context
    private ServletContext servletContext;

    private static final String INJECTOR_NAME = Injector.class.getName();

    @Override
    public boolean configure(FeatureContext context) {
        Injector i = (Injector) servletContext.getAttribute(INJECTOR_NAME);
        var injector = InjectorStore.getByClass(StartupServiceListener.class);
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(injector);


        return true;
    }


    public static class InjectorStore {
        private final static ConcurrentHashMap<Class<?>, Injector> injectorHolder = new ConcurrentHashMap<>();

        public static Injector register(Class<?> clazz, Injector injector) {
            injectorHolder.put(clazz, injector);
            return injector;
        }

        public static Injector getByClass(Class<?> clazz) {
            return injectorHolder.get(clazz);
        }
    }
}
