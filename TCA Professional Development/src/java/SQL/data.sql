SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `tca` DEFAULT CHARACTER SET utf8 ;
USE `tca` ;

-- -----------------------------------------------------
-- Table `tca`.`course_master`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tca`.`course_master` (
  `course_id` INT(11) NOT NULL ,
  `course_name` VARCHAR(50) NOT NULL ,
  `course_type` VARCHAR(50) NOT NULL ,
  `course_room` VARCHAR(50) NOT NULL ,
  `course_details` VARCHAR(50) NOT NULL ,
  `total_seats` INT(50) NOT NULL ,
  `description` VARCHAR(100) NOT NULL ,
  `status` TINYINT(4) NOT NULL DEFAULT '1' ,
  `date_of_creation` VARCHAR(50) NOT NULL ,
  `date_of_attendance` VARCHAR(50) NOT NULL ,
  `hours` INT(11) NOT NULL ,
  PRIMARY KEY (`course_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tca`.`teacher_master`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tca`.`teacher_master` (
  `teacher_id` INT(11) NOT NULL ,
  `teacher_fname` VARCHAR(30) NOT NULL ,
  `teacher_lname` VARCHAR(30) NOT NULL ,
  `teacher_division` VARCHAR(30) NOT NULL ,
  `teacher_grade` VARCHAR(30) NOT NULL ,
  `subject` VARCHAR(30) NOT NULL ,
  `hired_date` VARCHAR(30) NOT NULL ,
  `email_id` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`teacher_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tca`.`attendance`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tca`.`attendance` (
  `course_id` INT(11) NOT NULL ,
  `teacher_id` INT(11) NOT NULL ,
  `date_of_attendance` DATE NOT NULL ,
  `hours` INT(11) NOT NULL ,
  PRIMARY KEY (`course_id`, `teacher_id`) ,
  UNIQUE INDEX `course_id` (`course_id` ASC) ,
  UNIQUE INDEX `teacher_id` (`teacher_id` ASC) ,
  CONSTRAINT `attendance_ibfk_1`
    FOREIGN KEY (`course_id` )
    REFERENCES `tca`.`course_master` (`course_id` ),
  CONSTRAINT `attendance_ibfk_2`
    FOREIGN KEY (`teacher_id` )
    REFERENCES `tca`.`teacher_master` (`teacher_id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tca`.`course_signup_queue`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tca`.`course_signup_queue` (
  `course_id` INT(11) NOT NULL ,
  `teacher_id` INT(11) NOT NULL ,
  `applied_on` VARCHAR(30) NOT NULL ,
  `status` TINYINT(4) NOT NULL ,
  PRIMARY KEY (`course_id`, `teacher_id`) ,
  UNIQUE INDEX `course_id` (`course_id` ASC) ,
  UNIQUE INDEX `teacher_id` (`teacher_id` ASC) ,
  CONSTRAINT `course_signup_queue_ibfk_1`
    FOREIGN KEY (`course_id` )
    REFERENCES `tca`.`course_master` (`course_id` ),
  CONSTRAINT `course_signup_queue_ibfk_2`
    FOREIGN KEY (`teacher_id` )
    REFERENCES `tca`.`teacher_master` (`teacher_id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tca`.`course_teacher`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tca`.`course_teacher` (
  `course_id` INT(11) NOT NULL ,
  `teacher_id` INT(11) NOT NULL ,
  `assigned_on` VARCHAR(30) NOT NULL ,
  `remarks` VARCHAR(100) NOT NULL ,
  `status` INT(11) NOT NULL ,
  PRIMARY KEY (`course_id`, `teacher_id`) ,
  UNIQUE INDEX `course_id` (`course_id` ASC) ,
  UNIQUE INDEX `teacher_id` (`teacher_id` ASC) ,
  CONSTRAINT `course_teacher_ibfk_1`
    FOREIGN KEY (`course_id` )
    REFERENCES `tca`.`course_master` (`course_id` ),
  CONSTRAINT `course_teacher_ibfk_2`
    FOREIGN KEY (`teacher_id` )
    REFERENCES `tca`.`teacher_master` (`teacher_id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tca`.`development_hours`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tca`.`development_hours` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `date` VARCHAR(30) NOT NULL ,
  `num_hours` VARCHAR(50) NOT NULL ,
  `method` VARCHAR(50) NOT NULL ,
  `location` VARCHAR(50) NOT NULL ,
  `host_organization` VARCHAR(50) NOT NULL ,
  `topic` VARCHAR(100) NOT NULL ,
  `type` VARCHAR(100) NOT NULL ,
  `teacher_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `development_hours_ibfk_1` (`teacher_id` ASC) ,
  CONSTRAINT `development_hours_ibfk_1`
    FOREIGN KEY (`teacher_id` )
    REFERENCES `tca`.`teacher_master` (`teacher_id` ))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tca`.`euipment`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tca`.`euipment` (
  `material_id` VARCHAR(30) NOT NULL ,
  `course_id` INT(11) NOT NULL ,
  `material_count` INT(11) NOT NULL ,
  PRIMARY KEY (`material_id`) ,
  INDEX `euipment_ibfk_1` (`course_id` ASC) ,
  CONSTRAINT `euipment_ibfk_1`
    FOREIGN KEY (`course_id` )
    REFERENCES `tca`.`course_master` (`course_id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

USE `tca` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
