create table usuario(
	id_usuario int auto_increment,
	name varchar(50) not null,
	username varchar(50) unique,
	senha varchar(70) not null,
	email varchar(50) unique,
	matricula varchar(6) not null unique,
	papel varchar(50) not null,
	status boolean not null,
	constraint ref_pkey_usuario
	primary key(id_usuario)
);
create table feriado(
	id_feriado int auto_increment,
	dataFeriado varchar(12),
	descricao varchar(50) not null,
	id_usuario int,
	foreign key(id_usuario) references usuario(id_usuario) on update cascade on delete restrict, 
	constraint ref_pkey_feriado
	primary key(id_feriado)
);
create table bloco(
	id_bloco bigint auto_increment,
	nomeDoBloco varchar(50) not null,
	primary key(id_bloco)
);
create table sala(
	id_sala bigint auto_increment,
	nome_da_sala varchar(50) not null,
	bloco bigint,
	capacidade_fisica int not null,
	tipo_de_sala varchar(15) not null,
	foreign key(bloco) references bloco(id_bloco) on update cascade on delete restrict, 
	primary key(id_sala)
);
create table material(
	tombamento int(7),
	descricao varchar(50),
	quantidade int not null,
	status varchar(20),
	local bigint,
	foreign key(local) references sala(id_sala) on update cascade on delete restrict, 
	constraint ref_pkey_feriado
	primary key(tombamento)
);
insert into bloco values(1, 'Bloco 4');
insert into sala values(1, 'Sala 2', 1, 40, 'COMUM');
insert into material values(1111111, 'RetroProjetor', 20, 'Disponivel', 1);
insert into bloco values(2, 'Bloco 5');
insert into sala values(2, 'Sala 4', 2, 23, 'COMUM');
insert into material values(2211111, 'RetroProjetor', 20, 'Disponivel', 2);