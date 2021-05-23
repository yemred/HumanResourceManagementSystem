package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.EmployerUser;


public interface EmployerUserDao extends JpaRepository<EmployerUser, Integer> {
	
	@Query("SELECT * FROM employerUsers u where u.email = :email") 
	List<EmployerUser> findByEmail(@Param("email") String email);

}
