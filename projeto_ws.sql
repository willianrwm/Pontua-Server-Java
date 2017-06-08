-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 12-Maio-2017 às 00:07
-- Versão do servidor: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projeto_ws`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(100) NOT NULL,
  `CPF` varchar(11) DEFAULT NULL,
  `EMAIL` varchar(200) DEFAULT NULL,
  `NASCIMENTO` date DEFAULT NULL,
  `SEXO` varchar(1) DEFAULT NULL,
  `SENHA` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`ID`, `NOME`, `CPF`, `EMAIL`, `NASCIMENTO`, `SEXO`, `SENHA`) VALUES
(1, 'willian', '07172503937', 'willian_rwm@hotmail.com', '1990-07-08', 'M', '8790'),
(2, 'popo', '00011122233', 'teste@testanildo.com', '2017-05-09', 'M', '0909'),
(4, 'juvenal', '07172503937', 'willian_rwm@hotmail.com', '1990-07-08', 'M', 'juvenil');

-- --------------------------------------------------------

--
-- Estrutura da tabela `premio`
--

CREATE TABLE `premio` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(100) NOT NULL,
  `DESCRICAO` text,
  `QUANTIDADE_DISPONIVEL` decimal(15,2) DEFAULT NULL,
  `VALIDADE` date DEFAULT NULL,
  `VALOR_PONTOS` decimal(15,2) DEFAULT NULL,
  `ID_REPRESENTANTE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `promocao`
--

CREATE TABLE `promocao` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(100) NOT NULL,
  `QTD_PONTOS` int(11) NOT NULL,
  `INICIO_VIGENCIA` date NOT NULL,
  `FINAL_VIGENCIA` date NOT NULL,
  `VALIDADE` date DEFAULT NULL,
  `ID_REPRESENTANTE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `representante`
--

CREATE TABLE `representante` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(100) NOT NULL,
  `FANTASIA` varchar(100) DEFAULT NULL,
  `CNPJ_CPF` varchar(14) DEFAULT NULL,
  `END_LOGRADOURO` varchar(100) DEFAULT NULL,
  `END_NUMERO` varchar(10) DEFAULT NULL,
  `END_COMPLEMENTO` varchar(50) DEFAULT NULL,
  `END_BAIRRO` varchar(50) DEFAULT NULL,
  `END_CIDADE` varchar(100) DEFAULT NULL,
  `END_ESTADO` varchar(2) DEFAULT NULL,
  `END_CEP` varchar(8) DEFAULT NULL,
  `EMAIL` varchar(200) DEFAULT NULL,
  `VALIDADE_PONTOS` date DEFAULT NULL,
  `SENHA` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `premio`
--
ALTER TABLE `premio`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_representante_premio` (`ID_REPRESENTANTE`);

--
-- Indexes for table `promocao`
--
ALTER TABLE `promocao`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_representante_promocao` (`ID_REPRESENTANTE`);

--
-- Indexes for table `representante`
--
ALTER TABLE `representante`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `premio`
--
ALTER TABLE `premio`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `promocao`
--
ALTER TABLE `promocao`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `representante`
--
ALTER TABLE `representante`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `premio`
--
ALTER TABLE `premio`
  ADD CONSTRAINT `fk_representante_premio` FOREIGN KEY (`ID_REPRESENTANTE`) REFERENCES `representante` (`ID`);

--
-- Limitadores para a tabela `promocao`
--
ALTER TABLE `promocao`
  ADD CONSTRAINT `fk_representante_promocao` FOREIGN KEY (`ID_REPRESENTANTE`) REFERENCES `representante` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
