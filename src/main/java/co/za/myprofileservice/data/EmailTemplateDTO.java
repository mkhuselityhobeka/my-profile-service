package co.za.myprofileservice.data;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import co.za.myprofileservice.services.IsEmailValid;

@Component
public class EmailTemplateDTO {
	
	@NonNull
	@NotEmpty(message = "Please fill in name field, name cannot be empty")
	private String name;
	@NonNull
	@NotEmpty(message = "Please fill in email field, email cannot be empty")
	@IsEmailValid
	private String email;
	@NonNull
	@NotEmpty(message = "Please fill in message field, message cannot be empty")
	private String message;
	@NonNull
	@NotEmpty(message = "Please fill in message field, message cannot be empty")
	private String subject;
	
	public EmailTemplateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmailTemplateDTO(@NotEmpty(message = "Please fill in name field, name cannot be empty") String name,
			@NotEmpty(message = "Please fill in email field, email cannot be empty") String email,
			@NotEmpty(message = "Please fill in message field, message cannot be empty") String message,
			@NotEmpty(message = "Please fill in message field, message cannot be empty") String subject) {
		super();
		this.name = name;
		this.email = email;
		this.message = message;
		this.subject = subject;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, message, name, subject);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailTemplateDTO other = (EmailTemplateDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(message, other.message)
				&& Objects.equals(name, other.name) && Objects.equals(subject, other.subject);
	}
	@Override
	public String toString() {
		return "EmailTemplate [name=" + name + ", email=" + email + ", message=" + message + ", subject=" + subject
				+ "]";
	}
	


}
