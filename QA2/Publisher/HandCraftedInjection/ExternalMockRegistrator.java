package AgileDevCourse.QA2.Publisher.HandCraftedInjection;

import java.util.HashMap;

// Un mock te dice si una funci�n ha sido llamada 
// o no, no se preocupa de qu� hace, s�lo la llamada.
public class ExternalMockRegistrator implements ExternalRegistrator {
	int userDataCalls = 0;
	
	@Override
	public HashMap getUserData() {
		userDataCalls++;
		return null;
	}
	
	public boolean isRegistratorCalled(){
		return (userDataCalls > 0);
	}

}
