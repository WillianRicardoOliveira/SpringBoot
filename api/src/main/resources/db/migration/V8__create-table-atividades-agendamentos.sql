
create table atividades (
    id bigint not null auto_increment,
    nome varchar(100) not null,

    primary key(id)
);

create table agendamentos(

    id bigint not null auto_increment,
    id_pessoa bigint not null,
    id_atividade bigint not null,
    data datetime not null,

    primary key(id),
    constraint fk_agendamentos_pessoa_id foreign key(id_pessoa) references pessoas(id),
    constraint fk_agendamentos_atividade_id foreign key(id_atividade) references atividades(id)

);