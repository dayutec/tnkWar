package DP07;

import java.util.ArrayList;
import java.util.List;

public class TestBemcommon {

	
	
	private static List extractDnsIpAddress(String ipAddresses){
	   	final List dnsAddresses = new ArrayList();
	   	int end = 0;
	   	String ipAddress = "";
	   	while(ipAddresses.length() > 0){
	   	    ipAddresses = ipAddresses.trim();
	   	    end = ipAddresses.indexOf(",");
	   	    if(end > 0){
	   		ipAddress = ipAddresses.substring(0,end);
	   		ipAddresses = ipAddresses.substring(end+1);
	   		  
	   		ipAddresses = ipAddresses.trim();
	   		ipAddress = ipAddress.trim(); 
	   	    }
	   	    else{
	   		ipAddress = ipAddresses;
	   		ipAddresses = "";   		    
	   	    }
	   	    dnsAddresses.add(ipAddress);
	   	}
	   	
	   	return dnsAddresses;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ipString ="1.1.1.a,      1.1.1.2 ";
		List ls = extractDnsIpAddress(ipString);
		System.out.println(ls);
	}

}
