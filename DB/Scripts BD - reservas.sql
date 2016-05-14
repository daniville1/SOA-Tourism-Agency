--------------------------------------------------------------
ciudad
--------------------------------------------------------------
CREATE TABLE `reservas`.`ciudad` (
  `ciudad` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`ciudad`)
)
ENGINE = InnoDB;
--------------------------------------------------------------


--------------------------------------------------------------
reservas
--------------------------------------------------------------
CREATE TABLE `reservas`.`reservas` (
  `nro_reserva` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fecha_salida` DATE NOT NULL,
  `fecha_regreso` DATE NOT NULL,
  `ciudad_origen` VARCHAR(25) NOT NULL,
  `ciudad_destino` VARCHAR(25) NOT NULL,
  `nro_documento_pasajero` BIGINT UNSIGNED NOT NULL,
  `pasajero` VARCHAR(35) NOT NULL,
  `nro_vuelo_salida` BIGINT UNSIGNED NOT NULL,
  `nro_vuelo_regreso` BIGINT UNSIGNED NOT NULL,
  `hotel_reservado` VARCHAR(35) NOT NULL,
  PRIMARY KEY (`nro_reserva`),
  CONSTRAINT `fk_reservas_ciudad_origen` FOREIGN KEY `fk_reservas_ciudad_origen` (`ciudad_origen`)
    REFERENCES `ciudad` (`ciudad`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_reservas_ciudad_destino` FOREIGN KEY `fk_reservas_ciudad_destino` (`ciudad_destino`)
    REFERENCES `ciudad` (`ciudad`)
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
    ('SANTA FE')
-------------------------------------------------------------- 