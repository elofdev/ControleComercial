CREATE TABLE parcela(
id BIGINT NOT NULL AUTO_INCREMENT,
pedido_id BIGINT NOT NULL,
nr_parcela INT NOT NULL,
dias INT NOT NULL,
data_parcela_fatura DATETIME NOT NULL,
valor_fatura DECIMAL(10,2) NOT NULL,
data_parcela_comissao DATETIME NOT NULL,
valor_comissao DECIMAL(10,2) NOT NULL,
data_parcela_premiacao DATETIME NOT NULL,
valor_premiacao DECIMAL(10,2) NOT NULL,
obs TEXT,
datasys DATETIME NOT NULL,
PRIMARY KEY (id),
CONSTRAINT fk_parcela_pedido FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);
