package com.javaworld.sample.service.impl;

import android.app.Activity;

import com.javaworld.sample.service.HelloGyroskope;


	public class HelloGyroskopeImpl extends Activity implements HelloGyroskope /*, SensorEventListener*/ {

		/*private SensorManager sensorManager;	  	  
		Sensor temperature;
		EventListener event;*/
 	    
		@Override
		public String values(){
			int a = 14;
			        // Get an instance of the SensorManager
		/*	sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);	       
			        
			
			if(sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE).size()!=0)
			{
				temperature = sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE).get(0);
			    sensorManager.registerListener((SensorEventListener) this,temperature, SensorManager.SENSOR_DELAY_NORMAL);        		    
			}
			else
			{ 	        		        		   
				//////////////////////////////logString message = "Sorry!Sensor not found";
				// Create the text view				
				return null; 		          		           
			}	
			return "";
			   */
			return "A's value is:"+a;
		}
		
/*
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSensorChanged(SensorEvent event) {
			// TODO Auto-generated method stub
			
		}			
	
			  /*  @Override
			    public void onSensorChanged(SensorEvent event) {     	 
		        		       
		          //else it will output the Roll, Pitch and Yawn values  
		        /////////    textView.setText("Orientation X (Roll) :"+ Float.toString(event.values[2]) +"\n"+  
		           //            "Orientation Y (Pitch) :"+ Float.toString(event.values[1]) +"\n"+  
		           //           "Orientation Z (Yaw) :"+ Float.toString(event.values[0]));
			 
			    }
	
				*/
			
	}
