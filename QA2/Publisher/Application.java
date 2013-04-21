package AgileDevCourse.QA2.Publisher;

import AgileDevCourse.QA2.Publisher.HandCraftedInjection.FacebookRegistration;
import AgileDevCourse.QA2.Publisher.HandCraftedInjection.Registration;
import AgileDevCourse.QA2.Publisher.HandCraftedInjection.Users;

public class Application {

	// Inyectamos las dependencias
	public static void main() {
		
		Registration registration = new Registration();
		registration.SetRegistrator(new FacebookRegistration());
		registration.SetUsers(new Users());
		
	}
	
}
