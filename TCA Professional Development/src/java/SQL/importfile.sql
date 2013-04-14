CREATE DATABASE  IF NOT EXISTS `tca` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tca`;
-- MySQL dump 10.13  Distrib 5.6.10, for Win64 (x86_64)
--
-- Host: localhost    Database: tca
-- ------------------------------------------------------
-- Server version	5.6.10

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `isTeacher` tinyint(1) NOT NULL DEFAULT '0',
  `isAdmin` tinyint(1) NOT NULL DEFAULT '0',
  `isHeadofschool` tinyint(1) NOT NULL DEFAULT '0',
  `isInstructor` tinyint(1) NOT NULL DEFAULT '0',
  `in_active_directory` tinyint(1) NOT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `course_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `attended` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`course_id`,`teacher_id`),
  UNIQUE KEY `course_id` (`course_id`),
  UNIQUE KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL,
  `course_name` varchar(50) NOT NULL,
  `course_type` varchar(50) NOT NULL,
  `course_room` varchar(50) NOT NULL,
  `course_details` varchar(50) NOT NULL,
  `total_seats` int(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `date` varchar(50) NOT NULL,
  `hours` int(11) NOT NULL,
  `equipment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `course_signup_queue`
--

DROP TABLE IF EXISTS `course_signup_queue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_signup_queue` (
  `course_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `applied_on` varchar(30) NOT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`course_id`,`teacher_id`),
  UNIQUE KEY `course_id` (`course_id`),
  UNIQUE KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `course_signup_queue_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `course_signup_queue_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `development_hours`
--

DROP TABLE IF EXISTS `development_hours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `development_hours` (
  `hours_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(30) NOT NULL,
  `num_hours` varchar(50) NOT NULL,
  `method` varchar(50) NOT NULL,
  `location` varchar(50) NOT NULL,
  `host_organization` varchar(50) NOT NULL,
  `topic` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`hours_id`),
  KEY `development_hours_ibfk_1` (`teacher_id`),
  CONSTRAINT `development_hours_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `head_of_school`
--

DROP TABLE IF EXISTS `head_of_school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `head_of_school` (
  `idhead_of_school` int(11) NOT NULL,
  `access_lower_school` tinyint(1) NOT NULL DEFAULT '0',
  `access_middle_school` tinyint(1) NOT NULL DEFAULT '0',
  `access_high_school` tinyint(1) NOT NULL DEFAULT '0',
  `access_custom` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idhead_of_school`),
  CONSTRAINT `account_id` FOREIGN KEY (`idhead_of_school`) REFERENCES `account` (`account_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL,
  `teacher_fname` varchar(30) NOT NULL,
  `teacher_lname` varchar(30) NOT NULL,
  `teacher_division` varchar(30) NOT NULL,
  `teacher_grade` varchar(30) NOT NULL,
  `subject` varchar(30) NOT NULL,
  `hired_date` varchar(30) NOT NULL,
  `email_id` varchar(30) NOT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-04-14 14:16:59
