CREATE TABLE Cliente (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  data_nasc DATE NOT NULL,
  telefone VARCHAR(30) NOT NULL,
  endereco VARCHAR(50) NOT NULL,
  bairro VARCHAR(30) NOT NULL,
  cidade VARCHAR(30) NOT NULL,
  rg VARCHAR(15) NULL,
  cpf VARCHAR(15) NULL,
  PRIMARY KEY(id)
)
TYPE=InnoDB;

CREATE TABLE Usuario (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome_usuario VARCHAR(20) NOT NULL UNIQUE,
  senha VARCHAR(20) NOT NULL,
  email VARCHAR(60) NOT NULL,
  PRIMARY KEY(id)
)
TYPE=InnoDB;

CREATE TABLE Cargo (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  descricao VARCHAR(100),
  nivel_acesso INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(id)
)
TYPE=InnoDB;

CREATE TABLE Funcionario (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Usuario_id INTEGER UNSIGNED NOT NULL,
  Cargo_id INTEGER UNSIGNED NOT NULL,
  Cliente_id INTEGER UNSIGNED NOT NULL,
  salario FLOAT NOT NULL,
  PRIMARY KEY(id),
  INDEX Funcionario_FKIndex1(Cliente_id),
  INDEX Funcionario_FKIndex2(Cargo_id),
  INDEX Funcionario_FKIndex3(Usuario_id)
)
TYPE=InnoDB;

CREATE TABLE Categoria_produto (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  PRIMARY KEY(id)
)
TYPE=InnoDB;

CREATE TABLE Produto (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Categoria_produto_id INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(50) NOT NULL,
  PRIMARY KEY(id),
  INDEX Produto_FKIndex1(Categoria_produto_id)
)
TYPE=InnoDB;

CREATE TABLE Fornecedor (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  telefone VARCHAR(30) NOT NULL,
  endereco VARCHAR(50) NOT NULL,
  bairro VARCHAR(30) NOT NULL,
  cidade VARCHAR(30) NOT NULL,
  estado VARCHAR(2) NOT NULL,
  PRIMARY KEY(id)
)
TYPE=InnoDB;

CREATE TABLE Fornecimento (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Fornecedor_id INTEGER UNSIGNED NOT NULL,
  data_pedido DATE NOT NULL,
  data_recebimento DATE NULL,
  PRIMARY KEY(id),
  INDEX Fornecimento_FKIndex1(Fornecedor_id)
)
TYPE=InnoDB;

CREATE TABLE Forma_pagamento (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  num_parcelas INTEGER UNSIGNED NULL,
  cartao BOOL NULL,
  PRIMARY KEY(id)
)
TYPE=InnoDB;

CREATE TABLE Venda (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Cliente_id INTEGER UNSIGNED NULL,
  Funcionario_id INTEGER UNSIGNED NOT NULL,
  Forma_pagamento_id INTEGER UNSIGNED NOT NULL,
  data_venda DATE NOT NULL,
  valor_total FLOAT NOT NULL,
  valor_desconto FLOAT NULL,
  valor_juros FLOAT NULL,
  PRIMARY KEY(id),
  INDEX Venda_FKIndex1(Forma_pagamento_id),
  INDEX Venda_FKIndex2(Funcionario_id),
  INDEX Venda_FKIndex3(Cliente_id)
)
TYPE=InnoDB;

CREATE TABLE Estoque (
  cod_barra BIGINT NOT NULL AUTO_INCREMENT,
  Venda_id INTEGER UNSIGNED NULL,
  Fornecimento_id INTEGER UNSIGNED NULL,
  Produto_id INTEGER UNSIGNED NOT NULL,
  valor FLOAT NOT NULL,
  disponivel_venda BOOLEAN NOT NULL,
  PRIMARY KEY(cod_barra),
  INDEX Estoque_FKIndex1(Produto_id),
  INDEX Estoque_FKIndex2(Fornecimento_id),
  INDEX Estoque_FKIndex3(Venda_id)
)
TYPE=InnoDB;

CREATE TABLE Conta (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(50) NOT NULL,
  valor_total FLOAT NOT NULL,
  num_parcelas INTEGER UNSIGNED NOT NULL,
  data_cadastro DATE NOT NULL,
  data_vencimento DATE NOT NULL,
  PRIMARY KEY(id)
)
TYPE=InnoDB;

CREATE TABLE Pagamento_conta (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Conta_id INTEGER UNSIGNED NOT NULL,
  Funcionario_id INTEGER UNSIGNED NOT NULL,
  valor_pago FLOAT NOT NULL,
  data_pagamento DATE NOT NULL,
  PRIMARY KEY(id),
  INDEX Pagamento_conta_FKIndex1(Funcionario_id),
  INDEX Pagamento_conta_FKIndex2(Conta_id)
)
TYPE=InnoDB;

CREATE TABLE Movimentacao (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Funcionario_id INTEGER UNSIGNED NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  data_mov DATE NOT NULL,
  valor FLOAT NOT NULL,
  entrada_ou_saida CHAR(1) NOT NULL,
  PRIMARY KEY(id),
  INDEX Movimentacao_FKIndex1(Funcionario_id)
)
TYPE=InnoDB;

CREATE TABLE Pagamento_funcionario (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Usuario_id INTEGER UNSIGNED NOT NULL,
  Funcionario_id INTEGER UNSIGNED NOT NULL,
  data_pago DATE NOT NULL,
  valor FLOAT NOT NULL,
  PRIMARY KEY(id),
  INDEX Pagamento_funcionario_FKIndex2(Funcionario_id),
  INDEX Pagamento_funcionario_FKIndex2(Usuario_id)
)
TYPE=InnoDB;


