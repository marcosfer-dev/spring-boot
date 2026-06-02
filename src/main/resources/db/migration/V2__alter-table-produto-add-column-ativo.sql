ALTER TABLE produto
ADD COLUMN ativo BOOLEAN ;

UPDATE produto
SET ativo = TRUE;