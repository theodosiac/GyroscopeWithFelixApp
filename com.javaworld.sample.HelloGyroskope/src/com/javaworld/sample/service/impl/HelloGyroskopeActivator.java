package com.javaworld.sample.service.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


import com.javaworld.sample.service.HelloGyroskope;

	public class HelloGyroskopeActivator implements BundleActivator  {
		
		 ServiceRegistration<?> GyroskopeServiceRegistration;
		 
		 public void start(BundleContext context) throws Exception {
    	
    	    //registration of service
            HelloGyroskope helloGyroskope = new HelloGyroskopeImpl();
            GyroskopeServiceRegistration = context.registerService(HelloGyroskope.class.getName(), helloGyroskope, null);
    	
    }
    
    
		 public void stop(BundleContext context) throws Exception {
			 GyroskopeServiceRegistration.unregister();	
    }
}
