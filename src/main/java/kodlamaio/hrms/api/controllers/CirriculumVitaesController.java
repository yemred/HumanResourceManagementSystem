package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CirriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CirriculumVitae;

@RestController
@RequestMapping("/api/cirriculumVitaes")
@CrossOrigin
public class CirriculumVitaesController {
	
	private CirriculumVitaeService cirriculumVitaeService ;

	@Autowired
	public CirriculumVitaesController(CirriculumVitaeService cirriculumVitaeService) {
		super();
		this.cirriculumVitaeService = cirriculumVitaeService;
	} 
	
	@GetMapping("/getall")
	public DataResult<List<CirriculumVitae>> getAll(){
		return this.cirriculumVitaeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(CirriculumVitae cirriculumVitae) {
		return this.cirriculumVitaeService.Add(cirriculumVitae);
	}
	
	@GetMapping()
	public DataResult<List<CirriculumVitae>> getByCirrculumVitaeWithId(int id){	
		return this.cirriculumVitaeService.getByCirrculumVitaeWithId(id);
	}

}
