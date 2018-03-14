package fr.univavignon.rodeo.api;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;



public class IAnimalTest {

	IAnimal AnimalMock;

	@Before
	public void setUp() {

		AnimalMock = mock(IAnimal.class);
		when(AnimalMock.getXP()).thenReturn(100);
	}

	@Test
	public void testGetXP() {

		assertEquals(AnimalMock.getXP(), 100);
	}


	@After
	public void tearDown() {

		AnimalMock = null;
	}

	/*

	boolean isSecret();


	boolean isEndangered();


	boolean isBoss();
*/
}
