package co.za.myprofileservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.za.myprofileservice.data.EmailTemplateDTO;
import co.za.myprofileservice.servicesImpl.EmailTemplateServiceImpl;

@RequestMapping("/my-prfile/send")
@RestController
@CrossOrigin
public class EmailTemplateController {
	
	
	private EmailTemplateServiceImpl emailTemplateServiceImpl;
	
	public EmailTemplateController(EmailTemplateServiceImpl emailTemplateServiceImpl){
		this.emailTemplateServiceImpl = emailTemplateServiceImpl;
		
	}
	
	@PostMapping("email")
	public ResponseEntity<EmailTemplateDTO> sendEmail(@RequestBody EmailTemplateDTO emailTemplate){
		return new ResponseEntity<>(emailTemplateServiceImpl.sendEmail(emailTemplate), HttpStatus.OK);
		
	}

}
