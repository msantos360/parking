use parkingDb;

create table cliente (
    id bigint not null auto_increment,
    cpf bigint not null,
    data_cadastro datetime not null,
    data_nascimento date not null,
    nome varchar(255) not null,
    tipo varchar(255) not null,
    primary key (id)
);

create table colaborador (
    id bigint not null auto_increment,
    data_cadastro datetime,
    email varchar(255) not null,
    enabled bit not null,
    locked bit not null,
    nome varchar(255) not null,
    senha varchar(255) not null,
    primary key (id)
);

create table colaborador_perfis (
    colaborador_id bigint not null,
    perfis_id bigint not null
);

create table estacionamento (
    id bigint not null auto_increment,
    capacidade_vagas integer not null,
    cnpj bigint not null,
    nome varchar(255) not null,
    primary key (id)
); 

create table movimentacoes (
    id bigint not null auto_increment,
    forma_de_pagamento varchar(255),
    horario_entrada datetime not null,
    horario_saida datetime,
    status_de_pagamento varchar(255),
    total_apagar decimal(19,2),
    cliente_id bigint,
    estacionamento_id bigint,
    veiculo_id bigint,
    primary key (id)
);

create table perfil (
    id bigint not null auto_increment,
    nome varchar(255),
    primary key (id)
);

create table tabela_de_precos (
    id bigint not null auto_increment,
    preco_da_diaria decimal(19,2),
    preco_da_primeira_hora decimal(19,2) not null,
    preco_das_demais_horas decimal(19,2) not null,
    preco_mensalidade decimal(19,2),
    tipo varchar(255) not null,
    estacionamento_id bigint,
    primary key (id)
);

create table veiculo (
    id bigint not null auto_increment,
    marca varchar(255),
    modelo varchar(255) not null,
    placa varchar(8) not null,
    tipo varchar(255) not null,
    cliente_id bigint,
    primary key (id)
);

SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;

insert into colaborador (data_cadastro,email,enabled,locked,nome,senha) values('2021-07-03','adm@parking.com',1,1,'Administrador','$2a$10$8uVmsSvGCgx1SCgCN0LoyeYrTwyARUMqiAdg5qsv.yHvRtOfbc9ay');