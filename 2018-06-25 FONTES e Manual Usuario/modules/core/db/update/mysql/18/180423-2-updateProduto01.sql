alter table CACHACA_PRODUTO add constraint FK_CACHACA_PRODUTO_ID_CATEGORIA foreign key (ID_CATEGORIA_ID) references CACHACA_CATEGORIA(ID);
create index IDX_CACHACA_PRODUTO_ID_CATEGORIA on CACHACA_PRODUTO (ID_CATEGORIA_ID);