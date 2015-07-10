CREATE DATABASE  IF NOT EXISTS `socom` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `socom`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: socom
-- ------------------------------------------------------
-- Server version	5.7.7-rc-log

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
-- Table structure for table `camiones`
--

DROP TABLE IF EXISTS `camiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `camiones` (
  `idCamion` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(12) DEFAULT NULL,
  `modelo` varchar(60) DEFAULT NULL,
  `dominio` char(6) DEFAULT NULL,
  `anio` int(11) DEFAULT NULL,
  `descripcion` varchar(60) DEFAULT NULL,
  `idRuta` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCamion`),
  KEY `idRuta` (`idRuta`),
  CONSTRAINT `camiones_ibfk_1` FOREIGN KEY (`idRuta`) REFERENCES `rutas` (`idRuta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camiones`
--

LOCK TABLES `camiones` WRITE;
/*!40000 ALTER TABLE `camiones` DISABLE KEYS */;
/*!40000 ALTER TABLE `camiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` char(20) NOT NULL,
  `nombre` char(30) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Simpson','Homero','Av. Siempre viva 78','3434-4342343','homero.simpson@es.si'),(2,'Perez','Roberto','Hernandarias 54','3434-4833943','perez.sgffgfson@es.si'),(3,'Ayala','aida','Av Italia 900','3434-45442343','aida.gofdfa@es.si'),(5,'Balbuena','Igor','San Martin s/n','343434-44334343','IGOR.fdfddfdon@es.si');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` char(20) NOT NULL,
  `nombre` char(30) NOT NULL,
  `legajo` int(11) DEFAULT NULL,
  `cargo` char(15) DEFAULT NULL,
  `area` char(15) DEFAULT NULL,
  `idSucursal` int(11) NOT NULL,
  `fechaAlta` date DEFAULT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `idSucursal` (`idSucursal`),
  CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`idSucursal`) REFERENCES `sucursales` (`idSucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'carca','Juan',18000,'capo','Ventas',1,'2000-02-02'),(3,'luigui','sssss',33534325,NULL,'prostituto',1,NULL);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estados` (
  `idEstado` int(11) NOT NULL AUTO_INCREMENT,
  `idPaquete` int(11) NOT NULL,
  `descripcion` char(15) NOT NULL,
  `idEmpleado` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `idSucursal` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEstado`),
  KEY `idPaquete` (`idPaquete`),
  KEY `idEmpleado` (`idEmpleado`),
  KEY `idSucursal` (`idSucursal`),
  CONSTRAINT `estados_ibfk_1` FOREIGN KEY (`idPaquete`) REFERENCES `paquetes` (`idPaquete`),
  CONSTRAINT `estados_ibfk_2` FOREIGN KEY (`idEmpleado`) REFERENCES `empleados` (`idEmpleado`),
  CONSTRAINT `estados_ibfk_3` FOREIGN KEY (`idSucursal`) REFERENCES `sucursales` (`idSucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,1,'En proceso',1,'2015-04-01',1),(2,1,'En trÃ¡nsito',1,'2015-04-02',1);
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facturas` (
  `idFactura` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `monto` float DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idEmpleado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `idCliente` (`idCliente`),
  KEY `idEmpleado` (`idEmpleado`),
  CONSTRAINT `facturas_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`),
  CONSTRAINT `facturas_ibfk_2` FOREIGN KEY (`idEmpleado`) REFERENCES `empleados` (`idEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
INSERT INTO `facturas` VALUES (1,'2015-04-01',100,5,1);
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gerentes`
--

DROP TABLE IF EXISTS `gerentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gerentes` (
  `idGerente` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` char(20) NOT NULL,
  `nombre` char(30) NOT NULL,
  `legajo` int(11) DEFAULT NULL,
  `idSucursal` int(11) NOT NULL,
  PRIMARY KEY (`idGerente`),
  KEY `idSucursal` (`idSucursal`),
  CONSTRAINT `gerentes_ibfk_1` FOREIGN KEY (`idSucursal`) REFERENCES `sucursales` (`idSucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gerentes`
--

LOCK TABLES `gerentes` WRITE;
/*!40000 ALTER TABLE `gerentes` DISABLE KEYS */;
INSERT INTO `gerentes` VALUES (1,'argento','pipo',1234,1);
/*!40000 ALTER TABLE `gerentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidades`
--

DROP TABLE IF EXISTS `localidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localidades` (
  `idLocalidad` int(11) NOT NULL AUTO_INCREMENT,
  `idProvincia` int(11) NOT NULL,
  `nombre` char(25) NOT NULL,
  PRIMARY KEY (`idLocalidad`),
  KEY `idProvincia` (`idProvincia`),
  CONSTRAINT `localidades_ibfk_1` FOREIGN KEY (`idProvincia`) REFERENCES `provincias` (`idProvincia`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidades`
--

LOCK TABLES `localidades` WRITE;
/*!40000 ALTER TABLE `localidades` DISABLE KEYS */;
INSERT INTO `localidades` VALUES (1,1,'Corrientes'),(2,2,'Resistencia'),(4,3,'Rosario'),(5,3,'Ocampo');
/*!40000 ALTER TABLE `localidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paises`
--

DROP TABLE IF EXISTS `paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paises` (
  `idPais` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` char(15) NOT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paises`
--

LOCK TABLES `paises` WRITE;
/*!40000 ALTER TABLE `paises` DISABLE KEYS */;
INSERT INTO `paises` VALUES (1,'argentina'),(2,'paraguay');
/*!40000 ALTER TABLE `paises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paquetes`
--

DROP TABLE IF EXISTS `paquetes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paquetes` (
  `idPaquete` int(11) NOT NULL AUTO_INCREMENT,
  `peso` float DEFAULT NULL,
  `costoTotal` float DEFAULT NULL,
  `idFactura` int(11) DEFAULT NULL,
  `idServicio` int(11) DEFAULT NULL,
  `origen` int(11) NOT NULL,
  `destino` int(11) NOT NULL,
  `destinatarioNombre` varchar(50) NOT NULL,
  `destinatarioDNI` int(11) NOT NULL,
  `destinatarioDireccion` char(50) DEFAULT NULL,
  `destinatarioTelefono` varchar(20) DEFAULT NULL,
  `destinatarioEmail` varchar(30) DEFAULT NULL,
  `idCliente` int,
  PRIMARY KEY (`idPaquete`),
  KEY `idFactura` (`idFactura`),
  KEY `idServicio` (`idServicio`),
  KEY `origen` (`origen`),
  KEY `destino` (`destino`),
  KEY `idCliente` (`idCliente`),
  CONSTRAINT `paquetes_ibfk_5` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`),
  CONSTRAINT `paquetes_ibfk_1` FOREIGN KEY (`idFactura`) REFERENCES `facturas` (`idFactura`),
  CONSTRAINT `paquetes_ibfk_2` FOREIGN KEY (`idServicio`) REFERENCES `servicios` (`idServicio`),
  CONSTRAINT `paquetes_ibfk_3` FOREIGN KEY (`origen`) REFERENCES `sucursales` (`idSucursal`),
  CONSTRAINT `paquetes_ibfk_4` FOREIGN KEY (`destino`) REFERENCES `sucursales` (`idSucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paquetes`
--

LOCK TABLES `paquetes` WRITE;
/*!40000 ALTER TABLE `paquetes` DISABLE KEYS */;
INSERT INTO `paquetes` VALUES (1,10,100,1,1,1,8,'PepeArgento',434343,'Villa Mojarra','264-15456452','pepe@se.se',1);
/*!40000 ALTER TABLE `paquetes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paquetesxviaje`
--

DROP TABLE IF EXISTS `paquetesxviaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paquetesxviaje` (
  `idViaje` int(11) NOT NULL,
  `idPaquete` int(11) NOT NULL,
  PRIMARY KEY (`idViaje`,`idPaquete`),
  KEY `idPaquete` (`idPaquete`),
  CONSTRAINT `paquetesxviaje_ibfk_1` FOREIGN KEY (`idViaje`) REFERENCES `viajes` (`idViaje`),
  CONSTRAINT `paquetesxviaje_ibfk_2` FOREIGN KEY (`idPaquete`) REFERENCES `paquetes` (`idPaquete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paquetesxviaje`
--

LOCK TABLES `paquetesxviaje` WRITE;
/*!40000 ALTER TABLE `paquetesxviaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `paquetesxviaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincias`
--

DROP TABLE IF EXISTS `provincias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincias` (
  `idProvincia` int(11) NOT NULL AUTO_INCREMENT,
  `idPais` int(11) NOT NULL,
  `nombre` char(20) NOT NULL,
  PRIMARY KEY (`idProvincia`),
  KEY `idPais` (`idPais`),
  CONSTRAINT `provincias_ibfk_1` FOREIGN KEY (`idPais`) REFERENCES `paises` (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincias`
--

LOCK TABLES `provincias` WRITE;
/*!40000 ALTER TABLE `provincias` DISABLE KEYS */;
INSERT INTO `provincias` VALUES (1,1,'corrientes'),(2,1,'Chaco'),(3,1,'Santa Fe');
/*!40000 ALTER TABLE `provincias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rutas`
--

DROP TABLE IF EXISTS `rutas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rutas` (
  `idRuta` int(11) NOT NULL AUTO_INCREMENT,
  `origen` int(11) NOT NULL,
  `destino` int(11) NOT NULL,
  `descripcion` varchar(60) DEFAULT NULL,
  `cantidadSucursales` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRuta`),
  KEY `origen` (`origen`),
  KEY `destino` (`destino`),
  CONSTRAINT `rutas_ibfk_1` FOREIGN KEY (`origen`) REFERENCES `sucursales` (`idSucursal`),
  CONSTRAINT `rutas_ibfk_2` FOREIGN KEY (`destino`) REFERENCES `sucursales` (`idSucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutas`
--

LOCK TABLES `rutas` WRITE;
/*!40000 ALTER TABLE `rutas` DISABLE KEYS */;
INSERT INTO `rutas` VALUES (1,1,2,'qwqwq',NULL);
/*!40000 ALTER TABLE `rutas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicios` (
  `idServicio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `descripcion` varchar(60) DEFAULT NULL,
  `costokg` float DEFAULT NULL,
  `costoseguro` float DEFAULT NULL,
  `montoasegurado` float DEFAULT NULL,
  PRIMARY KEY (`idServicio`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES (1,'sevicio basico','este servicio consta de una atencion alalal',5,67,6789),(2,'sevicio hot','este servicio consta de una atencion de la puta madre',100,90,6.7891e15),(3,'premium','recibis el paquete al otro dia',200,50,10000),(4,' megapremium','recibis el paquete a las 2 horas',600,400,100000),(5,'Rapido','super rapido',300,50,25);
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursales`
--

DROP TABLE IF EXISTS `sucursales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursales` (
  `idSucursal` int(11) NOT NULL AUTO_INCREMENT,
  `idLocalidad` int(11) NOT NULL,
  `direccion` varchar(30) DEFAULT NULL,
  `horario` varchar(30) DEFAULT NULL,
  `descripcion` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idSucursal`),
  KEY `idLocalidad` (`idLocalidad`),
  CONSTRAINT `sucursales_ibfk_1` FOREIGN KEY (`idLocalidad`) REFERENCES `localidades` (`idLocalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursales`
--

LOCK TABLES `sucursales` WRITE;
/*!40000 ALTER TABLE `sucursales` DISABLE KEYS */;
INSERT INTO `sucursales` VALUES (1,1,'Carlos Pellegrini','8 hs a 20hs','Primera Sucursal'),(2,2,'San Martin 32256','comercial',''),(5,5,'Sarmiento 23','comercial',''),(6,1,'2 de abril 23','comercial',''),(8,4,'Alberdi 23','comercial','');
/*!40000 ALTER TABLE `sucursales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursalesxruta`
--

DROP TABLE IF EXISTS `sucursalesxruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursalesxruta` (
  `idSucursalesxRuta` int(11) NOT NULL AUTO_INCREMENT,
  `idRuta` int(11) NOT NULL,
  `origen` int(11) NOT NULL,
  `destino` int(11) NOT NULL,
  `secuencia` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSucursalesxRuta`),
  KEY `origen` (`origen`),
  KEY `destino` (`destino`),
  KEY `idRuta` (`idRuta`),
  CONSTRAINT `sucursalesxruta_ibfk_1` FOREIGN KEY (`origen`) REFERENCES `sucursales` (`idSucursal`),
  CONSTRAINT `sucursalesxruta_ibfk_2` FOREIGN KEY (`destino`) REFERENCES `sucursales` (`idSucursal`),
  CONSTRAINT `sucursalesxruta_ibfk_3` FOREIGN KEY (`idRuta`) REFERENCES `rutas` (`idRuta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursalesxruta`
--

LOCK TABLES `sucursalesxruta` WRITE;
/*!40000 ALTER TABLE `sucursalesxruta` DISABLE KEYS */;
/*!40000 ALTER TABLE `sucursalesxruta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` char(20) DEFAULT NULL,
  `pass` char(20) NOT NULL,
  `idEmpleado` int(11) DEFAULT NULL,
  `idGerente` int(11) DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `usuario` (`usuario`),
  KEY `idEmpleado` (`idEmpleado`),
  KEY `idGerente` (`idGerente`),
  KEY `idCliente` (`idCliente`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`idEmpleado`) REFERENCES `empleados` (`idEmpleado`),
  CONSTRAINT `usuarios_ibfk_2` FOREIGN KEY (`idGerente`) REFERENCES `gerentes` (`idGerente`),
  CONSTRAINT `usuarios_ibfk_3` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'pepe','1234',NULL,1,NULL),(2,'sahlawi','123',NULL,NULL,1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viajes`
--

DROP TABLE IF EXISTS `viajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viajes` (
  `idViaje` int(11) NOT NULL AUTO_INCREMENT,
  `origen` int(11) NOT NULL,
  `destino` int(11) NOT NULL,
  `idCamion` int(11) NOT NULL,
  `fechaSalida` date DEFAULT NULL,
  `fechaLlegada` date DEFAULT NULL,
  `horaSalida` char(5) DEFAULT NULL,
  `horaLlegada` char(5) DEFAULT NULL,
  PRIMARY KEY (`idViaje`),
  KEY `origen` (`origen`),
  KEY `destino` (`destino`),
  KEY `idCamion` (`idCamion`),
  CONSTRAINT `viajes_ibfk_1` FOREIGN KEY (`origen`) REFERENCES `sucursales` (`idSucursal`),
  CONSTRAINT `viajes_ibfk_2` FOREIGN KEY (`destino`) REFERENCES `sucursales` (`idSucursal`),
  CONSTRAINT `viajes_ibfk_3` FOREIGN KEY (`idCamion`) REFERENCES `camiones` (`idCamion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viajes`
--

LOCK TABLES `viajes` WRITE;
/*!40000 ALTER TABLE `viajes` DISABLE KEYS */;
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

-- Dump completed on 2015-07-09 21:44:27
