-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 05, 2020 at 04:24 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bukukas`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_balance`
--

CREATE TABLE `tb_m_balance` (
  `BalanceId` int(20) NOT NULL,
  `Balance` int(30) NOT NULL,
  `UserId` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_transaction`
--

CREATE TABLE `tb_m_transaction` (
  `TransId` int(20) NOT NULL,
  `TransType` varchar(30) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `TotalTrans` int(30) NOT NULL,
  `Time` timestamp NOT NULL DEFAULT current_timestamp(),
  `UserId` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_user`
--

CREATE TABLE `tb_m_user` (
  `UserId` int(20) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Telephone` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_m_balance`
--
ALTER TABLE `tb_m_balance`
  ADD PRIMARY KEY (`BalanceId`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `tb_m_transaction`
--
ALTER TABLE `tb_m_transaction`
  ADD PRIMARY KEY (`TransId`),
  ADD KEY `UserId` (`UserId`);

--
-- Indexes for table `tb_m_user`
--
ALTER TABLE `tb_m_user`
  ADD PRIMARY KEY (`UserId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_m_balance`
--
ALTER TABLE `tb_m_balance`
  MODIFY `BalanceId` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tb_m_transaction`
--
ALTER TABLE `tb_m_transaction`
  MODIFY `TransId` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tb_m_user`
--
ALTER TABLE `tb_m_user`
  MODIFY `UserId` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_m_balance`
--
ALTER TABLE `tb_m_balance`
  ADD CONSTRAINT `tb_m_balance_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `tb_m_user` (`UserId`);

--
-- Constraints for table `tb_m_transaction`
--
ALTER TABLE `tb_m_transaction`
  ADD CONSTRAINT `tb_m_transaction_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `tb_m_user` (`UserId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
