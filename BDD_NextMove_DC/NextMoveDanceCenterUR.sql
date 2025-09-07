-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema NextMoveDanceCenterUR
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema NextMoveDanceCenterUR
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `NextMoveDanceCenterUR` DEFAULT CHARACTER SET utf8 ;
USE `NextMoveDanceCenterUR` ;

-- -----------------------------------------------------
-- Table `NextMoveDanceCenterUR`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NextMoveDanceCenterUR`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `Nombre(s)` VARCHAR(50) NOT NULL,
  `Apellido` VARCHAR(50) NOT NULL,
  `Telefono` VARCHAR(11) NOT NULL,
  `Correo` VARCHAR(45) NOT NULL,
  `FechaRegistro` DATE NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `Correo_UNIQUE` (`Correo` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NextMoveDanceCenterUR`.`Maestros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NextMoveDanceCenterUR`.`Maestros` (
  `idMaestros` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(50) NOT NULL,
  `Apellido` VARCHAR(50) NOT NULL,
  `Telefono` VARCHAR(11) NOT NULL,
  `RedSocial` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idMaestros`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NextMoveDanceCenterUR`.`Clases`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NextMoveDanceCenterUR`.`Clases` (
  `idClases` INT NOT NULL AUTO_INCREMENT,
  `NombreClase` VARCHAR(45) NOT NULL,
  `EdadAdmicion` VARCHAR(45) NOT NULL,
  `Horario` VARCHAR(45) NOT NULL,
  `Maestros_idMaestros` INT NOT NULL,
  PRIMARY KEY (`idClases`),
  INDEX `fk_Clases_Maestros1_idx` (`Maestros_idMaestros` ASC) VISIBLE,
  CONSTRAINT `fk_Clases_Maestros1`
    FOREIGN KEY (`Maestros_idMaestros`)
    REFERENCES `NextMoveDanceCenterUR`.`Maestros` (`idMaestros`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NextMoveDanceCenterUR`.`Pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NextMoveDanceCenterUR`.`Pago` (
  `idPago` INT NOT NULL AUTO_INCREMENT,
  `Costo` INT NOT NULL,
  `Paquete` VARCHAR(45) NOT NULL,
  `FechaPago` DATE NOT NULL,
  PRIMARY KEY (`idPago`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NextMoveDanceCenterUR`.`Inscripcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NextMoveDanceCenterUR`.`Inscripcion` (
  `idInscripcion` INT NOT NULL AUTO_INCREMENT,
  `FechaInscripcion` DATE NOT NULL,
  `Clases_idClases` INT NOT NULL,
  `Usuario_idUsuario` INT NOT NULL,
  `Pago_idPago` INT NOT NULL,
  PRIMARY KEY (`idInscripcion`),
  INDEX `fk_Inscripcion_Clases_idx` (`Clases_idClases` ASC) VISIBLE,
  INDEX `fk_Inscripcion_Usuario1_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  INDEX `fk_Inscripcion_Pago1_idx` (`Pago_idPago` ASC) VISIBLE,
  CONSTRAINT `fk_Inscripcion_Clases`
    FOREIGN KEY (`Clases_idClases`)
    REFERENCES `NextMoveDanceCenterUR`.`Clases` (`idClases`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Inscripcion_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `NextMoveDanceCenterUR`.`Usuario` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Inscripcion_Pago1`
    FOREIGN KEY (`Pago_idPago`)
    REFERENCES `NextMoveDanceCenterUR`.`Pago` (`idPago`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
