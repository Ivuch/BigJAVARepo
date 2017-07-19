package com.snoopconsulting.antecedentes.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto;
import com.snoopconsulting.antecedentes.domain.Cuenta;
import com.snoopconsulting.antecedentes.domain.EstadoAntecedente;
import com.snoopconsulting.antecedentes.domain.solr.AntecedenteSolrDocument;

@Component
public class AntecedenteDocumentParser {

	public AntecedenteSolrDocument parseToDocument(
			AntecedenteProyecto antecedenteProyecto) {
		AntecedenteSolrDocument document = new AntecedenteSolrDocument();

		document.setId(antecedenteProyecto.getId().toString());
		document.setNombre(antecedenteProyecto.getNombre());
		document.setEstado(antecedenteProyecto.getEstado().toString());
		document.setAreaUsuaria(antecedenteProyecto.getAreaUsuaria());
		if (antecedenteProyecto.getCliente() != null) {
			document.setCliente(antecedenteProyecto.getCliente().getNombre());
		}
		if (antecedenteProyecto.getClienteFinal() != null) {
			document.setClienteFinal(antecedenteProyecto.getClienteFinal()
					.getNombre());
		}
		if (antecedenteProyecto.getCreadorAntecedente() != null) {
			document.setCreadorAntecedente(antecedenteProyecto
					.getCreadorAntecedente().getNombre());
		}
		document.setDescFuncionalProyecto(antecedenteProyecto
				.getDescFuncionalProyecto());
		document.setDescTecnicaProyecto(antecedenteProyecto
				.getDescTecnicaProyecto());
		document.setFechaCarga(antecedenteProyecto.getFechaCarga());
		document.setFechaFin(antecedenteProyecto.getFechaFin());
		document.setFechaInicio(antecedenteProyecto.getFechaInicio());
		document.setFechaModificacion(antecedenteProyecto
				.getFechaModificacion());
		document.setLiderProyecto(antecedenteProyecto.getLiderProyecto());
		document.setLogrosObtenidos(antecedenteProyecto.getLogrosObtenidos());
		if (antecedenteProyecto.getMonedaContrato() != null) {
			document.setMonedaContrato(antecedenteProyecto.getMonedaContrato()
					.getNombre());
		}
		if (antecedenteProyecto.getPais() != null) {
			document.setPais(antecedenteProyecto.getPais().getNombre());
		}
		document.setRecursosPerfiles(antecedenteProyecto.getRecursosPerfiles());
		if (antecedenteProyecto.getSbu() != null) {
			document.setSbu(antecedenteProyecto.getSbu().getNombre());
		}
		if (antecedenteProyecto.getServicio() != null) {
			document.setServicio(antecedenteProyecto.getServicio().getNombre());
		}
		document.setTags(antecedenteProyecto.getTags());
		if (antecedenteProyecto.getTipoSolucion() != null) {
			document.setTipoSolucion(antecedenteProyecto.getTipoSolucion());
		}
		return document;

	}

	public List<AntecedenteProyecto> parseToAntecedentesList(
			List<AntecedenteSolrDocument> documents) {
		List<AntecedenteProyecto> antecedentes = new ArrayList<AntecedenteProyecto>();
		AntecedenteProyecto antecedente;
		for (AntecedenteSolrDocument document : documents) {
			antecedente = new AntecedenteProyecto();
			antecedente.setNombre(document.getNombre());
			Cuenta cuenta = new Cuenta();
			cuenta.setNombre(document.getCliente());
			antecedente.setCliente(cuenta);
			antecedente.setId(Long.valueOf(document.getId()));
			antecedente.setEstado(EstadoAntecedente.valueOf(document
					.getEstado()));
			antecedentes.add(antecedente);
		}
		return antecedentes;
	}
}
