package com.reservation.utilities;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendItinerary(String toAddress, String filePath) {
		MimeMessage message=javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper=new MimeMessageHelper(message,true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject("Details Of Flight");
			messageHelper.setText("Please Find the Attached");
			messageHelper.addAttachment("Itinerary", new File(filePath));
			javaMailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
