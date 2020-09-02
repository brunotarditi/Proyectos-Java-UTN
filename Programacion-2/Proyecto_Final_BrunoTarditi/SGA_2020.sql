-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: sga_2020
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `alu_dni` bigint unsigned NOT NULL,
  `alu_nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `alu_apellido` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `alu_fec_nac` date NOT NULL,
  `alu_domicilio` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `alu_telefono` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `alu_insc_cod` bigint DEFAULT NULL,
  PRIMARY KEY (`alu_dni`),
  KEY `alu_insc_cod` (`alu_insc_cod`),
  CONSTRAINT `FK_Alumno` FOREIGN KEY (`alu_insc_cod`) REFERENCES `inscripcion` (`insc_cod`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (25369741,'Ignacio','Balboa','1950-06-16','calle falsa 123','12587436',2),(36124562,'Gonzalo','Huici','1991-11-23','Ramón Carrillo - Sanidad - Mendoza','2616300416',1),(36417548,'Bruno','Tarditi','1992-01-15','Gainza 3071 - Mendoza','2615934064',1),(38205298,'Camila','Guajardo','1994-05-13','Marmol 860 - Godoy Cruz','2613378444',2),(40258369,'Richard','King','2017-08-12','Sarmiento 815 - Mendoza','2615123456',5);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrera`
--

DROP TABLE IF EXISTS `carrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrera` (
  `car_cod` bigint NOT NULL AUTO_INCREMENT,
  `car_nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `car_duracion` bigint NOT NULL,
  PRIMARY KEY (`car_cod`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrera`
--

LOCK TABLES `carrera` WRITE;
/*!40000 ALTER TABLE `carrera` DISABLE KEYS */;
INSERT INTO `carrera` VALUES (1,'Programacion',2),(2,'Recursos Humanos',4),(3,'Medicina',6),(5,'Abogacia',5),(6,'Veterinaria',5);
/*!40000 ALTER TABLE `carrera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursado`
--

DROP TABLE IF EXISTS `cursado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursado` (
  `cur_alu_dni` bigint unsigned NOT NULL,
  `cur_mat_cod` bigint unsigned NOT NULL,
  `cur_nota` int unsigned NOT NULL,
  PRIMARY KEY (`cur_alu_dni`,`cur_mat_cod`),
  KEY `cur_mat_cod` (`cur_mat_cod`),
  CONSTRAINT `FK_CursadoAlumno` FOREIGN KEY (`cur_alu_dni`) REFERENCES `alumno` (`alu_dni`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_CursadoMat` FOREIGN KEY (`cur_mat_cod`) REFERENCES `materia` (`mat_cod`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursado`
--

LOCK TABLES `cursado` WRITE;
/*!40000 ALTER TABLE `cursado` DISABLE KEYS */;
INSERT INTO `cursado` VALUES (25369741,155,7),(36417548,123,5),(36417548,188,8),(38205298,123,9),(40258369,188,9);
/*!40000 ALTER TABLE `cursado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscripcion` (
  `insc_cod` bigint NOT NULL AUTO_INCREMENT,
  `insc_nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `insc_fecha` date NOT NULL,
  `insc_car_cod` bigint DEFAULT NULL,
  PRIMARY KEY (`insc_cod`),
  KEY `insc_car_cod` (`insc_car_cod`),
  CONSTRAINT `FK_Inscripcion` FOREIGN KEY (`insc_car_cod`) REFERENCES `carrera` (`car_cod`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcion`
--

LOCK TABLES `inscripcion` WRITE;
/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
INSERT INTO `inscripcion` VALUES (1,'Bruno','1992-01-15',1),(2,'Camila','1994-05-13',2),(3,'Richard','1996-08-20',3),(5,'Walter','2020-06-16',5);
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materia` (
  `mat_cod` bigint unsigned NOT NULL AUTO_INCREMENT,
  `mat_nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `mat_prof_dni` bigint unsigned NOT NULL,
  PRIMARY KEY (`mat_cod`),
  KEY `mat_prof_dni` (`mat_prof_dni`) /*!80000 INVISIBLE */,
  CONSTRAINT `FK_Materia_Prof_Dni` FOREIGN KEY (`mat_prof_dni`) REFERENCES `profesor` (`prof_dni`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=189 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
INSERT INTO `materia` VALUES (123,'Técnicas kinesicas',36766869),(155,'Inglés',14311338),(188,'Lengua',5879173);
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `prof_dni` bigint unsigned NOT NULL,
  `prof_nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `prof_apellido` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `prof_fec_nac` date NOT NULL,
  `prof_domicilio` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `prof_telefono` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`prof_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (5879173,'Ana Maria','Massa','1948-10-10','Gainza 3071 - Mendoza','2615933068'),(14311338,'Walter','Tomasini','1961-04-04','Paso de los Andes - 902','2614281498'),(36766869,'Judith','Llosa','1992-05-17','25 de mayo 393 B° Bombal - GC','2615930033');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sga_2020'
--

--
-- Dumping routines for database 'sga_2020'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-22 23:47:52
