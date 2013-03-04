-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 04, 2013 at 05:11 PM
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
-- Table structure for table `categorydef`
--

CREATE TABLE IF NOT EXISTS `categorydef` (
  `categorydef_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`categorydef_id`),
  KEY `FKBF11EE0779EC7426` (`category_id`),
  KEY `FKBF11EE0774FD9DE6` (`language_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `categorydef`
--

INSERT INTO `categorydef` (`categorydef_id`, `name`, `category_id`, `language_id`) VALUES
(1, 'cat 3 lan en', 3, 1),
(2, 'cat 3 lan ua', 3, 2),
(3, 'cat 6', 6, 1),
(4, 'cat 7', 7, 1),
(5, 'cat 12', 12, 1),
(6, 'cat 11', 11, 1),
(7, 'cat 13', 13, 1),
(8, 'cat 14', 14, 1),
(9, 'cat 8 ua', 8, 2),
(10, 'cat 9 ua', 9, 2),
(11, 'cat 4 ua', 4, 2),
(12, 'cat 5 ua', 5, 2),
(13, 'cat 4 en', 4, 1),
(14, 'cat 5 en', 5, 1),
(15, 'cat 10 en', 10, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `categorydef`
--
ALTER TABLE `categorydef`
  ADD CONSTRAINT `FKBF11EE0774FD9DE6` FOREIGN KEY (`language_id`) REFERENCES `language` (`language_id`),
  ADD CONSTRAINT `FKBF11EE0779EC7426` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
