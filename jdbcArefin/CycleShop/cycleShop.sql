-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: cycleshop
-- ------------------------------------------------------
-- Server version	5.6.40-log

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
-- Table structure for table `cyclepurchase`
--

DROP TABLE IF EXISTS `cyclepurchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cyclepurchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `pCode` varchar(30) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `unitPrice` double DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  `purchaseDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cyclepurchase`
--

LOCK TABLES `cyclepurchase` WRITE;
/*!40000 ALTER TABLE `cyclepurchase` DISABLE KEYS */;
INSERT INTO `cyclepurchase` VALUES (1,'Core Project 1','CORE01',10,14000,140000,'2018-12-02'),(2,'Core Project 1','CORE01',10,14000,140000,'2018-12-02');
/*!40000 ALTER TABLE `cyclepurchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cyclesales`
--

DROP TABLE IF EXISTS `cyclesales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cyclesales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `pCode` varchar(30) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `unitPrice` double DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  `salesDate` date DEFAULT NULL,
  `pId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pId` (`pId`),
  CONSTRAINT `cyclesales_ibfk_1` FOREIGN KEY (`pId`) REFERENCES `cyclepurchase` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cyclesales`
--

LOCK TABLES `cyclesales` WRITE;
/*!40000 ALTER TABLE `cyclesales` DISABLE KEYS */;
INSERT INTO `cyclesales` VALUES (1,'Core Project 1','CORE01',5,15000,750000,'2018-12-02',1);
/*!40000 ALTER TABLE `cyclesales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchasesalessummary`
--

DROP TABLE IF EXISTS `purchasesalessummary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchasesalessummary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `pCode` varchar(30) DEFAULT NULL,
  `totalQuantity` int(11) DEFAULT NULL,
  `soldQuantity` int(11) DEFAULT NULL,
  `availableQuantity` int(11) DEFAULT NULL,
  `lastUpdate` date DEFAULT NULL,
  `pId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pId` (`pId`),
  CONSTRAINT `purchasesalessummary_ibfk_1` FOREIGN KEY (`pId`) REFERENCES `cyclepurchase` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchasesalessummary`
--

LOCK TABLES `purchasesalessummary` WRITE;
/*!40000 ALTER TABLE `purchasesalessummary` DISABLE KEYS */;
INSERT INTO `purchasesalessummary` VALUES (2,'Core Project 1','CORE01',20,5,15,'2018-12-02',1);
/*!40000 ALTER TABLE `purchasesalessummary` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-02 21:58:22
