package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import kodlamaio.hrms.entities.concretes.CirriculumVitae;

public interface CirriculumVitaeDao extends JpaRepository<CirriculumVitae, Integer>{
	
	@Query("From CirriculumVitae where unEmployedUser=:id ")
	List<CirriculumVitae> getByCirrculumVitaeWithId(int id);		

}
