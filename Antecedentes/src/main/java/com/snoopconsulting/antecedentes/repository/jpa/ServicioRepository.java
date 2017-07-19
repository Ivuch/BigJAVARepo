package com.snoopconsulting.antecedentes.repository.jpa;
import com.snoopconsulting.antecedentes.domain.Servicio;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Servicio.class)
public interface ServicioRepository {
}
