package com.powermockpractice;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest( { LegacyContext.class})
public class StaticURLComposerTest {
	String esperado="http://localhost/";
	
	@Before
	public void setUp() throws MalformedURLException {
		
		//hace un mock de un metodo estatico
		PowerMockito.mockStatic(LegacyContext.class);
		when(LegacyContext.getUrl()).thenReturn(new URL(esperado));
	}
	
	@Test
	public void testMockStaticComposer() throws Exception {
		assertEquals(esperado+"ws/services/", LegacyURLComposer.getInstance().getWSServicesURL().toString());
	}

}