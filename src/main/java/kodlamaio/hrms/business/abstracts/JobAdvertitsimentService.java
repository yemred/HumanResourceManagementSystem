package kodlamaio.hrms.business.abstracts;

import java.util.Date;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertitsimentService {
	
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getByDateOfCreationAndStatus(Date date);
	DataResult<List<JobAdvertisement>> getByEmployerUser_IdAndStatus(int id);
	Result add(JobAdvertisement jobAdvertisement);
	Result delete(JobAdvertisement jobAdvertisement);
	DataResult<JobAdvertisement> update(JobAdvertisement jobAdvertisement);

	

}
