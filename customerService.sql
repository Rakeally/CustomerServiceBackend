-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 07, 2022 at 01:17 AM
-- Server version: 10.6.5-MariaDB
-- PHP Version: 8.0.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `customerService`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id` bigint(20) NOT NULL,
  `city` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `country` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `postal_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `state` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `street` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`id`, `city`, `country`, `postal_code`, `state`, `street`) VALUES
(11, 'Douala', 'Cameroun', '0000', 'Littoral', 'Akwa'),
(13, 'Douala', 'Cameroun', '0000', 'Littoral', 'Akwa');

-- --------------------------------------------------------

--
-- Table structure for table `app_role`
--

CREATE TABLE `app_role` (
  `id` bigint(20) NOT NULL,
  `role` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `app_role`
--

INSERT INTO `app_role` (`id`, `role`) VALUES
(1, 'Employee'),
(2, 'Customer'),
(3, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `app_user`
--

CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL,
  `tel` bigint(20) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `token` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `app_user`
--

INSERT INTO `app_user` (`id`, `tel`, `active`, `email`, `password`, `token`, `username`, `customer_id`, `employee_id`, `role_id`) VALUES
(2, NULL, b'0', 'kjane@gmail.com', '$2a$10$zR6Gkg54kddr7cRvU.5UHuJBIe7enUTcfCBP23rikSnRUmfjrdWFK', 'f1fc6f8a-8e46-4918-a215-b5da50070741', 'kjane@gmail.com', 1, NULL, 2),
(4, NULL, b'0', 'Rak@gmail.com', '$2a$10$UXyyD3tjzk.Nlycw6BjKwOEroYrTC7eL5p4tSMfzW2Kn1j3TmDF3i', '69eb0475-76d2-4b60-adc4-980c8221b737', 'Rak@gmail.com', 3, NULL, 2),
(6, NULL, b'0', 'efuet@gmail.com', '$2a$10$az/1iMyxr0lWCBLLZyYuYOEq.fTiUwbhIsF/aNDJyW6BkFDi9nLI6', '715a6e7b-dae9-4c05-8434-1ffbfe9385e6', 'efuet@gmail.com', NULL, 5, 1),
(7, 67575688, b'0', 'admin@gmail.com', '$2a$10$OG8Q1bPishyp9uuuLg4BZunJVe0Y4yRY.Dg6qZ6Qo.L7dOcIDf50i', '00dc949f-0eec-455f-96fd-b21d5e77d04e', 'admin@gmail.com', NULL, NULL, 3),
(9, NULL, b'1', 'johnDuk@gmail.com', '$2a$10$02PUsTjMxnIaWhc72Ywd/.o7fxmTdBwmMINvL7EBTRWysjONxjtOy', '459d562a-60ac-4d85-80e5-e7368fcd6919', 'johnDuk@gmail.com', NULL, 8, 1);

-- --------------------------------------------------------

--
-- Table structure for table `claims`
--

CREATE TABLE `claims` (
  `id` bigint(20) NOT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `date_lost_service` datetime DEFAULT NULL,
  `description` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gas_meter_reading` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `unique_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `claim_status_id` bigint(20) DEFAULT NULL,
  `claim_types_id` bigint(20) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `claims`
--

INSERT INTO `claims` (`id`, `amount`, `date`, `date_lost_service`, `description`, `gas_meter_reading`, `unique_id`, `claim_status_id`, `claim_types_id`, `customer_id`, `employee_id`) VALUES
(10, NULL, '2022-06-07 01:01:55', '0012-11-11 00:00:00', 'Beloz is the description for my complain', NULL, '23aaeefe-6460-46d1-8cc6-5ffc7357092b', 1, 1, 3, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `claim_result`
--

CREATE TABLE `claim_result` (
  `id` bigint(20) NOT NULL,
  `claim_decision` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `description` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `claims_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `claim_status`
--

CREATE TABLE `claim_status` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `claim_status`
--

INSERT INTO `claim_status` (`id`, `name`) VALUES
(1, 'NOT ATTENDED'),
(2, 'IN PROCESS'),
(3, 'ATTENDED'),
(4, 'CONFIRM');

-- --------------------------------------------------------

--
-- Table structure for table `claim_types`
--

CREATE TABLE `claim_types` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `claim_types`
--

INSERT INTO `claim_types` (`id`, `name`) VALUES
(1, 'Customer do not have Service.'),
(2, 'The Gas Company is over-billing the Service.');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL,
  `tel` bigint(20) DEFAULT NULL,
  `account_number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tax_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `app_user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `tel`, `account_number`, `email`, `first_name`, `last_name`, `name`, `tax_id`, `address_id`, `app_user_id`) VALUES
(1, 6767688344, 'A5671', 'kjane@gmail.com', 'jane', 'Rak', 'jane Rak', 'T15267', NULL, NULL),
(3, 6767688344, 'A6531371', 'Rak@gmail.com', 'Rak', 'Doe', 'Rak Doe', 'T15267', 13, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `tel` bigint(20) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `app_user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `tel`, `email`, `name`, `app_user_id`) VALUES
(5, 6756545475688, 'efuet@gmail.com', 'John Doe', NULL),
(8, 67545398, 'johnDuk@gmail.com', 'Jean Duk', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(14);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `app_role`
--
ALTER TABLE `app_role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `app_user`
--
ALTER TABLE `app_user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf8cjd2mkc4tu1u5nhju0clae7` (`customer_id`),
  ADD KEY `FKhu43rxudln7ogprgn3pd1bw77` (`employee_id`),
  ADD KEY `FKn1w45cvkd2bdpvu78k056mckg` (`role_id`);

--
-- Indexes for table `claims`
--
ALTER TABLE `claims`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5qrmf9oc61eov18fq0fh13q2a` (`claim_status_id`),
  ADD KEY `FKc1brrye1s1qr1fpqk8ygvxyxc` (`claim_types_id`),
  ADD KEY `FKrol4pvwwwx1lrjp286ggbihd1` (`customer_id`),
  ADD KEY `FKei6ig0j6ouwj0t56w3y3i6df7` (`employee_id`);

--
-- Indexes for table `claim_result`
--
ALTER TABLE `claim_result`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtksy5gu4gf3dsqtems7vg7o2a` (`claims_id`),
  ADD KEY `FK4h6q44licj4rmdrd35e41r5gm` (`employee_id`);

--
-- Indexes for table `claim_status`
--
ALTER TABLE `claim_status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `claim_types`
--
ALTER TABLE `claim_types`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKglkhkmh2vyn790ijs6hiqqpi` (`address_id`),
  ADD KEY `FKgn8girv8mn8xxqh5d98lr775w` (`app_user_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKc7ry7r59wb20ay0may25uujw3` (`app_user_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `app_user`
--
ALTER TABLE `app_user`
  ADD CONSTRAINT `FKf8cjd2mkc4tu1u5nhju0clae7` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `FKhu43rxudln7ogprgn3pd1bw77` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `FKn1w45cvkd2bdpvu78k056mckg` FOREIGN KEY (`role_id`) REFERENCES `app_role` (`id`);

--
-- Constraints for table `claims`
--
ALTER TABLE `claims`
  ADD CONSTRAINT `FK5qrmf9oc61eov18fq0fh13q2a` FOREIGN KEY (`claim_status_id`) REFERENCES `claim_status` (`id`),
  ADD CONSTRAINT `FKc1brrye1s1qr1fpqk8ygvxyxc` FOREIGN KEY (`claim_types_id`) REFERENCES `claim_types` (`id`),
  ADD CONSTRAINT `FKei6ig0j6ouwj0t56w3y3i6df7` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `FKrol4pvwwwx1lrjp286ggbihd1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);

--
-- Constraints for table `claim_result`
--
ALTER TABLE `claim_result`
  ADD CONSTRAINT `FK4h6q44licj4rmdrd35e41r5gm` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `FKtksy5gu4gf3dsqtems7vg7o2a` FOREIGN KEY (`claims_id`) REFERENCES `claims` (`id`);

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `FKglkhkmh2vyn790ijs6hiqqpi` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  ADD CONSTRAINT `FKgn8girv8mn8xxqh5d98lr775w` FOREIGN KEY (`app_user_id`) REFERENCES `app_user` (`id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FKc7ry7r59wb20ay0may25uujw3` FOREIGN KEY (`app_user_id`) REFERENCES `app_user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
