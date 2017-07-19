package com.snoopconsulting.antecedentes.mail;

import java.util.List;

public interface MailDao {
	public void enviarMail(String subject, String text, String sendTo);
	public void enviarMail(String subject, String text, List<String> sendTo);
}
