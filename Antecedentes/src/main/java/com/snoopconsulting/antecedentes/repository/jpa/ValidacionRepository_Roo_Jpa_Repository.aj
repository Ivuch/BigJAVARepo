// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.snoopconsulting.antecedentes.repository.jpa;

import com.snoopconsulting.antecedentes.domain.Validacion;
import com.snoopconsulting.antecedentes.repository.jpa.ValidacionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

privileged aspect ValidacionRepository_Roo_Jpa_Repository {
    
    declare parents: ValidacionRepository extends JpaRepository<Validacion, Long>;
    
    declare parents: ValidacionRepository extends JpaSpecificationExecutor<Validacion>;
    
    declare @type: ValidacionRepository: @Repository;
    
}
