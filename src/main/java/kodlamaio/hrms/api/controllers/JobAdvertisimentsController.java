package kodlamaio.hrms.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertitsimentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisiments")
@CrossOrigin
public class JobAdvertisimentsController {
	
	private JobAdvertitsimentService jobAdvertitsimentService;

	@Autowired
	public JobAdvertisimentsController(JobAdvertitsimentService jobAdvertitsimentService) {
		super();
		this.jobAdvertitsimentService = jobAdvertitsimentService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertitsimentService.add(jobAdvertisement);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertitsimentService.delete(jobAdvertisement);
	}
	
	@GetMapping("getByDateOfCreationAndStatus")
	public DataResult<List<JobAdvertisement>> getByDateOfCreationAndStatus(@RequestParam Date date){
		return this.getByDateOfCreationAndStatus(date);
	}
	
	@GetMapping("getByEmployerUser_IdAndStatus")
	public DataResult<List<JobAdvertisement>> getByEmployerUser_IdAndStatus(@RequestParam int id){
		return this.getByEmployerUser_IdAndStatus(id);
	}
	
	@PostMapping("/update")
	public DataResult<JobAdvertisement> update(@RequestBody JobAdvertisement jobAdvertisement){
		return this.update(jobAdvertisement);
	}
	
	

}
