package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.business.abstracts.EmployerUserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerUserDao;
import kodlamaio.hrms.entities.concretes.EmployerUser;
import kodlamaio.hrms.entities.concretes.User;

public class EmployerUserManager implements EmployerUserService {

	private EmployerUserDao employerUserDao;

	@Autowired
	public EmployerUserManager(EmployerUserDao employerUserDao) {
		super();
		this.employerUserDao = employerUserDao;
	}

	@Override
	public DataResult<List<EmployerUser>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(EmployerUser employerUser) {
		
		if(employerUser.getCompanyName() != null && employerUser.getWebsite() != null && employerUser.getEmail() != null && employerUser.getPhone() != null && employerUser.getPassword() != null) {
		
			if(checkUserByMail(employerUser.getEmail())) {
				
				return new SuccessResult("Kayıt Başarılı Şekilde Tamamlandı");
				
			}else {
				
				return new ErrorResult("Bu Mail Adresi ile Kullanıcı Bulunmaktadır");
			}
		}else {
			return new ErrorResult("Zorunlu Alanlar Boş Geçilemez");
		}
	}

	private boolean checkUserByMail(String email) {
		List<EmployerUser> result = employerUserDao.findByEmail(email);
		if(result!=null) {
			return false;
		}
		
		return true;
	}
}
