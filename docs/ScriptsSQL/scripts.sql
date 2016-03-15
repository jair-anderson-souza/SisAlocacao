create table usuario(
	id_usuario int auto_increment,
	username varchar(50) unique,
	senha varchar(50) not null,
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


	
	
	
	