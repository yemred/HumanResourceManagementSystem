package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertitsimentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisimentDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;


@Service
public class JobAdvertisimentManager implements JobAdvertitsimentService {

	private JobAdvertisimentDao jobAdvertisimentDao;

	@Autowired
	public JobAdvertisimentManager(JobAdvertisimentDao jobAdvertisimentDao) {
		super();
		this.jobAdvertisimentDao = jobAdvertisimentDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisimentDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByDateOfCreationAndStatus(Date date) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisimentDao.getByDateOfCreationAndStatus(date, true));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployerUser_IdAndStatus(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisimentDao.getByEmployerUser_IdAndStatus(id,true));
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisimentDao.save(jobAdvertisement);
		return new SuccessResult("Ürün Eklendi");
	}

	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisimentDao.delete(jobAdvertisement);
		return new SuccessResult("Ürün Silindi");
	}

	@Override
	public DataResult<JobAdvertisement> update(JobAdvertisement jobAdvertisement) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisimentDao.save(jobAdvertisement));
	}
	
	
	
}
