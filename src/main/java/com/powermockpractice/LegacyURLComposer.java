package com.powermockpractice;

public class LegacyURLComposer implements URLComposer{

	private static LegacyURLComposer instance;
	
	public LegacyURLComposer(){
		
	}

	public static LegacyURLComposer getInstance(){
		if (instance == null){
			instance = new LegacyURLComposer();
		}
		return instance;
	}
	
	public String getWSServicesURL() {
		return LegacyContext.getUrl() + "ws/services/";
	}
	
	public String getRestServicesURL() {
		return LegacyContext.getUrl() + "rest/services/";
	}

}