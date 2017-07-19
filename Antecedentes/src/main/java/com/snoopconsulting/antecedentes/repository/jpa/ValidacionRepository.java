package com.snoopconsulting.antecedentes.repository.jpa;

import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

import com.snoopconsulting.antecedentes.domain.Validacion;

@RooJpaRepository(domainType = Validacion.class)
public interface ValidacionRepository {
}
