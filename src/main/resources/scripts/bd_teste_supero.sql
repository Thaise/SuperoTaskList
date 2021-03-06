﻿create database testesupero;

use testesupero;

create table task(
	id_task int(11) auto_increment primary key,
	titulo varchar(50) not null,
	status_atual int(1) not null default 0,
	descricao varchar(100),
	dt_criacao datetime not null,
	dt_edicao datetime not null,
	dt_conclusao datetime,
	fl_excluido int(1) not null default 0
);

insert into task(titulo, descricao, dt_criacao, dt_edicao, dt_conclusao) values('Desafio Supero',1,'Realizar teste enviado por e-mail para seleção de candidatos', STR_TO_DATE('2018-01-21 10:30', '%Y-%m-%d %H:%i'), STR_TO_DATE('2018-01-21 10:30', '%Y-%m-%d %H:%i'), STR_TO_DATE('2018-01-21 17:00', '%Y-%m-%d %H:%i'));