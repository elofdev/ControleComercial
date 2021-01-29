create table comissao(
id BIGINT NOT NULL AUTO_INCREMENT,
tbl CHAR(1) NOT NULL,
limite DECIMAL(3,2) NOT NULL,
indice_comissionamento DECIMAL(3,2) NOT NULL,
obs TEXT,
datasys DATETIME NOT NULL,
PRIMARY KEY (id)
);
