package com.javaworld.sample.service.impl;
import com.javaworld.sample.service.HelloGyroskope;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

	public class HelloGyroskopeActivator implements BundleActivator  {
		
		 ServiceRegistration GyroskopeServiceRegistration;
		 
		 public void start(BundleContext context) throws Exception {
    	
    	    //registration of service
            HelloGyroskope helloGyroskope = new HelloGyroskopeImpl();
            GyroskopeServiceFactory gyroskopeServiceFactory = new GyroskopeServiceFactory();
            GyroskopeServiceRegistration = context.registerService(HelloGyroskope.class.getName(), helloGyroskope, null);
    	
    }
    
    
		 public void stop(BundleContext context) throws Exception {
			 GyroskopeServiceRegistration.unregister();	
    }
}
