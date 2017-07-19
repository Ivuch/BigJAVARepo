package com.snoopconsulting.antecedentes.repository.jpa;
import com.snoopconsulting.antecedentes.domain.Grupo;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Grupo.class)
public interface GrupoRepository {
}
