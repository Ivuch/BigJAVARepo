package com.snoopconsulting.antecedentes.repository.jpa;
import com.snoopconsulting.antecedentes.domain.Contacto;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Contacto.class)
public interface ContactoRepository {
}
