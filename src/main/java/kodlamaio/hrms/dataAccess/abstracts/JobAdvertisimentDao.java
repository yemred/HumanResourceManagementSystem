package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisimentDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> getByDateOfCreationAndStatus(Date date, boolean status);
	
	List<JobAdvertisement> getByEmployerUser_IdAndStatus(int id, boolean status);

}
