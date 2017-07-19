package com.snoopconsulting.antecedentes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.converter.RooConversionService;

import com.snoopconsulting.antecedentes.domain.Contacto;
import com.snoopconsulting.antecedentes.domain.Cuenta;
import com.snoopconsulting.antecedentes.domain.MonedaContrato;
import com.snoopconsulting.antecedentes.domain.Pais;
import com.snoopconsulting.antecedentes.domain.SBU;
import com.snoopconsulting.antecedentes.domain.Servicio;
import com.snoopconsulting.antecedentes.repository.jpa.ContactoRepository;
import com.snoopconsulting.antecedentes.repository.jpa.CuentaRepository;
import com.snoopconsulting.antecedentes.repository.jpa.MonedaContratoRepository;
import com.snoopconsulting.antecedentes.repository.jpa.PaisRepository;
import com.snoopconsulting.antecedentes.repository.jpa.SBURepository;
import com.snoopconsulting.antecedentes.repository.jpa.ServicioRepository;

/**
 * A central place to register application converters and formatters.
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends
		FormattingConversionServiceFactoryBean {

	@Autowired
	private MonedaContratoRepository monedaRepository;
	@Autowired
	private ServicioRepository servicioRepository;
	@Autowired
	private SBURepository sbuRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private CuentaRepository cuentaRepository;
	@Autowired
	private ContactoRepository contactoRepository;

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
		registry.addConverter(getIdToCuentaConverter());
		registry.addConverter(getIdToContactoConverter());
		registry.addConverter(getIdToPaisConverter());
		registry.addConverter(getIdToSBUConverter());
		registry.addConverter(getIdToServicioConverter());
		registry.addConverter(getIdToMonedaContratoConverter());

		registry.addConverter(getStringToCuentaConverter());
		registry.addConverter(getStringToContactoConverter());
		registry.addConverter(getStringToPaisConverter());
		registry.addConverter(getStringToSBUConverter());
		registry.addConverter(getStringToServicioConverter());
		registry.addConverter(getStringToMonedaContratoConverter());
	}

	public Converter<Long, Cuenta> getIdToCuentaConverter() {
		return new Converter<Long, Cuenta>() {
			public Cuenta convert(Long id) {
				return cuentaRepository.findOne(id);
			}
		};
	}

	public Converter<Long, Contacto> getIdToContactoConverter() {
		return new Converter<Long, Contacto>() {
			public Contacto convert(Long id) {
				return contactoRepository.findOne(id);
			}
		};
	}

	public Converter<Long, Pais> getIdToPaisConverter() {
		return new Converter<Long, Pais>() {
			public Pais convert(Long id) {
				return paisRepository.findOne(id);
			}
		};
	}

	public Converter<Long, SBU> getIdToSBUConverter() {
		return new Converter<Long, SBU>() {
			public SBU convert(Long id) {
				return sbuRepository.findOne(id);
			}
		};
	}

	public Converter<Long, Servicio> getIdToServicioConverter() {
		return new Converter<Long, Servicio>() {
			public Servicio convert(Long id) {
				return servicioRepository.findOne(id);
			}
		};
	}

	public Converter<Long, MonedaContrato> getIdToMonedaContratoConverter() {
		return new Converter<Long, MonedaContrato>() {
			public MonedaContrato convert(Long id) {
				return monedaRepository.findOne(id);
			}
		};
	}

	public Converter<String, Cuenta> getStringToCuentaConverter() {
		return new Converter<String, Cuenta>() {
			public Cuenta convert(String id) {
				return getObject().convert(getObject().convert(id, Long.class),
						Cuenta.class);
			}
		};
	}

	public Converter<String, Contacto> getStringToContactoConverter() {
		return new Converter<String, Contacto>() {
			public Contacto convert(String id) {
				return getObject().convert(getObject().convert(id, Long.class),
						Contacto.class);
			}
		};
	}

	public Converter<String, Pais> getStringToPaisConverter() {
		return new Converter<String, Pais>() {
			public Pais convert(String id) {
				return getObject().convert(getObject().convert(id, Long.class),
						Pais.class);
			}
		};
	}

	public Converter<String, Servicio> getStringToServicioConverter() {
		return new Converter<String, Servicio>() {
			public Servicio convert(String id) {
				return getObject().convert(getObject().convert(id, Long.class),
						Servicio.class);
			}
		};
	}

	public Converter<String, SBU> getStringToSBUConverter() {
		return new Converter<String, SBU>() {
			public SBU convert(String id) {
				return getObject().convert(getObject().convert(id, Long.class),
						SBU.class);
			}
		};
	}

	public Converter<String, MonedaContrato> getStringToMonedaContratoConverter() {
		return new Converter<String, MonedaContrato>() {
			public MonedaContrato convert(String id) {
				return getObject().convert(getObject().convert(id, Long.class),
						MonedaContrato.class);
			}
		};
	}
}
