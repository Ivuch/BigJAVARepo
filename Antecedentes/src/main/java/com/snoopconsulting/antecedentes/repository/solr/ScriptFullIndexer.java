package com.snoopconsulting.antecedentes.repository.solr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snoopconsulting.antecedentes.common.AntecedenteDocumentParser;
import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto;
import com.snoopconsulting.antecedentes.domain.solr.AntecedenteSolrDocument;
import com.snoopconsulting.antecedentes.repository.jpa.AntecedenteRepository;

@Service
public class ScriptFullIndexer {

	@Autowired
	private AntecedenteRepository repository;
	
	@Autowired
	private AntecedenteDocumentIndex index;
	
	@Autowired
	private AntecedenteDocumentParser parser;
	
	@Transactional
	public void reindexarDB(){
		List<AntecedenteSolrDocument> documents = new ArrayList<AntecedenteSolrDocument>();
		
		for (AntecedenteProyecto antecedente : repository.findAll()) {
			documents.add(parser.parseToDocument(antecedente));
		}
		
		index.save(documents);
		
	}
}
