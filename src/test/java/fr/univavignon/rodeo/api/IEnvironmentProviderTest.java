package fr.univavignon.rodeo.api;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IEnvironmentProviderTest {

	private IEnvironmentProvider envProviderMock;
	private List<String> envList;
	private IEnvironment envMock;

	public IEnvironmentProvider getInstance() {

		envProviderMock = mock(IEnvironmentProvider.class);
		envMock = mock(IEnvironment.class);

		envList = new ArrayList<>();
		String env1 = "Shadow Moses";
		String env2 = "Big shell";
		String env3 = "Mother Russia";

		envList.add(env1);
		envList.add(env2);
		envList.add(env3);

		when(envProviderMock.getAvailableEnvironments()).thenReturn(envList);
		when(envProviderMock.getEnvironment("Shadow Moses")).thenReturn(envMock);
		when(envProviderMock.getEnvironment(null)).thenThrow(IllegalArgumentException.class);

		return envProviderMock;
	}

	@Before
	public void setUp() {
		envProviderMock = getInstance();
	}

	@Test
	public void testGetAvailableEnvironment() {
		assertEquals(envProviderMock.getAvailableEnvironments(), envList);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetEnvironmentState() {
		envProviderMock.getEnvironment(null);
	}

	@Test
	public void testGetEnvironment() {
		assertEquals(envProviderMock.getEnvironment("Shadow Moses"), envMock);
	}

	@After
	public void tearDown() {
		envProviderMock = null;
	}
}
