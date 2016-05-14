--------------------------------------------------------------
ciudad
--------------------------------------------------------------
CREATE TABLE `vuelo`.`ciudad` (
  `ciudad` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`ciudad`)
)
ENGINE = InnoDB;
--------------------------------------------------------------


--------------------------------------------------------------
vuelo
--------------------------------------------------------------
CREATE TABLE `vuelo`.`vuelo` (
  `nro_vuelo` BIGINT UNSIGNED NOT NULL DEFAULT NULL AUTO_INCREMENT,
  `fecha_salida` DATE NOT NULL,
  `fecha_arribo` DATE NOT NULL,
  `ciudad_origen` VARCHAR(25) NOT NULL,
  `ciudad_destino` VARCHAR(25) NOT NULL,
  `ctd_asientos` INTEGER UNSIGNED NOT NULL,
  `ctd_asientos_ocupados` INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY (`nro_vuelo`),
  CONSTRAINT `fk_vuelo_ciudad_origen` FOREIGN KEY `fk_vuelo_ciudad_origen` (`ciudad_origen`)
    REFERENCES `ciudad` (`ciudad`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_vuelo_ciudad_destino` FOREIGN KEY `fk_vuelo_ciudad_destino` (`ciudad_destino`)
    REFERENCES `ciudad` (`ciudad`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
)
ENGINE = InnoDB;
--------------------------------------------------------------


--------------------------------------------------------------
reserva_vuelo
--------------------------------------------------------------
CREATE TABLE `vuelo`.`reserva_vuelo` (
  `nro_vuelo` BIGINT UNSIGNED NOT NULL DEFAULT NULL AUTO_INCREMENT,
  `nro_documento_pasajero` BIGINT UNSIGNED NOT NULL,
  `pasajero` VARCHAR(35) NOT NULL,
  PRIMARY KEY (`nro_vuelo`, `nro_documento_pasajero`),
  CONSTRAINT `fk_reserva_vuelo_nro_vuelo` FOREIGN KEY `fk_reserva_vuelo_nro_vuelo` (`nro_vuelo`)
    REFERENCES `vuelo` (`nro_vuelo`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
)
ENGINE = InnoDB;
--------------------------------------------------------------


--------------------------------------------------------------
carga de datos
--------------------------------------------------------------
INSERT INTO ciudad (ciudad)
  VALUES
    ('BUENOS AIRES'),
    ('CORDOBA'),
    ('NEUQUEN'),
    ('SALTA'),
    ('SANTA FE');

INSERT INTO vuelo (fecha_salida, fecha_arribo, ciudad_origen, ciudad_destino, ctd_asientos, ctd_asientos_ocupados)
  VALUES
    ('2011-06-24','2011-06-24','BUENOS AIRES','CORDOBA', 50, 0),
    ('2011-06-24','2011-06-24','BUENOS AIRES','NEUQUEN', 50, 0),
    ('2011-06-24','2011-06-24','BUENOS AIRES','CORDOBA', 50, 0),
    ('2011-06-24','2011-06-24','BUENOS AIRES','SALTA', 50, 0),
    ('2011-06-24','2011-06-24','BUENOS AIRES','SANTA FE', 50, 0),
    ('2011-06-25','2011-06-25','BUENOS AIRES','CORDOBA', 50, 0),
    ('2011-06-25','2011-06-25','BUENOS AIRES','NEUQUEN', 50, 0),
    ('2011-06-25','2011-06-25','BUENOS AIRES','CORDOBA', 50, 0),
    ('2011-06-25','2011-06-25','BUENOS AIRES','SALTA', 50, 0),
    ('2011-06-25','2011-06-25','BUENOS AIRES','SANTA FE', 50, 0),
    ('2011-06-26','2011-06-26','BUENOS AIRES','CORDOBA', 50, 0),
    ('2011-06-26','2011-06-26','BUENOS AIRES','NEUQUEN', 50, 0),
    ('2011-06-26','2011-06-26','BUENOS AIRES','CORDOBA', 50, 0),
    ('2011-06-26','2011-06-26','BUENOS AIRES','SALTA', 50, 0),
    ('2011-06-26','2011-06-26','BUENOS AIRES','SANTA FE', 50, 0),
    ('2011-06-27','2011-06-27','BUENOS AIRES','CORDOBA', 50, 0),
    ('2011-06-27','2011-06-27','BUENOS AIRES','NEUQUEN', 50, 0),
    ('2011-06-27','2011-06-27','BUENOS AIRES','CORDOBA', 50, 0),
    ('2011-06-27','2011-06-27','BUENOS AIRES','SALTA', 50, 0),
    ('2011-06-27','2011-06-27','BUENOS AIRES','SANTA FE', 50, 0),
    ('2011-06-28','2011-06-28','BUENOS AIRES','CORDOBA', 50, 0),
    ('2011-06-28','2011-06-28','BUENOS AIRES','NEUQUEN', 50, 0),
    ('2011-06-28','2011-06-28','BUENOS AIRES','CORDOBA', 50, 0),
    ('2011-06-28','2011-06-28','BUENOS AIRES','SALTA', 50, 0),
    ('2011-06-28','2011-06-28','BUENOS AIRES','SANTA FE', 50, 0),
    ('2011-06-29','2011-06-29','BUENOS AIRES','CORDOBA', 50, 0),
    ('2011-06-29','2011-06-29','BUENOS AIRES','NEUQUEN', 50, 0),
    ('2011-06-29','2011-06-29','BUENOS AIRES','CORDOBA', 50, 0),
    ('2011-06-29','2011-06-29','BUENOS AIRES','SALTA', 50, 0),
    ('2011-06-29','2011-06-29','BUENOS AIRES','SANTA FE', 50, 0),
    ('2011-06-30','2011-06-30','BUENOS AIRES','CORDOBA', 50, 0),
    ('2011-06-30','2011-06-30','BUENOS AIRES','NEUQUEN', 50, 0),
    ('2011-06-30','2011-06-30','BUENOS AIRES','CORDOBA', 50, 0),
    ('2011-06-30','2011-06-30','BUENOS AIRES','SALTA', 50, 0),
    ('2011-06-30','2011-06-30','BUENOS AIRES','SANTA FE', 50, 0),
    
    ('2011-06-24','2011-06-24','CORDOBA','BUENOS AIRES', 50, 0),
    ('2011-06-24','2011-06-24','CORDOBA','NEUQUEN', 50, 0),
    ('2011-06-24','2011-06-24','CORDOBA','BUENOS AIRES', 50, 0),
    ('2011-06-24','2011-06-24','CORDOBA','SALTA', 50, 0),
    ('2011-06-24','2011-06-24','CORDOBA','SANTA FE', 50, 0),
    ('2011-06-25','2011-06-25','CORDOBA','BUENOS AIRES', 50, 0),
    ('2011-06-25','2011-06-25','CORDOBA','NEUQUEN', 50, 0),
    ('2011-06-25','2011-06-25','CORDOBA','BUENOS AIRES', 50, 0),
    ('2011-06-25','2011-06-25','CORDOBA','SALTA', 50, 0),
    ('2011-06-25','2011-06-25','CORDOBA','SANTA FE', 50, 0),
    ('2011-06-26','2011-06-26','CORDOBA','BUENOS AIRES', 50, 0),
    ('2011-06-26','2011-06-26','CORDOBA','NEUQUEN', 50, 0),
    ('2011-06-26','2011-06-26','CORDOBA','BUENOS AIRES', 50, 0),
    ('2011-06-26','2011-06-26','CORDOBA','SALTA', 50, 0),
    ('2011-06-26','2011-06-26','CORDOBA','SANTA FE', 50, 0),
    ('2011-06-27','2011-06-27','CORDOBA','BUENOS AIRES', 50, 0),
    ('2011-06-27','2011-06-27','CORDOBA','NEUQUEN', 50, 0),
    ('2011-06-27','2011-06-27','CORDOBA','BUENOS AIRES', 50, 0),
    ('2011-06-27','2011-06-27','CORDOBA','SALTA', 50, 0),
    ('2011-06-27','2011-06-27','CORDOBA','SANTA FE', 50, 0),
    ('2011-06-28','2011-06-28','CORDOBA','BUENOS AIRES', 50, 0),
    ('2011-06-28','2011-06-28','CORDOBA','NEUQUEN', 50, 0),
    ('2011-06-28','2011-06-28','CORDOBA','BUENOS AIRES', 50, 0),
    ('2011-06-28','2011-06-28','CORDOBA','SALTA', 50, 0),
    ('2011-06-28','2011-06-28','CORDOBA','SANTA FE', 50, 0),
    ('2011-06-29','2011-06-29','CORDOBA','BUENOS AIRES', 50, 0),
    ('2011-06-29','2011-06-29','CORDOBA','NEUQUEN', 50, 0),
    ('2011-06-29','2011-06-29','CORDOBA','BUENOS AIRES', 50, 0),
    ('2011-06-29','2011-06-29','CORDOBA','SALTA', 50, 0),
    ('2011-06-29','2011-06-29','CORDOBA','SANTA FE', 50, 0),
    ('2011-06-30','2011-06-30','CORDOBA','BUENOS AIRES', 50, 0),
    ('2011-06-30','2011-06-30','CORDOBA','NEUQUEN', 50, 0),
    ('2011-06-30','2011-06-30','CORDOBA','BUENOS AIRES', 50, 0),
    ('2011-06-30','2011-06-30','CORDOBA','SALTA', 50, 0),
    ('2011-06-30','2011-06-30','CORDOBA','SANTA FE', 50, 0),
    
    ('2011-06-24','2011-06-24','NEUQUEN','BUENOS AIRES', 50, 0),
    ('2011-06-24','2011-06-24','NEUQUEN','CORDOBA', 50, 0),
    ('2011-06-24','2011-06-24','NEUQUEN','BUENOS AIRES', 50, 0),
    ('2011-06-24','2011-06-24','NEUQUEN','SALTA', 50, 0),
    ('2011-06-24','2011-06-24','NEUQUEN','SANTA FE', 50, 0),
    ('2011-06-25','2011-06-25','NEUQUEN','BUENOS AIRES', 50, 0),
    ('2011-06-25','2011-06-25','NEUQUEN','CORDOBA', 50, 0),
    ('2011-06-25','2011-06-25','NEUQUEN','BUENOS AIRES', 50, 0),
    ('2011-06-25','2011-06-25','NEUQUEN','SALTA', 50, 0),
    ('2011-06-25','2011-06-25','NEUQUEN','SANTA FE', 50, 0),
    ('2011-06-26','2011-06-26','NEUQUEN','BUENOS AIRES', 50, 0),
    ('2011-06-26','2011-06-26','NEUQUEN','CORDOBA', 50, 0),
    ('2011-06-26','2011-06-26','NEUQUEN','BUENOS AIRES', 50, 0),
    ('2011-06-26','2011-06-26','NEUQUEN','SALTA', 50, 0),
    ('2011-06-26','2011-06-26','NEUQUEN','SANTA FE', 50, 0),
    ('2011-06-27','2011-06-27','NEUQUEN','BUENOS AIRES', 50, 0),
    ('2011-06-27','2011-06-27','NEUQUEN','CORDOBA', 50, 0),
    ('2011-06-27','2011-06-27','NEUQUEN','BUENOS AIRES', 50, 0),
    ('2011-06-27','2011-06-27','NEUQUEN','SALTA', 50, 0),
    ('2011-06-27','2011-06-27','NEUQUEN','SANTA FE', 50, 0),
    ('2011-06-28','2011-06-28','NEUQUEN','BUENOS AIRES', 50, 0),
    ('2011-06-28','2011-06-28','NEUQUEN','CORDOBA', 50, 0),
    ('2011-06-28','2011-06-28','NEUQUEN','BUENOS AIRES', 50, 0),
    ('2011-06-28','2011-06-28','NEUQUEN','SALTA', 50, 0),
    ('2011-06-28','2011-06-28','NEUQUEN','SANTA FE', 50, 0),
    ('2011-06-29','2011-06-29','NEUQUEN','BUENOS AIRES', 50, 0),
    ('2011-06-29','2011-06-29','NEUQUEN','CORDOBA', 50, 0),
    ('2011-06-29','2011-06-29','NEUQUEN','BUENOS AIRES', 50, 0),
    ('2011-06-29','2011-06-29','NEUQUEN','SALTA', 50, 0),
    ('2011-06-29','2011-06-29','NEUQUEN','SANTA FE', 50, 0),
    ('2011-06-30','2011-06-30','NEUQUEN','BUENOS AIRES', 50, 0),
    ('2011-06-30','2011-06-30','NEUQUEN','CORDOBA', 50, 0),
    ('2011-06-30','2011-06-30','NEUQUEN','BUENOS AIRES', 50, 0),
    ('2011-06-30','2011-06-30','NEUQUEN','SALTA', 50, 0),
    ('2011-06-30','2011-06-30','NEUQUEN','SANTA FE', 50, 0),
    
    ('2011-06-24','2011-06-24','SALTA','BUENOS AIRES', 50, 0),
    ('2011-06-24','2011-06-24','SALTA','NEUQUEN', 50, 0),
    ('2011-06-24','2011-06-24','SALTA','BUENOS AIRES', 50, 0),
    ('2011-06-24','2011-06-24','SALTA','CORDOBA', 50, 0),
    ('2011-06-24','2011-06-24','SALTA','SANTA FE', 50, 0),
    ('2011-06-25','2011-06-25','SALTA','BUENOS AIRES', 50, 0),
    ('2011-06-25','2011-06-25','SALTA','NEUQUEN', 50, 0),
    ('2011-06-25','2011-06-25','SALTA','BUENOS AIRES', 50, 0),
    ('2011-06-25','2011-06-25','SALTA','CORDOBA', 50, 0),
    ('2011-06-25','2011-06-25','SALTA','SANTA FE', 50, 0),
    ('2011-06-26','2011-06-26','SALTA','BUENOS AIRES', 50, 0),
    ('2011-06-26','2011-06-26','SALTA','NEUQUEN', 50, 0),
    ('2011-06-26','2011-06-26','SALTA','BUENOS AIRES', 50, 0),
    ('2011-06-26','2011-06-26','SALTA','CORDOBA', 50, 0),
    ('2011-06-26','2011-06-26','SALTA','SANTA FE', 50, 0),
    ('2011-06-27','2011-06-27','SALTA','BUENOS AIRES', 50, 0),
    ('2011-06-27','2011-06-27','SALTA','NEUQUEN', 50, 0),
    ('2011-06-27','2011-06-27','SALTA','BUENOS AIRES', 50, 0),
    ('2011-06-27','2011-06-27','SALTA','CORDOBA', 50, 0),
    ('2011-06-27','2011-06-27','SALTA','SANTA FE', 50, 0),
    ('2011-06-28','2011-06-28','SALTA','BUENOS AIRES', 50, 0),
    ('2011-06-28','2011-06-28','SALTA','NEUQUEN', 50, 0),
    ('2011-06-28','2011-06-28','SALTA','BUENOS AIRES', 50, 0),
    ('2011-06-28','2011-06-28','SALTA','CORDOBA', 50, 0),
    ('2011-06-28','2011-06-28','SALTA','SANTA FE', 50, 0),
    ('2011-06-29','2011-06-29','SALTA','BUENOS AIRES', 50, 0),
    ('2011-06-29','2011-06-29','SALTA','NEUQUEN', 50, 0),
    ('2011-06-29','2011-06-29','SALTA','BUENOS AIRES', 50, 0),
    ('2011-06-29','2011-06-29','SALTA','CORDOBA', 50, 0),
    ('2011-06-29','2011-06-29','SALTA','SANTA FE', 50, 0),
    ('2011-06-30','2011-06-30','SALTA','BUENOS AIRES', 50, 0),
    ('2011-06-30','2011-06-30','SALTA','NEUQUEN', 50, 0),
    ('2011-06-30','2011-06-30','SALTA','BUENOS AIRES', 50, 0),
    ('2011-06-30','2011-06-30','SALTA','CORDOBA', 50, 0),
    ('2011-06-30','2011-06-30','SALTA','SANTA FE', 50, 0),
    
    ('2011-06-24','2011-06-24','SANTA FE','BUENOS AIRES', 50, 0),
    ('2011-06-24','2011-06-24','SANTA FE','NEUQUEN', 50, 0),
    ('2011-06-24','2011-06-24','SANTA FE','BUENOS AIRES', 50, 0),
    ('2011-06-24','2011-06-24','SANTA FE','SALTA', 50, 0),
    ('2011-06-24','2011-06-24','SANTA FE','CORDOBA', 50, 0),
    ('2011-06-25','2011-06-25','SANTA FE','BUENOS AIRES', 50, 0),
    ('2011-06-25','2011-06-25','SANTA FE','NEUQUEN', 50, 0),
    ('2011-06-25','2011-06-25','SANTA FE','BUENOS AIRES', 50, 0),
    ('2011-06-25','2011-06-25','SANTA FE','SALTA', 50, 0),
    ('2011-06-25','2011-06-25','SANTA FE','CORDOBA', 50, 0),
    ('2011-06-26','2011-06-26','SANTA FE','BUENOS AIRES', 50, 0),
    ('2011-06-26','2011-06-26','SANTA FE','NEUQUEN', 50, 0),
    ('2011-06-26','2011-06-26','SANTA FE','BUENOS AIRES', 50, 0),
    ('2011-06-26','2011-06-26','SANTA FE','SALTA', 50, 0),
    ('2011-06-26','2011-06-26','SANTA FE','CORDOBA', 50, 0),
    ('2011-06-27','2011-06-27','SANTA FE','BUENOS AIRES', 50, 0),
    ('2011-06-27','2011-06-27','SANTA FE','NEUQUEN', 50, 0),
    ('2011-06-27','2011-06-27','SANTA FE','BUENOS AIRES', 50, 0),
    ('2011-06-27','2011-06-27','SANTA FE','SALTA', 50, 0),
    ('2011-06-27','2011-06-27','SANTA FE','CORDOBA', 50, 0),
    ('2011-06-28','2011-06-28','SANTA FE','BUENOS AIRES', 50, 0),
    ('2011-06-28','2011-06-28','SANTA FE','NEUQUEN', 50, 0),
    ('2011-06-28','2011-06-28','SANTA FE','BUENOS AIRES', 50, 0),
    ('2011-06-28','2011-06-28','SANTA FE','SALTA', 50, 0),
    ('2011-06-28','2011-06-28','SANTA FE','CORDOBA', 50, 0),
    ('2011-06-29','2011-06-29','SANTA FE','BUENOS AIRES', 50, 0),
    ('2011-06-29','2011-06-29','SANTA FE','NEUQUEN', 50, 0),
    ('2011-06-29','2011-06-29','SANTA FE','BUENOS AIRES', 50, 0),
    ('2011-06-29','2011-06-29','SANTA FE','SALTA', 50, 0),
    ('2011-06-29','2011-06-29','SANTA FE','CORDOBA', 50, 0),
    ('2011-06-30','2011-06-30','SANTA FE','BUENOS AIRES', 50, 0),
    ('2011-06-30','2011-06-30','SANTA FE','NEUQUEN', 50, 0),
    ('2011-06-30','2011-06-30','SANTA FE','BUENOS AIRES', 50, 0),
    ('2011-06-30','2011-06-30','SANTA FE','SALTA', 50, 0),
    ('2011-06-30','2011-06-30','SANTA FE','CORDOBA', 50, 0);
-------------------------------------------------------------- 
















