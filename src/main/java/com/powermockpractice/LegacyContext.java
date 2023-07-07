package com.powermockpractice;

import java.net.MalformedURLException;
import java.net.URL;
 
public class LegacyContext {
 
	private static URL url;
	
	static{
		try {
			url = new URL("http://192.168.1.11/");
		} catch (MalformedURLException e) {
			throw new IllegalStateException(e);
		}
	}
	
	public static URL getUrl() {
		return url;
	}
 
}