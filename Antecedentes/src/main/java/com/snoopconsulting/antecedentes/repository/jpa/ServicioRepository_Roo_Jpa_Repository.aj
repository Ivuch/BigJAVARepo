// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.snoopconsulting.antecedentes.repository.jpa;

import com.snoopconsulting.antecedentes.domain.Servicio;
import com.snoopconsulting.antecedentes.repository.jpa.ServicioRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

privileged aspect ServicioRepository_Roo_Jpa_Repository {
    
    declare parents: ServicioRepository extends JpaRepository<Servicio, Long>;
    
    declare parents: ServicioRepository extends JpaSpecificationExecutor<Servicio>;
    
    declare @type: ServicioRepository: @Repository;
    
}
