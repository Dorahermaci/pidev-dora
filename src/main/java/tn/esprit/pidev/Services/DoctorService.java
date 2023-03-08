package tn.esprit.pidev.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.Entities.Doctor;
import tn.esprit.pidev.Repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Transactional
	public Doctor addDoctor(Doctor doc) {
	return 	doctorRepository.save(doc);
	}

}
