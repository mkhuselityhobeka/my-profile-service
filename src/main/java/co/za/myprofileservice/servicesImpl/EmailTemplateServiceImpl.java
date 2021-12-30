package co.za.myprofileservice.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import co.za.myprofileservice.data.EmailTemplateDTO;
import co.za.myprofileservice.services.EmailTemplaterService;

@Service
public class EmailTemplateServiceImpl implements EmailTemplaterService{

	@Autowired
	JavaMailSender javaMailSender;
	@Autowired
	EmailTemplateDTO emailTemplate;
	
	@Override
	public EmailTemplateDTO sendEmail(EmailTemplateDTO emailTemplate){
		
        if(emailTemplate != null) {
           SimpleMailMessage mailMessage = new SimpleMailMessage();
           mailMessage.setTo("mkhuselityhobeka@gmail.com");
           mailMessage.setSubject(emailTemplate.getSubject());
           mailMessage.setText(emailTemplate.getName() + '\n' + emailTemplate.getMessage() 
                  + '\n' + "You can get back to me on this mail " + emailTemplate.getEmail());
           javaMailSender.send(mailMessage);
        }
		return emailTemplate;
	}
	
	

}
