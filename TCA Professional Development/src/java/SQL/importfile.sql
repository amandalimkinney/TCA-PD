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
  `password` varchar(45) NOT NULL,
  `in_active_directory` tinyint(1) NOT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (100,'john','aaa1',0),(101,'david','bbb1',1),(102,'bush','ccc1',1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

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
  KEY `fk1_idx` (`teacher_id`),
  KEY `fk2_idx` (`course_id`),
  CONSTRAINT `fk1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk2` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (101,1001,1),(101,1002,1),(102,1002,1),(103,1003,0);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

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
  `date` date NOT NULL,
  `hours` int(11) NOT NULL,
  `equipment` varchar(45) DEFAULT NULL,
  `course_instructor` varchar(45) NOT NULL,
  `course_assistants` varchar(90) DEFAULT NULL,
  `begin_time` time NOT NULL,
  `end_time` time NOT NULL,
  `course_topic` varchar(45) NOT NULL,
  `course_instructor_id` int(11) NOT NULL,
  PRIMARY KEY (`course_id`),
  KEY `instructorid_idx` (`course_instructor_id`),
  CONSTRAINT `instructorid` FOREIGN KEY (`course_instructor_id`) REFERENCES `account` (`account_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (101,'cs','academic','1','a',10,'test',1,'2012-01-02',3,'3','a',NULL,'12:00:00','13:30:00','',101),(102,'se','tech','4','a',15,'test',1,'2013-02-02',3,'2','a',NULL,'02:00:00','03:00:00','',101),(103,'ee','academic','2','a',20,'test',1,'2013-04-22',3,'2','a',NULL,'02:00:00','03:00:00','',101),(104,'te','tech','2','a',10,'test',1,'2013-05-02',2,'3','a',NULL,'04:00:00','04:30:00','',101);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_signup_queue`
--

DROP TABLE IF EXISTS `course_signup_queue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_signup_queue` (
  `course_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `applied_on` date NOT NULL,
  `waitinglist_num` int(4) NOT NULL DEFAULT '-1',
  PRIMARY KEY (`course_id`,`teacher_id`),
  KEY `course_signup_queueibfk2_idx` (`teacher_id`),
  CONSTRAINT `course_signup_queueibfk2` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `course_signup_queue_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_signup_queue`
--

LOCK TABLES `course_signup_queue` WRITE;
/*!40000 ALTER TABLE `course_signup_queue` DISABLE KEYS */;
INSERT INTO `course_signup_queue` VALUES (101,1001,'0001-01-13',1),(101,1002,'2012-04-04',1),(102,1002,'0002-02-13',1);
/*!40000 ALTER TABLE `course_signup_queue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `development_hours`
--

DROP TABLE IF EXISTS `development_hours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `development_hours` (
  `hours_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `num_hours` int(5) NOT NULL,
  `method` varchar(50) NOT NULL,
  `location` varchar(50) NOT NULL,
  `host_organization` varchar(50) NOT NULL,
  `topic` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`hours_id`),
  KEY `development_hours_ibfk_1` (`teacher_id`),
  CONSTRAINT `development_hours_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `development_hours`
--

LOCK TABLES `development_hours` WRITE;
/*!40000 ALTER TABLE `development_hours` DISABLE KEYS */;
INSERT INTO `development_hours` VALUES (1,'0004-05-13',3,'course','onsite','popular1','science','academic',1001),(2,'0004-09-13',2,'conference','onsite','popular2','math','technical',1002),(3,'0004-06-13',2,'course','offsite','popular1','science','academic',1003),(4,'0004-02-13',3,'course','offsite','popular2','math','academic',1004),(18,'2013-05-19',5,'conference','off-site','National Science System','academic','academic',1001);
/*!40000 ALTER TABLE `development_hours` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `head_of_school`
--

LOCK TABLES `head_of_school` WRITE;
/*!40000 ALTER TABLE `head_of_school` DISABLE KEYS */;
INSERT INTO `head_of_school` VALUES (101,1,1,1,'1'),(102,1,0,1,'1');
/*!40000 ALTER TABLE `head_of_school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permissions` (
  `account_id` int(11) NOT NULL,
  `accountGroup` varchar(45) NOT NULL,
  `index` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`index`),
  KEY `account_id_idx` (`account_id`),
  CONSTRAINT `account` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1001,'A','D','U','A','science','2-2-13','a@gmail.com'),(1002,'B','C','L','A','math','2-3-13','b@gmail.com'),(1003,'C','B','U','A','arts','11-1-13','c@gmail.com'),(1004,'D','A','L','A','math','2-6-13','d@gmail.com');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-02 19:12:08
