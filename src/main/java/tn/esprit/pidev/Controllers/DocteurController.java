package tn.esprit.pidev.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.pidev.Entities.Doctor;
import tn.esprit.pidev.Services.DoctorService;


@RestController

@RequestMapping("/doctor")
public class DocteurController {
	
	@Autowired
	private DoctorService doctorServ;
	@PostMapping(value = "/Adddoctor")

	public Doctor AddDocteur (@RequestBody Doctor doc) {
		
		return doctorServ.addDoctor(doc);
		
	}

}
