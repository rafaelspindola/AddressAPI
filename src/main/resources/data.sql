insert into Pessoa (nome, dataNascimento) values ('Rafael', '1995-02-06');
insert into Pessoa (nome, dataNascimento) values ('Julia', '1997-10-20');

insert into Endereco (logradouro, cep, numero, cidade, principal, pessoa_id) values ('Rua A', '12345-098', '123', 'Brasília', TRUE, 1);
insert into Endereco (logradouro, cep, numero, cidade, principal, pessoa_id) values ('Rua B', '12543-077', '456', 'São Paulo', FALSE, 1);
insert into Endereco (logradouro, cep, numero, cidade, principal, pessoa_id) values ('Rua C', '98765-098', '321', 'Ceará', TRUE, 1);
insert into Endereco (logradouro, cep, numero, cidade, principal, pessoa_id) values ('Rua D', '98765-077', '654', 'Pará', FALSE, 1);