-- Create database

CREATE DATABASE  IF NOT EXISTS `code_tracker`;
USE `code_tracker`;

-- Table structure for table `code`

DROP TABLE IF EXISTS `code`;

CREATE TABLE `code` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `file_name` varchar(100) DEFAULT NULL,
  `file_data` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;