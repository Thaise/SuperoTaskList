create database testesupero;

use testesupero;

create table task(
	id_task int(11) auto_increment primary key,
    titulo varchar(50) not null,
    status_atual int(1) not null,
    descricao varchar(100),
    dt_criacao timestamp not null,
    dt_edicao timestamp not null,
    dt_conclusao timestamp,
    fl_excluido int(1) not null default 0
);