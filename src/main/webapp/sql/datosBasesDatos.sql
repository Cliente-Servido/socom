-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: socom
-- ------------------------------------------------------
-- Server version	5.6.25-log

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
-- Dumping data for table `camiones`
--

LOCK TABLES `camiones` WRITE;
/*!40000 ALTER TABLE `camiones` DISABLE KEYS */;
INSERT INTO `camiones` VALUES (2,'IVECO','2015','aaa111',2015,'camion 2',2),(3,'IVECO','2010','bbb222',2014,'camion 3',3),(4,'IVECO','2010','bbb333',2014,'camion 4',2),(6,'VOLVO2','VO','pab123',2015,'pablo',NULL),(7,'Mercedes','2008','ccc333',2014,'Camion ruta 3',3),(8,'Mercedes','2010','abc123',2014,'',4);
/*!40000 ALTER TABLE `camiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Perez','Pablo','french 123','123456','plabo@algo.com');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'carca','Juan',18000,'Cadete','Ventas',1,NULL),(4,'pereez','pablo',18001,'cadete','Ventas',1,NULL),(5,'Perez','Lili',11111,'cadete','compras',1,NULL),(7,'Alegre','Carlos',14145,'cadete','',1,NULL),(8,'Alegre','Carlitos',2121,'cadete','2015/6/6',1,NULL),(9,'Sanchez','Julio',54321,'Secretario','',1,NULL),(12,'agostian','asfgo',45651,'cadete','2015-09-09',1,NULL),(13,'Alegre','Carlos',4566,'cadete','',1,NULL),(14,'Alegre2','Carlos2',456789,'cadete2','kjkjkj',1,NULL),(15,'Gonzales','Gonzalo',34343,'guardia','seguridad',1,'2015-07-08');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,1,'origen',1,'2015-06-08',1),(2,1,'partio',1,'2015-06-08',1),(3,1,'llego',1,'2015-06-08',1),(4,1,'qa',NULL,NULL,NULL),(5,2,'qa',NULL,NULL,NULL);
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
INSERT INTO `facturas` VALUES (1,'2015-02-05',5000,1,1),(2,'2015-07-05',200,1,1),(3,NULL,200,1,1),(4,NULL,200,1,1),(5,NULL,NULL,1,1),(6,NULL,NULL,1,1),(8,NULL,NULL,1,1),(9,NULL,500,1,1),(10,NULL,5641,NULL,1),(12,'2014-05-11',5555110,1,1),(13,'2012-12-12',65465500,1,1),(14,'2012-12-12',65465500,1,1),(15,NULL,555,1,1),(16,NULL,546468,1,1),(17,NULL,55445,1,1),(18,NULL,1555,1,1),(19,NULL,1212,1,1),(20,NULL,545,1,1),(21,NULL,155,1,1),(22,NULL,11,1,1),(23,NULL,22,1,1),(24,NULL,5154,1,1),(25,NULL,899,NULL,1),(26,NULL,554105,NULL,1),(27,NULL,545,NULL,1),(28,NULL,2,NULL,1),(29,NULL,2,NULL,1),(30,NULL,5454,NULL,1),(31,NULL,5454,NULL,1),(32,NULL,36,NULL,1),(33,NULL,555,NULL,1),(34,NULL,121.1,NULL,1),(35,NULL,5456,1,1),(36,NULL,666,NULL,1),(37,NULL,1.2,NULL,1),(38,NULL,54545,NULL,1),(39,NULL,546546,1,1),(40,NULL,554566,1,1),(41,NULL,3234,NULL,1),(42,NULL,NULL,NULL,1),(43,NULL,654456,1,1),(44,NULL,7546,1,1),(45,NULL,87858,NULL,1),(46,'2013-09-17',88888,NULL,1),(47,NULL,444,1,1),(48,NULL,5855,1,1),(49,NULL,5682,1,1),(50,NULL,66666,1,1),(51,NULL,5666,1,1),(52,NULL,55,1,1),(53,NULL,555,1,1),(54,NULL,666,1,1),(55,NULL,9456650000,1,1),(56,NULL,6666,1,1);
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `gerentes`
--

LOCK TABLES `gerentes` WRITE;
/*!40000 ALTER TABLE `gerentes` DISABLE KEYS */;
INSERT INTO `gerentes` VALUES (1,'perez','pepe',1234,1);
/*!40000 ALTER TABLE `gerentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `localidades`
--

LOCK TABLES `localidades` WRITE;
/*!40000 ALTER TABLE `localidades` DISABLE KEYS */;
INSERT INTO `localidades` VALUES (1,1,'corrientes'),(2,1,'corrientes'),(3,1,'Bella Vista'),(4,2,'Resistencia');
/*!40000 ALTER TABLE `localidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `paises`
--

LOCK TABLES `paises` WRITE;
/*!40000 ALTER TABLE `paises` DISABLE KEYS */;
INSERT INTO `paises` VALUES (1,'argentina'),(2,'argentina');
/*!40000 ALTER TABLE `paises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `paquetes`
--

LOCK TABLES `paquetes` WRITE;
/*!40000 ALTER TABLE `paquetes` DISABLE KEYS */;
INSERT INTO `paquetes` VALUES (1,5,200,1,1,1,1,'pepe',36000000,'10101','123456','pepe@algo.com'),(2,15,150,2,1,1,2,'pepe2',36000000,'10101','123456','pepe2@algo.com'),(3,5,200,56,1,1,1,'pepe',36000000,'10101','123456','pepe@algo.com');
/*!40000 ALTER TABLE `paquetes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `paquetesxviaje`
--

LOCK TABLES `paquetesxviaje` WRITE;
/*!40000 ALTER TABLE `paquetesxviaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `paquetesxviaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `provincias`
--

LOCK TABLES `provincias` WRITE;
/*!40000 ALTER TABLE `provincias` DISABLE KEYS */;
INSERT INTO `provincias` VALUES (1,1,'corrientes'),(2,1,'corrientes'),(3,1,'Chaco');
/*!40000 ALTER TABLE `provincias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `rutas`
--

LOCK TABLES `rutas` WRITE;
/*!40000 ALTER TABLE `rutas` DISABLE KEYS */;
INSERT INTO `rutas` VALUES (1,1,1,'ruta1',1),(2,1,4,NULL,4),(3,1,7,NULL,7),(4,4,7,NULL,3),(5,5,7,NULL,2),(6,1,2,'lala',NULL),(7,1,3,'',NULL),(8,1,6,'',NULL),(9,4,5,'1cvbvxb',NULL);
/*!40000 ALTER TABLE `rutas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES (1,'1nomarl','envio normal',12,6,10),(2,'rapido','el mas rapido',50,25,100);
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sucursales`
--

LOCK TABLES `sucursales` WRITE;
/*!40000 ALTER TABLE `sucursales` DISABLE KEYS */;
INSERT INTO `sucursales` VALUES (1,1,'Carlos Pellegrini','8 hs a 20hs','Primera Sucursal'),(2,1,'Carlos Pellegrini','8 hs a 20hs','Primera Sucursal'),(3,2,'Carlos Pellegrini','8 hs a 20hs','Segunda Sucursal'),(4,2,'carlos pellegrino 1992','de 8hs a 21hs','otra Sucursal'),(5,2,'alberdi','de 8hs a 21hs','otra Sucursal'),(6,2,'megasucursal','de 8hs a 21hs','otra Sucursal'),(7,2,'megaman','de 8hs a 21hs','otra Sucursal'),(8,2,'uruguay 19992','de 8hs a 21hs','otra Sucursal'),(9,2,'Frondizi 1231','de 8hs a 21hs','otra Sucursal'),(10,2,'Paraguay 2324','de 8hs a 21hs','otra Sucursal');
/*!40000 ALTER TABLE `sucursales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sucursalesxruta`
--

LOCK TABLES `sucursalesxruta` WRITE;
/*!40000 ALTER TABLE `sucursalesxruta` DISABLE KEYS */;
INSERT INTO `sucursalesxruta` VALUES (1,1,1,2,NULL),(2,1,1,2,NULL),(3,2,5,5,NULL),(4,2,5,5,NULL),(5,2,5,5,NULL),(6,2,5,5,NULL);
/*!40000 ALTER TABLE `sucursalesxruta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'socom','1234',NULL,1,NULL),(2,'soc','1234',1,NULL,NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `viajes`
--

LOCK TABLES `viajes` WRITE;
/*!40000 ALTER TABLE `viajes` DISABLE KEYS */;
INSERT INTO `viajes` VALUES (1,1,2,2,NULL,NULL,NULL,NULL),(2,1,2,2,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `viajes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-09 22:47:53
