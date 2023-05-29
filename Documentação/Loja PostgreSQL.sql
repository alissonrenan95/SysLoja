CREATE SEQUENCE "seq_cargo";
CREATE SEQUENCE "seq_categoria_produto";
CREATE SEQUENCE "seq_cliente";
CREATE SEQUENCE "seq_fornecimento";
CREATE SEQUENCE "seq_conta";
CREATE SEQUENCE "seq_forma_pagamento";
CREATE SEQUENCE "seq_fornecedor";
CREATE SEQUENCE "seq_funcionario";
CREATE SEQUENCE "seq_movimentacao";
CREATE SEQUENCE "seq_pagamento_conta";
CREATE SEQUENCE "seq_pagamento_funcionario";
CREATE SEQUENCE "seq_produto";
CREATE SEQUENCE "seq_usuario";
CREATE SEQUENCE "seq_venda";

CREATE TABLE Cliente (
  id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_cliente'::REGCLASS),
  nome VARCHAR(50) NOT NULL,
  data_nasc DATE NOT NULL,
  telefone VARCHAR(30) NOT NULL,
  endereco VARCHAR(50) NOT NULL,
  bairro VARCHAR(30) NOT NULL,
  cidade VARCHAR(30) NOT NULL,
  rg VARCHAR(15) NOT NULL,
  cpf VARCHAR(15) NOT NULL UNIQUE,
  cnpj VARCHAR(20) NULL
);

CREATE TABLE Usuario (
  id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_usuario'::REGCLASS),
  nome_usuario VARCHAR(20) NOT NULL UNIQUE,
  senha VARCHAR(20) NOT NULL,
  email VARCHAR(50) NOT NULL
);

CREATE TABLE Cargo (
  id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_cargo'::REGCLASS),
  nome VARCHAR(50) NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  nivel_acesso INTEGER NOT NULL
);

CREATE TABLE Funcionario (
  id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_funcionario'::REGCLASS),
  Usuario_id INTEGER NOT NULL REFERENCES Usuario(id),
  Cargo_id INTEGER NOT NULL REFERENCES Cargo(id),
  Cliente_id INTEGER NOT NULL REFERENCES Cliente(id),
  salario FLOAT NOT NULL
);

CREATE TABLE Categoria_produto (
  id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_categoria_produto'::REGCLASS),
  nome VARCHAR(50) NOT NULL
);

CREATE TABLE Produto (
  id INTEGER DEFAULT NEXTVAL('seq_produto'::REGCLASS),
  Categoria_produto_id INTEGER NOT NULL REFERENCES Categoria_produto(id),
  nome VARCHAR(50) NOT NULL,
  valor_unitario FLOAT NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE Fornecedor (
  id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_fornecedor'::regclass),
  nome VARCHAR(50) NOT NULL,
  telefone VARCHAR(30) NOT NULL,
  endereco VARCHAR(50) NOT NULL,
  bairro VARCHAR(30) NOT NULL,
  cidade VARCHAR(30) NOT NULL,
  estado VARCHAR(2) NOT NULL,
  cnpj VARCHAR(20) NOT NULL
);

CREATE TABLE Fornecimento (
  id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_fornecimento'::REGCLASS),
  Fornecedor_id INTEGER NOT NULL REFERENCES Fornecedor(id),
  data_pedido DATE NOT NULL,
  data_prevista_recebimento DATE,
  data_recebida DATE,
  valor_total FLOAT NOT NULL
);

CREATE TABLE Forma_pagamento (
  id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_forma_pagamento'::regclass),
  num_parcelas INTEGER NOT NULL,
  cartao BOOL NOT NULL,
  taxa_juros FLOAT NOT NULL,
  tipo_cartao BOOL NOT NULL
);

CREATE TABLE Venda (
  id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_venda'::REGCLASS),
  Cliente_id INTEGER NULL REFERENCES Cliente(id),
  Funcionario_id INTEGER NOT NULL REFERENCES Funcionario(id),
  Forma_pagamento_id INTEGER NOT NULL REFERENCES Forma_pagamento(id),
  data_venda DATE NOT NULL,
  valor_total FLOAT NOT NULL,
  valor_desconto FLOAT NULL,
  valor_juros FLOAT NULL
);

CREATE TABLE Estoque (
  cod_barra BIGINT PRIMARY KEY,
  Produto_id INTEGER NOT NULL,
  disponivel_venda BOOLEAN NOT NULL,
  quantidade INTEGER NOT NULL,
  FOREIGN KEY(Produto_id) REFERENCES Produto(id)
);

CREATE TABLE Estoque_venda (
  Estoque_cod_barra BIGINT NOT NULL REFERENCES Estoque(cod_barra),
  Venda_id INTEGER NOT NULL REFERENCES Venda(id),
  quantidade INTEGER NOT NULL,
  valor_unitario FLOAT NOT NULL,
  PRIMARY KEY(Estoque_cod_barra, Venda_id)
);

create table Fornecimento_Estoque(
  Fornecimento_id int not null references Fornecimento(id),
  Estoque_cod_barra bigint not null references Estoque(cod_barra),
  quantidade int not null,
  disponivel_estoque boolean not null,
  valor_unitario float not null,
  data_fabricacao date, 
  data_vencimento date,
  PRIMARY KEY(Fornecimento_id, Estoque_cod_barra)
);

CREATE TABLE Conta (
  id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_conta'::REGCLASS),
  descricao VARCHAR(50) NOT NULL,
  valor_parcela FLOAT NOT NULL,
  num_parcelas INTEGER NOT NULL,
  data_cadastro DATE NOT NULL,
  data_vencimento DATE NOT NULL
);

CREATE TABLE Pagamento_conta (
  id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_pagamento_conta'::REGCLASS),
  Conta_id INTEGER NOT NULL REFERENCES Conta(id),
  Funcionario_id INTEGER NOT NULL REFERENCES Funcionario(id),
  valor_pago FLOAT NOT NULL,
  data_pagamento DATE NOT NULL
);

CREATE TABLE Movimentacao (
  id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_movimentacao'::REGCLASS),
  Funcionario_id INTEGER NOT NULL REFERENCES Funcionario(id),
  descricao VARCHAR(255) NOT NULL,
  data_mov DATE NOT NULL,
  valor FLOAT NOT NULL,
  entrada_ou_saida CHAR(1) NOT NULL
);

CREATE TABLE Pagamento_funcionario (
  id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_pagamento_funcionario'::REGCLASS),
  Usuario_id INTEGER NOT NULL REFERENCES Usuario(id),
  Funcionario_id INTEGER NOT NULL REFERENCES Funcionario(id),
  data_pago DATE NOT NULL,
  valor FLOAT NOT NULL
);

insert into usuario values(1,'alisson.renan95','renan2016','alisson.renan95.aj@gmail.com');
insert into cargo values(1,'Gerente','Gerencia de loja',3);
insert into cliente values(1,'Alisson Renan Carvalho Freitas','23-01-1995','85994057746','Tabelião José Gama Filho 30','Centro','Pacajus','20078240985','05787603397','');
insert into funcionario values(1,1,1,1,800.00);
