package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.entities.concretes.Image;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;

@Service
public class ImageManager implements ImageService {

	private ImageDao imageDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public ImageManager(ImageDao imageDao, CloudinaryService cloudinaryService) {
		super();
		this.imageDao = imageDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public Result add(Image image) {
		this.imageDao.save(image);
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll(),"Resimler Başarıyla Listelendi");
	}

	@Override
	public Result change(Image image, MultipartFile file) {
		
		this.cloudinaryService.uploadImage(file);
		
		return new SuccessResult("Photo added.");
	
	}

}
