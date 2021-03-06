# boletim

-- MySQL Script generated by MySQL Workbench
-- 05/27/18 18:31:36
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema boletimdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema boletimdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `boletimdb` DEFAULT CHARACTER SET utf8 ;
USE `boletimdb` ;

-- -----------------------------------------------------
-- Table `boletimdb`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boletimdb`.`curso` (
  `idcurso` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `sigla` VARCHAR(45) NULL,
  `duracao` VARCHAR(45) NULL,
  `preco` FLOAT NULL,
  PRIMARY KEY (`idcurso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boletimdb`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boletimdb`.`professor` (
  `idprofessor` INT NOT NULL AUTO_INCREMENT,
  `cpf` BIGINT(11) NULL,
  `nome` VARCHAR(45) NOT NULL,
  `matricula` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idprofessor`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boletimdb`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boletimdb`.`aluno` (
  `matricula` INT UNSIGNED NOT NULL,
  `nome` VARCHAR(45) NULL,
  `data` DATE NOT NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`matricula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boletimdb`.`nota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boletimdb`.`nota` (
  `idnotas` INT NOT NULL AUTO_INCREMENT,
  `periodo` INT NULL,
  `av1` FLOAT NOT NULL,
  `av2` FLOAT NOT NULL,
  `media` FLOAT NULL,
  `final` FLOAT NULL,
  `aluno_fk` INT UNSIGNED NULL,
  PRIMARY KEY (`idnotas`),
  INDEX `fk_nota_aluno1_idx` (`aluno_fk` ASC),
  CONSTRAINT `fk_nota_aluno1`
    FOREIGN KEY (`aluno_fk`)
    REFERENCES `boletimdb`.`aluno` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boletimdb`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boletimdb`.`disciplina` (
  `iddisciplina` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `horas` VARCHAR(45) NULL,
  `curso_fk` INT NULL,
  `professor_fk` INT NULL,
  `nota_fk` INT NULL,
  PRIMARY KEY (`iddisciplina`),
  INDEX `fk_disciplina_curso1_idx` (`curso_fk` ASC),
  INDEX `fk_disciplina_professor1_idx` (`professor_fk` ASC),
  INDEX `fk_disciplina_nota1_idx` (`nota_fk` ASC),
  CONSTRAINT `fk_disciplina_curso1`
    FOREIGN KEY (`curso_fk`)
    REFERENCES `boletimdb`.`curso` (`idcurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_professor1`
    FOREIGN KEY (`professor_fk`)
    REFERENCES `boletimdb`.`professor` (`idprofessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_nota1`
    FOREIGN KEY (`nota_fk`)
    REFERENCES `boletimdb`.`nota` (`idnotas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boletimdb`.`turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boletimdb`.`turma` (
  `idturma` INT NOT NULL AUTO_INCREMENT,
  `alunosqtd` INT(2) NULL,
  `turno` VARCHAR(45) NULL,
  `curso_idcurso` INT NOT NULL,
  PRIMARY KEY (`idturma`),
  INDEX `fk_turma_curso1_idx` (`curso_idcurso` ASC),
  CONSTRAINT `fk_turma_curso1`
    FOREIGN KEY (`curso_idcurso`)
    REFERENCES `boletimdb`.`curso` (`idcurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boletimdb`.`frequencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boletimdb`.`frequencia` (
  `idfrequencia` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `presente` TINYINT(1) NOT NULL,
  `aluno_fk` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idfrequencia`),
  INDEX `fk_frequencia_aluno1_idx` (`aluno_fk` ASC),
  CONSTRAINT `fk_frequencia_aluno1`
    FOREIGN KEY (`aluno_fk`)
    REFERENCES `boletimdb`.`aluno` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boletimdb`.`aula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boletimdb`.`aula` (
  `turma_id` INT NOT NULL,
  `data` DATE NOT NULL,
  `conteudo` VARCHAR(200) NOT NULL,
  `disciplina_fk` INT NULL,
  `frequencia_fk` INT NULL,
  `professor_FK` INT NULL,
  PRIMARY KEY (`turma_id`),
  INDEX `fk_aula_disciplina1_idx` (`disciplina_fk` ASC),
  INDEX `fk_aula_frequencia1_idx` (`frequencia_fk` ASC),
  INDEX `fk_aula_professor1_idx` (`professor_FK` ASC),
  CONSTRAINT `fk_aula_disciplina1`
    FOREIGN KEY (`disciplina_fk`)
    REFERENCES `boletimdb`.`disciplina` (`iddisciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aula_frequencia1`
    FOREIGN KEY (`frequencia_fk`)
    REFERENCES `boletimdb`.`frequencia` (`idfrequencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aula_professor1`
    FOREIGN KEY (`professor_FK`)
    REFERENCES `boletimdb`.`professor` (`idprofessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boletimdb`.`turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boletimdb`.`turma` (
  `idturma` INT NOT NULL AUTO_INCREMENT,
  `alunosqtd` INT(2) NULL,
  `turno` VARCHAR(45) NULL,
  `curso_idcurso` INT NOT NULL,
  PRIMARY KEY (`idturma`),
  INDEX `fk_turma_curso1_idx` (`curso_idcurso` ASC),
  CONSTRAINT `fk_turma_curso1`
    FOREIGN KEY (`curso_idcurso`)
    REFERENCES `boletimdb`.`curso` (`idcurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boletimdb`.`d_and_t`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boletimdb`.`d_and_t` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `turma_fk` INT NOT NULL,
  `disciplina_fk` INT NOT NULL,
  INDEX `fk_d_and_t_turma1_idx` (`turma_fk` ASC),
  INDEX `fk_d_and_t_disciplina1_idx` (`disciplina_fk` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_d_and_t_turma1`
    FOREIGN KEY (`turma_fk`)
    REFERENCES `boletimdb`.`turma` (`idturma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_d_and_t_disciplina1`
    FOREIGN KEY (`disciplina_fk`)
    REFERENCES `boletimdb`.`disciplina` (`iddisciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boletimdb`.`t_and_a`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boletimdb`.`t_and_a` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `aluno_fk` INT UNSIGNED NOT NULL,
  `turma_fk` INT NOT NULL,
  `curso_fk` INT NOT NULL,
  INDEX `fk_t_and_a_aluno1_idx` (`aluno_fk` ASC),
  INDEX `fk_t_and_a_turma1_idx` (`turma_fk` ASC),
  PRIMARY KEY (`id`),
  INDEX `fk_t_and_a_curso1_idx` (`curso_fk` ASC),
  CONSTRAINT `fk_t_and_a_aluno1`
    FOREIGN KEY (`aluno_fk`)
    REFERENCES `boletimdb`.`aluno` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_and_a_turma1`
    FOREIGN KEY (`turma_fk`)
    REFERENCES `boletimdb`.`turma` (`idturma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_and_a_curso1`
    FOREIGN KEY (`curso_fk`)
    REFERENCES `boletimdb`.`curso` (`idcurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
