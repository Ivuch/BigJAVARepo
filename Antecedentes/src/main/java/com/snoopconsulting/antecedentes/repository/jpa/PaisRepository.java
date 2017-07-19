package com.snoopconsulting.antecedentes.repository.jpa;
import com.snoopconsulting.antecedentes.domain.Pais;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Pais.class)
public interface PaisRepository {
}
