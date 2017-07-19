package com.snoopconsulting.antecedentes.repository.solr;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.snoopconsulting.antecedentes.domain.Cuenta;
import com.snoopconsulting.antecedentes.domain.SBU;
import com.snoopconsulting.antecedentes.domain.Servicio;
import com.snoopconsulting.antecedentes.domain.solr.AntecedenteSolrDocument;

public interface AntecedenteDocumentSearch {

	Page<AntecedenteSolrDocument> findByKeywords(String searchTerms, Cuenta cliente, 
			Servicio servicio, String nombreUsuario, SBU sbu, Date fechaDesde, Date fechaHasta, Pageable pageable);
	
	List<String> getSuggestions(String searchQuery);
}
