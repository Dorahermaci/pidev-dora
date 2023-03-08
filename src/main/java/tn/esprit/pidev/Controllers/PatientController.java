package tn.esprit.pidev.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pidev.Entities.Patient;
import tn.esprit.pidev.Services.PatientService;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatientController {
	@Autowired
	PatientService patientService;
	
	
	@PostMapping(value = "/AddPatient")
	public Patient AddPatient (@Validated @RequestBody Patient pat) {
		return patientService.addPatient(pat);
	}

}
