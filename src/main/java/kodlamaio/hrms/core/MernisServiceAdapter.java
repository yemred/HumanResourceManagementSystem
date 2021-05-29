package kodlamaio.hrms.core;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.UnEmployedUser;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean checkIfRealPerson(UnEmployedUser unEmployedUser) {
		boolean result = false;
		KPSPublicSoapProxy soapClient = new KPSPublicSoapProxy();
		try {
			
			result = soapClient.TCKimlikNoDogrula(Long.parseLong(unEmployedUser.getNationalityId()), unEmployedUser.getFirstName(), unEmployedUser.getLastName(), unEmployedUser.getBirthdate().getYear());
			
		}catch (Exception e) {
			System.out.println("Hata Kullanıcı Bulanamadı");
		}
		
		return result;
		
	}

	

}
