CREATE TABLE produto (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco NUMERIC(10,2) NOT NULL,
    quantidade INTEGER NOT NULL,
    sku VARCHAR(100) UNIQUE NOT NULL,
    categoria VARCHAR(100) NOT NULL
);