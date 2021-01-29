create table pedido(
id BIGINT NOT NULL AUTO_INCREMENT,
cliente_id BIGINT NOT NULL, 
item_id BIGINT NOT NULL, 
nr_pedido_cliente varchar(20), 
nr_master VARCHAR(20),
valor_normal DECIMAL(10,2) NOT NULL, 
valor_venda DECIMAL(10,2) NOT NULL, 
valor_comissao DECIMAL(10,2) NOT NULL, 
data_abertura DATETIME NOT NULL,
data_faturamento DATETIME,
obs TEXT,
datasys DATETIME NOT NULL,
PRIMARY KEY (id),
CONSTRAINT fk_pedido_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id),
CONSTRAINT fk_pedido_item FOREIGN KEY (item_id) REFERENCES item(id)
);
