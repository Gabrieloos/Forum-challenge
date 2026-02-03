CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE
);

CREATE TABLE curso (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL
);

CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao DATETIME NOT NULL,
    status VARCHAR(30) NOT NULL,

    autor_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,

    CONSTRAINT fk_topico_autor
        FOREIGN KEY (autor_id)
        REFERENCES usuario(id),

    CONSTRAINT fk_topico_curso
        FOREIGN KEY (curso_id)
        REFERENCES curso(id)
);
