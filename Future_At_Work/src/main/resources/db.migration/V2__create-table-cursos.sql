create table curso (
    id bigint not null auto_increment primary key,
    ativo tinyint default 1,
    titulo varchar(100) not null,
    duracao int not null,
    ano int not null,
    categoria varchar(100) not null,
    professor varchar(100) not null
);