package kodlamaio.hrms.core;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;





@Service
public class CloudinaryManager implements CloudinaryService {
	
	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "drel0a8od", "api_key", "764321943533252",
			"api_secret", "p7HLIoeX7h560v3owt48JWLrQ10"));

	@Override
	public DataResult<?> uploadImage(MultipartFile file) {
		try {
			Map upload = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(upload);
		} catch (IOException e) {
			e.printStackTrace();
			return new ErrorDataResult<Map>();
		}
	}



}
