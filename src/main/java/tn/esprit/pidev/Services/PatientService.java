package tn.esprit.pidev.Services;

import java.io.File;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import tn.esprit.pidev.DTO.PatientDTO;
import tn.esprit.pidev.Entities.Appointement;
import tn.esprit.pidev.Entities.MedicalFolder;
import tn.esprit.pidev.Entities.Patient;
import tn.esprit.pidev.Mapper.PatientDtoMapper;
import tn.esprit.pidev.Repository.MedicalFolderRepository;
import tn.esprit.pidev.Repository.PatientRepository;

@Service
public class PatientService {
	
    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private MedicalFolderRepository medicalFolderRepository;

    public Patient addPatient(Patient patient) {
      patientRepository.save(patient);
  	String path = "./PieceJoint/"+patient.getId()+"-"+patient.getFirstName();
	File dossier = new File(path);
	boolean res = dossier.mkdir();
	patient.setPathFolder(path);
       
      
    	return patientRepository.save(patient);
    }
    
}

