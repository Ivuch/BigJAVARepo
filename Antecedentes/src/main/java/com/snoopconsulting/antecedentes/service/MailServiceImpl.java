package com.snoopconsulting.antecedentes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto;
import com.snoopconsulting.antecedentes.domain.EstadoAntecedente;
import com.snoopconsulting.antecedentes.domain.PermisosUsuario;
import com.snoopconsulting.antecedentes.mail.MailDao;
import com.snoopconsulting.antecedentes.repository.jpa.UsuarioRepository;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private MailDao mailDao;
	
	@Autowired
	private UsuarioRepository usuarioRepository;	
	
	public void enviarMail(AntecedenteProyecto antecedente)
	{
		String text, subject;
		if(antecedente.getEstado().equals(EstadoAntecedente.PENDIENTE_APROBACION) ||
				antecedente.getEstado().equals(EstadoAntecedente.MODIFICADO)){
			List<String> mails = usuarioRepository.findEmailsUsarioByPermiso(PermisosUsuario.VALIDAR_ANTECEDENTE);
			text ="Tiene un antecedente para validar en su Bandeja de Entrada.";
			subject = "Nuevo antecedente para validar";
			mailDao.enviarMail(subject,text, mails);
		}
		else if(antecedente.getEstado().equals(EstadoAntecedente.APROBADO)){
			String mail = antecedente.getCreadorAntecedente().getEmail();			
			text ="Se aprobo tu Antecedente "+antecedente.getNombre();
			subject = "Antecedente aprobado";
			mailDao.enviarMail(subject,text, mail);
		}
		else if(antecedente.getEstado().equals(EstadoAntecedente.RECHAZADO) ){
			String mail = antecedente.getCreadorAntecedente().getEmail();
			text ="Tu antecedente "+antecedente.getNombre()+" ha sido rechazado por:" + 
					antecedente.getValidaciones().getMensaje();
			subject = "Antecedente rechazado";
			mailDao.enviarMail(subject,text, mail);
		}
		
		
	}
	
	
}
