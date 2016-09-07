-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema OutStok
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema OutStok
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `OutStok` DEFAULT CHARACTER SET utf8 ;
USE `OutStok` ;

-- -----------------------------------------------------
-- Table `OutStok`.`Estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OutStok`.`Estado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `sigla` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OutStok`.`Cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OutStok`.`Cidade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `Estado_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Cidade_Estado_idx` (`Estado_id` ASC),
  CONSTRAINT `fk_Cidade_Estado`
    FOREIGN KEY (`Estado_id`)
    REFERENCES `OutStok`.`Estado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OutStok`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OutStok`.`Cliente` (
  `id` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `data_nascimento` VARCHAR(45) NULL,
  `sexo` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  `celular` VARCHAR(45) NULL,
  `endereco` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NULL,
  `Cidade_id` INT NOT NULL,
  `email` VARCHAR(45) NULL,
  `rg` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NULL,
  `observacao` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Cliente_Cidade1_idx` (`Cidade_id` ASC),
  CONSTRAINT `fk_Cliente_Cidade1`
    FOREIGN KEY (`Cidade_id`)
    REFERENCES `OutStok`.`Cidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OutStok`.`Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OutStok`.`Fornecedor` (
  `id` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NULL,
  `celular` VARCHAR(45) NULL,
  `endereco` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NULL,
  `Cidade_id` INT NOT NULL,
  `email` VARCHAR(45) NULL,
  `cnpj` VARCHAR(45) NULL,
  `observacao` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Cliente_Cidade1_idx` (`Cidade_id` ASC),
  CONSTRAINT `fk_Cliente_Cidade10`
    FOREIGN KEY (`Cidade_id`)
    REFERENCES `OutStok`.`Cidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OutStok`.`Categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OutStok`.`Categorias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OutStok`.`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OutStok`.`produtos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `preco_custo` FLOAT NULL,
  `preco_venda` FLOAT NULL,
  `quantidade` INT NULL,
  `codigo` VARCHAR(45) NULL,
  `estoque_minimo` INT NULL,
  `observacao` TEXT NULL,
  `Fornecedor_id` INT ZEROFILL NOT NULL,
  `Categorias_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_produtos_Fornecedor1_idx` (`Fornecedor_id` ASC),
  INDEX `fk_produtos_Categorias1_idx` (`Categorias_id` ASC),
  CONSTRAINT `fk_produtos_Fornecedor1`
    FOREIGN KEY (`Fornecedor_id`)
    REFERENCES `OutStok`.`Fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produtos_Categorias1`
    FOREIGN KEY (`Categorias_id`)
    REFERENCES `OutStok`.`Categorias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OutStok`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OutStok`.`venda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data_venda` VARCHAR(45) NULL,
  `valor_venda` DECIMAL(10,0) NULL,
  `pagamento` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OutStok`.`produtos_has_venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OutStok`.`produtos_has_venda` (
  `produtos_id` INT NOT NULL,
  `venda_id` INT NOT NULL,
  PRIMARY KEY (`produtos_id`, `venda_id`),
  INDEX `fk_produtos_has_venda_venda1_idx` (`venda_id` ASC),
  INDEX `fk_produtos_has_venda_produtos1_idx` (`produtos_id` ASC),
  CONSTRAINT `fk_produtos_has_venda_produtos1`
    FOREIGN KEY (`produtos_id`)
    REFERENCES `OutStok`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produtos_has_venda_venda1`
    FOREIGN KEY (`venda_id`)
    REFERENCES `OutStok`.`venda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OutStok`.`Cliente_has_venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `OutStok`.`Cliente_has_venda` (
  `Cliente_id` INT ZEROFILL NOT NULL,
  `venda_id` INT NOT NULL,
  PRIMARY KEY (`Cliente_id`, `venda_id`),
  INDEX `fk_Cliente_has_venda_venda1_idx` (`venda_id` ASC),
  INDEX `fk_Cliente_has_venda_Cliente1_idx` (`Cliente_id` ASC),
  CONSTRAINT `fk_Cliente_has_venda_Cliente1`
    FOREIGN KEY (`Cliente_id`)
    REFERENCES `OutStok`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cliente_has_venda_venda1`
    FOREIGN KEY (`venda_id`)
    REFERENCES `OutStok`.`venda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
