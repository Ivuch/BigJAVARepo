package com.snoopconsulting.antecedentes.repository.jpa;
import com.snoopconsulting.antecedentes.domain.Cuenta;

import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Cuenta.class)
public interface CuentaRepository {

	Cuenta findByIdCrm(String id);
}
