package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.hrms.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService {

	private WorkTypeDao workTypeDao;
	
	public WorkTypeManager(WorkTypeDao workTypeDao) {
		super();
		this.workTypeDao = workTypeDao;
	}

	@Override
	public DataResult<List<WorkType>> getAll() {
		return new SuccessDataResult<List<WorkType>>(workTypeDao.findAll(),"Başarıyla Listelendi");
	}

}
