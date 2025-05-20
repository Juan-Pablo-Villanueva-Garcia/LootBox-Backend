-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema LootBox
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema LootBox
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `LootBox` DEFAULT CHARACTER SET utf8mb3 ;
USE `LootBox` ;

-- -----------------------------------------------------
-- Table `LootBox`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LootBox`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefono` CHAR(10) NOT NULL,
  `contraseña` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `LootBox`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LootBox`.`pedido` (
  `idPedido` INT NOT NULL,
  `pedido_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idUsuario_fk` INT NOT NULL,
  `precioTotal` DECIMAL(6,2) NOT NULL,
  `status` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idPedido`),
  INDEX `fk_Pedido_Usuario_idx` (`idUsuario_fk` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_Usuario`
    FOREIGN KEY (`idUsuario_fk`)
    REFERENCES `LootBox`.`usuario` (`idUsuario`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `LootBox`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LootBox`.`productos` (
  `idProductos` INT NOT NULL AUTO_INCREMENT,
  `name` CHAR(100) NOT NULL,
  `img` VARCHAR(255) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `category` INT ZEROFILL NOT NULL,
  `price` DECIMAL(6,2) NOT NULL,
  `rating` JSON NOT NULL,
  `sku` INT NOT NULL,
  `stock` INT UNSIGNED ZEROFILL NOT NULL,
  `costo` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`idProductos`),
  UNIQUE INDEX `sku_UNIQUE` (`sku` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `LootBox`.`pedido_has_productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `LootBox`.`pedido_has_productos` (
  `Pedido_idPedido` INT NOT NULL,
  `Productos_idProductos` INT NOT NULL,
  PRIMARY KEY (`Pedido_idPedido`, `Productos_idProductos`),
  INDEX `fk_Pedido_has_Productos_Productos1_idx` (`Productos_idProductos` ASC) VISIBLE,
  INDEX `fk_Pedido_has_Productos_Pedido1_idx` (`Pedido_idPedido` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_has_Productos_Pedido1`
    FOREIGN KEY (`Pedido_idPedido`)
    REFERENCES `LootBox`.`pedido` (`idPedido`),
  CONSTRAINT `fk_Pedido_has_Productos_Productos1`
    FOREIGN KEY (`Productos_idProductos`)
    REFERENCES `LootBox`.`productos` (`idProductos`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
