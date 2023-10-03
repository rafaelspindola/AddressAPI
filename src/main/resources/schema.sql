DROP TABLE IF EXISTS Pessoa cascade;

CREATE TABLE Pessoa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE
);

DROP TABLE IF EXISTS Endereco cascade;

CREATE TABLE Endereco (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    logradouro VARCHAR(255) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    numero VARCHAR(10),
    cidade VARCHAR(100) NOT NULL,
    principal BOOLEAN,
    pessoa_id BIGINT NOT NULL,
    FOREIGN KEY (pessoa_id) REFERENCES Pessoa (id)
);