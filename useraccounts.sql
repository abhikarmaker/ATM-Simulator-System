-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 18, 2018 at 12:07 AM
-- Server version: 5.6.34-log
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `atmsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `useraccounts`
--

CREATE TABLE `useraccounts` (
  `user_id` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `middle_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `father_name` varchar(255) NOT NULL,
  `dateofBirth` date NOT NULL,
  `gender` varchar(255) NOT NULL,
  `email_address` varchar(255) NOT NULL,
  `marital_status` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `pin_code` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `religion` varchar(255) NOT NULL,
  `income` varchar(255) NOT NULL,
  `education_qualification` varchar(255) NOT NULL,
  `occupation` varchar(255) NOT NULL,
  `sin_number` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `existing_account` varchar(255) NOT NULL,
  `account_type` varchar(255) NOT NULL,
  `randomNumber` varchar(255) NOT NULL,
  `pinNumber` varchar(255) NOT NULL,
  `account_number` varchar(255) NOT NULL,
  `service_request` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `useraccounts`
--

INSERT INTO `useraccounts` (`user_id`, `first_name`, `middle_name`, `last_name`, `father_name`, `dateofBirth`, `gender`, `email_address`, `marital_status`, `address`, `city`, `pin_code`, `state`, `religion`, `income`, `education_qualification`, `occupation`, `sin_number`, `status`, `existing_account`, `account_type`, `randomNumber`, `pinNumber`, `account_number`, `service_request`) VALUES
(1, 'Abhijeet', '', 'Karmaker', 'Dr Jadab Lal Karmaker', '2018-04-01', 'Male', 'abhijeet.karmaker@yahoo.com', 'Single', '755 Roger Street', 'Sarnia', 'N7S2S8', 'On', 'Hindu', '$20,000', 'Graduation', 'Student', '159159159', 'Non Immigrant', 'No', 'Saving Account', '4174813279487479', '123456', '84248002020038', 'ATM CARD,Internet Banking,Mobile Banking,Email Alerts,E-Statement');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `useraccounts`
--
ALTER TABLE `useraccounts`
  ADD PRIMARY KEY (`account_number`),
  ADD UNIQUE KEY `sin_number` (`sin_number`),
  ADD UNIQUE KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `useraccounts`
--
ALTER TABLE `useraccounts`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
