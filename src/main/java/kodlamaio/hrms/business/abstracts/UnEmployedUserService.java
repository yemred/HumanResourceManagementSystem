package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UnEmployedUser;

public interface UnEmployedUserService {
	
	Result add(UnEmployedUser unEmployedUser);
	
	DataResult<List<UnEmployedUser>> getAll();
	
	DataResult<UnEmployedUser> getByEmail(String email);
	
	DataResult<UnEmployedUser> getByNationalityId(String nationalityId);
	
	

}
