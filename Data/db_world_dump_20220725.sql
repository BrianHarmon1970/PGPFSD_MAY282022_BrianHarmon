-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: webauth
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Current Database: `webauth`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `webauth` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci */;

USE `webauth`;

--
-- Table structure for table `user_pwd`
--

DROP TABLE IF EXISTS `user_pwd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_pwd` (
  `name` char(30) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `pass` char(32) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_pwd`
--

LOCK TABLES `user_pwd` WRITE;
/*!40000 ALTER TABLE `user_pwd` DISABLE KEYS */;
INSERT INTO `user_pwd` VALUES ('xampp','wampp');
/*!40000 ALTER TABLE `user_pwd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'webauth'
--

--
-- Dumping routines for database 'webauth'
--

--
-- Current Database: `db_world`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `db_world` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_world`;

--
-- Table structure for table `addrotomapp`
--

DROP TABLE IF EXISTS `addrotomapp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addrotomapp` (
  `addressId` int(11) NOT NULL,
  `addressLine1` varchar(500) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  KEY `addressId` (`addressId`),
  CONSTRAINT `addrotomapp_ibfk_1` FOREIGN KEY (`addressId`) REFERENCES `empotomapp` (`employeeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addrotomapp`
--

LOCK TABLES `addrotomapp` WRITE;
/*!40000 ALTER TABLE `addrotomapp` DISABLE KEYS */;
INSERT INTO `addrotomapp` VALUES (1,'G-21,Lohia nagar','Ghaziabad','UP','India',201301),(2,'G-21,Lohia nagar','Ghaziabad','UP','India',201301),(3,'G-21,Lohia nagar','Ghaziabad','UP','India',201301);
/*!40000 ALTER TABLE `addrotomapp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answerbag`
--

DROP TABLE IF EXISTS `answerbag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answerbag` (
  `qid` int(11) NOT NULL,
  `answer` varchar(30) DEFAULT NULL,
  KEY `FKn9dn1jujdxka23yeg2l5yx36s` (`qid`),
  CONSTRAINT `FKn9dn1jujdxka23yeg2l5yx36s` FOREIGN KEY (`qid`) REFERENCES `questionbag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answerbag`
--

LOCK TABLES `answerbag` WRITE;
/*!40000 ALTER TABLE `answerbag` DISABLE KEYS */;
INSERT INTO `answerbag` VALUES (1,'Java is a programming language'),(1,'Java is a platform'),(2,'Servlet is an Interface'),(2,'Servlet is an API'),(3,'Java is a programming language'),(3,'Java is a platform'),(4,'Servlet is an Interface'),(4,'Servlet is an API'),(5,'Java is a programming language'),(5,'Java is a platform'),(6,'Servlet is an Interface'),(6,'Servlet is an API');
/*!40000 ALTER TABLE `answerbag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answermap`
--

DROP TABLE IF EXISTS `answermap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answermap` (
  `questionid` int(11) NOT NULL,
  `answer` varchar(300) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answermap`
--

LOCK TABLES `answermap` WRITE;
/*!40000 ALTER TABLE `answermap` DISABLE KEYS */;
INSERT INTO `answermap` VALUES (1,'Java is a programming language','John Milton'),(1,'Java is a platform','Ashok Kumar'),(2,'Servlet is a package','Rahul Kumar'),(2,'Servlet technology is a server side programming','John Milton'),(2,'Servlet is an Interface','Ashok Kumar'),(3,'Java is a programming language','John Milton'),(3,'Java is a platform','Ashok Kumar'),(4,'Servlet is a package','Rahul Kumar'),(4,'Servlet technology is a server side programming','John Milton'),(4,'Servlet is an Interface','Ashok Kumar');
/*!40000 ALTER TABLE `answermap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `author_id` int(11) NOT NULL,
  `authorName` varchar(30) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'Kraig Muller','Wordnewton@gmail.com','Male'),(2,'Karrie Nicolette','karrie23@gmail.com','Female');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `BookId` int(11) NOT NULL,
  `ISBN` int(11) NOT NULL,
  `book_name` varchar(30) NOT NULL,
  `author` int(11) DEFAULT NULL,
  `ed_num` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  PRIMARY KEY (`ISBN`),
  UNIQUE KEY `BookId` (`BookId`),
  KEY `author` (`author`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`author`) REFERENCES `author` (`author_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,1,'Glimpses of the past',1,1,650,396),(2,2,'Beyond The Horizons of Venus',1,1,650,396),(3,3,'Ultrasonic Aquaculture',2,1,799,500),(4,4,'Cyrogenic Engines',2,1,700,330);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cate_items`
--

DROP TABLE IF EXISTS `cate_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cate_items` (
  `c_id_fk` int(11) NOT NULL,
  `item_id_fk` int(11) NOT NULL,
  PRIMARY KEY (`c_id_fk`,`item_id_fk`),
  KEY `FKoli79c9hfeen8hiojt6etgvqx` (`item_id_fk`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cate_items`
--

LOCK TABLES `cate_items` WRITE;
/*!40000 ALTER TABLE `cate_items` DISABLE KEYS */;
INSERT INTO `cate_items` VALUES (1,31),(1,32),(2,31),(2,32);
/*!40000 ALTER TABLE `cate_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `c_id` int(11) NOT NULL,
  `c_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'category 01'),(2,'category 02');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificateotm`
--

DROP TABLE IF EXISTS `certificateotm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `certificateotm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `certificate_name` varchar(30) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf9cmrinwjggigr45l1wol586k` (`employee_id`),
  CONSTRAINT `FKf9cmrinwjggigr45l1wol586k` FOREIGN KEY (`employee_id`) REFERENCES `empotmmapp` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificateotm`
--

LOCK TABLES `certificateotm` WRITE;
/*!40000 ALTER TABLE `certificateotm` DISABLE KEYS */;
/*!40000 ALTER TABLE `certificateotm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `componentmapp`
--

DROP TABLE IF EXISTS `componentmapp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `componentmapp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componentmapp`
--

LOCK TABLES `componentmapp` WRITE;
/*!40000 ALTER TABLE `componentmapp` DISABLE KEYS */;
INSERT INTO `componentmapp` VALUES (1,'amit','gzb','india',221233),(2,'Vijay','noida','india',224123),(3,'amit','gzb','india',221233),(4,'Vijay','noida','india',224123),(5,'amit','gzb','india',221233),(6,'Vijay','noida','india',224123);
/*!40000 ALTER TABLE `componentmapp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp` (
  `empid` int(11) NOT NULL,
  `empname` varchar(50) NOT NULL,
  `salary` int(11) NOT NULL,
  PRIMARY KEY (`empid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (101,'Rohan',12000),(102,'Alia',15000),(103,'Shyam',11000),(104,'Abhishek',10000),(105,'Vikas',90000),(106,'Sonam',34000);
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp99`
--

DROP TABLE IF EXISTS `emp99`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp99` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `salary` int(11) NOT NULL,
  `designation` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp99`
--

LOCK TABLES `emp99` WRITE;
/*!40000 ALTER TABLE `emp99` DISABLE KEYS */;
/*!40000 ALTER TABLE `emp99` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empheritance`
--

DROP TABLE IF EXISTS `empheritance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empheritance` (
  `id` int(11) NOT NULL,
  `type` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `bonus` int(11) DEFAULT NULL,
  `pay_per_hour` int(11) DEFAULT NULL,
  `contract_duration` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empheritance`
--

LOCK TABLES `empheritance` WRITE;
/*!40000 ALTER TABLE `empheritance` DISABLE KEYS */;
/*!40000 ALTER TABLE `empheritance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (58,'Zara','Ali',5000),(60,'John','Paul',10000),(61,'Zara','Ali',5000),(63,'John','Paul',10000),(64,'Zara','Ali',5000),(66,'John','Paul',10000),(67,'Zara','Ali',5000),(69,'John','Paul',10000),(70,'Zara','Ali',5000),(72,'John','Paul',10000),(73,'Zara','Ali',5000),(75,'John','Paul',10000);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_proc`
--

DROP TABLE IF EXISTS `employee_proc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_proc` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `edept` varchar(255) DEFAULT NULL,
  `edesig` varchar(255) DEFAULT NULL,
  `ename` varchar(255) DEFAULT NULL,
  `esal` int(11) NOT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_proc`
--

LOCK TABLES `employee_proc` WRITE;
/*!40000 ALTER TABLE `employee_proc` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_proc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empotmmapp`
--

DROP TABLE IF EXISTS `empotmmapp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empotmmapp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empotmmapp`
--

LOCK TABLES `empotmmapp` WRITE;
/*!40000 ALTER TABLE `empotmmapp` DISABLE KEYS */;
/*!40000 ALTER TABLE `empotmmapp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empotomapp`
--

DROP TABLE IF EXISTS `empotomapp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empotomapp` (
  `employeeId` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`employeeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empotomapp`
--

LOCK TABLES `empotomapp` WRITE;
/*!40000 ALTER TABLE `empotomapp` DISABLE KEYS */;
INSERT INTO `empotomapp` VALUES (1,'Ravi Malik','ravi@gmail.com'),(2,'Ravi Malik','ravi@gmail.com'),(3,'Ravi Malik','ravi@gmail.com');
/*!40000 ALTER TABLE `empotomapp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emptpc`
--

DROP TABLE IF EXISTS `emptpc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emptpc` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emptpc`
--

LOCK TABLES `emptpc` WRITE;
/*!40000 ALTER TABLE `emptpc` DISABLE KEYS */;
INSERT INTO `emptpc` VALUES (1,'Virendra'),(2,'Arjun Kumar'),(3,'Kamal Jain'),(4,'Gaurav Chawla'),(5,'Vivek Kumar'),(6,'Arjun Kumar'),(7,'Viren Sharma'),(8,'Vivek Kumar'),(9,'Arjun Kumar'),(10,'Viren Sharma'),(11,'Vivek Kumar'),(12,'Arjun Kumar'),(13,'Gaurav Chawla'),(14,'Vivek Kumar'),(15,'Arjun Kumar'),(16,'Virendra'),(17,'Arjun Kumar'),(18,'Kamal Jain');
/*!40000 ALTER TABLE `emptpc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emptpc_ce`
--

DROP TABLE IF EXISTS `emptpc_ce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emptpc_ce` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `pay_per_hour` int(11) DEFAULT NULL,
  `contract_duration` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emptpc_ce`
--

LOCK TABLES `emptpc_ce` WRITE;
/*!40000 ALTER TABLE `emptpc_ce` DISABLE KEYS */;
/*!40000 ALTER TABLE `emptpc_ce` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emptpc_re`
--

DROP TABLE IF EXISTS `emptpc_re`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emptpc_re` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `bonus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emptpc_re`
--

LOCK TABLES `emptpc_re` WRITE;
/*!40000 ALTER TABLE `emptpc_re` DISABLE KEYS */;
/*!40000 ALTER TABLE `emptpc_re` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emptps_ce`
--

DROP TABLE IF EXISTS `emptps_ce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emptps_ce` (
  `eid` int(11) NOT NULL,
  `pay_per_hour` float DEFAULT NULL,
  `contract_duration` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emptps_ce`
--

LOCK TABLES `emptps_ce` WRITE;
/*!40000 ALTER TABLE `emptps_ce` DISABLE KEYS */;
INSERT INTO `emptps_ce` VALUES (3,1000,'20 hours'),(6,1000,'15 hours'),(9,1000,'15 hours'),(12,1000,'15 hours'),(15,1000,'15 hours'),(18,1000,'20 hours');
/*!40000 ALTER TABLE `emptps_ce` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emptps_re`
--

DROP TABLE IF EXISTS `emptps_re`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emptps_re` (
  `eid` int(11) NOT NULL,
  `salary` float DEFAULT NULL,
  `bonus` int(11) DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emptps_re`
--

LOCK TABLES `emptps_re` WRITE;
/*!40000 ALTER TABLE `emptps_re` DISABLE KEYS */;
INSERT INTO `emptps_re` VALUES (2,50000,5),(5,50000,5),(8,50000,5),(11,50000,5),(14,50000,5),(17,50000,5);
/*!40000 ALTER TABLE `emptps_re` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eproduct`
--

DROP TABLE IF EXISTS `eproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eproduct` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `parts_hdd` varchar(10) DEFAULT NULL,
  `parts_cpu` varchar(10) DEFAULT NULL,
  `parts_ram` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eproduct`
--

LOCK TABLES `eproduct` WRITE;
/*!40000 ALTER TABLE `eproduct` DISABLE KEYS */;
INSERT INTO `eproduct` VALUES (1,'HP Laptop ABC',21900.00,'2019-06-04 12:18:57','2 Gb HDD','AMD Phenom','4 Gb'),(2,'Acer Laptop ABC',23300.00,'2019-06-04 12:19:07','500 Gb HDD','Core-i7','4 Gb'),(3,'Lenovo Laptop ABC',33322.00,'2019-06-04 12:19:19','1 Tb HDD','Core-i7','8 Gb');
/*!40000 ALTER TABLE `eproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (5);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hqladdress`
--

DROP TABLE IF EXISTS `hqladdress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hqladdress` (
  `emp_id` bigint(20) NOT NULL,
  `address_line1` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hqladdress`
--

LOCK TABLES `hqladdress` WRITE;
/*!40000 ALTER TABLE `hqladdress` DISABLE KEYS */;
/*!40000 ALTER TABLE `hqladdress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hqlemployee`
--

DROP TABLE IF EXISTS `hqlemployee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hqlemployee` (
  `emp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(255) DEFAULT NULL,
  `emp_salary` double DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hqlemployee`
--

LOCK TABLES `hqlemployee` WRITE;
/*!40000 ALTER TABLE `hqlemployee` DISABLE KEYS */;
/*!40000 ALTER TABLE `hqlemployee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `i_id` int(11) NOT NULL,
  `i_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`i_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (31,'item 11'),(32,'item 21');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `Id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  UNIQUE KEY `Id` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Pencil',15.15),(2,'Pen',5150.00),(3,'Color Box',12.45);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionbag`
--

DROP TABLE IF EXISTS `questionbag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionbag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qname` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionbag`
--

LOCK TABLES `questionbag` WRITE;
/*!40000 ALTER TABLE `questionbag` DISABLE KEYS */;
INSERT INTO `questionbag` VALUES (1,'What is Java?'),(2,'What is Servlet?'),(3,'What is Java?'),(4,'What is Servlet?'),(5,'What is Java?'),(6,'What is Servlet?');
/*!40000 ALTER TABLE `questionbag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionmap`
--

DROP TABLE IF EXISTS `questionmap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionmap` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionmap`
--

LOCK TABLES `questionmap` WRITE;
/*!40000 ALTER TABLE `questionmap` DISABLE KEYS */;
INSERT INTO `questionmap` VALUES (1,'What is Java?','Alok'),(2,'What is Servlet?','Jai Dixit'),(3,'What is Java?','Alok'),(4,'What is Servlet?','Jai Dixit');
/*!40000 ALTER TABLE `questionmap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `degree` varchar(100) DEFAULT NULL,
  `roll` varchar(100) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Hemanth','B.Com','104',989876),(2,'Mukesh','B.Com','103',999954),(3,'Ravi','B.E','102',934499),(4,'Mukesh','B.E','101',99999);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_table`
--

DROP TABLE IF EXISTS `student_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_table` (
  `student_id` int(20) NOT NULL,
  `student_name` varchar(20) DEFAULT NULL,
  `student_age` int(20) DEFAULT NULL,
  `student_city` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_table`
--

LOCK TABLES `student_table` WRITE;
/*!40000 ALTER TABLE `student_table` DISABLE KEYS */;
INSERT INTO `student_table` VALUES (123,'123',123,'123'),(123,'123',123,'123'),(123,'123',123,'123'),(123,'123',123,'123'),(123,'123',123,'123'),(123,'123',123,'123'),(123321,'Abby',123,'Rhode_Island'),(1543,'DonkeyKong',500,'Toky'),(222,'someDumbThing',333,'someDumbPlace');
/*!40000 ALTER TABLE `student_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'db_world'
--

--
-- Dumping routines for database 'db_world'
--
/*!50003 DROP PROCEDURE IF EXISTS `new_update_price` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `new_update_price`(IN author_id int, IN book_id int,  IN new_price integer,
    OUT author_name varchar(20) , OUT author_gender varchar(6),
    OUT bookname varchar(20), OUT book_num_pages integer )
begin
select a.authorname, a.gender, b.book_name, b.pages, b.bookId
into author_name, author_gender, bookname, book_num_pages, book_id
from author a, book b
where a.author_id = b.author and b.bookId = book_id and b.author = author_id ;
update book set price=new_price where book.BookId = book_id  ;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `PRODUCT_PROC` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `PRODUCT_PROC`(IN pid int, OUT pname varchar(50),INOUT pprice decimal(10,2))
BEGIN
declare tempPrice decimal(10,2);    
-- Select data
select name,price into pname,tempPrice from product where id = pid;    
-- Update new price
update product set price=pprice where  id = pid;  
-- Return old price
set pprice= tempPrice;    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_price` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_price`(IN temp_ISBN varchar(10), IN new_price integer)
begin
update book set price=new_price where ISBN=temp_ISBN;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Current Database: `phase2`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `phase2` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `phase2`;

--
-- Dumping events for database 'phase2'
--

--
-- Dumping routines for database 'phase2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-25 23:53:24
