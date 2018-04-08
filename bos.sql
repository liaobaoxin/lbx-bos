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

/*Table structure for table `auth_function` */

DROP TABLE IF EXISTS `auth_function`;

CREATE TABLE `auth_function` (
  `id` varchar(32) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `code` varchar(32) DEFAULT NULL,
  `description` varchar(32) DEFAULT NULL,
  `page` varchar(32) DEFAULT NULL,
  `generatemenu` tinyint(1) DEFAULT NULL,
  `zindex` int(11) DEFAULT NULL,
  `pid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `auth_function` */

insert  into `auth_function`(`id`,`name`,`code`,`description`,`page`,`generatemenu`,`zindex`,`pid`) values ('266be6972d2411e88f65000c29e8042d','订单管理','quick-list','','/quick/page',1,1,'b5b47bca2d2211e88f65000c29e8042d'),('2c5849862d3a11e88f65000c29e8042d','权限管理','authManage-page','','/authManage/page',1,2,'33cb76a52d2511e88f65000c29e8042d'),('33cb76a52d2511e88f65000c29e8042d','系统管理','','','',1,1,NULL),('5aab5e752d3a11e88f65000c29e8042d','角色管理','role-manage','','/roleManage/page',1,3,'33cb76a52d2511e88f65000c29e8042d'),('6ad5f5002d3a11e88f65000c29e8042d','用户管理','user-page','','/user/page',1,4,'33cb76a52d2511e88f65000c29e8042d'),('a5e681a32d2411e88f65000c29e8042d','增加一行','quick-add','','',0,NULL,'266be6972d2411e88f65000c29e8042d'),('b5b47bca2d2211e88f65000c29e8042d','基础数据','','','',1,0,NULL),('b8dad7b62d4411e88f65000c29e8042d','查看列表','quick-list','','',0,NULL,'266be6972d2411e88f65000c29e8042d'),('c23bb1e82d2411e88f65000c29e8042d','取消编辑','quick-cancel','','',0,NULL,'266be6972d2411e88f65000c29e8042d'),('d0975bf82d2411e88f65000c29e8042d','删除','quick-remove','','',0,NULL,'266be6972d2411e88f65000c29e8042d'),('df2d2e002d2411e88f65000c29e8042d','保存','quick-save','','',0,NULL,'266be6972d2411e88f65000c29e8042d'),('f8710f322d3911e88f65000c29e8042d','数据源监控','sys-dbMonit','','/druid/',1,1,'33cb76a52d2511e88f65000c29e8042d');

/*Table structure for table `auth_role` */

DROP TABLE IF EXISTS `auth_role`;

CREATE TABLE `auth_role` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `auth_role` */

insert  into `auth_role`(`id`,`name`,`code`,`description`) values ('8d9a77fa2d6411e88f65000c29e8042d','超级管理员','超级管理员','超级管理员'),('f7c612272d6511e88f65000c29e8042d','test','test','test');

/*Table structure for table `base_order` */

DROP TABLE IF EXISTS `base_order`;

CREATE TABLE `base_order` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(4) NOT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `address` varchar(999) DEFAULT NULL,
  `goods_desc` varchar(40) DEFAULT NULL,
  `order_num` varchar(40) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT NULL,
  `export_courier` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `base_order` */

/*Table structure for table `role_function` */

DROP TABLE IF EXISTS `role_function`;

CREATE TABLE `role_function` (
  `function_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`role_id`,`function_id`),
  KEY `FK5f8riddotqjpm9vly0b8c5nmf` (`function_id`),
  CONSTRAINT `FK10qo908yd9evkyb40vf88og85` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`),
  CONSTRAINT `FK5f8riddotqjpm9vly0b8c5nmf` FOREIGN KEY (`function_id`) REFERENCES `auth_function` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_function` */

insert  into `role_function`(`function_id`,`role_id`) values ('266be6972d2411e88f65000c29e8042d','8d9a77fa2d6411e88f65000c29e8042d'),('266be6972d2411e88f65000c29e8042d','f7c612272d6511e88f65000c29e8042d'),('2c5849862d3a11e88f65000c29e8042d','8d9a77fa2d6411e88f65000c29e8042d'),('33cb76a52d2511e88f65000c29e8042d','8d9a77fa2d6411e88f65000c29e8042d'),('5aab5e752d3a11e88f65000c29e8042d','8d9a77fa2d6411e88f65000c29e8042d'),('6ad5f5002d3a11e88f65000c29e8042d','8d9a77fa2d6411e88f65000c29e8042d'),('a5e681a32d2411e88f65000c29e8042d','8d9a77fa2d6411e88f65000c29e8042d'),('a5e681a32d2411e88f65000c29e8042d','f7c612272d6511e88f65000c29e8042d'),('b5b47bca2d2211e88f65000c29e8042d','8d9a77fa2d6411e88f65000c29e8042d'),('b5b47bca2d2211e88f65000c29e8042d','f7c612272d6511e88f65000c29e8042d'),('b8dad7b62d4411e88f65000c29e8042d','8d9a77fa2d6411e88f65000c29e8042d'),('b8dad7b62d4411e88f65000c29e8042d','f7c612272d6511e88f65000c29e8042d'),('c23bb1e82d2411e88f65000c29e8042d','8d9a77fa2d6411e88f65000c29e8042d'),('c23bb1e82d2411e88f65000c29e8042d','f7c612272d6511e88f65000c29e8042d'),('d0975bf82d2411e88f65000c29e8042d','8d9a77fa2d6411e88f65000c29e8042d'),('d0975bf82d2411e88f65000c29e8042d','f7c612272d6511e88f65000c29e8042d'),('df2d2e002d2411e88f65000c29e8042d','8d9a77fa2d6411e88f65000c29e8042d'),('df2d2e002d2411e88f65000c29e8042d','f7c612272d6511e88f65000c29e8042d'),('f8710f322d3911e88f65000c29e8042d','8d9a77fa2d6411e88f65000c29e8042d');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gender` varchar(32) DEFAULT NULL,
  `station` varchar(32) DEFAULT NULL,
  `telephone` varchar(32) DEFAULT NULL,
  `remark` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`salary`,`birthday`,`gender`,`station`,`telephone`,`remark`) values ('012a6ae52d6611e88f65000c29e8042d','test','test',NULL,NULL,'','','222',NULL),('1','admin','123456',NULL,NULL,NULL,NULL,NULL,NULL),('9f22437f2d6411e88f65000c29e8042d','1234','1234',1234,NULL,'','','1234',NULL);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `role_id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKqqlqhas35obkljn18mrh6mmms` (`role_id`),
  CONSTRAINT `FKeqon9sx5vssprq67dxm3s7ump` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKqqlqhas35obkljn18mrh6mmms` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`role_id`,`user_id`) values ('8d9a77fa2d6411e88f65000c29e8042d','9f22437f2d6411e88f65000c29e8042d'),('f7c612272d6511e88f65000c29e8042d','012a6ae52d6611e88f65000c29e8042d');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
