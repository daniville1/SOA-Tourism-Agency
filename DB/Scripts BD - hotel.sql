--------------------------------------------------------------
ciudad
--------------------------------------------------------------
CREATE TABLE `hotel`.`ciudad` (
  `ciudad` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`ciudad`)
)
ENGINE = InnoDB;
--------------------------------------------------------------


--------------------------------------------------------------
hotel
--------------------------------------------------------------
CREATE TABLE `hotel`.`hotel` (
  `hotel` VARCHAR(35) NOT NULL,
  `fecha` DATE NOT NULL,
  `ctd_habitaciones` INTEGER UNSIGNED NOT NULL,
  `ctd_habitaciones_ocupadas` INTEGER UNSIGNED NOT NULL,
  `ciudad` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`hotel`, `fecha`, `ciudad`),
  CONSTRAINT `fk_hotel_ciudad` FOREIGN KEY `fk_hotel_ciudad` (`ciudad`)
    REFERENCES `ciudad` (`ciudad`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
)
ENGINE = InnoDB;
--------------------------------------------------------------


--------------------------------------------------------------
reserva_hotel
--------------------------------------------------------------
CREATE TABLE `hotel`.`reserva_hotel` (
  `hotel` VARCHAR(35) NOT NULL,
  `fecha` DATE NOT NULL,
  `nro_documento_pasajero` BIGINT UNSIGNED NOT NULL,
  `pasajero` VARCHAR(35) NOT NULL,
  `ciudad` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`hotel`, `fecha`, `nro_documento_pasajero`, `ciudad`),
  CONSTRAINT `fk_reserva_hotel` FOREIGN KEY `fk_reserva_hotel` (`hotel`, `fecha`, `ciudad`)
    REFERENCES `hotel` (`hotel`, `fecha`, `ciudad`)
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
    
INSERT INTO hotel (hotel, fecha, ctd_habitaciones, ctd_habitaciones_ocupadas, ciudad)
  VALUES
    ('AMERIAN', '2011-06-24', 100, 0, 'BUENOS AIRES'),
    ('AMERIAN', '2011-06-25', 100, 0, 'BUENOS AIRES'),
    ('AMERIAN', '2011-06-26', 100, 0, 'BUENOS AIRES'),
    ('AMERIAN', '2011-06-27', 100, 0, 'BUENOS AIRES'),
    ('AMERIAN', '2011-06-28', 100, 0, 'BUENOS AIRES'),
    ('AMERIAN', '2011-06-29', 100, 0, 'BUENOS AIRES'),
    ('AMERIAN', '2011-06-30', 100, 0, 'BUENOS AIRES'),
    ('HOWARD JOHNSON', '2011-06-24', 100, 0, 'BUENOS AIRES'),
    ('HOWARD JOHNSON', '2011-06-25', 100, 0, 'BUENOS AIRES'),
    ('HOWARD JOHNSON', '2011-06-26', 100, 0, 'BUENOS AIRES'),
    ('HOWARD JOHNSON', '2011-06-27', 100, 0, 'BUENOS AIRES'),
    ('HOWARD JOHNSON', '2011-06-28', 100, 0, 'BUENOS AIRES'),
    ('HOWARD JOHNSON', '2011-06-29', 100, 0, 'BUENOS AIRES'),
    ('HOWARD JOHNSON', '2011-06-30', 100, 0, 'BUENOS AIRES'),
    ('SHERATON', '2011-06-24', 100, 0, 'BUENOS AIRES'),
    ('SHERATON', '2011-06-25', 100, 0, 'BUENOS AIRES'),
    ('SHERATON', '2011-06-26', 100, 0, 'BUENOS AIRES'),
    ('SHERATON', '2011-06-27', 100, 0, 'BUENOS AIRES'),
    ('SHERATON', '2011-06-28', 100, 0, 'BUENOS AIRES'),
    ('SHERATON', '2011-06-29', 100, 0, 'BUENOS AIRES'),
    ('SHERATON', '2011-06-30', 100, 0, 'BUENOS AIRES'),
    
    ('AMERIAN', '2011-06-24', 100, 0, 'CORDOBA'),
    ('AMERIAN', '2011-06-25', 100, 0, 'CORDOBA'),
    ('AMERIAN', '2011-06-26', 100, 0, 'CORDOBA'),
    ('AMERIAN', '2011-06-27', 100, 0, 'CORDOBA'),
    ('AMERIAN', '2011-06-28', 100, 0, 'CORDOBA'),
    ('AMERIAN', '2011-06-29', 100, 0, 'CORDOBA'),
    ('AMERIAN', '2011-06-30', 100, 0, 'CORDOBA'),
    ('HOLIDAY INN', '2011-06-24', 100, 0, 'CORDOBA'),
    ('HOLIDAY INN', '2011-06-25', 100, 0, 'CORDOBA'),
    ('HOLIDAY INN', '2011-06-26', 100, 0, 'CORDOBA'),
    ('HOLIDAY INN', '2011-06-27', 100, 0, 'CORDOBA'),
    ('HOLIDAY INN', '2011-06-28', 100, 0, 'CORDOBA'),
    ('HOLIDAY INN', '2011-06-29', 100, 0, 'CORDOBA'),
    ('HOLIDAY INN', '2011-06-30', 100, 0, 'CORDOBA'),
    ('HOWARD JOHNSON', '2011-06-24', 100, 0, 'CORDOBA'),
    ('HOWARD JOHNSON', '2011-06-25', 100, 0, 'CORDOBA'),
    ('HOWARD JOHNSON', '2011-06-26', 100, 0, 'CORDOBA'),
    ('HOWARD JOHNSON', '2011-06-27', 100, 0, 'CORDOBA'),
    ('HOWARD JOHNSON', '2011-06-28', 100, 0, 'CORDOBA'),
    ('HOWARD JOHNSON', '2011-06-29', 100, 0, 'CORDOBA'),
    ('HOWARD JOHNSON', '2011-06-30', 100, 0, 'CORDOBA'),
    ('SHERATON', '2011-06-24', 100, 0, 'CORDOBA'),
    ('SHERATON', '2011-06-25', 100, 0, 'CORDOBA'),
    ('SHERATON', '2011-06-26', 100, 0, 'CORDOBA'),
    ('SHERATON', '2011-06-27', 100, 0, 'CORDOBA'),
    ('SHERATON', '2011-06-28', 100, 0, 'CORDOBA'),
    ('SHERATON', '2011-06-29', 100, 0, 'CORDOBA'),
    ('SHERATON', '2011-06-30', 100, 0, 'CORDOBA'),
    
    ('HOLIDAY INN', '2011-06-24', 100, 0, 'NEUQUEN'),
    ('HOLIDAY INN', '2011-06-25', 100, 0, 'NEUQUEN'),
    ('HOLIDAY INN', '2011-06-26', 100, 0, 'NEUQUEN'),
    ('HOLIDAY INN', '2011-06-27', 100, 0, 'NEUQUEN'),
    ('HOLIDAY INN', '2011-06-28', 100, 0, 'NEUQUEN'),
    ('HOLIDAY INN', '2011-06-29', 100, 0, 'NEUQUEN'),
    ('HOLIDAY INN', '2011-06-30', 100, 0, 'NEUQUEN'),
    ('HOWARD JOHNSON', '2011-06-24', 100, 0, 'NEUQUEN'),
    ('HOWARD JOHNSON', '2011-06-25', 100, 0, 'NEUQUEN'),
    ('HOWARD JOHNSON', '2011-06-26', 100, 0, 'NEUQUEN'),
    ('HOWARD JOHNSON', '2011-06-27', 100, 0, 'NEUQUEN'),
    ('HOWARD JOHNSON', '2011-06-28', 100, 0, 'NEUQUEN'),
    ('HOWARD JOHNSON', '2011-06-29', 100, 0, 'NEUQUEN'),
    ('HOWARD JOHNSON', '2011-06-30', 100, 0, 'NEUQUEN'),
    
    ('AMERIAN', '2011-06-24', 100, 0, 'SALTA'),
    ('AMERIAN', '2011-06-25', 100, 0, 'SALTA'),
    ('AMERIAN', '2011-06-26', 100, 0, 'SALTA'),
    ('AMERIAN', '2011-06-27', 100, 0, 'SALTA'),
    ('AMERIAN', '2011-06-28', 100, 0, 'SALTA'),
    ('AMERIAN', '2011-06-29', 100, 0, 'SALTA'),
    ('AMERIAN', '2011-06-30', 100, 0, 'SALTA'),
    ('SHERATON', '2011-06-24', 100, 0, 'SALTA'),
    ('SHERATON', '2011-06-25', 100, 0, 'SALTA'),
    ('SHERATON', '2011-06-26', 100, 0, 'SALTA'),
    ('SHERATON', '2011-06-27', 100, 0, 'SALTA'),
    ('SHERATON', '2011-06-28', 100, 0, 'SALTA'),
    ('SHERATON', '2011-06-29', 100, 0, 'SALTA'),
    ('SHERATON', '2011-06-30', 100, 0, 'SALTA'),
    
    ('AMERIAN', '2011-06-24', 100, 0, 'SANTA FE'),
    ('AMERIAN', '2011-06-25', 100, 0, 'SANTA FE'),
    ('AMERIAN', '2011-06-26', 100, 0, 'SANTA FE'),
    ('AMERIAN', '2011-06-27', 100, 0, 'SANTA FE'),
    ('AMERIAN', '2011-06-28', 100, 0, 'SANTA FE'),
    ('AMERIAN', '2011-06-29', 100, 0, 'SANTA FE'),
    ('AMERIAN', '2011-06-30', 100, 0, 'SANTA FE'),
    ('HOLIDAY INN', '2011-06-24', 100, 0, 'SANTA FE'),
    ('HOLIDAY INN', '2011-06-25', 100, 0, 'SANTA FE'),
    ('HOLIDAY INN', '2011-06-26', 100, 0, 'SANTA FE'),
    ('HOLIDAY INN', '2011-06-27', 100, 0, 'SANTA FE'),
    ('HOLIDAY INN', '2011-06-28', 100, 0, 'SANTA FE'),
    ('HOLIDAY INN', '2011-06-29', 100, 0, 'SANTA FE'),
    ('HOLIDAY INN', '2011-06-30', 100, 0, 'SANTA FE'),
    ('HOWARD JOHNSON', '2011-06-24', 100, 0, 'SANTA FE'),
    ('HOWARD JOHNSON', '2011-06-25', 100, 0, 'SANTA FE'),
    ('HOWARD JOHNSON', '2011-06-26', 100, 0, 'SANTA FE'),
    ('HOWARD JOHNSON', '2011-06-27', 100, 0, 'SANTA FE'),
    ('HOWARD JOHNSON', '2011-06-28', 100, 0, 'SANTA FE'),
    ('HOWARD JOHNSON', '2011-06-29', 100, 0, 'SANTA FE'),
    ('HOWARD JOHNSON', '2011-06-30', 100, 0, 'SANTA FE');
-------------------------------------------------------------- 