-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 08-Set-2016 às 17:31
-- Versão do servidor: 5.7.11
-- PHP Version: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `outstok`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `categorias`
--

CREATE TABLE `categorias` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE `cidade` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `Estado_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`id`, `nome`, `Estado_id`) VALUES
(1, 'Lucas', 1),
(2, 'dsadsa', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(10) UNSIGNED ZEROFILL NOT NULL,
  `nome` varchar(45) NOT NULL,
  `data_nascimento` varchar(45) DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `Cidade_id` int(11) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `rg` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `observacao` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `data_nascimento`, `sexo`, `telefone`, `celular`, `endereco`, `bairro`, `Cidade_id`, `email`, `rg`, `cpf`, `observacao`) VALUES
(0000000001, 'Lucas Gabriel dos Santos Alves', '04/10/1993', 'Masculino', '(19)3661-3880', '(19)99243-9514', 'Rua João Meloni nª 45', 'Parque da Figueira', 2, 'lukaasgabrieel@hotmail.com', '48.995.095-4', '391.855.208-02', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente_has_venda`
--

CREATE TABLE `cliente_has_venda` (
  `Cliente_id` int(10) UNSIGNED ZEROFILL NOT NULL,
  `venda_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `estado`
--

CREATE TABLE `estado` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `sigla` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `estado`
--

INSERT INTO `estado` (`id`, `nome`, `sigla`) VALUES
(1, 'AC', 'Acre'),
(2, 'AL', 'Alagoas'),
(3, 'AM', 'Amazonas'),
(4, 'AP', 'Amapá'),
(5, 'BA', 'Bahia'),
(6, 'CE', 'Ceará'),
(7, 'DF', 'Distrito Federal'),
(8, 'ES', 'Espírito Santo'),
(9, 'GO', 'Goiás'),
(10, 'MA', 'Maranhão'),
(11, 'MG', 'Minas Gerais'),
(12, 'MS', 'Mato Grosso do Sul'),
(13, 'MT', 'Mato Grosso'),
(14, 'PA', 'Pará'),
(15, 'PB', 'Paraíba'),
(16, 'PE', 'Pernambuco'),
(17, 'PI', 'Piauí'),
(18, 'PR', 'Paraná'),
(19, 'RJ', 'Rio de Janeiro'),
(20, 'RN', 'Rio Grande do Norte'),
(21, 'RO', 'Rondônia'),
(22, 'RR', 'Roraima'),
(23, 'RS', 'Rio Grande do Sul'),
(24, 'SC', 'Santa Catarina'),
(25, 'SE', 'Sergipe'),
(26, 'SP', 'São Paulo'),
(27, 'TO', 'Tocantins');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `id` int(10) UNSIGNED ZEROFILL NOT NULL,
  `nome` varchar(45) NOT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `Cidade_id` int(11) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `observacao` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`id`, `nome`, `telefone`, `celular`, `endereco`, `bairro`, `Cidade_id`, `email`, `cnpj`, `observacao`) VALUES
(0000000001, 'teste', '(19)9999-9999', '(19)99999-9999', 'teste', 'teste', 2, 'teste', '11.111.111/1111-11', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `preco_custo` float DEFAULT NULL,
  `preco_venda` float DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `codigo` varchar(45) DEFAULT NULL,
  `estoque_minimo` int(11) DEFAULT NULL,
  `observacao` text,
  `Fornecedor_id` int(10) UNSIGNED ZEROFILL NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`id`, `nome`, `preco_custo`, `preco_venda`, `quantidade`, `codigo`, `estoque_minimo`, `observacao`, `Fornecedor_id`) VALUES
(1, 'Uno', 10, 25, 94, '746775133504', 1, '', 0000000001),
(3, 'Fone ', 20.5, 37.99, 0, '050644568725', 1, '', 0000000001),
(4, 'HD Externo', 100, 150.99, 0, '718037807911', 1, '', 0000000001);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos_has_venda`
--

CREATE TABLE `produtos_has_venda` (
  `produtos_id` int(11) NOT NULL,
  `venda_id` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produtos_has_venda`
--

INSERT INTO `produtos_has_venda` (`produtos_id`, `venda_id`, `quantidade`) VALUES
(1, 78, 1),
(1, 80, 1),
(1, 82, 1),
(1, 83, 1),
(1, 84, 1),
(1, 85, 1),
(1, 86, 1),
(1, 88, 1),
(1, 89, 1),
(1, 90, 1),
(1, 92, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `id` int(11) NOT NULL,
  `data_venda` varchar(45) DEFAULT NULL,
  `valor_venda` float(10,0) DEFAULT NULL,
  `pagamento` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`id`, `data_venda`, `valor_venda`, `pagamento`) VALUES
(78, NULL, 0, NULL),
(79, NULL, 0, NULL),
(80, NULL, 0, NULL),
(81, '04/10/2013', 101, 'A VISTA'),
(82, NULL, 0, NULL),
(83, NULL, 0, NULL),
(84, NULL, 0, NULL),
(85, NULL, 0, NULL),
(86, NULL, 0, NULL),
(87, NULL, 0, NULL),
(88, NULL, 0, NULL),
(89, NULL, 0, NULL),
(90, '08/09/2016', 25, NULL),
(91, NULL, 0, NULL),
(92, '08/09/2016', 25, 'Á Vista'),
(93, NULL, 0, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cidade`
--
ALTER TABLE `cidade`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Cidade_Estado_idx` (`Estado_id`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Cliente_Cidade1_idx` (`Cidade_id`);

--
-- Indexes for table `cliente_has_venda`
--
ALTER TABLE `cliente_has_venda`
  ADD PRIMARY KEY (`Cliente_id`,`venda_id`),
  ADD KEY `fk_Cliente_has_venda_venda1_idx` (`venda_id`),
  ADD KEY `fk_Cliente_has_venda_Cliente1_idx` (`Cliente_id`);

--
-- Indexes for table `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Cliente_Cidade1_idx` (`Cidade_id`);

--
-- Indexes for table `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_produtos_Fornecedor1_idx` (`Fornecedor_id`);

--
-- Indexes for table `produtos_has_venda`
--
ALTER TABLE `produtos_has_venda`
  ADD PRIMARY KEY (`produtos_id`,`venda_id`),
  ADD KEY `fk_produtos_has_venda_venda1_idx` (`venda_id`),
  ADD KEY `fk_produtos_has_venda_produtos1_idx` (`produtos_id`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cidade`
--
ALTER TABLE `cidade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `estado`
--
ALTER TABLE `estado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `id` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `produtos`
--
ALTER TABLE `produtos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cidade`
--
ALTER TABLE `cidade`
  ADD CONSTRAINT `fk_Cidade_Estado` FOREIGN KEY (`Estado_id`) REFERENCES `estado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_Cliente_Cidade1` FOREIGN KEY (`Cidade_id`) REFERENCES `cidade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `cliente_has_venda`
--
ALTER TABLE `cliente_has_venda`
  ADD CONSTRAINT `fk_Cliente_has_venda_Cliente1` FOREIGN KEY (`Cliente_id`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Cliente_has_venda_venda1` FOREIGN KEY (`venda_id`) REFERENCES `venda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD CONSTRAINT `fk_Cliente_Cidade10` FOREIGN KEY (`Cidade_id`) REFERENCES `cidade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `produtos`
--
ALTER TABLE `produtos`
  ADD CONSTRAINT `fk_produtos_Fornecedor1` FOREIGN KEY (`Fornecedor_id`) REFERENCES `fornecedor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `produtos_has_venda`
--
ALTER TABLE `produtos_has_venda`
  ADD CONSTRAINT `fk_produtos_has_venda_produtos1` FOREIGN KEY (`produtos_id`) REFERENCES `produtos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_produtos_has_venda_venda1` FOREIGN KEY (`venda_id`) REFERENCES `venda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
