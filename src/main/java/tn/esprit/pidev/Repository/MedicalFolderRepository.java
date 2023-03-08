package tn.esprit.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.pidev.Entities.MedicalFolder;

public interface MedicalFolderRepository extends JpaRepository<MedicalFolder, Long > {

}
