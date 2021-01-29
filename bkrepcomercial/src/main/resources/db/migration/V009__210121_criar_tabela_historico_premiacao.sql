CREATE TABLE historico_premiacao(
id BIGINT NOT NULL AUTO_INCREMENT,
item_id BIGINT NOT NULL,
parcela_id BIGINT NOT NULL,
data_premiacao DATETIME NOT NULL,
valor_total_premiacao DECIMAL(10,2) NOT NULL,
status_recebimento VARCHAR(10) NOT NULL,
obs TEXT,
datasys DATETIME NOT NULL,
PRIMARY KEY (id),
CONSTRAINT fk_historico_premiacao_item FOREIGN KEY (item_id) REFERENCES item(id),
CONSTRAINT fk_historico_premiacao_parcela FOREIGN KEY (parcela_id) REFERENCES parcela(id)
);
