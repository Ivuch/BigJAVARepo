package com.snoopconsulting.antecedentes.service;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;
import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto;
import com.snoopconsulting.antecedentes.domain.AntecedenteProyectoDataOnDemand;
import com.snoopconsulting.antecedentes.domain.EstadoAntecedente;
import com.snoopconsulting.antecedentes.domain.Usuario;
import com.snoopconsulting.antecedentes.domain.UsuarioDataOnDemand;
import com.snoopconsulting.antecedentes.domain.solr.AntecedenteSolrDocument;
import com.snoopconsulting.antecedentes.repository.jpa.AntecedenteRepository;
import com.snoopconsulting.antecedentes.repository.solr.AntecedenteDocumentIndex;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring-test/applicationContext*-test.xml")
public class AntecedenteProyectoServiceIntegrationTest {

//	private static final Long CANTIDAD = 5L;
//	private static final Long CANTIDAD_2 = 2L;
//
//	@Autowired
//	private AntecedenteProyectoService service;
//
//	@Autowired
//	private AntecedenteRepository antecedenteRepository;
//
//	@Autowired
//	private AntecedenteDocumentIndex antecedenteDocumentIndex;
//
//	@Autowired
//	private AntecedenteProyectoDataOnDemand dod;
//
//	@Autowired
//	private UsuarioDataOnDemand usuarioDod;
//
//	private AntecedenteProyecto antecedente;
//
//	private List<EstadoAntecedente> unEstado;
//
//	private List<EstadoAntecedente> dosEstados;
//
//	@Before
//	public void setUp() {
//
//		unEstado = Lists.newArrayList(EstadoAntecedente.APROBADO);
//		dosEstados = Lists.newArrayList(EstadoAntecedente.APROBADO,
//				EstadoAntecedente.INCOMPLETO);
//	}
//
//	@After
//	public void tearDown() {
//		antecedenteDocumentIndex.deleteAll();
//		antecedenteRepository.deleteAll();
//	}
//
//	@Test
//	public void testCreateAntecedente() {
//
//		antecedente = dod.getNewTransientAntecedenteProyecto(1);
//		antecedente = service.saveAntecedenteProyecto(antecedente);
//
//		AntecedenteProyecto dbAntecedente = antecedenteRepository
//				.findOne(antecedente.getId());
//
//		Assert.assertNotNull(dbAntecedente);
//		Assert.assertEquals(antecedente.getId(), dbAntecedente.getId());
//		Assert.assertEquals(antecedente.getNombre(), dbAntecedente.getNombre());
//
//		String id = antecedente.getId().toString();
//
//		AntecedenteSolrDocument document = antecedenteDocumentIndex.findOne(id);
//
//		Assert.assertNotNull(document);
//		Assert.assertEquals(document.getId(), id);
//		Assert.assertEquals(antecedente.getNombre(), document.getNombre());
//	}
//
//	@Test
//	public void testDeleteAntecedente() {
//
//		antecedente = dod.getNewTransientAntecedenteProyecto(1);
//		antecedente = service.saveAntecedenteProyecto(antecedente);
//
//		service.deleteAntecedenteProyecto(antecedente.getId());
//
//		Assert.assertEquals(antecedenteRepository.count(), 0);
//	}

//	@Test
//	public void testFindByEstadosIn() {
//		dod.createWithEstadoAndCreator(CANTIDAD, EstadoAntecedente.APROBADO, null);
//		dod.createWithEstadoAndCreator(CANTIDAD_2, EstadoAntecedente.INCOMPLETO, null);
//
//		Page<AntecedenteProyecto> antecedentes = service.findByEstados(unEstado, 0, 10);
//
//		Assert.assertNotNull(antecedentes);
//		Assert.assertTrue(antecedentes.getNumberOfElements() == CANTIDAD);
//
//		antecedentes = service.findByEstados(dosEstados, 0, 10);
//
//		Assert.assertNotNull(antecedentes);
//		Assert.assertTrue(antecedentes.getNumberOfElements() == CANTIDAD + CANTIDAD_2);
//	}
//
//	@Test
//	public void testFindByEstadosInPageable() {
//		dod.createWithEstadoAndCreator(CANTIDAD, EstadoAntecedente.APROBADO, null);
//
//		Page<AntecedenteProyecto> antecedentes = service.findByEstados(unEstado, 0, 3);
//
//		Assert.assertNotNull(antecedentes);
//		Assert.assertTrue(antecedentes.getNumberOfElements() == 3);
//
//		antecedentes = service.findByEstados(unEstado, 1, 2);
//
//		Assert.assertNotNull(antecedentes);
//		Assert.assertTrue(antecedentes.getNumberOfElements() == 2);
//		Assert.assertTrue(antecedentes.getTotalElements() == CANTIDAD);
//
//		antecedentes = service.findByEstados(unEstado, (int) (CANTIDAD + 1), 1);
//
//		Assert.assertNotNull(antecedentes);
//		Assert.assertTrue(antecedentes.getNumberOfElements() == 0);
//	}
//
//	@Test
//	public void testFindAndCountByEstadosAndCreator() {
//
//		usuarioDod.init();
//		Usuario usuario = usuarioDod.getSpecificUsuario(1);
//		Usuario usuario2 = usuarioDod.getSpecificUsuario(2);
//
//		dod.createWithEstadoAndCreator(CANTIDAD, EstadoAntecedente.APROBADO,
//				usuario);
//		dod.createWithEstadoAndCreator(CANTIDAD_2,
//				EstadoAntecedente.INCOMPLETO, usuario);
//		dod.createWithEstadoAndCreator(CANTIDAD_2, EstadoAntecedente.APROBADO,
//				usuario2);
//
//		Page<AntecedenteProyecto> antecedentes = service
//				.findByEstadosAndCreator(unEstado, usuario, 0, 10);
//
//		Assert.assertTrue(antecedentes.getNumberOfElements() == CANTIDAD);
//
//		antecedentes = service.findByEstadosAndCreator(dosEstados, usuario, 0,
//				10);
//
//		Assert.assertTrue(antecedentes.getNumberOfElements() == CANTIDAD + CANTIDAD_2);
//	}

//	@Test
//	public void testValidarAntecedente() {
//		antecedente = dod.getNewTransientAntecedenteProyecto(1);
//		
//		antecedente = service.saveAntecedenteProyecto(antecedente);
//
//		
//		service.validarAntecedente(antecedente.getId());
//
//		AntecedenteProyecto dbAntecedente = service
//				.findAntecedenteProyecto(antecedente.getId());
//
//		Assert.assertEquals(dbAntecedente.getEstado(),
//				EstadoAntecedente.APROBADO);
//	}

}
