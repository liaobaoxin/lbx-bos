/*
SQLyog v10.2 
MySQL - 5.6.26 : Database - bos
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bos` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bos`;

/*Table structure for table `base_order` */

DROP TABLE IF EXISTS `base_order`;

CREATE TABLE `base_order` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `telephone` varchar(33) DEFAULT NULL,
  `address` varchar(300) DEFAULT NULL,
  `goods_desc` varchar(60) DEFAULT NULL,
  `order_num` varchar(120) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT NULL,
  `export_courier` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
