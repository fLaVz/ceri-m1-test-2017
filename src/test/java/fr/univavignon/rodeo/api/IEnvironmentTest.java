package fr.univavignon.rodeo.api;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IEnvironmentTest {

	private IEnvironment EnvMock;
	private List<ISpecie> specList;

	public IEnvironment getInstance() {

		IEnvironment EnvMock = mock(IEnvironment.class);

		specList = new ArrayList<>();
		ISpecie	specMock1 = mock(ISpecie.class);
		ISpecie	specMock2 = mock(ISpecie.class);
		ISpecie	specMock3 = mock(ISpecie.class);
		specList.add(specMock1);
		specList.add(specMock2);
		specList.add(specMock3);

		when(EnvMock.getAreas()).thenReturn(10);
		when(EnvMock.getSpecies()).thenReturn(specList);

		return EnvMock;
	}

	@Before
	public void setUp() {
		EnvMock = getInstance();
	}

	@Test
	public void testGetAreas() {
		assertEquals(EnvMock.getAreas(), 10);
	}

	@Test
	public void testGetSpecies() {
		assertEquals(EnvMock.getSpecies(), specList);
	}

	@After
	public void tearDown() {
		EnvMock = null;
	}
}
