package fr.univavignon.rodeo.api;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ISpecieTest {

	private ISpecie specMock;
	private ArrayList<IAnimal> animaList;

	private ISpecie getInstance() {
		specMock = mock(ISpecie.class);

		when(specMock.getArea()).thenReturn(10);

		animaList = new ArrayList<>();
		IAnimal	animalMock1 = mock(IAnimal.class);
		IAnimal	animalMock2 = mock(IAnimal.class);
		IAnimal	animalMock3 = mock(IAnimal.class);
		animaList.add(animalMock1);
		animaList.add(animalMock2);
		animaList.add(animalMock3);
		when(specMock.getAnimals()).thenReturn(animaList);

		return specMock;
	}

	@Before
	public void setUp() {
		specMock = getInstance();
	}

	@Test
	public void testGetArea() {
		assertEquals(specMock.getArea(), 10);
	}

	@Test
	public void testGetAnimals() {
		assertEquals(specMock.getAnimals(), animaList);
	}

	@After
	public void tearDown() {
		specMock = null;
	}
}

