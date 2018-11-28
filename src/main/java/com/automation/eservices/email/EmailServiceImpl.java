package com.automation.eservices.email;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {
	 
	@Autowired
	private JavaMailSender sender;
	

	@Value("${eservices.mail.from}")
	private String from;
	
	@Value("${eservices.mail.to}")
	private String to;
	
	@Value("${eservices.mail.cc}")
	private String cc;
	
	@Value("${eservices.mail.subjectLine}")
	private String subjectLine;
	
	@Value("${eservices.mail.text}")
	private String text;
		
	@Value("${eservices.mail.attachmentpath}")
	private String attachmentpath;
	
	@Value("${eservices.mail.attachmentname}")
	private String attachmentname;
	
	@SuppressWarnings("unused")
	private void sendEmail() {
		MimeMessage message = sender.createMimeMessage();
	    MimeMessageHelper helper;
		try {
			
				String content = getContent();
				helper = new MimeMessageHelper(message,true);
				helper.setFrom(from);
				helper.setTo(to);
				helper.setCc(cc);
				helper.setText(text);
				helper.setSubject(subjectLine);
				
				
				/*ClassPathResource file = new ClassPathResource("D:\\Sai\\Doc\\eServiceReportICARequest.xls");
				helper.addAttachment("eServiceReportICARequest.xls", file);
				*/
				FileSystemResource file = new FileSystemResource(new File(attachmentpath));
				helper.addAttachment(attachmentname, file);
				
				sender.send(message);
		} catch (MessagingException e) {			
			e.printStackTrace();
		}catch (Exception e) {			
			e.printStackTrace();
		}
	   		
	}

	
	private String getContent() {
		String msg = text ;
        msg += "Please find the attached report";
        msg += "";
        msg += "";
        msg += "";
        msg += "";
        return msg;
	}
	
	 

}
