package com.snoopconsulting.antecedentes.repository.solr;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.snoopconsulting.antecedentes.domain.solr.AntecedenteSolrDocument;

@Repository
public interface AntecedenteDocumentIndex extends
		SolrCrudRepository<AntecedenteSolrDocument, String> {
}
