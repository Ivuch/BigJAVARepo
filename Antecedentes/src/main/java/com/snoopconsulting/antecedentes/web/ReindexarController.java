package com.snoopconsulting.antecedentes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.snoopconsulting.antecedentes.repository.solr.ScriptFullIndexer;

@Controller
public class ReindexarController {

	@Autowired
	private ScriptFullIndexer indexer;
	
	@RequestMapping(value = "/reindexar", produces = "text/html")
	public String reindexar(){
		indexer.reindexarDB();
		return "redirect:/bandeja";
	}
}
