package tn.esprit.pidev.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.Entities.Appointement;
import tn.esprit.pidev.Entities.Doctor;
import tn.esprit.pidev.Entities.Patient;


@Repository
public interface AppointementRepository extends JpaRepository<Appointement , Long> {

	List<Appointement> findByDoctor(Doctor doc);

	List<Appointement> findByPatient(Patient Pat);
}
