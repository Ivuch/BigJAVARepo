// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.snoopconsulting.antecedentes.domain;

import com.snoopconsulting.antecedentes.domain.Grupo;
import com.snoopconsulting.antecedentes.domain.PermisosUsuario;
import java.util.Set;

privileged aspect Grupo_Roo_JavaBean {
    
    public Set<PermisosUsuario> Grupo.getPermisosUsuarios() {
        return this.permisosUsuarios;
    }
    
    public void Grupo.setPermisosUsuarios(Set<PermisosUsuario> permisosUsuarios) {
        this.permisosUsuarios = permisosUsuarios;
    }
    
    public String Grupo.getNombre() {
        return this.nombre;
    }
    
    public void Grupo.setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean Grupo.isEnabled() {
        return this.enabled;
    }
    
    public void Grupo.setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
}
