package ptithcm.controller;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ptithcm.bean.MailModel;
import ptithcm.bean.UploadFile;

@Controller
@RequestMapping("lab8")
public class MailController {
	
	@Autowired
	@Qualifier("UploadFile")
	UploadFile baseUpdaloadFile;
	
	@Autowired
	JavaMailSender mailer;
	
	@RequestMapping(value="sendmail", method = RequestMethod.GET)
	public String sendmail(
			@ModelAttribute("mailObject") MailModel mailObject
			
			) {
		
		return "lab8/demo3";
	}
	
	@RequestMapping(value="sendmail", method = RequestMethod.POST)
	public String sendmail1( ModelMap model,
			@ModelAttribute("mailObject") MailModel mailObject,
			@RequestParam("attachFile") MultipartFile attachFile
			
			) {
		
		try {
			// khởi tạo hàm hỗ trợ send mail
			MimeMessage mail = mailer.createMimeMessage();
			MimeMessageHelper hepler = new  MimeMessageHelper(mail,true);
			
			
			hepler.setFrom("quansonvu2408@gmail.com.com",mailObject.getSender());
			// người nhận
			hepler.setTo(mailObject.getMailRecepient());
			// reply ai sẽ là người nhận
			hepler.setReplyTo("quansonvu2408@gmail.com.com");
			
			hepler.setSubject(mailObject.getSubject());
			/*ckeditor - get messange body thì phải có thuộc tính true mới
			 *  hiện những thông tin đi kèm như ảnh, file 	*/
			hepler.setText(mailObject.getMessagebody(),true);
			
			if(!attachFile.isEmpty()) {
				// lấy link file
				String uploadBasedir = baseUpdaloadFile.getBasePath() + File.separator + attachFile.getOriginalFilename();
				// chuyển link file hiện tại tới file chỉ dẫn
				attachFile.transferTo(new File(uploadBasedir));
				
				// khời tạo file để thêm vào mail
				FileSystemResource file1 = new FileSystemResource(new File(uploadBasedir));
				// thêm file đính kèm vào mail để gửi 
				hepler.addAttachment(attachFile.getOriginalFilename(), file1);
		
			}
			
			mailer.send(mail);
			
			
			model.addAttribute("masseage","Mail đã gửi thành công.");
			mailObject.setSender("");
			mailObject.setMailRecepient("");
			mailObject.setMessagebody("");
			mailObject.setSubject("");
			
		} catch (Exception e) {
			model.addAttribute("masseage", "Gửi mail thất bại");
		}
		
		
		return "lab8/success";
	}
	
	@RequestMapping(value = "form", method = RequestMethod.POST)
	String Lap5B3Send(ModelMap model,
		@RequestParam("from") String from,
		@RequestParam("to") String to,
		@RequestParam("subject") String subject,
		@RequestParam("body") String body ) {

		try {
			MimeMessage mail = mailer.createMimeMessage();
			
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setFrom(from,from);
			helper.setTo(to);
			helper.setReplyTo("quansonvu2408@gmail.com",from);
			helper.setSubject(subject);
			helper.setText(subject);
			
			mailer.send(mail);
			model.addAttribute("message","Gửi thành công");
			
		} catch (Exception e) {
			model.addAttribute("message","Gửi thất bại");
		}
		
		return "mailer/success";
	}
	
	
	@RequestMapping(value = "form")
	String Lap5B3() {

		return "mailer/form";
	}
	
}
