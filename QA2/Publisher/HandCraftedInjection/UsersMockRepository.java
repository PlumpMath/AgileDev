package AgileDevCourse.QA2.Publisher.HandCraftedInjection;

import java.util.HashMap;

public class UsersMockRepository implements UsersRepository {

	int callsCounter = 0;
	
	@Override
	public void create(HashMap userData) {
		callsCounter++;
	}
	
	public boolean isRepositoryCalled(){
		return (callsCounter > 0);
	}

}
