-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: restaurant
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `order_foods`
--

DROP TABLE IF EXISTS `order_foods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_foods` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `detail` json NOT NULL,
  `price_total` double NOT NULL,
  `price_include_vat` double NOT NULL,
  `orderDate` timestamp NOT NULL,
  `user` varchar(100) NOT NULL,
  PRIMARY KEY (`orderID`),
  UNIQUE KEY `orderID_UNIQUE` (`orderID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_foods`
--

LOCK TABLES `order_foods` WRITE;
/*!40000 ALTER TABLE `order_foods` DISABLE KEYS */;
INSERT INTO `order_foods` VALUES (1,'[{\"name\": \"GreenTea Lava\", \"price\": 89.0, \"detail\": \"หวานน้อย\", \"quantity\": 1, \"price_each\": 89.0}, {\"name\": \"Honey Toast\", \"price\": 189.0, \"quantity\": 1, \"price_each\": 189.0}]',278,297,'2018-11-27 16:22:58','admin'),(2,'[{\"name\": \"GreenTea Lava\", \"price\": 89.0, \"quantity\": 1, \"price_each\": 89.0}, {\"name\": \"Cookies\", \"price\": 55.0, \"quantity\": 1, \"price_each\": 55.0}, {\"name\": \"Water\", \"price\": 10.0, \"quantity\": 1, \"price_each\": 10.0}]',154,165,'2018-11-27 16:23:37','admin'),(3,'[{\"name\": \"Chocolat Mousse Cake\", \"price\": 169.0, \"quantity\": 1, \"price_each\": 169.0}, {\"name\": \"Mash Potato Cheese\", \"price\": 89.0, \"quantity\": 1, \"price_each\": 89.0}, {\"name\": \"Milk\", \"price\": 55.0, \"quantity\": 1, \"price_each\": 55.0}]',313,335,'2018-11-27 16:24:26','mo'),(4,'[{\"name\": \"Super Sunday\", \"price\": 79.0, \"detail\": \"ขออร่อยๆนะคะ เร็วๆด้วย หิวแดกควายได้ทั้งตัวเแล้วค่ะ\", \"quantity\": 1, \"price_each\": 79.0}, {\"name\": \"Nuty Waffle\", \"price\": 149.0, \"quantity\": 1, \"price_each\": 149.0}]',228,244,'2018-11-27 16:28:27','admin'),(5,'[{\"name\": \"Juice\", \"price\": 49.0, \"quantity\": 1, \"price_each\": 49.0}, {\"name\": \"Frenchfries Cheese\", \"price\": 79.0, \"detail\": \"ขอชีสเยอะๆ\", \"quantity\": 1, \"price_each\": 79.0}, {\"name\": \"Super Sunday\", \"price\": 79.0, \"quantity\": 1, \"price_each\": 79.0}]',207,221,'2018-11-28 06:00:51','admin'),(6,'[{\"name\": \"Mix Berry Pancake\", \"price\": 159.0, \"quantity\": 1, \"price_each\": 159.0}, {\"name\": \"Super Sunday\", \"price\": 158.0, \"quantity\": 2, \"price_each\": 79.0}, {\"name\": \"Cookies\", \"price\": 55.0, \"quantity\": 1, \"price_each\": 55.0}, {\"name\": \"Milk\", \"price\": 55.0, \"quantity\": 1, \"price_each\": 55.0}]',427,457,'2018-11-29 02:55:42','admin'),(7,'[{\"name\": \"Chocolat Mousse Cake\", \"price\": 169.0, \"quantity\": 1, \"price_each\": 169.0}, {\"name\": \"Super Sunday\", \"price\": 79.0, \"quantity\": 1, \"price_each\": 79.0}]',248,265,'2018-12-01 06:38:52','mo'),(8,'[{\"name\": \"Hot Chocolate\", \"price\": 297.0, \"quantity\": 3, \"price_each\": 99.0}, {\"name\": \"Banana\", \"price\": 9.0, \"quantity\": 1, \"price_each\": 9.0}, {\"name\": \"Chocolat Lava\", \"price\": 89.0, \"quantity\": 1, \"price_each\": 89.0}]',395,423,'2018-12-01 18:11:11','mo'),(9,'[{\"name\": \"Honey Toast\", \"price\": 567.0, \"quantity\": 3, \"price_each\": 189.0}, {\"name\": \"Banana\", \"price\": 9.0, \"quantity\": 1, \"price_each\": 9.0}, {\"name\": \"Juice\", \"price\": 49.0, \"quantity\": 1, \"price_each\": 49.0}]',625,669,'2018-12-06 14:24:50','admin'),(10,'[{\"name\": \"Chocolat Lava\", \"price\": 89.0, \"quantity\": 1, \"price_each\": 89.0}]',89,95,'2018-12-08 08:28:45','mo');
/*!40000 ALTER TABLE `order_foods` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-12 15:48:04
