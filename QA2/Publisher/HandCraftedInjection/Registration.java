package AgileDevCourse.QA2.Publisher.HandCraftedInjection;

import java.util.HashMap;

public class Registration {

	// Explicitamos la dependencia de la interface Registrator.
	ExternalRegistrator registrator;

	// Explicitamos la dependencia de la interface UsersRepository.
	UsersRepository users;
	
	public void register(String userId){
		// Quitamos la instanciacion de las dependencias y  
		// delegamos en quien sea que utilice esta clase
		// la explicitación de las implementaciones a utilizar.
		
		//FacebookRegistration registratorn = new FacebookRegistration();
		HashMap userData = registrator.getUserData();
		
		//Users users = new Users();
		users.create(userData);
	}
	
	// Exponemos una forma de inyectar las dependencias en la clase dependiente
	// Para no depender de una implementación concreta, definimos la dependencia 
	// en terminos de su interface.
	public void SetRegistrator(ExternalRegistrator registrator){
		this.registrator = registrator;
	}
	
	public void SetUsers(UsersRepository usersRepository){
		this.users = usersRepository;
	}
}
