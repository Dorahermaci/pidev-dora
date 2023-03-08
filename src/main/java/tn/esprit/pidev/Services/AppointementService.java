
package tn.esprit.pidev.Services;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import tn.esprit.pidev.Entities.Appointement;
import tn.esprit.pidev.Entities.Doctor;
import tn.esprit.pidev.Entities.Patient;
import tn.esprit.pidev.Repository.AppointementRepository;
import tn.esprit.pidev.Repository.DoctorRepository;
import tn.esprit.pidev.Repository.PatientRepository;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class AppointementService {
	
	
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	AppointementRepository appointementRepository;
	@Autowired
	public JavaMailSender mailSender;
	
	public Appointement addAppointement(Long idPAtient  , Long IdDocteur ,Appointement app ) {
		
		Patient Pat =patientRepository.findById(idPAtient).get();
		Doctor Doc =doctorRepository.findById(IdDocteur).get();


		app.setPatient(Pat);
		app.setDoctor(Doc);
		 appointementRepository.save(app);
			try {
				sendEmail( Doc, Pat);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 
		 return app;

		
		
	}
	

	public void sendEmail(Doctor doc ,Patient pat) throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("dorra.hermassi@esprit.tn", "Charlie Nicole");
		helper.setTo(doc.getEmail());

		String subject = "New RDV";

		String content = "<p> Hello Doctor ,"+doc.getFirstName() +"</p>" + "<p> I hope this email finds you well. I am writing to inform you that you have a new appointment scheduled with a patient "+ pat.getFirstName()+" " + "<p> Please confirm your availability for the above-mentioned appointment. If you are unavailable, please let me know as soon as possible so that we can reschedule the appointment at a more convenient time for the patient. </p> </p>";
				

		helper.setSubject(subject);

		helper.setText(content, true);

		mailSender.send(message);
	}


	public List<Appointement> getAllAppointement() {
		// TODO Auto-generated method stub
		return appointementRepository.findAll();
	}
	
	
	public Appointement findbyId(Long id) {
		// TODO Auto-generated method stub
		return appointementRepository.findById(id).get();
	}
	
	public List<Appointement> findbyDoctor(Long id) {
		// TODO Auto-generated method stub
		Doctor doc= doctorRepository.findById(id).get();
		return appointementRepository.findByDoctor(doc);
	}
	
	
	public List<Appointement> findbyPatient(Long id) {
		// TODO Auto-generated method stub
		Patient doc= patientRepository.findById(id).get();
		return appointementRepository.findByPatient(doc);
	}
	
}