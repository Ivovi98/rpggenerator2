-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: rpggenerator2
-- ------------------------------------------------------
-- Server version	8.0.30

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
  `id` int NOT NULL AUTO_INCREMENT,
  `nome_attributi_abilita` varchar(45) DEFAULT NULL,
  `nome_abilita` varchar(45) DEFAULT NULL,
  `versione` int DEFAULT NULL,
  `data_creazione` datetime DEFAULT NULL,
  `data_ultima_modifica` datetime DEFAULT NULL,
  `id_classe` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idclasse_idx` (`id_classe`),
  CONSTRAINT `Classe_idclasseAbilita` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id`)
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
  `id` int NOT NULL AUTO_INCREMENT,
  `nome_attributi_categoria` varchar(45) DEFAULT NULL,
  `versione` int DEFAULT NULL,
  `data_ultima_modifica` datetime DEFAULT NULL,
  `data_creazione` datetime DEFAULT NULL,
  `id_descrizione` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Descrizione_iddescrizione_idx` (`id_descrizione`),
  CONSTRAINT `Descrizione_iddescrizione` FOREIGN KEY (`id_descrizione`) REFERENCES `descrizione` (`id`)
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
  `id` int NOT NULL AUTO_INCREMENT,
  `nome_attributi_classe` varchar(45) DEFAULT NULL,
  `versione` int DEFAULT NULL,
  `data_creazione` datetime DEFAULT NULL,
  `data_ultima_modifica` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
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
  `id` int NOT NULL AUTO_INCREMENT,
  `versione` int DEFAULT NULL,
  `data_creazione` datetime DEFAULT NULL,
  `data_ultima_modifica` datetime DEFAULT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  `id_abilita` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Abilita_idabilita_idx` (`id_abilita`),
  CONSTRAINT `id_abilita` FOREIGN KEY (`id_abilita`) REFERENCES `abilita` (`id`)
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
  `id` int NOT NULL AUTO_INCREMENT,
  `versione` int DEFAULT NULL,
  `data_creazione` datetime DEFAULT NULL,
  `data_ultima_modifica` datetime DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `livello` int DEFAULT NULL,
  `intellij` int DEFAULT NULL,
  `forza` int DEFAULT NULL,
  `salute` int DEFAULT NULL,
  `id_classe` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Classe_idclasse_idx` (`id_classe`),
  CONSTRAINT `id_classe` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id`)
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

-- Dump completed on 2023-03-15 20:36:04
