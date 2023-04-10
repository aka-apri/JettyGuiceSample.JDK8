package org.example.startup;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class StartupServiceListener extends GuiceServletContextListener implements HttpSessionListener{

    private Logger logger = LoggerFactory.getLogger(StartupServiceListener.class);

    @Override
    protected Injector getInjector() {
        logger.info("Creating Injector");
        return Guice.createInjector();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
