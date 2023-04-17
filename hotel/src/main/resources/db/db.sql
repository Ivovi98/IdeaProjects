-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel
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
-- Table structure for table `camera`
--

DROP TABLE IF EXISTS `camera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `camera` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipologia` varchar(45) DEFAULT NULL,
  `numero_camera` int DEFAULT NULL,
  `costo` int DEFAULT NULL,
  `id_hotel` int NOT NULL,
  `data_creazione` timestamp NULL DEFAULT NULL,
  `data_ultima_modifica` timestamp NULL DEFAULT NULL,
  `versione` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_hotelCamera_idx` (`id_hotel`),
  CONSTRAINT `fk_id_hotelCamera` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camera`
--

LOCK TABLES `camera` WRITE;
/*!40000 ALTER TABLE `camera` DISABLE KEYS */;
/*!40000 ALTER TABLE `camera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `camera_servizi`
--

DROP TABLE IF EXISTS `camera_servizi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `camera_servizi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_servizi` int NOT NULL,
  `id_camera` int NOT NULL,
  `data_creazione` timestamp NULL DEFAULT NULL,
  `data_ultima_modifica` timestamp NULL DEFAULT NULL,
  `versione` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_serviziCameraServizi_idx` (`id_servizi`),
  KEY `fk_id_cameraCameraServizi_idx` (`id_camera`),
  CONSTRAINT `fk_id_cameraCameraServizi` FOREIGN KEY (`id_camera`) REFERENCES `camera` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_id_serviziCameraServizi` FOREIGN KEY (`id_servizi`) REFERENCES `servizi` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camera_servizi`
--

LOCK TABLES `camera_servizi` WRITE;
/*!40000 ALTER TABLE `camera_servizi` DISABLE KEYS */;
/*!40000 ALTER TABLE `camera_servizi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `stelle` int DEFAULT NULL,
  `tipologia` varchar(45) DEFAULT NULL,
  `data_creazione` timestamp NULL DEFAULT NULL,
  `data_ultima_modifica` timestamp NULL DEFAULT NULL,
  `versione` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazione`
--

DROP TABLE IF EXISTS `prenotazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazione` (
  `idprenotazione` int NOT NULL AUTO_INCREMENT,
  `data_inizio` timestamp NULL DEFAULT NULL,
  `data_fine` timestamp NULL DEFAULT NULL,
  `id_utente` int NOT NULL,
  `id_camera` int NOT NULL,
  `data_creazione` timestamp NULL DEFAULT NULL,
  `data_ultima_modifica` timestamp NULL DEFAULT NULL,
  `versione` int DEFAULT NULL,
  PRIMARY KEY (`idprenotazione`),
  KEY `fk_id_utente_idx` (`id_utente`),
  KEY `fk_id_camera_idx` (`id_camera`),
  CONSTRAINT `fk_id_cameraPrenotazione` FOREIGN KEY (`id_camera`) REFERENCES `camera` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_id_utentePrenotazione` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazione`
--

LOCK TABLES `prenotazione` WRITE;
/*!40000 ALTER TABLE `prenotazione` DISABLE KEYS */;
/*!40000 ALTER TABLE `prenotazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recensioni`
--

DROP TABLE IF EXISTS `recensioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recensioni` (
  `id` int NOT NULL AUTO_INCREMENT,
  `recensione` varchar(500) DEFAULT NULL,
  `numero_stelle` int DEFAULT NULL,
  `id_utente` int NOT NULL,
  `id_hotel` int NOT NULL,
  `data_creazione` timestamp NULL DEFAULT NULL,
  `data_ultima_modifica` timestamp NULL DEFAULT NULL,
  `versione` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_hotel_idx` (`id_hotel`),
  KEY `fk_id_utente_idx` (`id_utente`),
  KEY `fk_id_utenteRecensioni_idx` (`id_utente`),
  CONSTRAINT `fk_id_hotelRecensioni` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_id_utenteRecensioni` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recensioni`
--

LOCK TABLES `recensioni` WRITE;
/*!40000 ALTER TABLE `recensioni` DISABLE KEYS */;
/*!40000 ALTER TABLE `recensioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servizi`
--

DROP TABLE IF EXISTS `servizi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servizi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `data_creazione` timestamp NULL DEFAULT NULL,
  `data_ultima_modifica` timestamp NULL DEFAULT NULL,
  `versione` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servizi`
--

LOCK TABLES `servizi` WRITE;
/*!40000 ALTER TABLE `servizi` DISABLE KEYS */;
/*!40000 ALTER TABLE `servizi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `data_di_nascita` timestamp NULL DEFAULT NULL,
  `numero_telefono` int DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `data_creazione` timestamp NULL DEFAULT NULL,
  `data_ultima_modifica` timestamp NULL DEFAULT NULL,
  `versione` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,NULL,NULL,NULL,0,NULL,'2023-03-22 11:14:57',NULL,69);
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-22 14:58:46
