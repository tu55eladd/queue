package com.feasible.queue;

import android.app.Fragment;
import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.DiscoveryListener;
import android.net.nsd.NsdServiceInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DiscoveryFramgent extends Fragment {

	DiscoveryListener discoveryListener;
	NsdManager nsdManager;
	String serviceName = "QueueService";
	final String serviceType = "_http._tcp.";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
		nsdManager = (NsdManager) getActivity().getSystemService(Context.NSD_SERVICE);
		
		return null;
	}
	
	public void initializeDiscoveryListener(){
		
		discoveryListener = new DiscoveryListener() {
			
			@Override
			public void onStopDiscoveryFailed(String serviceType, int errorCode) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartDiscoveryFailed(String serviceType, int errorCode) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onServiceLost(NsdServiceInfo serviceInfo) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onServiceFound(NsdServiceInfo service) {
				if (!service.getServiceType().equals(serviceType)) {
	                // Service type is the string containing the protocol and
	                // transport layer for this service.
	                //Log.d(TAG, "Unknown Service Type: " + service.getServiceType());
	            } else if (service.getServiceName().equals(serviceName)) {
	                // The name of the service tells the user what they'd be
	                // connecting to. It could be "Bob's Chat App".
	                //Log.d(TAG, "Same machine: " + serviceName);
	            } else if (service.getServiceName().contains("NsdChat")){
	                nsdManager.resolveService(service, mResolveListener);
	            }
				
			}
			
			@Override
			public void onDiscoveryStopped(String serviceType) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onDiscoveryStarted(String serviceType) {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
