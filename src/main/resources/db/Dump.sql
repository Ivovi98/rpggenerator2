-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: rpggenerator2
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `abilita`
--

DROP TABLE IF EXISTS `abilita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abilita` (
  `idabilita` int NOT NULL AUTO_INCREMENT,
  `nomeAttributiAbilita` varchar(45) DEFAULT NULL,
  `nomeAbilita` varchar(45) DEFAULT NULL,
  `versione` int DEFAULT NULL,
  `dataCreazione` datetime DEFAULT NULL,
  `dataUltimaModifica` datetime DEFAULT NULL,
  `Classe_idclasse` int NOT NULL,
  PRIMARY KEY (`idabilita`),
  KEY `idclasse_idx` (`Classe_idclasse`),
  CONSTRAINT `Classe_idclasseAbilita` FOREIGN KEY (`Classe_idclasse`) REFERENCES `classe` (`idclasse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abilita`
--

LOCK TABLES `abilita` WRITE;
/*!40000 ALTER TABLE `abilita` DISABLE KEYS */;
/*!40000 ALTER TABLE `abilita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `idcategoria` int NOT NULL AUTO_INCREMENT,
  `nomeAttributiCategoria` varchar(45) DEFAULT NULL,
  `versione` int DEFAULT NULL,
  `dataUltimaModifica` datetime DEFAULT NULL,
  `dataCreazione` datetime DEFAULT NULL,
  `Descrizione_iddescrizione` int NOT NULL,
  PRIMARY KEY (`idcategoria`),
  KEY `Descrizione_iddescrizione_idx` (`Descrizione_iddescrizione`),
  CONSTRAINT `Descrizione_iddescrizione` FOREIGN KEY (`Descrizione_iddescrizione`) REFERENCES `descrizione` (`iddescrizione`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classe` (
  `idclasse` int NOT NULL AUTO_INCREMENT,
  `nomeAttributiClasse` varchar(45) DEFAULT NULL,
  `versione` int DEFAULT NULL,
  `dataCreazione` datetime DEFAULT NULL,
  `dataUltimaModifica` datetime DEFAULT NULL,
  PRIMARY KEY (`idclasse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe`
--

LOCK TABLES `classe` WRITE;
/*!40000 ALTER TABLE `classe` DISABLE KEYS */;
/*!40000 ALTER TABLE `classe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descrizione`
--

DROP TABLE IF EXISTS `descrizione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `descrizione` (
  `iddescrizione` int NOT NULL AUTO_INCREMENT,
  `versione` int DEFAULT NULL,
  `dataCreazione` datetime DEFAULT NULL,
  `dataUltimaModifica` datetime DEFAULT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  `Abilita_idabilita` int NOT NULL,
  PRIMARY KEY (`iddescrizione`),
  KEY `Abilita_idabilita_idx` (`Abilita_idabilita`),
  CONSTRAINT `Abilita_idabilita` FOREIGN KEY (`Abilita_idabilita`) REFERENCES `abilita` (`idabilita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descrizione`
--

LOCK TABLES `descrizione` WRITE;
/*!40000 ALTER TABLE `descrizione` DISABLE KEYS */;
/*!40000 ALTER TABLE `descrizione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personaggio`
--

DROP TABLE IF EXISTS `personaggio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personaggio` (
  `idpersonaggio` int NOT NULL AUTO_INCREMENT,
  `versione` int DEFAULT NULL,
  `dataCreazione` datetime DEFAULT NULL,
  `dataUltimaModifica` datetime DEFAULT NULL,
  `nomePersonaggio` varchar(45) DEFAULT NULL,
  `classePersonaggio` varchar(45) DEFAULT NULL,
  `livelloPersonaggio` int DEFAULT NULL,
  `intellijPersonaggio` int DEFAULT NULL,
  `forzaPersonaggio` int DEFAULT NULL,
  `salutePersonaggio` int DEFAULT NULL,
  `Classe_idclasse` int NOT NULL,
  PRIMARY KEY (`idpersonaggio`),
  KEY `Classe_idclasse_idx` (`Classe_idclasse`),
  CONSTRAINT `Classe_idclasse` FOREIGN KEY (`Classe_idclasse`) REFERENCES `classe` (`idclasse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaggio`
--

LOCK TABLES `personaggio` WRITE;
/*!40000 ALTER TABLE `personaggio` DISABLE KEYS */;
/*!40000 ALTER TABLE `personaggio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-15 16:52:51
