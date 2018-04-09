package fr.univavignon.rodeo.api;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IGameStateProviderTest {

	private IGameStateProvider gsProviderMock;
	private IGameState gsMock;


	public IGameStateProvider getInstance() {

		gsProviderMock = mock(IGameStateProvider.class);
		gsMock = mock(IGameState.class);

		when(gsProviderMock.get(null)).thenThrow(IllegalArgumentException.class);
		when(gsProviderMock.get("pause")).thenReturn(gsMock);

		return gsProviderMock;
	}

	@Before
	public void setUp() {
		gsProviderMock = getInstance();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetArg() {
		gsProviderMock.get(null);
	}

	@Test
	public void testGet() {
		assertEquals(gsProviderMock.get("pause"), gsMock);
	}

	@After
	public void tearDown() {
		gsProviderMock = null;
	}
}
