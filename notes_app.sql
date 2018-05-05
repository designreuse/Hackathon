-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2018 at 09:32 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 5.6.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `notes_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `amazon`
--

CREATE TABLE `amazon` (
  `ID` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `Updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Competition';

--
-- Dumping data for table `amazon`
--

INSERT INTO `amazon` (`ID`, `Price`, `Updated`) VALUES
(1, 12, '2018-05-05 10:55:21'),
(2, 12, '2018-05-01 06:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `competion`
--

CREATE TABLE `competion` (
  `id` bigint(20) NOT NULL,
  `competion` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `updated` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `competion`
--

INSERT INTO `competion` (`id`, `competion`, `price`, `updated`) VALUES
(1, NULL, 12, '2018-05-05 10:55:21'),
(2, NULL, 12, '2018-05-01 06:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `notes`
--

CREATE TABLE `notes` (
  `id` bigint(20) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notes`
--

INSERT INTO `notes` (`id`, `content`, `created_at`, `title`, `updated_at`) VALUES
(1, '1', '2018-05-04 00:00:00', '1', '2018-05-01 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `price_enitity`
--

CREATE TABLE `price_enitity` (
  `id` bigint(20) NOT NULL,
  `price` double DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `competion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `amazon`
--
ALTER TABLE `amazon`
  ADD UNIQUE KEY `ID` (`ID`);

--
-- Indexes for table `competion`
--
ALTER TABLE `competion`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notes`
--
ALTER TABLE `notes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `price_enitity`
--
ALTER TABLE `price_enitity`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `competion`
--
ALTER TABLE `competion`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `notes`
--
ALTER TABLE `notes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `price_enitity`
--
ALTER TABLE `price_enitity`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
