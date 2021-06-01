package kodlamaio.hrms.core;

import org.hibernate.mapping.Map;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {

	Map upload (MultipartFile multipartFile);
	Map delete (String id);

	
}
