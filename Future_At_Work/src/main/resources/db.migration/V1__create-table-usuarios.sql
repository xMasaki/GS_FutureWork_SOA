create table usuario(
    id bigint not null auto_increment primary key,
    ativo tinyint default 1,
    nome varchar(100) not null ,
    email varchar(100) not null  unique ,
    telefone varchar(20) not null ,
    rg varchar(9) not null unique ,
    tipo varchar(100) not null ,
    logradouro varchar(100) not null ,
    numero varchar(20),
    complemento varchar(100),
    bairro varchar(100) not null ,
    cidade varchar(100) not null ,
    uf varchar(2) not null ,
    cep varchar(8) not null
);