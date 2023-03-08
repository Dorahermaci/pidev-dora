package tn.esprit.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.pidev.Entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor , Long> {
}
