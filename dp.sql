/*
SQLyog Community Edition- MySQL GUI v7.02 
MySQL - 5.1.59-community : Database - pollution
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`pollution` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `pollution`;

/*Table structure for table `imm` */

DROP TABLE IF EXISTS `imm`;

CREATE TABLE `imm` (
  `sno` int(30) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) DEFAULT NULL,
  `fileName` varchar(30) DEFAULT NULL,
  `filePath` varchar(30) DEFAULT NULL,
  `fileContent` longblob,
  `key1` varchar(30) DEFAULT NULL,
  `checksum1` varchar(30) DEFAULT NULL,
  `checksum` varchar(30) DEFAULT NULL,
  `key2` varchar(30) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=latin1;

/*Data for the table `imm` */

LOCK TABLES `imm` WRITE;

insert  into `imm`(`sno`,`userName`,`fileName`,`filePath`,`fileContent`,`key1`,`checksum1`,`checksum`,`key2`,`status`) values (76,'suresh','suresh.txt','D:/image/suresh.txt','hallo how are you','67788407','53281','25484','94895199','download'),(84,'suresh','fakesuresh.txt','D:/image/fakesuresh.txt','suresh.txtsureshD:/image/suresh.txt','18068097','2384','2384','30885489','accept'),(85,'suresh','suresh.txt','D:/image/suresh.txt','hallo how are you','9515375','53281','53281','84138076','download'),(86,'suresh','suresh.txt','D:/image/suresh.txt','hallo how are you','34131255','53281','53281','88700182','download');

UNLOCK TABLES;

/*Table structure for table `reg` */

DROP TABLE IF EXISTS `reg`;

CREATE TABLE `reg` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(300) DEFAULT NULL,
  `password` varchar(300) DEFAULT NULL,
  `mailid` varchar(300) DEFAULT NULL,
  `gender` varchar(300) DEFAULT NULL,
  `dob` varchar(300) DEFAULT NULL,
  `contact` varchar(300) DEFAULT NULL,
  `status` varchar(300) DEFAULT NULL,
  `logincount` varchar(300) DEFAULT NULL,
  `blockreq` varchar(300) DEFAULT NULL,
  `blockkey` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

/*Data for the table `reg` */

LOCK TABLES `reg` WRITE;

insert  into `reg`(`sno`,`username`,`password`,`mailid`,`gender`,`dob`,`contact`,`status`,`logincount`,`blockreq`,`blockkey`) values (16,'suresh','123','suresh.stigmata07@gmail.com','male','2017-10-08','7708252747','access','0','no','no'),(18,'suresh123','123','suresh.stigmata07@gmail.com','male','2017-12-28','234567890','access','1',NULL,NULL);

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
