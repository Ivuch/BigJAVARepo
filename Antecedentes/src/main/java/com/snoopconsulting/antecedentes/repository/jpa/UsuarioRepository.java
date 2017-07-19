package com.snoopconsulting.antecedentes.repository.jpa;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

import com.snoopconsulting.antecedentes.domain.PermisosUsuario;
import com.snoopconsulting.antecedentes.domain.Usuario;

@RooJpaRepository(domainType = Usuario.class)
public interface UsuarioRepository {
	
		
	Usuario findByNombre(String currentUserName);

	@Query(" SELECT DISTINCT u.email FROM Usuario u JOIN u.grupos g JOIN g.permisosUsuarios p WHERE p = ?1")	
	List<String> findEmailsUsarioByPermiso(PermisosUsuario validarAntecedente);
	
	
}

