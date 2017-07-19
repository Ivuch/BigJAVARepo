package com.snoopconsulting.antecedentes.mail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class MailDaoImpl implements MailDao {
   
	@Autowired
	private MailSender mailSender;
	
	@Autowired
    private SimpleMailMessage templateMessage;

	//getters & setters ? w/o @Autowired : none;
    
    public void enviarMail(String subject, String text, String sendTo)
    {
    	SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
    	msg.setSubject(subject);
    	msg.setTo(sendTo);
    	msg.setText(text);
    	this.mailSender.send(msg);
    	
    }
    
    public void enviarMail(String subject, String text, List<String> sendTo)
    {
    	String[] mails =  sendTo.toArray(new String[sendTo.size()]);
    	SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
    	msg.setSubject(subject);
    	msg.setTo(mails);
    	msg.setText(text);
    	this.mailSender.send(msg);
    	
    }
}