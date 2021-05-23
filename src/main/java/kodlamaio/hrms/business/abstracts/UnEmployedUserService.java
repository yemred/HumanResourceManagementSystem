package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UnEmployedUser;

public interface UnEmployedUserService {
	
	Result add(UnEmployedUser unEmployedUser);
	
	DataResult<List<UnEmployedUser>> getAll();
	
	

}
