package com.javaworld.sample.service.impl;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

import com.javaworld.sample.service.HelloGyroskope;

public class GyroskopeServiceFactory implements ServiceFactory{
    private int usageCounter = 0;
    
    public Object getService(Bundle bundle, ServiceRegistration registration) {
        System.out.println("Create object of HelloGyroskope for " + bundle.getSymbolicName());
        usageCounter++;
        System.out.println("Number of bundles using service " + usageCounter);
        HelloGyroskope helloGyroskope = new HelloGyroskopeImpl();
        return helloGyroskope;
    }
    public void ungetService(Bundle bundle, ServiceRegistration registration, Object service) {
        System.out.println("Release object of HelloGyroskope for " + bundle.getSymbolicName());
        usageCounter--;
        System.out.println("Number of bundles using service " + usageCounter);
    }
}
