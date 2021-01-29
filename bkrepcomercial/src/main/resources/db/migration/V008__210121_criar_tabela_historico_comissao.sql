CREATE TABLE historico_comissao(
id BIGINT NOT NULL AUTO_INCREMENT,
parcela_id BIGINT NOT NULL,
data_total_comissao DATETIME NOT NULL,
valor_total_comissao DECIMAL(10,2) NOT NULL,
status_recebimento VARCHAR(10) NOT NULL,
obs TEXT,
datasys DATETIME NOT NULL,
PRIMARY KEY (id),
CONSTRAINT fk_historico_comissao_parcela FOREIGN KEY (parcela_id) REFERENCES parcela(id)
);
