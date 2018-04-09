package fr.univavignon.rodeo.api;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;



public class IAnimalTest {

	public IAnimal AnimalMock;

	@Before
	public void setUp() {
		AnimalMock = getInstance();
	}

	public IAnimal getInstance() {

		IAnimal AnimalMock = mock(IAnimal.class);
		when(AnimalMock.getXP()).thenReturn(100);
		when(AnimalMock.isSecret()).thenReturn(true);
		when(AnimalMock.isEndangered()).thenReturn(true);
		when(AnimalMock.isBoss()).thenReturn(true);

		return AnimalMock;
	}

	@Test
	public void testGetXP() {

		assertEquals(AnimalMock.getXP(), 100);
	}

	@Test
	public void testIsSecret() {
		assertEquals(AnimalMock.isSecret(), true);
	}

	@Test
	public void testIsEndangered() {
		assertEquals(AnimalMock.isEndangered(), true);
	}

	@Test
	public void testIsBoss() {
		assertEquals(AnimalMock.isBoss(), true);
	}


	@After
	public void tearDown() {
		AnimalMock = null;
	}
}