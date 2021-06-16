package kodlamaio.hrms.core;

import java.io.IOException;

import org.hibernate.mapping.Map;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {

	DataResult<?> uploadImage(MultipartFile file);

	
}
