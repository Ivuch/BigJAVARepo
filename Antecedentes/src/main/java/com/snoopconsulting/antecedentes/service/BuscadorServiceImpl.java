package com.snoopconsulting.antecedentes.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snoopconsulting.antecedentes.common.AntecedenteDocumentParser;
import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto;
import com.snoopconsulting.antecedentes.domain.Cuenta;
import com.snoopconsulting.antecedentes.domain.SBU;
import com.snoopconsulting.antecedentes.domain.Servicio;
import com.snoopconsulting.antecedentes.domain.solr.AntecedenteSolrDocument;
import com.snoopconsulting.antecedentes.repository.solr.AntecedenteDocumentSearch;
import com.snoopconsulting.antecedentes.security.SecurityUtils;

@Service
@Transactional
public class BuscadorServiceImpl implements BuscadorService {

	@Autowired
	private AntecedenteDocumentSearch searcher;

	@Autowired
	private AntecedenteDocumentParser parser;

	@Override
	public Page<AntecedenteProyecto> searchAntecedentes(String searchTerms,	Cuenta cuenta, 
			Servicio servicio, Boolean currentUser, SBU sbu, Date fechaDesde, Date fechaHasta,
			int firstResult, int maxResults) {

		String nombreUsuario = null;

		if (currentUser) {
			nombreUsuario = SecurityUtils.getCurrentUserName();
		}
		
		Pageable pageable = new PageRequest(firstResult / maxResults, maxResults);
		
		Page<AntecedenteSolrDocument> antecedentesPage = 
				searcher.findByKeywords(searchTerms, cuenta, servicio, nombreUsuario, sbu, fechaDesde, fechaHasta, pageable);

		return new PageImpl<AntecedenteProyecto>(
				parser.parseToAntecedentesList(antecedentesPage.getContent()), pageable, antecedentesPage.getTotalElements());
		
	}

	@Override
	public List<String> getSuggestions(String stringQuery) {
		return searcher.getSuggestions(stringQuery);
	}
}
