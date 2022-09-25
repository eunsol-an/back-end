CREATE DATABASE `jspdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE USER 'jspuser'@'%' IDENTIFIED BY 'mysql';

GRANT Alter ON jspdb.* TO 'jspuser'@'%';
GRANT Create ON jspdb.* TO 'jspuser'@'%';
GRANT Create view ON jspdb.* TO 'jspuser'@'%';
GRANT Delete ON jspdb.* TO 'jspuser'@'%';
GRANT Drop ON jspdb.* TO 'jspuser'@'%';
GRANT Grant option ON jspdb.* TO 'jspuser'@'%';
GRANT Index ON jspdb.* TO 'jspuser'@'%';
GRANT Insert ON jspdb.* TO 'jspuser'@'%';
GRANT References ON jspdb.* TO 'jspuser'@'%';
GRANT Select ON jspdb.* TO 'jspuser'@'%';
GRANT Show view ON jspdb.* TO 'jspuser'@'%';
GRANT Trigger ON jspdb.* TO 'jspuser'@'%';
GRANT Update ON jspdb.* TO 'jspuser'@'%';
GRANT Alter routine ON jspdb.* TO 'jspuser'@'%';
GRANT Create routine ON jspdb.* TO 'jspuser'@'%';
GRANT Create temporary tables ON jspdb.* TO 'jspuser'@'%';
GRANT Execute ON jspdb.* TO 'jspuser'@'%';
GRANT Lock tables ON jspdb.* TO 'jspuser'@'%';
GRANT Grant option ON jspdb.* TO 'jspuser'@'%';

CREATE TABLE `emp` (
  `EMPNO` int NOT NULL,
  `PWD` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ENAME` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `JOB` varchar(9) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `MGR` int DEFAULT NULL,
  `HIREDATE` date DEFAULT NULL,
  `SAL` double DEFAULT NULL,
  `COMM` double DEFAULT NULL,
  `DEPTNO` int DEFAULT NULL,
  PRIMARY KEY (`EMPNO`),
  KEY `idx_sal` (`SAL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

create table product (
pno int primary key auto_increment,
pname varchar(100) not null,
price double not null,
regdate datetime default now(),
madeby varchar(100) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;