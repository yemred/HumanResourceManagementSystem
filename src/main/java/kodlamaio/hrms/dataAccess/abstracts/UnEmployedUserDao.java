package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.UnEmployedUser;

public interface UnEmployedUserDao extends JpaRepository<UnEmployedUser, Integer> {
	
	UnEmployedUser getByEmail(String email);
	
	UnEmployedUser getByNationalityId(String nationalityId);
	
}
