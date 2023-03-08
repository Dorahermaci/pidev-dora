package tn.esprit.pidev.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import tn.esprit.pidev.Entities.Patient;

public interface PatientRepository extends JpaRepository<Patient , Long> {
	Optional<Patient> findById(Long id);

}
