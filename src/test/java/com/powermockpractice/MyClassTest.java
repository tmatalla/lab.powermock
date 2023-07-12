package com.powermockpractice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

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
	public void testFinalLegacyCode(){
		System.out.println("MyClassTest.testFinalLegacyCode");
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
	public void testStaticLegacyCode(){
		System.out.println("MyClassTest.testStaticLegacyCode");
		String expected="Esto ya es otra cosa";
		mockStatic(LegacyCode.class);
		when(LegacyCode.getMessage()).thenReturn(expected);
		
		MyClassLegacyCode myClass = new MyClassLegacyCode();
		String actual = myClass.methodToTest();
		assertEquals(expected, actual);
	}
	
	//private
	@Test
	public void testPrivateLegacyCode()  {
		System.out.println("MyClassTest.testPrivateLegacyCode");
		String expected="Esto ya es otra cosa";
		//mock de la clase que tiene el método private
		LegacyCode mock = PowerMockito.spy(new LegacyCode());
		
		String actual = "";
		try {
		//When
		PowerMockito.doReturn(expected).when(mock,"getPrivateMessage");
		
		//lanzar la llamada
		actual = Whitebox.invokeMethod(mock, "getPrivateMessage");
		}catch (Exception e) {
			System.out.println("MyClassTest.testPrivateLegacyCode exception:"+e.getMessage());
		}
		
		assertEquals(expected, actual);
	}
	
}