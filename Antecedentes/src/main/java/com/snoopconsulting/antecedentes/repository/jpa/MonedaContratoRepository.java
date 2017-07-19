package com.snoopconsulting.antecedentes.repository.jpa;

import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

import com.snoopconsulting.antecedentes.domain.MonedaContrato;

@RooJpaRepository(domainType = MonedaContrato.class)
public interface MonedaContratoRepository {
}
