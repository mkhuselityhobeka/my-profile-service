package co.za.myprofileservice.data;

import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class EmailTemplateDTO {
	
	private String name;
	private String email;
	private String message;
	private String subject;
	
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
