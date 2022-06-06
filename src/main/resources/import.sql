insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');

insert into restaurante (nome,taxa_frete,cozinha_id) values ('Sabor do Nordeste',1.5,1);
insert into restaurante (nome,taxa_frete,cozinha_id) values ('Sabor da Roça',4.5,2);

insert into forma_pagamento (descricao) values ('À vista');
insert into forma_pagamento (descricao) values ('À prazo');

insert into permissao (nome, descricao) values ('Administrador','Possui controle total');
insert into permissao (nome, descricao) values ('Padrão','Não possui controle total');

insert into estado (nome) value ('São Paulo');
insert into estado (nome) value ('Paraná');

insert into cidade (nome, estado_id) value ('Araçatuba', 1);
insert into cidade (nome, estado_id) value ('Campinas', 1);
