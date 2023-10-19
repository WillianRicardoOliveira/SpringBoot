ALTER TABLE abelhas ADD COLUMN ativo tinyint;

update abelhas set ativo = 1;	


alter table abelhas modify ativo tinyint not null;