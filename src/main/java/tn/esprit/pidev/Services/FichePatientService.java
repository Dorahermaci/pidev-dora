package tn.esprit.pidev.Services;

import javax.transaction.Transactional;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FichePatientService {
	@Transactional
	public void addFileToDocument(MultipartFile file, String path) throws FileUploadException {
		try {
			System.out.println("file =" + file.getOriginalFilename());

			Path root = Paths.get(path);
			System.out.println("file =" + file.getOriginalFilename());
			Path resolve = root.resolve(file.getOriginalFilename());
			if (resolve.toFile().exists()) {
				throw new FileUploadException("File already exists: " + file.getOriginalFilename());
			}

			Files.copy(file.getInputStream(), resolve);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new FileUploadException("Could not store the file. Error: " + e.getMessage());
		}

	}
}
