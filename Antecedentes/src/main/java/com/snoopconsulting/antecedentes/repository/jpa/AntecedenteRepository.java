package com.snoopconsulting.antecedentes.repository.jpa;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto;
import com.snoopconsulting.antecedentes.domain.EstadoAntecedente;
import com.snoopconsulting.antecedentes.domain.Usuario;

@RooJpaRepository(domainType = AntecedenteProyecto.class)
public interface AntecedenteRepository {

	Page<AntecedenteProyecto> findByEstadoInAndCreadorAntecedente(Collection<EstadoAntecedente> estados, 
			Usuario creadorAntecedente,	Pageable pageable);

	@Query("FROM AntecedenteProyecto a WHERE a.estado IN ?1 OR (a.estado IN ?2 AND a.creadorAntecedente = ?3)")
	Page<AntecedenteProyecto> findByEstadoInOrEstadoInAndCreadorAntecedente(List<EstadoAntecedente> estados, 
			List<EstadoAntecedente> estados2, Usuario creadorAntecedente, Pageable pageable);
}
