-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2020 at 01:14 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

CREATE USER 'root'@'localhost' IDENTIFIED BY '';
GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP ON *.* TO 'root'@'localhost';


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `admin` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `password`, `username`, `admin`) VALUES
(1, '1234', 'mouad', b'1'),
(4, '1234', 'elkacem', b'0'),
(5, '1234', 'jee', b'0'),
(6, '1234', 'elkacemM', b'0'),
(7, '1234', 'elkacemMm', b'0'),
(8, '1234', 'mostafa', b'0'),
(9, '1234', 'fatima', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `id` bigint(20) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `year` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`id`, `brand`, `color`, `year`) VALUES
(1, 'mouad', 'mouu', 1998),
(2, 'mouadert', 'mouuzert', 1998);

-- --------------------------------------------------------

--
-- Table structure for table `card`
--

CREATE TABLE `card` (
  `id` bigint(20) NOT NULL,
  `id_prod` bigint(20) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `user` varchar(255) DEFAULT NULL,
  `orderbool` bit(1) NOT NULL,
  `valid` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `card`
--

INSERT INTO `card` (`id`, `id_prod`, `quantity`, `user`, `orderbool`, `valid`) VALUES
(13, 2, 3, 'mouad', b'1', b'1'),
(14, 1, 3, 'mouad', b'1', b'1'),
(16, 1, 2, 'mouad', b'1', b'1'),
(17, 1, 10, 'mouad', b'1', b'1'),
(18, 1, 5, 'mouad', b'1', b'1'),
(19, 4, 2, 'mouad', b'1', b'1'),
(20, 1, 2, 'mouad', b'1', b'0'),
(21, 1, 1, 'mouad', b'1', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'T-shirts'),
(2, 'Shoes'),
(3, 'Pants');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `category`, `description`, `image_url`, `name`, `price`, `quantity`) VALUES
(1, 'T-shirts', 'Mervel good quality', 'https://i.pinimg.com/736x/c7/eb/98/c7eb9832b8662868c5144add547a5127--gray-hulk-marvel-entertainment.jpg', 'Marvel 1', 180, 83),
(2, 'Shoes', 'The best shoes !', 'https://cf.shopee.sg/file/7d088a476ad4dac1915bf0597f1a70e1', 'Sprime Shoes', 300, 100),
(4, 'Pants', 'Michael Kors feature stretch fabric for improved comfort.', 'https://slimages.macysassets.com/is/image/MCY/products/8/optimized/15491658_fpx.tif?op_sharpen=1&wid=402&hei=489&fit=fit,1&$filtersm$&fmt=webp', 'Men\'s Parker Slim-Fit Stretch Pants New', 170, 18);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `card`
--
ALTER TABLE `card`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `car`
--
ALTER TABLE `car`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `card`
--
ALTER TABLE `card`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
