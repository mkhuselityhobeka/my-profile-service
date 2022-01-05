package co.za.myprofileservice.servicesImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import co.za.myprofileservice.services.ResumeService;

@Service

public class ResumeServiceImpl implements ResumeService{
	
	private ResourceLoader resourceLoader;
	
	public ResumeServiceImpl(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	public Resource getResume() {
		Resource resource =  resourceLoader.getResource("file:/home/papi/Documents/MKhuseli CV/Mkhuseli Tyhobeka CV.pdf");
		return resource;
	}
	
	public ResponseEntity<InputStreamResource> displayResume() {
		String path = "/home/papi/Documents/resume/";
		String filename = "MkhuseliTyhobekaCV.pdf";
		File file = new File(path+filename);
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-disposition", "inline;filename=" + filename);
		headers.setContentDisposition(ContentDisposition.inline().filename("filename").build());
		InputStreamResource inputStreamResource = null;
		try {
			inputStreamResource = new InputStreamResource(new FileInputStream(file));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/pdf")).body(inputStreamResource);
	}

}
