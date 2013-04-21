package AgileDevCourse.QA2.Publisher.HandCraftedInjection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegistrationTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void getUserDataIsCalled() {
		ExternalMockRegistrator mock = new ExternalMockRegistrator();
		UsersStubRepository stub = new UsersStubRepository();
		Registration sut = new Registration();
		sut.SetRegistrator(mock);
		sut.SetUsers(stub);
		
		sut.register("123");		
		assertTrue(mock.isRegistratorCalled());
	}

	@Test
	public final void createUserIsCalled() {
		ExternalStubRegistrator stub = new ExternalStubRegistrator();
		UsersMockRepository mock = new UsersMockRepository();
		Registration sut = new Registration();
		sut.SetRegistrator(stub); 
		sut.SetUsers(mock);
		
		sut.register("123");		
		assertTrue(mock.isRepositoryCalled());
	}
	
	@Test
	public final void getUserDataIsCalledWithMockito(){
		Registration sut = new Registration();
		ExternalRegistrator mock = mock(ExternalRegistrator.class);
		UsersRepository stub = mock(UsersRepository.class);
		
		sut.SetRegistrator(mock);
		sut.SetUsers(stub);
		sut.register("123");
		verify(mock).getUserData();
		
	}
	
	@Test
	public final void createUserIsCalledWithMockito(){
		Registration sut = new Registration();
		ExternalRegistrator stub = mock(ExternalRegistrator.class);
		UsersRepository mock = mock(UsersRepository.class);
		
		sut.SetRegistrator(stub);
		sut.SetUsers(mock);
		sut.register("123");
		verify(mock).create(new HashMap());
		
	}
	
	@Test
	public final void retrievedUserDataIsPassedToRepository(){
		Registration sut = new Registration();
		
		HashMap returnedHashMap = new HashMap();
		returnedHashMap.put("uno", "dos");
		
		ExternalRegistrator registratorMock = mock(ExternalRegistrator.class);
		when(registratorMock.getUserData()).thenReturn(returnedHashMap);
		
		UsersRepository usersMock = mock(UsersRepository.class);
		
		sut.SetRegistrator(registratorMock);
		sut.SetUsers(usersMock);
		
		sut.register("123");
		
		verify(usersMock).create(returnedHashMap); 
		// verifica que el hashmap que se le ha pasado era ese y no otro
		
	}

}
