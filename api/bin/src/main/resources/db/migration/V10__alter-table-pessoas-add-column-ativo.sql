ALTER TABLE pessoas ADD COLUMN ativo tinyint;

update pessoas set ativo = 1;	


alter table pessoas modify ativo tinyint not null;