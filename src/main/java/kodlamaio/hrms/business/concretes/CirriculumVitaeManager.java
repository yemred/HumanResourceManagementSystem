package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CirriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CirriculumVitaeDao;
import kodlamaio.hrms.entities.concretes.CirriculumVitae;

@Service
public class CirriculumVitaeManager implements CirriculumVitaeService {
	
	private CirriculumVitaeDao cirriculumVitaeDao;

	@Autowired
	public CirriculumVitaeManager(CirriculumVitaeDao cirriculumVitaeDao) {
		super();
		this.cirriculumVitaeDao = cirriculumVitaeDao;
	}

	@Override
	public DataResult<List<CirriculumVitae>> getAll() {
		return new SuccessDataResult<List<CirriculumVitae>>(this.cirriculumVitaeDao.findAll());
	}

	@Override
	public Result Add(CirriculumVitae cirriculumVitae) {
		this.cirriculumVitaeDao.save(cirriculumVitae);
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<CirriculumVitae>> getByCirrculumVitaeWithId(int id) {
		return new SuccessDataResult<List<CirriculumVitae>>(this.cirriculumVitaeDao.getByCirrculumVitaeWithId(id));
	} 
	
	

}
