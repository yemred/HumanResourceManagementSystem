package kodlamaio.hrms.core;

import java.io.IOException;

import org.hibernate.mapping.Map;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

@Service
public class CloudinaryManager implements CloudinaryService {
	
    Cloudinary cloudinary;
    private Map<String, String> valuesMap = new HashMap<>();


	public CloudinaryManager() {
		valuesMap.put("cloud_name","drel0a8od" );
		valuesMap.put("api_key", "764321943533252" );
		valuesMap.put("api_secret","p7HLIoeX7h560v3owt48JWLrQ10" );
		cloudinary = new Cloudinary();
	}
	
	@Override
	public Map upload (MultipartFile multipartFile) throws IOException {
		File file = convert(multipartFile);
		Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		file.delete();
		Map result1 = null;
		return result1;
	}

	@Override
	public Map delete (String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
		return result;
	}
	

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }

}
