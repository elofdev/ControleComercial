CREATE TABLE item(
id BIGINT NOT NULL AUTO_INCREMENT,
produto_id BIGINT NOT NULL,
quantidade_item INTEGER NOT NULL,
indice_item_tabela_cheia DECIMAL(3,2) NOT NULL,
valor_item_tabela_cheia DECIMAL(10,2) NOT NULL,
indice_item_sem_desconto DECIMAL(3,2) NOT NULL,
valor_item_sem_desconto DECIMAL(10,2) NOT NULL,
valor_comissao_sem_desconto DECIMAL(10,2) NOT NULL,
indice_item_venda DECIMAL(3,2) NOT NULL,
valor_item_venda DECIMAL(10,2) NOT NULL,
valor_comissao_venda DECIMAL(10,2) NOT NULL,
valor_premiacao_venda DECIMAL(10,2) NOT NULL,
obs TEXT,
datasys DATETIME NOT NULL,
PRIMARY KEY (id),
CONSTRAINT fk_item_produto FOREIGN KEY (produto_id) REFERENCES produto(id)
);
