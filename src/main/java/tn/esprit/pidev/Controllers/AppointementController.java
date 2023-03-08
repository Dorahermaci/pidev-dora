package tn.esprit.pidev.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.pidev.Entities.Appointement;
import tn.esprit.pidev.Entities.Patient;
import tn.esprit.pidev.Services.AppointementService;

@RestController

@RequestMapping("/appoientment")
public class AppointementController {
	@Autowired 
	AppointementService appointementService;
	@PostMapping(value = "/AddAppoientment")
	public Appointement addAppointement (@Validated @RequestBody Appointement app ,@RequestParam  Long idPatient ,@RequestParam Long idDoctor) {

		return appointementService.addAppointement(idPatient,idDoctor,app);
	}
	
	
	@GetMapping(value = "/GetAllAppointement")
	public List<Appointement> getAllAppointement () {
		return appointementService.getAllAppointement();
	}
	
	@GetMapping(value = "/GetAllAppointementByPatient")
	public List<Appointement> getAllAppointementByPatient  (@RequestParam Long id  ) {
		return appointementService.findbyPatient(id);
	}
	
	@GetMapping(value = "/GetAllAppointementByDoctor")
	public List<Appointement> getAllAppointementByDoctor (@RequestParam Long id  ) {
		return appointementService.findbyDoctor(id);
	}
	
	@GetMapping(value = "/GetAppointementById")
	public Appointement getAppointementById (@RequestParam Long id  ) {
		return appointementService.findbyId(id);
	}
}
