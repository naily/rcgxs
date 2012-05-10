DROP DATABASE IF EXISTS `cxcjs`;

CREATE DATABASE cxcjs DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci; 

USE cxcjs ;
URL=jdbc:mysql://yourIP/college?user=root&password=yourPassword&useUnicode=true&characterEncoding=utf8

DROP TABLE IF EXISTS `cxcjs_user`;
--用户表
CREATE TABLE cxcjs_user (id int NOT NULL AUTO_INCREMENT ,PRIMARY KEY (id),  userId VARCHAR(32),password VARCHAR(255),SYMC VARCHAR(255),roleId VARCHAR(255),tel VARCHAR(32),pic VARCHAR(32),email VARCHAR(255),ms VARCHAR(255),HZSBM VARCHAR(255));
--合作社信息
create table cxcjs_hzs(hzsbm      varchar(50),
						hzsmc      varchar(50),
						frdb       varchar(50),
						ssdq       varchar(50),
						dqdm       varchar(50),
						syrs       varchar(50),
						tdzmj      varchar(50),
						hzslx      varchar(50),
						createDate varchar(50),PRIMARY KEY (hzsbm));
