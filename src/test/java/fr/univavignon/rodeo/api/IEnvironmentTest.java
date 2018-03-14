package fr.univavignon.rodeo.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IEnvironmentTest {

	public IEnvironment envMock;
	public List<ISpecie> specList;

	public IEnvironment getInstance() {

		IEnvironment envMock = mock(IEnvironment.class);

		specList = new ArrayList<>();
		ISpecie	specMock1 = mock(ISpecie.class);
		ISpecie	specMock2 = mock(ISpecie.class);
		ISpecie	specMock3 = mock(ISpecie.class);
		specList.add(specMock1);
		specList.add(specMock2);
		specList.add(specMock3);

		when(envMock.getAreas()).thenReturn(10);
		when(envMock.getSpecies()).thenReturn(specList);

		return envMock;
	}

	@Before
	public void setup() {
		envMock = getInstance();
	}

	@Test
	public void testGetAreas() {
		assertEquals(envMock.getAreas(), 10);
	}

	@Test
	public void testGetSpecies() {
		assertEquals(envMock.getSpecies(), specList);
	}
}
