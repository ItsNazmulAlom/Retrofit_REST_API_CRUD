-- phpMyAdmin SQL Dump
-- version 4.9.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 17, 2020 at 09:02 AM
-- Server version: 10.3.25-MariaDB-log-cll-lve
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nkriecou_rectrofit`
--

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `cell` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `name`, `cell`, `password`) VALUES
(1, 'Noor Mohammed Anik ', '01672902634', '1234'),
(2, 'Anik', '01778001401', '1234'),
(3, 'name', '05555555555', '1234'),
(4, 'ggg', '05123456789', '1234'),
(5, 'nazmul alom', '01819800222', '12345'),
(6, 'kausar', '01628511467', '12345678'),
(7, 'kausar', '01726834534', '12345678'),
(8, 'kausar', '01799997900', '1234'),
(9, 'Shahidul ', '01816044862', '12345'),
(10, 'kausar', '01799997914', '1234'),
(11, 'kausar', '01799997915', '1234'),
(12, 'kausar', '01799997990', '1234'),
(13, 'kausar', '01799997960', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` mediumint(8) UNSIGNED NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`) VALUES
(111, 'Kamal', 'kamal@gmail.com'),
(113, 'Noor Mohammed Anik', 'anik@gmail.com'),
(114, 'Naser', 'naser@gmail.com'),
(115, 'Emu Khan', 'emu@gmail.com'),
(116, 'Kamal', 'kamal@gmail.com'),
(117, 'Rakib', 'rakib@gmail.com'),
(118, 'Noor Mohammed Anik', 'anik@gmail.com'),
(119, 'Naser', 'naser@gmail.com'),
(120, 'Emu Khan', 'emu@gmail.com'),
(121, 'Kamal', 'kamal@gmail.com'),
(122, 'Rakib', 'rakib@gmail.com'),
(123, 'Noor Mohammed Anik', 'anik@gmail.com'),
(124, 'Naser', 'naser@gmail.com'),
(125, 'Emu Khan', 'emu@gmail.com'),
(126, 'Kamal', 'kamal@gmail.com'),
(127, 'Rakib', 'rakib@gmail.com'),
(128, 'Noor Mohammed Anik', 'anik@gmail.com'),
(129, 'Naser', 'naser@gmail.com'),
(130, 'Emu Khan', 'emu@gmail.com'),
(131, 'Kamal', 'kamal@gmail.com'),
(132, 'Rakib', 'rakib@gmail.com'),
(133, 'Noor Mohammed Anik', 'anik@gmail.com'),
(134, 'Naser', 'naser@gmail.com'),
(135, 'Emu Khan', 'emu@gmail.com'),
(136, 'Kamal', 'kamal@gmail.com'),
(137, 'Rakib', 'rakib@gmail.com'),
(138, 'Noor Mohammed Anik', 'anik@gmail.com'),
(139, 'Naser', 'naser@gmail.com'),
(140, 'Emu Khan', 'sayeeraemu@gmail.com'),
(141, 'Kamal', 'kamal@gmail.com'),
(142, 'Rakib', 'rakib@gmail.com'),
(143, 'Noor Mohammed Anik', 'anik@gmail.com'),
(144, 'Naser', 'naser@gmail.com'),
(145, 'Emu Khan', 'emu@gmail.com'),
(148, 'saifa', 'saifa@gmail.com'),
(151, 'Md.Nazmul Alom', 'nazmulpciucse@gmail.com'),
(153, 'Md.Nazmul Alom', 'nazmulpciucse@gmail.com'),
(156, 'Md.Nazmul Alom', 'nazmulpciucse@gmail.com'),
(158, 'Md.Nazmul Alom', 'nazmulpciucse@gmail.com'),
(159, 'Md.Nazmul Alom', 'nazmulpciucse@gmail.com'),
(160, 'kausar', '1234'),
(161, 'kausar111', 'kausar@gmail.com'),
(162, 'kausar', '0777');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=163;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
