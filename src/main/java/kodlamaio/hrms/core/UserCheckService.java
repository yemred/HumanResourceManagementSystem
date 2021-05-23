package kodlamaio.hrms.core;

import kodlamaio.hrms.entities.concretes.UnEmployedUser;


public interface UserCheckService {
	
	boolean checkIfRealPerson(UnEmployedUser unEmployedUser);

}
