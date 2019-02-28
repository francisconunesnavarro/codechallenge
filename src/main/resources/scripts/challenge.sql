-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 28-Fev-2019 às 14:09
-- Versão do servidor: 5.7.18-log
-- PHP Version: 7.0.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `challenge`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `finan`
--

CREATE TABLE `finan` (
  `id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `value` double NOT NULL,
  `quota` double DEFAULT NULL,
  `finantype_id` int(11) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `contacto` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `finantype`
--

CREATE TABLE `finantype` (
  `id` int(11) NOT NULL,
  `type` varchar(1) NOT NULL,
  `name` varchar(200) NOT NULL,
  `factor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `finantype`
--

INSERT INTO `finantype` (`id`, `type`, `name`, `factor`) VALUES
(1, 'I', 'Interno', 4),
(2, 'E', 'Externo', 6.5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `finan`
--
ALTER TABLE `finan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `finantype`
--
ALTER TABLE `finantype`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
