package co.za.myprofileservice.web;

import javax.validation.Valid;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.za.myprofileservice.data.EmailTemplateDTO;
import co.za.myprofileservice.servicesImpl.EmailTemplateServiceImpl;
import co.za.myprofileservice.servicesImpl.ResumeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping("/mkhuseli")
@RestController
@CrossOrigin
public class EmailTemplateController {
	
	
	private EmailTemplateServiceImpl emailTemplateServiceImpl;
	private ResumeServiceImpl resumeServiceImpl;
	public EmailTemplateController(EmailTemplateServiceImpl emailTemplateServiceImpl, ResumeServiceImpl resumeServiceImpl){
		this.emailTemplateServiceImpl = emailTemplateServiceImpl;
		this.resumeServiceImpl = resumeServiceImpl;
		
	}
	@Operation(summary = "sends an email to my gmail address")
	@ApiResponses(value = {@ApiResponse(responseCode = "201", description = "email created",
	            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = EmailTemplateDTO.class))}),
			             @ApiResponse(responseCode = "400", description = "Invalid request",content = @Content)})
	@PostMapping("send/email")
	public ResponseEntity<EmailTemplateDTO> sendEmail(@Valid @RequestBody EmailTemplateDTO emailTemplate){
		
		return new ResponseEntity<>(emailTemplateServiceImpl.sendEmail(emailTemplate), HttpStatus.CREATED);
		
	}
	
	@GetMapping(value="/diplay-resume",produces = "application/pdf")
	public ResponseEntity<?>displayResume(){
		return ResponseEntity.ok(resumeServiceImpl.getResume());
	}
	@GetMapping(value="/show-resume")
	public ResponseEntity<InputStreamResource> showCv() {
		return resumeServiceImpl.displayResume();
	}

}
