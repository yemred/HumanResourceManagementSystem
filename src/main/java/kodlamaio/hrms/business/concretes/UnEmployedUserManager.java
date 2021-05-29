package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UnEmployedUserService;
import kodlamaio.hrms.core.UserCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UnEmployedUserDao;
import kodlamaio.hrms.entities.concretes.UnEmployedUser;

@Service
public class UnEmployedUserManager implements UnEmployedUserService {
	
	private UnEmployedUserDao unEmployedUserDao;
	private UserCheckService userCheckService;

	@Autowired
	public UnEmployedUserManager(UnEmployedUserDao unEmployedUserDao, UserCheckService userCheckService) {
		super();
		this.unEmployedUserDao = unEmployedUserDao;
		this.userCheckService = userCheckService;
	}

	@Override
	public Result add(UnEmployedUser unEmployedUser) {
		
		if(unEmployedUser.getFirstName()!= null && unEmployedUser.getLastName()!= null && unEmployedUser.getEmail() != null && unEmployedUser.getNationalityId()!= null && unEmployedUser.getBirthdate() != null && unEmployedUser.getPassword() != null ) {
			
			if(userCheckService.checkIfRealPerson(unEmployedUser)) {
				
	

				if(checkUserByMail(unEmployedUser.getEmail()) && checkUserByNationalityId(unEmployedUser.getNationalityId())) {
					
					this.unEmployedUserDao.save(unEmployedUser);
					return new SuccessResult("Kayıt Başarılı Bir Şekilde Gerçekleşti");
					
				}else {
					
					return new ErrorResult("Bu email adresi ve tc no zaten kayıtlıdır");
			
				}
				
			}else {
				
				return new ErrorResult("Bu Şekilde Bir Kullanıcı Yoktur");
				
			}
			
		}else {
			
			return new ErrorResult("Lütfen Alanaları Eksiksiz Doldurunuz");
			
		}
		
	}


	@Override
	public DataResult<List<UnEmployedUser>> getAll() {
		return new SuccessDataResult<List<UnEmployedUser>>("Listelendi");
	}
	
	private boolean checkUserByNationalityId(String nationalityId) {
		
		UnEmployedUser result = unEmployedUserDao.getByNationalityId(nationalityId);
		
		if(result != null) {
			
			return false;
		}
		
		return true;
	}
	

	private boolean checkUserByMail(String email) {
		
		UnEmployedUser result  =  unEmployedUserDao.getByEmail(email);
		
		if(result != null) {
			
			return false;
		}
		
		return true;
	}

	@Override
	public DataResult<UnEmployedUser> getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<UnEmployedUser> getByNationalityId(String nationalityId) {
		// TODO Auto-generated method stub
		return null;
	}

}




