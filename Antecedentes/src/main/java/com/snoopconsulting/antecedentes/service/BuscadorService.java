package com.snoopconsulting.antecedentes.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto;
import com.snoopconsulting.antecedentes.domain.Cuenta;
import com.snoopconsulting.antecedentes.domain.SBU;
import com.snoopconsulting.antecedentes.domain.Servicio;

public interface BuscadorService {

	/**
	 * Es necesario hacer un spellcheck.build=true contra el solr server la
	 * primera vez, para construir el indice
	 */
	List<String> getSuggestions(String stringQuery);

	Page<AntecedenteProyecto> searchAntecedentes(String searchTerms, Cuenta cuenta, 
			Servicio servicio, Boolean currentUser, SBU sbu, Date fechaDesde, Date fechaHasta, 
			int firstResult, int maxResults);
}
