package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.entities.concretes.UnEmployedUser;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.business.abstracts.UnEmployedUserService;

@RestController
@RequestMapping("/api/unemployedusers")
@CrossOrigin
public class UnEmployedUsersController {
	
	private UnEmployedUserService unEmployedUserService;

	@Autowired
	public UnEmployedUsersController(UnEmployedUserService unEmployedUserService) {
		super();
		this.unEmployedUserService = unEmployedUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<UnEmployedUser>> getAll() {
		return this.unEmployedUserService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody  UnEmployedUser unEmployedUser ) {
		return this.unEmployedUserService.add(unEmployedUser);
	}

}
