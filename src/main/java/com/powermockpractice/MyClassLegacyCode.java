package com.powermockpractice;

public class MyClassLegacyCode {
	public String methodToTest (){
		return LegacyCode.getMessage();
	}
	public String methodToTestNotStatic(LegacyCode legacyCode){
		return legacyCode.getAnotherMessage();
	}
}
