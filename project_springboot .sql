-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 13, 2021 at 04:11 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project_springboot`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `BRANCHID` int(11) NOT NULL,
  `BRANCHNAME` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`BRANCHID`, `BRANCHNAME`) VALUES
(2, 'สาขาร่มเกล้า (OH)'),
(4, 'สาขาโรจนะ (RJ)');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `ROOMID` int(11) NOT NULL,
  `ROOMNAME` text COLLATE utf8_unicode_ci NOT NULL,
  `BRANCHID` int(11) NOT NULL,
  `CREATEDBY` text COLLATE utf8_unicode_ci NOT NULL,
  `CREATEDDATE` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`ROOMID`, `ROOMNAME`, `BRANCHID`, `CREATEDBY`, `CREATEDDATE`) VALUES
(7, 'ห้องประชุม 1 : อาคารหน้า ชั้น1', 4, 'Admin', '2021-02-12'),
(12, 'Snailwhite 1 : อาคาร1 ชั้น1', 2, 'Admin', '2021-02-12'),
(13, 'Snailwhite 3 : อาคาร 1 ชั้น1', 2, 'Admin', '2021-02-12'),
(14, 'Snailwhite 5 : อาคาร 1 ชั้น1', 2, 'Admin', '2021-02-12'),
(15, 'Snailwhite 6 : อาคาร2 ชั้น1', 2, 'Admin', '2021-02-12'),
(16, 'Snailwhite 7 : อาคาร2 ชั้น1', 2, 'Admin', '2021-02-12'),
(17, 'ห้องประชุม 2 : อาคารหน้า ชั้น1', 4, 'Admin', '2021-02-12'),
(18, 'ห้องประชุม 4 : อาคารหน้า ชั้น2', 4, 'Admin', '2021-02-12'),
(19, 'ห้องประชุม 5 : อาคารหน้า ชั้น2', 4, 'Admin', '2021-02-12');

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `id` int(11) NOT NULL,
  `ROOMID` int(11) DEFAULT NULL,
  `date` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `reservationer` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `time_start` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `time_end` text COLLATE utf8_unicode_ci NOT NULL,
  `Detail` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`id`, `ROOMID`, `date`, `reservationer`, `time_start`, `time_end`, `Detail`, `created_at`) VALUES
(2, 14, '2012-12-12', 'Admin', '10:30', '11:00', 'test', '2021-02-13 18:26:09'),
(7, 12, '2021-02-16', 'Admin', '22:44', '19:48', 'test', '2021-02-13 19:44:26');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `USERID` int(11) NOT NULL,
  `FIRSTNAME` text COLLATE utf8_unicode_ci NOT NULL,
  `LASTNAME` text COLLATE utf8_unicode_ci NOT NULL,
  `USEREMAIL` text COLLATE utf8_unicode_ci NOT NULL,
  `PASSWORD` text COLLATE utf8_unicode_ci NOT NULL,
  `CREATEDDATE` date NOT NULL,
  `STATUS` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`USERID`, `FIRSTNAME`, `LASTNAME`, `USEREMAIL`, `PASSWORD`, `CREATEDDATE`, `STATUS`) VALUES
(3, 'test', 'lasttest', 'test@email.com', '123', '2021-02-13', 'Inactive'),
(4, 'test', 'lasttest', 'test@email.com', '00012344', '2021-02-13', 'Inactive'),
(9, 'tt', 'tttt', 'example@email.com', '1114445', '2021-02-13', 'Inactive'),
(10, 'สมชาย', 'จันทร์โอชา', 'junochar@email.com', 'password', '2021-02-13', 'Inactive');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`BRANCHID`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`ROOMID`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`USERID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `BRANCHID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `ROOMID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `USERID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
