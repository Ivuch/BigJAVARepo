// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.snoopconsulting.antecedentes.domain;

import com.snoopconsulting.antecedentes.domain.Grupo;
import com.snoopconsulting.antecedentes.domain.Usuario;
import java.util.Set;

privileged aspect Usuario_Roo_JavaBean {
    
    public String Usuario.getUsername() {
        return this.username;
    }
    
    public void Usuario.setUsername(String username) {
        this.username = username;
    }
    
    public String Usuario.getNombre() {
        return this.nombre;
    }
    
    public void Usuario.setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String Usuario.getEmail() {
        return this.email;
    }
    
    public void Usuario.setEmail(String email) {
        this.email = email;
    }
    
    public Set<Grupo> Usuario.getGrupos() {
        return this.grupos;
    }
    
    public void Usuario.setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    public boolean Usuario.isEnabled() {
        return this.enabled;
    }
    
    public void Usuario.setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public String Usuario.getPassword() {
        return this.password;
    }
    
    public void Usuario.setPassword(String password) {
        this.password = password;
    }
    
}
