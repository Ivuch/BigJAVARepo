package com.snoopconsulting.antecedentes.repository.solr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.SimpleStringCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snoopconsulting.antecedentes.domain.Cuenta;
import com.snoopconsulting.antecedentes.domain.SBU;
import com.snoopconsulting.antecedentes.domain.Servicio;
import com.snoopconsulting.antecedentes.domain.solr.AntecedenteSolrDocument;

@Service
@Transactional
public class AntecedenteDocumentSearchImpl implements AntecedenteDocumentSearch {

	@Autowired
	private SolrTemplate solrTemplate;

	@Override
	public Page<AntecedenteSolrDocument> findByKeywords(String searchTerms,
			Cuenta cuenta, Servicio servicio, String nombreUsuario, SBU sbu,
			Date fechaDesde, Date fechaHasta, Pageable pageable) {

		searchTerms = searchTerms.toLowerCase();

		if (searchTerms == null || searchTerms.isEmpty()) {
			searchTerms = "*";
		} else {
			String[] terms = searchTerms.split(",");
			searchTerms = "(";
			for (String term : terms) {
				searchTerms = searchTerms + "+" + term + " ";
			}
			searchTerms = searchTerms + ")";
		}

		Criteria criteria = new Criteria("text");
		criteria.expression(searchTerms);

		if (cuenta != null && !cuenta.getNombre().isEmpty()) {
			criteria.and(new SimpleStringCriteria("clienteFinal:\""
					+ cuenta.getNombre() + "\""));
		}

		if (servicio != null && !servicio.getNombre().isEmpty()) {
			criteria.and(new SimpleStringCriteria("servicio:\""
					+ servicio.getNombre() + "\""));
		}

		if (sbu != null && !sbu.getNombre().isEmpty()) {
			criteria.and(new SimpleStringCriteria("sbu:\"" + sbu.getNombre()
					+ "\""));
		}

		if (nombreUsuario != null && !nombreUsuario.isEmpty()) {
			criteria.and(new SimpleStringCriteria("creadorAntecedente:\""
					+ nombreUsuario + "\""));
		}

		if (fechaDesde != null) {
			Criteria desdeCriteria = new Criteria("fechaInicio");
			desdeCriteria.greaterThanEqual(fechaDesde);
			criteria.and(desdeCriteria);
		}

		if (fechaHasta != null) {
			Criteria hastaCriteria = new Criteria("fechaFin");
			hastaCriteria.lessThanEqual(fechaHasta);
			criteria.and(hastaCriteria);
		}

		Query query = new SimpleQuery(criteria).setPageRequest(pageable);

		return solrTemplate.queryForPage(query, AntecedenteSolrDocument.class);
	}

	@Override
	public List<String> getSuggestions(String searchQuery) {
		List<String> suggestions = new ArrayList<String>();

		searchQuery = searchQuery.toLowerCase();
		
		SolrQuery query = new SolrQuery();
		query.setRequestHandler("/suggest");
		
		query.set("q", searchQuery);
		query.add("text_autocomplete", searchQuery);
		QueryResponse result;
		try {
			result = solrTemplate.getSolrServer().query(query);

			if (!result.getSpellCheckResponse().getSuggestions().isEmpty()) {
				suggestions = result.getSpellCheckResponse().getSuggestions()
						.get(0).getAlternatives();
			}
			if (!result.getResults().isEmpty()) {
				suggestions.add(searchQuery);
			}
		} catch (Exception e) {
		}

		return suggestions;
	}

}
