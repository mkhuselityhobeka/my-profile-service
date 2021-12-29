package co.za.myprofileservice.services;

import co.za.myprofileservice.data.EmailTemplateDTO;

public interface EmailTemplaterService {
	
	EmailTemplateDTO sendEmail(EmailTemplateDTO emailTemplate);

}
