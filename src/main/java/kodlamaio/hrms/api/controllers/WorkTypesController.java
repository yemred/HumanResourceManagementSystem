package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkType;

@RestController
@RequestMapping("/api/workTypes")
@CrossOrigin
public class WorkTypesController {
	
	private WorkTypeService workTypeService;

	public WorkTypesController(WorkTypeService workTypeService) {
		super();
		this.workTypeService = workTypeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkType>> getAll(){
		return workTypeService.getAll();
	}
	
	

}
