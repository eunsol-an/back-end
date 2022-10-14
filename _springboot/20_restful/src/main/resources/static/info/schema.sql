CREATE DATABASE `bootdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE USER 'bootuser'@'%' IDENTIFIED BY 'mysql';
GRANT Alter ON bootdb.* TO 'bootuser'@'%';
GRANT Create ON bootdb.* TO 'bootuser'@'%';
GRANT Create view ON bootdb.* TO 'bootuser'@'%';
GRANT Delete ON bootdb.* TO 'bootuser'@'%';
GRANT Drop ON bootdb.* TO 'bootuser'@'%';
GRANT Grant option ON bootdb.* TO 'bootuser'@'%';
GRANT Index ON bootdb.* TO 'bootuser'@'%';
GRANT Insert ON bootdb.* TO 'bootuser'@'%';
GRANT References ON bootdb.* TO 'bootuser'@'%';
GRANT Select ON bootdb.* TO 'bootuser'@'%';
GRANT Show view ON bootdb.* TO 'bootuser'@'%';
GRANT Trigger ON bootdb.* TO 'bootuser'@'%';
GRANT Update ON bootdb.* TO 'bootuser'@'%';
GRANT Alter routine ON bootdb.* TO 'bootuser'@'%';
GRANT Create routine ON bootdb.* TO 'bootuser'@'%';
GRANT Create temporary tables ON bootdb.* TO 'bootuser'@'%';
GRANT Execute ON bootdb.* TO 'bootuser'@'%';
GRANT Lock tables ON bootdb.* TO 'bootuser'@'%';
GRANT Grant option ON bootdb.* TO 'bootuser'@'%';

-- bootdb.board definition

CREATE TABLE `board` (
  `bno` int NOT NULL AUTO_INCREMENT,
  `title` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `content` text COLLATE utf8mb4_general_ci NOT NULL,
  `readcount` int NOT NULL DEFAULT '0',
  `regdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `regid` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `moddate` datetime DEFAULT NULL,
  `modid` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `isremoved` char(1) COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'N',
  PRIMARY KEY (`bno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;