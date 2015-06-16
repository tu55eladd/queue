package com.feasible.queue;

import android.app.Fragment;
import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.RegistrationListener;
import android.net.nsd.NsdServiceInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RegisterFragment extends Fragment{

	NsdServiceInfo serviceInfo;
	NsdManager.RegistrationListener regListener;
	NsdManager nsdManager;
	String serviceType = "_http._tcp.";
	String serviceName = "QueueService";
	String givenServiceName;
	int localNsdPort;
	
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState){
		 
		 registerService(0);
		 
		 return null;
	 }
	 
	 
	 public void registerService(int port){
		 
		 serviceInfo = new NsdServiceInfo();
		 serviceInfo.setServiceType(serviceName);
		 serviceInfo.setServiceName(serviceType);
		 serviceInfo.setPort(port);
		 
		 nsdManager = (NsdManager) getActivity().getSystemService(Context.NSD_SERVICE);
		 
		 nsdManager.registerService(serviceInfo, NsdManager.PROTOCOL_DNS_SD, regListener);
	 }

	 public void initializeRegistrationListener(){
		 regListener = new NsdManager.RegistrationListener() {

		        @Override
		        public void onServiceRegistered(NsdServiceInfo NsdServiceInfo) {
		            // Save the service name.  Android may have changed it in order to
		            // resolve a conflict, so update the name you initially requested
		            // with the name Android actually used.
		            givenServiceName = NsdServiceInfo.getServiceName();
		        }

		        @Override
		        public void onRegistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
		            // Registration failed!  Put debugging code here to determine why.
		        }

		        @Override
		        public void onServiceUnregistered(NsdServiceInfo arg0) {
		            // Service has been unregistered.  This only happens when you call
		            // NsdManager.unregisterService() and pass in this listener.
		        }

		        @Override
		        public void onUnregistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
		            // Unregistration failed.  Put debugging code here to determine why.
		        }
		    };
	 }
	 
}
