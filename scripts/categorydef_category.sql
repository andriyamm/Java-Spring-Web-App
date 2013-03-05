-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 05, 2013 at 01:42 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ams`
--

-- --------------------------------------------------------

--
-- Table structure for table `categorydef_category`
--

CREATE TABLE IF NOT EXISTS `categorydef_category` (
  `category_id` bigint(20) DEFAULT NULL,
  `categorydef_id` bigint(20) NOT NULL,
  PRIMARY KEY (`categorydef_id`),
  KEY `FK8C134FF679EC7426` (`category_id`),
  KEY `FK8C134FF66BB3958E` (`categorydef_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categorydef_category`
--

INSERT INTO `categorydef_category` (`category_id`, `categorydef_id`) VALUES
(3, 1),
(3, 2),
(4, 11),
(4, 13),
(5, 12),
(5, 14),
(6, 3),
(7, 4),
(8, 9),
(9, 10),
(10, 15),
(11, 6),
(12, 5),
(13, 7),
(14, 8);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `categorydef_category`
--
ALTER TABLE `categorydef_category`
  ADD CONSTRAINT `FK8C134FF66BB3958E` FOREIGN KEY (`categorydef_id`) REFERENCES `categorydef` (`categorydef_id`),
  ADD CONSTRAINT `FK8C134FF679EC7426` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
