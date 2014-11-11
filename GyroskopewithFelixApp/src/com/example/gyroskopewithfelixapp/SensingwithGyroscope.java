package com.example.gyroskopewithfelixapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;
//import android.view.View;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.felix.framework.Felix;
import org.apache.felix.framework.util.FelixConstants;
import org.osgi.framework.BundleContext;
//import org.osgi.util.tracker.ServiceTracker;



//import java.util.Properties;

///import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleException;
//import org.osgi.framework.Constants;
//import org.osgi.framework.InvalidSyntaxException;
//import org.osgi.framework.ServiceReference;
//import org.osgi.util.tracker.ServiceTrackerCustomizer;


import java.util.LinkedList;


//import com.javaworld.sample.service.HelloGyroskope;
//import com.javaworld.sample.service.impl.HelloGyroskopeActivator;
//import android.provider.ContactsContract.Directory;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.TextView;



	public class SensingwithGyroscope extends Activity{
		
		TextView label = null;
		private Felix m_felix=null;  
		//private HelloGyroskopeActivator m_activator = null;
		//private ServiceTracker m_tracker = null;
		//private HostActivator m_activator=null;
	 

	    @Override
	    protected void onCreate(Bundle savedInstanceState) 
	    {
	        super.onCreate(savedInstanceState); 
	        
	        setContentView(R.layout.activity_sensingwith_gyroscope);
	        launchFelix();
	        
	       // setContentView(label);      
	    }
	    
	    void launchFelix ()
	     {   	
	    	LogEx("About to start Felix...");
	    	
	    	
	    	File cacheDir = null;
	    	try
	    	{
	    	
	    		cacheDir = File.createTempFile("felix-cache",".tmp");
	    		
	    	}
	    	catch (IOException e)
	    	{
	    		Log.d("Felix","unable to create tmp file", e);
	    	}
	    
	    	cacheDir.delete();
	    	// Create a configuration property map.
	    
			Map<String, Object> configMap = new HashMap<String, Object>();	    	
            // Create host activator;
           // m_activator = new HostActivator();
            List<Object> list = new ArrayList<Object>();
           // list.add(m_activator);
//	    	//store bundles in SD card
//	    	configMap.put("org.osgi.framework.storage", getString(R.string._mnt_sdcard_felix_cachedir));
//	    	configMap.put("felix.embedded.execution", "true");
//	    	//change felix configuration so as to use android API
	    	configMap.put("org.osgi.framework.system.packages.extra", "android.*");
//	    	configMap.put("felix.auto.deploy.dir", getString(R.string._mnt_sdcard_felix_bundle));
//	    	configMap.put(FelixConstants.SYSTEMBUNDLE_ACTIVATORS_PROP, list);
//	    	configMap.put("org.osgi.service.http.port", "9990");
//	    	configMap.put("org.osgi.framework.startlevel.beginning", "5");
	    	

			configMap.put("org.osgi.framework.storage", cacheDir.getParent());
			configMap.put("felix.embedded.execution", "true");
			configMap.put("org.osgi.service.http.port", "9990");
			configMap.put("org.osgi.framework.startlevel.beginning", "5");
	    	
	    	
	    	//configMap.put(FelixConstants.FRAMEWORK_STORAGE, cacheDir.getAbsolutePath());
	    	
           
	    	
	    	try   
	    	{
	    	    m_felix = new Felix(configMap);    		
	    		m_felix.start();
	    		LogEx("Felix is started");
	    		
	    		LogEx("Started felix bundles:");          
	    		for(org.osgi.framework.Bundle b : m_felix.getBundleContext().getBundles())
	    			LogEx("Bundle:" + b.getSymbolicName()); 
	    		LogEx("END of Started felix bundles"); 
	    	}
	    	catch (Throwable ex)
	    	{
	    	Log.d("Felix", "Could not create framework: " + ex.getMessage(), ex);	
	    	}

	    	LogEx("About to install mybundles...");
	    	
	    	//install the bundle HelloGyroskope
    		BundleContext bc=m_felix.getBundleContext();
    		List<org.osgi.framework.Bundle> installedBundles = new LinkedList<org.osgi.framework.Bundle>();

    		try {
    			//com.google.dexmaker.DexMakerDexMaker dsfds;
    			//installedBundles.add(context.installBundle("file:storage/extSdCard/Files/temp/com.javaworld.sample.HelloService_1.0.0.201410011449.jar"));
    			//installedBundles.add(context.installBundle("file:storage/extSdCard/Files/temp/com.javaworld.sample.HelloWorld_1.0.0.201410011449.jar"));
    			
    		//	installedBundles.add(bc.installBundle("file:storage/extSdCard/Files/temp/android-felix/bundle/org.apache.felix.shell.tui-1.0.2.jar"));
    			//installedBundles.add(bc.installBundle("file:storage/extSdCard/Files/temp/android-felix/bundle/org.apache.felix.shell-1.0.2.jar"));
    			//installedBundles.add(bc.installBundle("file:storage/extSdCard/Files/temp/android-felix/bundle/EnglishDictionary.jar"));
    			//installedBundles.add(bc.installBundle("file:storage/extSdCard/Files/temp/android-felix/bundle/FrenchDictionary.jar"));
    			//installedBundles.add(bc.installBundle("file:storage/extSdCard/Files/temp/android-felix/bundle/SpellChecker.jar"));
    			installedBundles.add(bc.installBundle("file:mnt/ext_card/gyr2.jar"));
    			LogEx("Mybundles install succ...");
    		} 
    		catch (BundleException e) 
    		{

    			LogEx("Additional Bundles were not installed");
    			LogEx(e.getMessage());
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	//	bc.installBundle("C:/Users/Vitsas/Desktop/felix-framework-4.4.1/bundle/HelloGyroskope.jar");
          	  
    		LogEx("The following bundles are now installed...");
    		for(org.osgi.framework.Bundle b : m_felix.getBundleContext().getBundles())
    			LogEx("Bundle: "+ b.getSymbolicName()+ ",ID: "+b.getBundleId());
	    	// m_tracker = new ServiceTracker(
	    	// m_activator.getContext(), HelloGyroskope.class.getName(), null);
	    	// m_tracker.open();
    		LogEx("About to start the installed bundles..");
    		for (org.osgi.framework.Bundle bundle : installedBundles) 
    		{ 
    		    try {
    				bundle.start();
    				LogEx("Bundle: "+ bundle.getSymbolicName()+ " started succesfully...");
    			} catch (BundleException e) {
    				LogEx("Bundle not started: ");
    				// TODO Auto-generated catch block
    				LogEx(e.getMessage());
    			}
    		}
	    	
	     }
	    	  	
	    	public void LogEx(String info)
	    	{
	    		///TextView label=new TextView(this);
	    		Log.d("Felix", info);
	    		
	    		if(label == null)
	    			label = (TextView) findViewById(R.id.text_view);
	    		if(label != null)	    			
	    			label.setText(label.getText() + info + "\n");
	    	}
	    
	    
	}
 