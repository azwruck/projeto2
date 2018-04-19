-- begin CACHACA_CATEGORIA
create table CACHACA_CATEGORIA (
    ID integer,
    UUID varchar(32),
    --
    NOME varchar(64) not null,
    --
    primary key (ID)
)^
-- end CACHACA_CATEGORIA
-- begin CACHACA_PRODUTO
create table CACHACA_PRODUTO (
    ID integer,
    UUID varchar(32),
    --
    NOME varchar(255) not null,
    CATEGORIA_ID integer not null,
    PRECO double precision not null,
    QUANTIDADE integer,
    --
    primary key (ID)
)^
-- end CACHACA_PRODUTO
-- begin CACHACA_ESTADO
create table CACHACA_ESTADO (
    ID integer,
    UUID varchar(32),
    --
    NOME varchar(64) not null,
    SIGLA varchar(2) not null,
    --
    primary key (ID)
)^
-- end CACHACA_ESTADO
-- begin CACHACA_CLIENTE
create table CACHACA_CLIENTE (
    ID integer,
    UUID varchar(32),
    --
    NOME varchar(128) not null,
    EMAIL varchar(128),
    TELEFONE varchar(16),
    ENDERECO varchar(255) not null,
    CIDADE varchar(128) not null,
    CEP varchar(16) not null,
    ESTADO_ID integer not null,
    --
    primary key (ID)
)^
-- end CACHACA_CLIENTE