package com.powermockpractice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
@RunWith(PowerMockRunner.class)
@PrepareForTest(LegacyCode.class)
public class MyClassTest {
	@Test
	public void testLegacyCode(){
		String expected="Lo que diga el mock";
		
		MyClassLegacyCode myClass = new MyClassLegacyCode();
		LegacyCode mockLegacyCode = mock(LegacyCode.class);
		
		when(mockLegacyCode.getAnotherMessage()).thenReturn(expected);
		
		String actual=myClass.methodToTestNotStatic(mockLegacyCode);
		assertEquals(expected, actual);
		
		verify(mockLegacyCode, times(1)).getAnotherMessage();
	}
	
	//prueba static
	@Test
	public void testMockLegacyCode(){
		
		String expected="Esto ya es otra cosa";
		mockStatic(LegacyCode.class);
		when(LegacyCode.getMessage()).thenReturn(expected);
		
		MyClassLegacyCode myClass = new MyClassLegacyCode();
		String actual = myClass.methodToTest();
		assertEquals(expected, actual);
	}
}