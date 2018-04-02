/*
SQLyog v10.2 
MySQL - 5.1.73 : Database - bos
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
  `id` varchar(40) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL COMMENT 'shiro授权标识',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `page` varchar(255) DEFAULT NULL COMMENT '链接',
  `generatemenu` tinyint(1) NOT NULL COMMENT '是否生成菜单',
  `zindex` int(11) DEFAULT NULL COMMENT '排序ID',
  `pid` varchar(32) DEFAULT NULL COMMENT '父ID',
  PRIMARY KEY (`id`),
  KEY `FK33r6np87v1p6gge7t6rpcao5h` (`pid`),
  CONSTRAINT `FK33r6np87v1p6gge7t6rpcao5h` FOREIGN KEY (`pid`) REFERENCES `auth_function` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `auth_function` */

insert  into `auth_function`(`id`,`name`,`code`,`description`,`page`,`generatemenu`,`zindex`,`pid`) values ('11','基础档案','jichudangan',NULL,NULL,1,0,NULL),('112','收派标准','standard',NULL,'page_base_standard.action',1,1,'11'),('113','取派员设置','staff',NULL,'page_base_staff.action',1,2,'11'),('114','区域设置','region',NULL,'page_base_region.action',1,3,'11'),('115','管理分区','subarea',NULL,'page_base_subarea.action',1,4,'11'),('116','管理定区/调度排班','decidedzone',NULL,'page_base_decidedzone.action',1,5,'11'),('12','受理','shouli',NULL,NULL,1,1,NULL),('121','业务受理','noticebill',NULL,'page_qupai_noticebill_add.action',1,0,'12'),('122','工作单快速录入','quickworkordermanage',NULL,'page_qupai_quickworkorder.action',1,1,'12'),('124','工作单导入','workordermanageimport',NULL,'page_qupai_workorderimport.action',1,3,'12'),('13','调度','diaodu',NULL,NULL,1,2,NULL),('131','查台转单','changestaff',NULL,NULL,1,0,'13'),('132','人工调度','personalassign',NULL,'page_qupai_diaodu.action',1,1,'13');

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

/*Table structure for table `base_order` */

DROP TABLE IF EXISTS `base_order`;

CREATE TABLE `base_order` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(5) NOT NULL COMMENT '姓名',
  `telephone` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `address` varchar(100) NOT NULL COMMENT '地址',
  `goods_desc` varchar(20) DEFAULT NULL COMMENT '商品描述',
  `order_num` varchar(40) DEFAULT '0' COMMENT '订单编号',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(1) DEFAULT NULL COMMENT '0表示未删除，1表示删除',
  `export_courier` tinyint(1) DEFAULT NULL COMMENT '0表示未导出，1表示导出',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

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

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `salary` double DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `station` varchar(40) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`salary`,`birthday`,`gender`,`station`,`telephone`,`remark`) values ('967370822e8b11e89a68000c297d8d87','admin','123456',NULL,NULL,NULL,NULL,NULL,NULL);

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

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
