package com.snoopconsulting.antecedentes.domain;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.test.RooIntegrationTest;
import org.springframework.test.context.ContextConfiguration;

import com.google.common.collect.Sets;
import com.snoopconsulting.antecedentes.repository.jpa.GrupoRepository;

@RooIntegrationTest(entity = Usuario.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring-test/applicationContext*-test.xml")
public class UsuarioIntegrationTest {

//	@Autowired
//	private GrupoRepository grupoRepository;
//
//	@Autowired
//	private GrupoDataOnDemand grupoDod;
//
//	@Test
//	public void testFindEmailsUsarioByPermiso() {
//		Grupo grupo = grupoDod.getNewTransientGrupo(1);
//		grupo.setPermisosUsuarios(Sets
//				.newHashSet(PermisosUsuario.VALIDAR_ANTECEDENTE));
//		grupo = grupoRepository.save(grupo);
//
//		Grupo grupo2 = grupoDod.getNewTransientGrupo(2);
//		grupo2.setPermisosUsuarios(Sets
//				.newHashSet(PermisosUsuario.ADMINISTRAR_USUARIOS));
//		grupo2 = grupoRepository.save(grupo2);
//
//		Grupo grupo3 = grupoDod.getNewTransientGrupo(3);
//		grupo3.setPermisosUsuarios(Sets.newHashSet(
//				PermisosUsuario.ADMINISTRAR_USUARIOS,
//				PermisosUsuario.CREAR_ANTECEDENTE));
//		grupo3 = grupoRepository.save(grupo3);
//
//		Usuario usuario = dod.getNewTransientUsuario(1);
//		usuario.setGrupos(Sets.newHashSet(grupo));
//		usuarioRepository.save(usuario);
//
//		Usuario usuario2 = dod.getNewTransientUsuario(2);
//		usuario2.setGrupos(Sets.newHashSet(grupo2));
//		usuarioRepository.save(usuario2);
//
//		Usuario usuario3 = dod.getNewTransientUsuario(3);
//		usuario3.setGrupos(Sets.newHashSet(grupo, grupo2));
//		usuarioRepository.save(usuario3);
//
//		Usuario usuario4 = dod.getNewTransientUsuario(4);
//		usuario4.setGrupos(Sets.newHashSet(grupo2, grupo3));
//		usuarioRepository.save(usuario4);
//
//		List<String> mails = usuarioRepository
//				.findEmailsUsarioByPermiso(PermisosUsuario.VALIDAR_ANTECEDENTE);
//
//		Assert.assertTrue(mails.size() == 2);
//
//		mails = usuarioRepository
//				.findEmailsUsarioByPermiso(PermisosUsuario.ADMINISTRAR_USUARIOS);
//
//		Assert.assertTrue(mails.size() == 3);
//
//		mails = usuarioRepository
//				.findEmailsUsarioByPermiso(PermisosUsuario.CREAR_ANTECEDENTE);
//
//		Assert.assertTrue(mails.size() == 1);
//
//	}
}
