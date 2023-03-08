package tn.esprit.pidev.Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.util.IOUtils;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.pidev.Services.FichePatientService;

@RestController

@RequestMapping("/file")
@CrossOrigin(origins = "http://localhost:4200")
public class FichePatient {
	
	@Autowired
	FichePatientService justificatifServ;


	@PostMapping(value = "/UplodFichePatient", produces = { MediaType.MULTIPART_FORM_DATA_VALUE })

	public ResponseEntity<String> uploadFile(@PathVariable MultipartFile file, @Validated @RequestParam String path)
			throws FileUploadException {

		justificatifServ.addFileToDocument(file, path);

		return ResponseEntity.status(HttpStatus.OK).body("");
	}
	
	
	@GetMapping(value = "/downloadFile")

	public ResponseEntity<byte[]> downloadFile(@Validated @RequestParam String fileName, @RequestParam String path)
			throws IOException {

		Path root = Paths.get(path);
		File file = new File(root.toFile(), fileName);
		FileInputStream fis;

		try {

			fis = new FileInputStream(file);
			byte[] content = IOUtils.toByteArray(fis);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType
					.parseMediaType("application/vnd.openxmlformats-officedocument.wordprocessingml.document"));
			headers.setContentDispositionFormData(fileName, fileName);
			headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
			ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(content, headers, HttpStatus.OK);
			return response;
		} catch (Exception e) {
			return null;
		}
	}

}
