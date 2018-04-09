package fr.univavignon.rodeo.api;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IGameStateTest {

	private IGameState gameStateMock;
	private IAnimal animalMock;
	private ISpecie specieMock;

	public IGameState getInstance() {

		gameStateMock = mock(IGameState.class);
		animalMock = mock(IAnimal.class);
		specieMock = mock(ISpecie.class);

		doThrow(IllegalStateException.class).when(gameStateMock).exploreArea();

		doThrow(IllegalArgumentException.class).when(gameStateMock).catchAnimal(null);
		doThrow(IllegalStateException.class).when(gameStateMock).catchAnimal(animalMock);

		doThrow(IllegalArgumentException.class).when(gameStateMock).getSpecieLevel(null);
		when(gameStateMock.getSpecieLevel(specieMock)).thenReturn(SpecieLevel.MASTER);



		/*when(EnvProviderMock.getAvailableEnvironments()).thenReturn(envList);
		when(EnvProviderMock.getEnvironment("Shadow Moses")).thenReturn(env);
		when(EnvProviderMock.getEnvironment(null)).thenThrow(IllegalArgumentException.class);
		*/
		return gameStateMock;
	}

	@Before
	public void setUp() {
		gameStateMock = getInstance();
	}

	@Test(expected = IllegalStateException.class)
	public void testExploreArea() {
		gameStateMock.exploreArea();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCatchAnimalArg() {
		gameStateMock.catchAnimal(null);
	}

	@Test(expected = IllegalStateException.class)
	public void testCatchAnimalState() {
		gameStateMock.catchAnimal(animalMock);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetSpecieLevelArg() {
		gameStateMock.getSpecieLevel(null);
	}

	@Test
	public void testGetSpecieLevel() {
		assertEquals(gameStateMock.getSpecieLevel(specieMock), SpecieLevel.MASTER);
	}

	@After
	public void tearDown() {
		gameStateMock = null;
	}
}
