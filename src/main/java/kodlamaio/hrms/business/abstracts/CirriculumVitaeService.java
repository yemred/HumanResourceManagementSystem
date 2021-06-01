package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CirriculumVitae;

public interface CirriculumVitaeService {
	
	DataResult<List<CirriculumVitae>> getAll();
	Result Add(CirriculumVitae cirriculumVitae);
	DataResult<List<CirriculumVitae>> getByCirrculumVitaeWithId(int id);
	

}
