-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 08, 2018 at 08:24 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


CREATE Database procument;

use procument;

CREATE TABLE `department` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `name`) VALUES
(1, 'Tourism'),
(2, 'AD'),
(3, 'Rhino'),
(4, 'PAC'),
(5, 'Buildings'),
(6, 'Fence'),
(7, 'Procuments'),
(8, 'Accounts'),
(9, 'Human Capital'),
(10, 'Roads'),
(11, 'Customer care'),
(12, 'Admininstration'),
(13, 'ICT'),
(14, 'Telecom'),
(15, 'RPU'),
(16, 'Intelligence'),
(17, 'Education'),
(18, 'Research'),
(19, 'Ngong'),
(20, 'Machakos'),
(21, 'Makueni'),
(22, 'Ngurumani'),
(23, 'workshop'),
(24, 'Eastgate');

-- --------------------------------------------------------

--
-- Table structure for table `purchaseorder`
--

CREATE TABLE `purchaseorder` (
  `id` int(11) NOT NULL,
  `LPODate` date NOT NULL,
  `PurchaseDescription` varchar(256) NOT NULL,
  `unitOfIssue` varchar(256) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `unitPrice` double NOT NULL,
  `totalcost` double NOT NULL,
  `pl4` varchar(256) NOT NULL,
  `requestby` varchar(256) NOT NULL,
  `vehicleNo` varchar(256) NOT NULL,
  `department` varchar(256) NOT NULL,
  `LPONo` varchar(256) NOT NULL,
  `authorisedBy` varchar(256) NOT NULL,
  `procumentMethod` varchar(256) NOT NULL,
  `supplier` varchar(256) NOT NULL,
  `invoiceNo` varchar(256) NOT NULL,
  `Q` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchaseorder`
--

INSERT INTO `purchaseorder` (`id`, `LPODate`, `PurchaseDescription`, `unitOfIssue`, `Quantity`, `unitPrice`, `totalcost`, `pl4`, `requestby`, `vehicleNo`, `department`, `LPONo`, `authorisedBy`, `procumentMethod`, `supplier`, `invoiceNo`, `Q`) VALUES
(2, '1969-12-31', 'Oil Filter', 'pcs', 3, 1000, 3000, '616826', 'D. kimaru', 'SERVICE', 'Tourism', '110091', 'MURAYA', 'Quotation', 'Admiral trading co. ltd', 'INV-230009', ''),
(3, '1969-12-31', 'Diesel', 'lts', 5000, 114.56, 572800, '500410', 'J. THUO', 'ASSORTED', 'Tourism', '110098', 'J.Wandeto', 'Profoma', 'National oil corporation', 'INV-00834', ''),
(4, '1969-12-31', 'Petrol', 'lts', 5000, 114.56, 572800, '500410', 'J. THUO', 'Service', 'Rhino', '110098', 'J.Wandeto', 'Profoma', 'starbell agencies', 'INV-00834', ''),
(5, '1969-12-31', 'Barbed Wire', 'pcs', 5, 4000, 20000, '500417', 'MURANYA', 'Service', 'Fence', '110099', 'J.Wandeto', 'Profoma', 'starbell agencies', 'INV-00834', ''),
(6, '2018-09-08', 'Barbed Wire', 'pcs', 5, 4000, 20000, '500417', 'MURANYA', 'Service', 'Tourism', '110099', 'J.Wandeto', 'Quotation', 'Admiral trading co. ltd', 'INV-00834', ''),
(7, '1969-12-31', 'Barbed Wire', 'pcs', 5, 4000, 20000, '500417', 'MURANYA', 'Service', 'Tourism', '110099', 'J.Wandeto', 'Quotation', 'Admiral trading co. ltd', 'INV-00834', ''),
(8, '1969-12-31', 'TestData', 'pcs', 5, 4000, 20000, '500417', 'MURANYA', 'Service', 'AD', '110099', 'J.Wandeto', 'Quotation', 'Dapny limited', 'INV-00834', ''),
(9, '1969-12-31', 'TestData', 'pcs', 5, 4000, 20000, '500417', 'MURANYA', 'Service', 'AD', '110099', 'J.Wandeto', 'Quotation', 'Dapny limited', 'INV-00834', ''),
(10, '1969-12-31', 'TestData', 'pcs', 5, 4000, 20000, '500417', 'MURANYA', 'Service', 'AD', '110099', 'J.Wandeto', 'Quotation', 'Dapny limited', 'INV-00834', '');

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`id`, `name`) VALUES
(1, 'Admiral trading co. ltd'),
(2, 'Toyota kenya limited'),
(3, 'Merida spares'),
(4, 'Dapny limited'),
(5, 'National oil corporation'),
(6, 'Duke energy products & company ltd'),
(7, 'starbell agencies'),
(8, 'Tanar suppliers'),
(9, 'Upper land petrol station'),
(10, 'Aquara aqencies'),
(11, 'sagoo holdings'),
(12, 'City engineering hydraulic'),
(13, 'Cherik enterprises'),
(14, 'wire products ltd'),
(15, 'kenol kobil'),
(16, 'kansai plascom'),
(17, 'samco auto parts'),
(18, 'autostyle performance limited'),
(19, 'Nairobi crankshaft center'),
(20, 'Ministry of transport'),
(21, 'Jaidah motors ltd'),
(22, 'E.A drillicon ltd'),
(23, 'chloride oxide'),
(24, 'badgas autospares'),
(25, 'andy ventures'),
(26, 'Anitaan agencies'),
(27, 'Roots general suppliers'),
(28, 'Elwalk printers');

-- --------------------------------------------------------

--
-- Table structure for table `system_user`
--

CREATE TABLE `system_user` (
  `id` int(11) NOT NULL,
  `email` varchar(256) NOT NULL,
  `role` varchar(22) NOT NULL,
  `password` varchar(256) NOT NULL,
  `registered_date` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `system_user`
--

INSERT INTO `system_user` (`id`, `email`, `role`, `password`, `registered_date`) VALUES
(1, 'admin@gmail.com', 'ADMIN', 'ccb9bmf5dla1848ldtf988dtadfe8levdhb7d9e8bjfsabdod88vbf9adka8d98o', '07-09-2018');

-- --------------------------------------------------------

--
-- Table structure for table `users_logs`
--

CREATE TABLE `users_logs` (
  `id` int(11) NOT NULL,
  `email` varchar(256) NOT NULL,
  `time` varchar(256) NOT NULL,
  `date` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users_logs`
--

INSERT INTO `users_logs` (`id`, `email`, `time`, `date`) VALUES
(1, 'admin@gmail.com', '20:32:59.415', '2018-09-07'),
(2, 'admin@gmail.com', '20:36:57.911', '2018-09-07'),
(3, 'admin@gmail.com', '20:42:24.741', '2018-09-07'),
(4, 'admin@gmail.com', '20:47:47.826', '2018-09-07'),
(5, 'admin@gmail.com', '20:48:43.835', '2018-09-07'),
(6, 'admin@gmail.com', '20:55:24.749', '2018-09-07'),
(7, 'admin@gmail.com', '21:06:01.310', '2018-09-07'),
(8, 'admin@gmail.com', '21:09:59.434', '2018-09-07'),
(9, 'admin@gmail.com', '21:11:44.926', '2018-09-07'),
(10, 'admin@gmail.com', '21:15:26.075', '2018-09-07'),
(11, 'admin@gmail.com', '21:23:52.031', '2018-09-07'),
(12, 'admin@gmail.com', '05:41:09.871', '2018-09-08'),
(13, 'admin@gmail.com', '05:45:01.169', '2018-09-08'),
(14, 'admin@gmail.com', '05:47:12.983', '2018-09-08'),
(15, 'admin@gmail.com', '05:49:06.929', '2018-09-08'),
(16, 'admin@gmail.com', '05:56:18.482', '2018-09-08'),
(17, 'admin@gmail.com', '06:02:38.608', '2018-09-08'),
(18, 'admin@gmail.com', '06:07:17.477', '2018-09-08'),
(19, 'admin@gmail.com', '06:10:51.717', '2018-09-08'),
(20, 'admin@gmail.com', '06:26:26.189', '2018-09-08'),
(21, 'admin@gmail.com', '06:34:32.863', '2018-09-08'),
(22, 'admin@gmail.com', '07:09:17.066', '2018-09-08'),
(23, 'admin@gmail.com', '07:53:31.002', '2018-09-08'),
(24, 'admin@gmail.com', '08:04:41.745', '2018-09-08'),
(25, 'admin@gmail.com', '09:12:21.424', '2018-09-08'),
(26, 'admin@gmail.com', '09:20:50.207', '2018-09-08'),
(27, 'admin@gmail.com', '09:26:26.603', '2018-09-08'),
(28, 'admin@gmail.com', '09:27:35.633', '2018-09-08'),
(29, 'admin@gmail.com', '09:48:46.637', '2018-09-08'),
(30, 'admin@gmail.com', '10:46:20.960', '2018-09-08'),
(31, 'admin@gmail.com', '11:22:02.344', '2018-09-08');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `purchaseorder`
--
ALTER TABLE `purchaseorder`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `system_user`
--
ALTER TABLE `system_user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_logs`
--
ALTER TABLE `users_logs`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `purchaseorder`
--
ALTER TABLE `purchaseorder`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `system_user`
--
ALTER TABLE `system_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `users_logs`
--
ALTER TABLE `users_logs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
