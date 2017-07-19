package com.snoopconsulting.antecedentes.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto;

public interface AntecedenteProyectoService {

	AntecedenteProyecto saveAntecedenteProyecto(AntecedenteProyecto antecedenteProyecto);

	void deleteAntecedenteProyecto(Long id);

	AntecedenteProyecto findAntecedenteProyecto(Long id);

	List<AntecedenteProyecto> findAllAntecedenteProyectoes();

	void validarAntecedente(Long id);

	AntecedenteProyecto completarNuevoAntecedente(AntecedenteProyecto antecedenteProyecto);

	void rechazarAntecedente(Long id, String motivoRechazo);

	AntecedenteProyecto completarClientes(AntecedenteProyecto antecedenteProyecto);

	List<AntecedenteProyecto> findAll(List<Long> idsAsList);

	Page<AntecedenteProyecto> getAntecedentesForCurrentUser(int firstResult, int sizeNo);	

}
