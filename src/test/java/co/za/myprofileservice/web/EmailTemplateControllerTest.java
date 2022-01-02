package co.za.myprofileservice.web;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import co.za.myprofileservice.MyProfileServiceApplication;
import co.za.myprofileservice.data.EmailTemplateDTO;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyProfileServiceApplication.class, 
webEnvironment = WebEnvironment.RANDOM_PORT)
class EmailTemplateControllerTest {

    @LocalServerPort
	private int port;
    
    private String url = "http://localhost:";
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Autowired
    EmailTemplateDTO emailTemplateDTO;
	
	@Test
	public void sendEmailTest() {
		emailTemplateDTO.setEmail("mkhuselityhoeka@gmail.com");
		emailTemplateDTO.setName("Mkhuseli");
		emailTemplateDTO.setMessage("unit test");
		emailTemplateDTO.setSubject("unit test subject");
		ResponseEntity<EmailTemplateDTO>responseEntity = this.restTemplate.postForEntity(url+port+"/mkhuseli/send/email", emailTemplateDTO, EmailTemplateDTO.class);
		assertEquals(201, responseEntity.getStatusCodeValue());
		
	}

}
