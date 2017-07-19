CREATE TABLE UserConnection (userId varchar(255) not null,
    providerId varchar(255) not null,
    providerUserId varchar(255),
    rank int not null,
    displayName varchar(255),
    profileUrl varchar(512),
    imageUrl varchar(512),
    accessToken varchar(255) not null,					
    secret varchar(255),
    refreshToken varchar(255),
    expireTime bigint,
    primary key (userId, providerId, providerUserId));

CREATE TABLE contacto (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  area_perteneciente varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  id_crm varchar(255) NOT NULL,
  nombre varchar(255) DEFAULT NULL,
  telefono varchar(255) DEFAULT NULL,
  version int(11) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cuenta (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  direccion varchar(255) DEFAULT NULL,
  id_crm varchar(255) DEFAULT NULL,
  linkcrm varchar(255) NOT NULL,
  nombre varchar(255) DEFAULT NULL,
  telefono varchar(255) DEFAULT NULL,
  version int(11) DEFAULT NULL,
  vertical varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE grupo (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  enabled tinyint(1) NOT NULL,
  nombre varchar(255) NOT NULL,
  version int(11) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE moneda_contrato (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  nombre varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY moneda_nombre (nombre)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE pais (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  nombre varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY pais_nombre (nombre)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE sbu (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  nombre varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY sbu_nombre (nombre)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE servicio (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  nombre varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY servicio_nombre (nombre)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE usuario (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  email varchar(255) NOT NULL,
  enabled tinyint(1) NOT NULL,
  nombre varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  version int(11) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE usuario_grupos (
  usuario bigint(20) NOT NULL,
  grupos bigint(20) NOT NULL,
  PRIMARY KEY (usuario,grupos),
  KEY FK492A3B5B404B551B (usuario),
  KEY FK492A3B5B52FDA012 (grupos),
  CONSTRAINT FK492A3B5B52FDA012 FOREIGN KEY (grupos) REFERENCES grupo (id),
  CONSTRAINT FK492A3B5B404B551B FOREIGN KEY (usuario) REFERENCES usuario (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE validacion (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  estado varchar(255) DEFAULT NULL,
  fecha_validacion datetime NOT NULL,
  mensaje varchar(10000) DEFAULT NULL,
  version int(11) DEFAULT NULL,
  usuario bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FKFD5F8E2A404B551B (usuario),
  CONSTRAINT FKFD5F8E2A404B551B FOREIGN KEY (usuario) REFERENCES usuario (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE grupo_permisos_usuarios (
  grupo bigint(20) NOT NULL,
  permisos_usuarios varchar(255) DEFAULT NULL,
  KEY FK15DDCC50A29E2B51 (grupo),
  CONSTRAINT FK15DDCC50A29E2B51 FOREIGN KEY (grupo) REFERENCES grupo (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE antecedente_proyecto (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  area_usuaria varchar(255) DEFAULT NULL,
  cotizacion_moneda decimal(19,2) DEFAULT NULL,
  desc_funcional_proyecto longtext,
  desc_tecnica_proyecto longtext,
  diagrama longblob,
  duracion int(11) DEFAULT NULL,
  estado varchar(255) DEFAULT NULL,
  fecha_carga datetime DEFAULT NULL,
  fecha_fin datetime DEFAULT NULL,
  fecha_inicio datetime DEFAULT NULL,
  fecha_modificacion datetime DEFAULT NULL,
  horas int(11) DEFAULT NULL,
  lider_proyecto varchar(255) DEFAULT NULL,
  logros_obtenidos longtext,
  monto_contrato decimal(19,2) DEFAULT NULL,
  nombre varchar(255) DEFAULT NULL,
  recursos_perfiles longtext,
  tags varchar(255) DEFAULT NULL,
  tipo_solucion varchar(255) DEFAULT NULL,
  version int(11) DEFAULT NULL,
  cliente bigint(20) DEFAULT NULL,
  cliente_final bigint(20) DEFAULT NULL,
  contacto bigint(20) DEFAULT NULL,
  creador_antecedente bigint(20) DEFAULT NULL,
  moneda_contrato bigint(20) DEFAULT NULL,
  pais bigint(20) DEFAULT NULL,
  sbu bigint(20) DEFAULT NULL,
  servicio bigint(20) DEFAULT NULL,
  validaciones bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FKFD96AD26706729BF (contacto),
  KEY FKFD96AD2658768ACD (servicio),
  KEY FKFD96AD262E40EAD8 (moneda_contrato),
  KEY FKFD96AD26BF701A4B (sbu),
  KEY FKFD96AD262E90E757 (pais),
  KEY FKFD96AD2630CB1C9A (cliente_final),
  KEY FKFD96AD2673A23548 (creador_antecedente),
  KEY FKFD96AD263AAEB63 (validaciones),
  KEY FKFD96AD262781DBA3 (cliente),
  CONSTRAINT FKFD96AD262781DBA3 FOREIGN KEY (cliente) REFERENCES cuenta (id),
  CONSTRAINT FKFD96AD262E40EAD8 FOREIGN KEY (moneda_contrato) REFERENCES moneda_contrato (id),
  CONSTRAINT FKFD96AD262E90E757 FOREIGN KEY (pais) REFERENCES pais (id),
  CONSTRAINT FKFD96AD2630CB1C9A FOREIGN KEY (cliente_final) REFERENCES cuenta (id),
  CONSTRAINT FKFD96AD263AAEB63 FOREIGN KEY (validaciones) REFERENCES validacion (id),
  CONSTRAINT FKFD96AD2658768ACD FOREIGN KEY (servicio) REFERENCES servicio (id),
  CONSTRAINT FKFD96AD26706729BF FOREIGN KEY (contacto) REFERENCES contacto (id),
  CONSTRAINT FKFD96AD2673A23548 FOREIGN KEY (creador_antecedente) REFERENCES usuario (id),
  CONSTRAINT FKFD96AD26BF701A4B FOREIGN KEY (sbu) REFERENCES sbu (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into pais(id,nombre) values('1','Argentina');
insert into pais(id,nombre) values('2','Chile');

insert into usuario(id,email,nombre,enabled,username,password, version) values('1','info@snoopconsulting.com','admin','1','admin','a40546cc4fd6a12572828bb803380888ad1bfdab','0');
insert into usuario(id,email,nombre,enabled,username,password, version) values('2','user@user','user','1','user','b6b1f4781776979c0775c71ebdd8bdc084aac5fe','0');
insert into usuario(id,email,nombre,enabled,username,password, version) values('3','federico.balbi@snoopconsulting.com','Fede Balbi','0','federico.balbi@snoopconsulting.com','.','0');
insert into usuario(id,email,nombre,enabled,username,password, version) values('4','roman.cunci@snoopconsulting.com','Roman Cunci','0','roman.cunci@snoopconsulting.com','.','0');


insert into grupo(id,enabled,nombre, version) values('1','1','administrador','0');
insert into grupo(id,enabled,nombre, version) values('2','1','cargador','0');

insert into usuario_grupos (usuario, grupos) values ('1', '1');
insert into usuario_grupos (usuario, grupos) values ('2', '2');
insert into usuario_grupos (usuario, grupos) values ('3', '2');
insert into usuario_grupos (usuario, grupos) values ('4', '2');

insert into grupo_permisos_usuarios (grupo, permisos_usuarios) values ('1', 'ADMINISTRAR_GRUPOS');
insert into grupo_permisos_usuarios (grupo, permisos_usuarios) values ('1', 'ADMINISTRAR_USUARIOS');
insert into grupo_permisos_usuarios (grupo, permisos_usuarios) values ('1', 'ADMINISTRAR_TABLAS_MAESTRAS');
insert into grupo_permisos_usuarios (grupo, permisos_usuarios) values ('1', 'BORRAR_ANTECEDENTE');
insert into grupo_permisos_usuarios (grupo, permisos_usuarios) values ('1', 'CREAR_ANTECEDENTE');
insert into grupo_permisos_usuarios (grupo, permisos_usuarios) values ('1', 'VALIDAR_ANTECEDENTE');
insert into grupo_permisos_usuarios (grupo, permisos_usuarios) values ('1', 'GENERAR_REPORTE');

insert into grupo_permisos_usuarios (grupo, permisos_usuarios) values ('2', 'CREAR_ANTECEDENTE');

insert into servicio(id,nombre) values ('1','Desarrollo');
insert into servicio(id,nombre) values ('2','Consultoria');
insert into servicio(id,nombre) values ('3','Tecnologia');
insert into servicio(id,nombre) values ('4','Agroindustria y Alimentos');
insert into servicio(id,nombre) values ('5','Servicios Financieros');

insert into sbu(id,nombre) values('1','Consultoria');
insert into sbu(id,nombre) values('2','Servicios Profesionales');
insert into sbu(id,nombre) values('3','Desarrollo');
insert into sbu(id,nombre) values('4','Grandes Cuentas');
insert into sbu(id,nombre) values('5','Soluciones');

insert into moneda_contrato(id,nombre) values('1','ARS');
insert into moneda_contrato(id,nombre) values('2','USD');