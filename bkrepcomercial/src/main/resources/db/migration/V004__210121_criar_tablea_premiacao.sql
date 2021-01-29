create table premiacao(
id BIGINT NOT NULL AUTO_INCREMENT,
classe_produto VARCHAR(10) NOT NULL,
meta DECIMAL(10,2) NOT NULL,
indice_premiacao DECIMAL(3,2) NOT NULL,
obs TEXT,
datasys DATETIME NOT NULL,
PRIMARY KEY (id)
);
