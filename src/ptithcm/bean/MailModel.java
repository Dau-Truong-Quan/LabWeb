package ptithcm.bean;

import org.springframework.web.multipart.MultipartFile;

public class MailModel {
	private String sender;
	private String mailRecepient;
	private String subject;
	
	
	
	public MailModel() {
		super();
	}
	public MailModel(String sender, String mailRecepient, String subject, String messagebody,
			MultipartFile attachmentsfile) {
		super();
		this.sender = sender;
		this.mailRecepient = mailRecepient;
		this.subject = subject;
		this.messagebody = messagebody;
		this.attachmentsfile = attachmentsfile;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMailRecepient() {
		return mailRecepient;
	}
	public void setMailRecepient(String mailRecepient) {
		this.mailRecepient = mailRecepient;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessagebody() {
		return messagebody;
	}
	public void setMessagebody(String messagebody) {
		this.messagebody = messagebody;
	}
	public MultipartFile getAttachmentsfile() {
		return attachmentsfile;
	}
	public void setAttachmentsfile(MultipartFile attachmentsfile) {
		this.attachmentsfile = attachmentsfile;
	}
	private String messagebody;
	private MultipartFile attachmentsfile;

}
