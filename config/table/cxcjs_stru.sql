-- MySQL dump 10.13  Distrib 5.1.37, for Win32 (ia32)
--
-- Host: localhost    Database: cxcjs
-- ------------------------------------------------------
-- Server version	5.1.37-community

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
-- Table structure for table `cxcjs_area`
--

DROP TABLE IF EXISTS `cxcjs_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_area` (
  `areaId` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `parentId` varchar(50) DEFAULT NULL,
  `cityType` varchar(50) DEFAULT NULL,
  `areaType` varchar(50) DEFAULT NULL,
  `jscType` varchar(50) DEFAULT NULL,
  `status` int(32) DEFAULT NULL,
  `systemId` bigint(64) DEFAULT NULL,
  `subjectCodeId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`areaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_areamien`
--

DROP TABLE IF EXISTS `cxcjs_areamien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_areamien` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `enterpriseName` varchar(50) DEFAULT NULL,
  `enterpriseType` varchar(50) DEFAULT NULL,
  `product` varchar(2000) DEFAULT NULL,
  `productPic` varchar(1000) DEFAULT NULL,
  `text` text,
  `linkMan` varchar(50) DEFAULT NULL,
  `linkTel` varchar(50) DEFAULT NULL,
  `linkAddress` varchar(50) DEFAULT NULL,
  `areaId` varchar(50) DEFAULT NULL,
  `HZSBM` varchar(50) DEFAULT NULL,
  `picStatus` int(32) DEFAULT NULL,
  `status` int(32) DEFAULT NULL,
  `systemId` bigint(64) DEFAULT NULL,
  `subjectCodeId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3610 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_buttinfo`
--

DROP TABLE IF EXISTS `cxcjs_buttinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_buttinfo` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `receiverName` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `text` text,
  `startDate` varchar(50) DEFAULT NULL,
  `endDate` varchar(50) DEFAULT NULL,
  `hzsName` varchar(50) DEFAULT NULL,
  `userId` int(32) DEFAULT NULL,
  `msgStatus` varchar(50) DEFAULT NULL,
  `createDate` varchar(50) DEFAULT NULL,
  `status` int(32) DEFAULT NULL,
  `systemId` bigint(64) DEFAULT NULL,
  `subjectCodeId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_buttjoininfo`
--

DROP TABLE IF EXISTS `cxcjs_buttjoininfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_buttjoininfo` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `hzsbm` varchar(50) DEFAULT NULL,
  `hzsmc` varchar(50) DEFAULT NULL,
  `cpid` varchar(50) DEFAULT NULL,
  `cpname` varchar(50) DEFAULT NULL,
  `planSize` varchar(50) DEFAULT NULL,
  `price` decimal(15,10) DEFAULT NULL,
  `fzr` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `idea` varchar(50) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `buttId` int(32) DEFAULT NULL,
  `status` int(32) DEFAULT NULL,
  `systemId` bigint(64) DEFAULT NULL,
  `subjectCodeId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_butttradeinfo`
--

DROP TABLE IF EXISTS `cxcjs_butttradeinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_butttradeinfo` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `hzsName` varchar(50) DEFAULT NULL,
  `areaId` varchar(50) DEFAULT NULL,
  `productName` varchar(50) DEFAULT NULL,
  `size` decimal(15,10) DEFAULT NULL,
  `money` decimal(15,10) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `buttId` bigint(64) DEFAULT NULL,
  `HZSBM` varchar(50) DEFAULT NULL,
  `status` int(32) DEFAULT NULL,
  `systemId` bigint(64) DEFAULT NULL,
  `subjectCodeId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_govmsg`
--

DROP TABLE IF EXISTS `cxcjs_govmsg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_govmsg` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `content` text,
  `createDate` varchar(50) DEFAULT NULL,
  `authorId` int(32) DEFAULT NULL,
  `outboxStatus` varchar(50) DEFAULT NULL,
  `status` int(32) DEFAULT NULL,
  `systemId` bigint(64) DEFAULT NULL,
  `subjectCodeId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_hzs`
--

DROP TABLE IF EXISTS `cxcjs_hzs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_hzs` (
  `hzsbm` varchar(50) NOT NULL,
  `hzsmc` varchar(50) DEFAULT NULL,
  `frdb` varchar(50) DEFAULT NULL,
  `ssdq` varchar(50) DEFAULT NULL,
  `dqdm` varchar(50) DEFAULT NULL,
  `syrs` varchar(50) DEFAULT NULL,
  `tdzmj` varchar(50) DEFAULT NULL,
  `hzslx` varchar(50) DEFAULT NULL,
  `createDate` varchar(50) DEFAULT NULL,
  `link_tel` varchar(50) DEFAULT NULL,
  `link_man` varchar(50) DEFAULT NULL,
  `link_address` varchar(50) DEFAULT NULL,
  `status` int(32) DEFAULT NULL,
  `systemId` bigint(64) DEFAULT NULL,
  `subjectCodeId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`hzsbm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_menuinfo`
--

DROP TABLE IF EXISTS `cxcjs_menuinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_menuinfo` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `uri` varchar(50) DEFAULT NULL,
  `visible` varchar(50) DEFAULT NULL,
  `sysId` varchar(50) DEFAULT NULL,
  `parentId` int(32) DEFAULT NULL,
  `sortId` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_msghazard`
--

DROP TABLE IF EXISTS `cxcjs_msghazard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_msghazard` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `createDate` varchar(50) DEFAULT NULL,
  `msgType` varchar(50) DEFAULT NULL,
  `msgDeep` varchar(50) DEFAULT NULL,
  `msgImpact` varchar(50) DEFAULT NULL,
  `msgProduct` varchar(50) DEFAULT NULL,
  `msgArea` varchar(50) DEFAULT NULL,
  `msgImpactArea` varchar(50) DEFAULT NULL,
  `msgTitle` varchar(50) DEFAULT NULL,
  `content` text,
  `uid` int(32) DEFAULT NULL,
  `status` int(32) DEFAULT NULL,
  `systemId` bigint(64) DEFAULT NULL,
  `subjectCodeId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_msgusers`
--

DROP TABLE IF EXISTS `cxcjs_msgusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_msgusers` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `msgId` int(32) DEFAULT NULL,
  `uId` int(32) DEFAULT NULL,
  `status` int(32) DEFAULT NULL,
  `systemId` bigint(64) DEFAULT NULL,
  `subjectCodeId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_plantplan`
--

DROP TABLE IF EXISTS `cxcjs_plantplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_plantplan` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `hzsbm` varchar(50) DEFAULT NULL,
  `dkbm` varchar(50) DEFAULT NULL,
  `zwmc` varchar(50) DEFAULT NULL,
  `zzmj` varchar(50) DEFAULT NULL,
  `bzsj` varchar(50) DEFAULT NULL,
  `shsj` varchar(50) DEFAULT NULL,
  `yjcl` varchar(50) DEFAULT NULL,
  `zlms` varchar(50) DEFAULT NULL,
  `ccsj` varchar(50) DEFAULT NULL,
  `cctj` varchar(50) DEFAULT NULL,
  `tj` varchar(50) DEFAULT NULL,
  `sfdd` varchar(50) DEFAULT NULL,
  `dd` varchar(50) DEFAULT NULL,
  `plantDate` varchar(50) DEFAULT NULL,
  `areaId` varchar(50) DEFAULT NULL,
  `status` int(32) DEFAULT NULL,
  `systemId` bigint(64) DEFAULT NULL,
  `subjectCodeId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_productclass`
--

DROP TABLE IF EXISTS `cxcjs_productclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_productclass` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `pClass01` varchar(50) DEFAULT NULL,
  `pClass02` varchar(50) DEFAULT NULL,
  `pClass03` varchar(50) DEFAULT NULL,
  `pClass04` varchar(50) DEFAULT NULL,
  `status1` varchar(50) DEFAULT NULL,
  `pClassId` varchar(50) DEFAULT NULL,
  `status` int(32) DEFAULT NULL,
  `systemId` bigint(64) DEFAULT NULL,
  `subjectCodeId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=887 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_role`
--

DROP TABLE IF EXISTS `cxcjs_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_role` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `menus` varchar(50) DEFAULT NULL,
  `text` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_rolemenus`
--

DROP TABLE IF EXISTS `cxcjs_rolemenus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_rolemenus` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `roleId` int(32) DEFAULT NULL,
  `menuId` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_roleuser`
--

DROP TABLE IF EXISTS `cxcjs_roleuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_roleuser` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `roleId` int(32) DEFAULT NULL,
  `userId` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_sninfo`
--

DROP TABLE IF EXISTS `cxcjs_sninfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_sninfo` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `createDate` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `content` text,
  `uid` int(32) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `status` int(32) DEFAULT NULL,
  `systemId` bigint(64) DEFAULT NULL,
  `subjectCodeId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_synchlogs`
--

DROP TABLE IF EXISTS `cxcjs_synchlogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_synchlogs` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `businessName` varchar(50) DEFAULT NULL,
  `startTime` varchar(50) DEFAULT NULL,
  `endTime` varchar(50) DEFAULT NULL,
  `resultInfo` varchar(2000) DEFAULT NULL,
  `usedTime` bigint(64) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `uid` int(32) DEFAULT NULL,
  `count` int(32) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `createTime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=336 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_topnews`
--

DROP TABLE IF EXISTS `cxcjs_topnews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_topnews` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `content` text,
  `createTime` varchar(50) DEFAULT NULL,
  `editor` varchar(50) DEFAULT NULL,
  `origin` varchar(50) DEFAULT NULL,
  `readCount` int(32) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `status` int(32) DEFAULT NULL,
  `systemId` bigint(64) DEFAULT NULL,
  `subjectCodeId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_user`
--

DROP TABLE IF EXISTS `cxcjs_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `userId` varchar(50) DEFAULT NULL,
  `passWord` varchar(50) DEFAULT NULL,
  `SYMC` varchar(50) DEFAULT NULL,
  `roleId` int(32) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `pic` varchar(500) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `ms` varchar(50) DEFAULT NULL,
  `HZSBM` varchar(50) DEFAULT NULL,
  `isDel` int(32) DEFAULT NULL,
  `createDate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cxcjs_userinfo`
--

DROP TABLE IF EXISTS `cxcjs_userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cxcjs_userinfo` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `subjectCode` varchar(50) DEFAULT NULL,
  `userDetail` varchar(50) DEFAULT NULL,
  `field1` varchar(50) DEFAULT NULL,
  `field2` varchar(50) DEFAULT NULL,
  `field3` varchar(50) DEFAULT NULL,
  `status` int(32) DEFAULT NULL,
  `systemId` bigint(64) DEFAULT NULL,
  `subjectCodeId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-10-26 16:20:50
